package com.company.location.model.response;

/**
 * 定位
 * lat : 30.62285
 * lng : 114.23684
 * city : 武汉市
 * code :
 * host : 1
 * msec : 806
 * ctime : 2018-07-13T16:57:21.251864
 * resid : 0
 * rtime : 2018-07-13T16:57:22.07744
 * exinfo :
 * mobile : 15210802188
 * resmsg : 移动授权经纬度定位成功
 * street : 江旺路
 * areacode :
 * district : 江汉区
 * location : 湖北省武汉市江汉区江汉经济开发区武汉德威电力测试设备有限公司汉口创业中心(发展一路)
 * province : 湖北省
 * roamcity :
 */
public class SmsLocationResponse {


    /**
     * 纬度
     */
    private String lat;
    /**
     * 经度
     */
    private String lng;
    /**
     * 地理位置所在的城市
     */
    private String city;

    /**
     * 街道
     */
    private String street;
    /**
     *
     */
    private String code;
    /**
     *
     */
    private String host;
    /**
     *
     */
    private int msec;
    /**
     *
     */
    private String ctime;
    /**
     * 0：成功，1：定位失败，-1：当前不是白名单用户,请先调用开通定位接口，-404：未开通
     */
    private int resid;
    /**
     *
     */
    private String rtime;
    /**
     *
     */
    private String exinfo;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 描述信息
     */
    private String resmsg;

    /**
     * 手机号码归属地区
     */
    private String areacode;
    /**
     * 地理位置所在的区域
     */
    private String district;
    /**
     * 地理位置信息
     */
    private String location;
    /**
     * 地理位置所在的省
     */
    private String province;
    /**
     * 手机号码所在的漫游地区
     */
    private String roamcity;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getMsec() {
        return msec;
    }

    public void setMsec(int msec) {
        this.msec = msec;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getExinfo() {
        return exinfo;
    }

    public void setExinfo(String exinfo) {
        this.exinfo = exinfo;
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

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRoamcity() {
        return roamcity;
    }

    public void setRoamcity(String roamcity) {
        this.roamcity = roamcity;
    }
}
