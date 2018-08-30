package com.company.location.model.request;

/**
 * 车牌号定位
 */
public class PlatenumRequest extends CommonRequest {

    /**
     * 车牌号
     */
    private String platenum;

    public String getPlatenum() {
        return platenum;
    }

    public void setPlatenum(String platenum) {
        this.platenum = platenum;
    }

    //    public static void main(String[] args) throws Exception {
//        PlatenumRequest request = new PlatenumRequest();
//        request.setPlatenum("黑F88739");
//        request.setClientId("db57571d53df4fe19213ee6999476d69");
//        request.setTimestamp("15747545455");
//        request.makeMd5Signature("d3f5af202c229cb5e86675d3695f02a2");
//        System.out.println(request.getSign());
//    }
}
