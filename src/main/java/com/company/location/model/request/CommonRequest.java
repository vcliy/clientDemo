package com.company.location.model.request;

import com.company.util.MD5Util;
import com.company.util.MapUtil;
import java.io.Serializable;
import java.util.Map;

/**
 *  授权加签
 */
public class CommonRequest implements Serializable {

    private static final long serialVersionUID = -4521674776453877049L;

    private String clientId;

    private String timestamp;

    private String sign;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * MD5加签
     *
     * @param key
     * @throws Exception
     */
    public void makeMd5Signature(String key) throws Exception {
        Map map = MapUtil.convertBean(this);
        this.setSign(MD5Util.makeSignature(map, key));
    }

    /**
     * 验签
     *
     * @param key
     * @return
     * @throws Exception
     */
    public boolean verifySignature(String key) throws Exception {
        Map map = MapUtil.convertBean(this);
        return MD5Util.verifySignature(map, key);
    }

}
