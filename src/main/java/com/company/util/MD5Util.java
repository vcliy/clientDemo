package com.company.util;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.util.*;

/**
 * Created by Vito on 6/6/16 11:38.
 */

public class MD5Util {

    private static Logger logger = LogManager.getLogger(MD5Util.class);

    /**
     * 制作MD5签名
     *
     * @param map 待签名map
     * @param key API 密钥
     * @return String signString
     */
    public static String makeSignature(Map map, String key) throws Exception {

        String text = buildSignString(map, key);
        return makeSignature(text);
    }

    public static String makeSignature(String text, String key) throws Exception {
        text = buildSignString(text, key);
        return makeSignature(text);
    }

    public static String makeSignature(String text) throws Exception {
        byte[] bytes = text.getBytes("UTF-8");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        bytes = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 验证传参的MD5是否正确
     *
     * @param map 入参map，包含原始签名
     * @param key API 密钥
     * @return Boolean true/false
     */
    public static Boolean verifySignature(Map map, String key) throws Exception {
        String sign = String.valueOf(map.get("sign"));
        map.remove("sign");
        String nowSign = makeSignature(map, key);
        logger.info("MD5Util.verifySignature|原始签名：" + sign + ",nowSign：" + nowSign);
        if (sign.equals(nowSign)) {
            return true;
        }
        return false;
    }

    /**
     * 组装代签名字符串格式为 key1=value1&key2=value2&key=keyValue
     * 去除空的和null的字段
     * 需要做urlEncoding
     *
     * @param map 代签名map
     * @param key API密钥
     * @return String 代签名字符串包括key
     */
    private static String buildSignString(Map map, String key) {

        return buildSignString(FormDateReportConvertor.postFormLinkReport(map), key);
    }

    private static String buildSignString(String text, String key) {
        if (!StringUtils.isBlank(key)) {
            return text + "&secret=" + key;
        }
        return text;
    }

    private boolean validateReqReportMD5(Map<String, String> dataMap, String mhtSignature, String md5KEY) {
        dataMap.remove("funcode");
        dataMap.remove("mhtSignType");
        dataMap.remove("mhtSignature");
        String deviceType = dataMap.remove("deviceType");

        boolean isValidReqMD5 = false;
        try {
            isValidReqMD5 = validateFormDataParamMD5(dataMap, md5KEY, mhtSignature);
        } catch (Exception ex) {
            logger.info("订单验证交易--MD5验证请求报文签名失败", ex);
        }

        //关键字段的还原
        dataMap.put("deviceType", deviceType);
        return isValidReqMD5;
    }

    public static boolean validateFormDataParamMD5(Map<String, String> dataMap, String securityKey, String currentSignature) {
        if (dataMap == null || dataMap.isEmpty())
            return false;
        Set<String> keySet = dataMap.keySet();
        List<String> keyList = new ArrayList<String>(keySet);
        Collections.sort(keyList);
        StringBuilder toMD5StringBuilder = new StringBuilder();
        for (String key : keyList) {
            String value = dataMap.get(key);
            if (StringUtils.isNotBlank(value)) {
                toMD5StringBuilder.append(key + "=" + value + "&");
            }
        }
        try {
            String securityKeyMD5 = MD5.md5(securityKey, "");
            toMD5StringBuilder.append(securityKeyMD5);
            String toMD5String = toMD5StringBuilder.toString();
            String actualMD5Value = MD5.md5(toMD5String, "");
            return actualMD5Value.equals(currentSignature);
        } catch (Exception ex) {
            return false;
        }
    }
}
