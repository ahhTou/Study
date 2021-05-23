package com.tou.utils.getter;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.tou.utils.TokenProperty;
import com.tou.utils.JwtService;
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

    public StreamJwtVerifyData(TokenProperty property) {
        DecodedJWT verify = null;
        try {
            verify = JwtService.verify(property.getToken(), property.getSecret());
            this.setClaims(verify.getClaims());
        } catch (Exception e) {
            setException(e);
        }

        this.setValid(verify != null);

    }


}
