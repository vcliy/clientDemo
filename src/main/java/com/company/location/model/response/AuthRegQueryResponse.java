package com.company.location.model.response;

/**
 * 短信开通查询
 */
public class AuthRegQueryResponse {

    /**
     * 状态id，0：未开通，1：开通
     */
    private int resid;

    /**
     * 描述信息
     */
    private String resmsg;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 描述
     */
    private String remark;

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getResmsg() {
        return resmsg;
    }

    public void setResmsg(String resmsg) {
        this.resmsg = resmsg;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
