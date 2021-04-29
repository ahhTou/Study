package com.tou.utils.getter;

import com.tou.utils.JwtProperty;
import lombok.Data;

@Data
public class StreamJwtGetter implements IStreamJwtGetter {
    String token;
    JwtProperty property;

    public StreamJwtGetter(String token, JwtProperty property) {
        this.setToken(token);
        setProperty(property);
    }

    @Override
    public IStreamJwtGetter setToken(String token) {
        this.token = token;
        return this;
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
        return new StreamJwtVerifyData(token, property);
    }
}
