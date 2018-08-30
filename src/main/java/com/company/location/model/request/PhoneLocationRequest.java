package com.company.location.model.request;

/**
 * 手机号定位
 */
public class PhoneLocationRequest extends CommonRequest {

    /**
     * 手机号码
     */
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public static void main(String[] args) {
//        PhoneLocationRequest authModel = new PhoneLocationRequest();
//        authModel.setClientId("cc2ee95d83424f7988650755b49bca60");
//        authModel.setTimestamp("15747545455");
//        authModel.setPhone("15210802181");
//        try {
//            authModel.makeMd5Signature("581f408d83d0de4d7a6b312d8909fa24");
//            System.out.println(authModel.getSign());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
