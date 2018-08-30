package com.company.location.model.response;

/**
 * 授权开通短信定位
 */
public class AuthRegResponse {

    /**
     * 1：已开通，0：已发送定位请求通知,请等待机主回复,Y表示同意定位,机主回复后再进行定位
     */
    private int resid;

    private int async;

    private String host;

    private String seqno;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 描述
     */
    private String resmsg;

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public int getAsync() {
        return async;
    }

    public void setAsync(int async) {
        this.async = async;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getResmsg() {
        return resmsg;
    }

    public void setResmsg(String resmsg) {
        this.resmsg = resmsg;
    }
}
