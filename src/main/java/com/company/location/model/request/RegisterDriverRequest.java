package com.company.location.model.request;

/**
 * 司机注册
 */
public class RegisterDriverRequest extends CommonRequest {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证号
     */
    private String identityCard;

    /**
     * 车牌号
     */
    private String plateNum;

    /**
     * 司机姓名
     */
    private String driverName;

    /**
     * 行驶证号
     */
    private String ldrivingLicense;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLdrivingLicense() {
        return ldrivingLicense;
    }

    public void setLdrivingLicense(String ldrivingLicense) {
        this.ldrivingLicense = ldrivingLicense;
    }


    //    public static void main(String[] args) throws Exception {
//
//    }
}
