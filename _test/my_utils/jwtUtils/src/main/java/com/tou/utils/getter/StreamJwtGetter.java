package com.tou.utils.getter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.tou.utils.TokenProperty;
import com.tou.utils.JwtService;
import com.tou.utils.handler.IJwtVerifyErrHandler;
import com.tou.utils.handler.IJwtVerifySuccessHandler;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamJwtGetter implements IStreamJwtGetter {

    TokenProperty p;

    public StreamJwtGetter(TokenProperty tokenProperty) {
        this.p = tokenProperty;
    }


    @Override
    public StreamJwtVerifyData verify() {
        return getStreamJwtData();
    }

    @Override
    public Boolean isValid() {
        return getStreamJwtData().isValid();
    }

    private StreamJwtVerifyData getStreamJwtData() {
        return new StreamJwtVerifyData(p);
    }


    @Override
    public void verify(IJwtVerifySuccessHandler success, IJwtVerifyErrHandler err) {
        try {
            DecodedJWT verify = JwtService.verify(p.getToken(), p.getSecret());

            Map<String, String> res = verify.getClaims().entrySet().stream()
                    .filter(entry -> !"exp".equals(entry.getKey()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            key -> key.getValue().asString())
                    );

            success.handle(res);
        } catch (Exception e) {
            err.handler(e);
        }
    }
}
