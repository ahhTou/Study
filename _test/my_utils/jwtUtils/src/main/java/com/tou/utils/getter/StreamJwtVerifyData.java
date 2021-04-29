package com.tou.utils.getter;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tou.utils.JwtProperty;
import com.tou.utils.handler.IJwtVerifyErrHandler;

import com.tou.utils.handler.IJwtVerifySuccessHandler;
import com.tou.utils.service.JwtService;
import lombok.Data;

import java.util.Map;

@Data
public class StreamJwtVerifyData implements IStreamJwtVerifyData {

    boolean isValid;
    Map<String, Claim> claims;
    Exception exception = null;

    @Override
    public Map<String, String> getClaims() {
        if (!isValid()) return null;
        return null;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }

    @Override
    public void doHandler(IJwtVerifySuccessHandler success, IJwtVerifyErrHandler error) {
        if (isValid()) {
            success.handle(this);
        } else {
            error.handler(getException());
        }
    }

    public StreamJwtVerifyData(String token, JwtProperty property) {
        DecodedJWT verify = null;
        try {
            verify = JwtService.verify(token, property.getSECRET());
            this.setClaims(verify.getClaims());
        } catch (Exception e) {
            setException(e);
        }

        this.setValid(verify != null);

    }


}
