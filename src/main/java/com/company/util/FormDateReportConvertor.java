package com.company.util;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 表单数据转换器
 * User: 表单数据型报文转换器
 * Date: 14-8-13
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class FormDateReportConvertor {

    private static Logger logger = LogManager.getLogger(FormDateReportConvertor.class);

    /**
     * 将数据映射表拼接成表单数据POST样式的字符串  key1=value1&key2=value2
     *
     * @param dataMap
     * @return
     */
    public static String postFormLinkReport(Map<String, String> dataMap) {

        if (dataMap==null || dataMap.isEmpty()) {
            return "";
        }

        List<String> keyList = new ArrayList<String>(dataMap.keySet());
        Collections.sort(keyList);

        StringBuilder reportBuilder = new StringBuilder();
        for (String key : keyList) {
            if (!StringUtils.isBlank(String.valueOf(dataMap.get(key)))) {
                reportBuilder.append(key + "=" + dataMap.get(key) + "&");
            }
        }
        reportBuilder.deleteCharAt(reportBuilder.lastIndexOf("&"));
        return reportBuilder.toString();
    }

    /**
     * 将数据映射表拼接成表单数据POST样式的字符串  key1=value1&key2=value2
     * <p>并且对key=value中的vaule进行URLEncoder编码
     *
     * @param dataMap 加签map
     * @param charset 编码
     * @return
     */
    public static String URLEncodeOnlyValue(Map<String, String> dataMap, String charset) throws UnsupportedEncodingException {

        if (dataMap==null || dataMap.isEmpty()) {
            return "";
        }

        List<String> keyList = new ArrayList<String>(dataMap.keySet());
        Collections.sort(keyList);

        StringBuilder reportBuilder = new StringBuilder();
        String valueAfterEncode;
        for (String key : keyList) {
            String value = dataMap.get(key);
            if (!StringUtils.isBlank(value)) {
                valueAfterEncode = URLEncoder.encode(value, charset);
                reportBuilder.append(key + "=" + valueAfterEncode + "&");
            }
        }
        if (reportBuilder.length() > 0) {
            reportBuilder.deleteCharAt(reportBuilder.lastIndexOf("&"));
        }
        return reportBuilder.toString();
    }

}
