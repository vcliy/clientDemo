package com.company.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.company.location.model.request.PhoneLocationRequest;
import com.company.location.model.request.PlatenumRequest;
import com.company.location.model.request.RegisterDriverRequest;
import com.company.location.model.response.AuthRegQueryResponse;
import com.company.location.model.response.AuthRegResponse;
import com.company.location.model.response.PlatenumLocation;
import com.company.location.model.response.SmsLocationResponse;
import com.company.msg.ObjectRestResponse;
import com.company.util.HttpUtil;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 定位实现类
 */
public class LocationService {

    private String url;

    public ObjectRestResponse<AuthRegResponse> registerDriver(RegisterDriverRequest request) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        String result = HttpUtil.doPost(url + "/api/ext-manage-api/driver/register", request);
        ObjectRestResponse<AuthRegResponse> objectRestResponse = JSONObject.parseObject(result, new TypeReference<ObjectRestResponse<AuthRegResponse>>(){});
        return objectRestResponse;
    }

    public ObjectRestResponse<AuthRegQueryResponse> queryAuthReg(PhoneLocationRequest request) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        String result = HttpUtil.doPost(getUrl() + "/api/ext-manage-api/smslocation/queryAuthReg", request);
        ObjectRestResponse<AuthRegQueryResponse> objectRestResponse = JSONObject.parseObject(result, new TypeReference<ObjectRestResponse<AuthRegQueryResponse>>(){});
        return objectRestResponse;
    }

    public ObjectRestResponse<SmsLocationResponse> smsLocation(PhoneLocationRequest request) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        String result = HttpUtil.doPost(getUrl() + "/api/ext-manage-api/smslocation/location", request);
        ObjectRestResponse<SmsLocationResponse> objectRestResponse = JSONObject.parseObject(result, new TypeReference<ObjectRestResponse<SmsLocationResponse>>(){});
        return objectRestResponse;
    }

    public ObjectRestResponse<PlatenumLocation> platenumLocation(PlatenumRequest request) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        String result = HttpUtil.doPost(getUrl() + "/api/ext-manage-api/platenumLocation/location", request);
        ObjectRestResponse<PlatenumLocation> objectRestResponse = JSONObject.parseObject(result, new TypeReference<ObjectRestResponse<PlatenumLocation>>(){});
        return objectRestResponse;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
