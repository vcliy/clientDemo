package com.company.service;

import com.alibaba.fastjson.JSONObject;
import com.company.location.model.request.PhoneLocationRequest;
import com.company.location.model.request.PlatenumRequest;
import com.company.location.model.request.RegisterDriverRequest;
import com.company.location.model.response.AuthRegQueryResponse;
import com.company.location.model.response.AuthRegResponse;
import com.company.location.model.response.PlatenumLocation;
import com.company.location.model.response.SmsLocationResponse;
import com.company.msg.ObjectRestResponse;
import junit.framework.TestCase;

public class LocationServiceTest extends TestCase {

    private LocationService locationService;

    private static final String url = "http://localhost:5000";
    protected void setUp() {
        locationService = new LocationService();
        locationService.setUrl(url);
    }

    /**
     * 注册司机
     *
     * @throws Exception
     */
    public void testRegisterDriver() throws Exception {
        RegisterDriverRequest driver = new RegisterDriverRequest();
        driver.setClientId("db57571d53df4fe19213ee6999476d69");
        driver.setTimestamp("15747545455");
        driver.setDriverName("test");
        driver.setIdentityCard("1111111111244545");
        driver.setLdrivingLicense("43545766878");
        driver.setPhone("15210802181");
        driver.setPlateNum("鄂A8936");
        driver.makeMd5Signature("d3f5af202c229cb5e86675d3695f02a2");
        ObjectRestResponse<AuthRegResponse> response = locationService.registerDriver(driver);
        System.out.println(JSONObject.toJSONString(response));
    }

    /**
     * 开通短信状态查询
     *
     * @throws Exception
     */
    public void testQueryAuthReg() throws Exception {
        PhoneLocationRequest request = new PhoneLocationRequest();
        request.setClientId("cc2ee95d83424f7988650755b49bca60");
        request.setTimestamp("15747545455");
        request.setPhone("15210802181");
        request.makeMd5Signature("581f408d83d0de4d7a6b312d8909fa24");
        ObjectRestResponse<AuthRegQueryResponse> response = locationService.queryAuthReg(request);
        System.out.println(JSONObject.toJSONString(response));
    }

    /**
     * 短信定位
     *
     * @throws Exception
     */
    public void testSmsLocation() throws Exception {
        PhoneLocationRequest request = new PhoneLocationRequest();
        request.setClientId("cc2ee95d83424f7988650755b49bca60");
        request.setTimestamp("15747545455");
        request.setPhone("15210802181");
        request.makeMd5Signature("581f408d83d0de4d7a6b312d8909fa24");
        ObjectRestResponse<SmsLocationResponse> response = locationService.smsLocation(request);
        System.out.println(JSONObject.toJSONString(response));
    }

    /**
     * 车牌号定位
     *
     * @throws Exception
     */
    public void testPlatenumLocation() throws Exception {
        PlatenumRequest request = new PlatenumRequest();
        request.setPlatenum("黑F88739");
        request.setClientId("db57571d53df4fe19213ee6999476d69");
        request.setTimestamp("15747545455");
        request.makeMd5Signature("d3f5af202c229cb5e86675d3695f02a2");
        ObjectRestResponse<PlatenumLocation> response = locationService.platenumLocation(request);
        System.out.println(JSONObject.toJSONString(response));
    }
}