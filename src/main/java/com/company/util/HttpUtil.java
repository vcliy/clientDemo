package com.company.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Vito on 6/25/16 13:39.
 **/

public class HttpUtil {

    private static final int SO_TIME_OUT = 80000;
    private static final int CONNECTION_TIME_OUT = 50000;

    public static String doPost(String url, Object obj) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        return doPost(url,MapUtil.convertBean(obj));
    }
    public static String doPost(String url, Map<String, String> map) {
        long start_time = System.currentTimeMillis();
        String jsonString = null;
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(map);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);// 创建httpPost
            httpPost.setHeader("Content-Type", "application/json");
            String charSet = "UTF-8";
            StringEntity entity = new StringEntity(jsonObject.toString(), charSet);
            httpPost.setEntity(entity);
            CloseableHttpResponse response = null;
            try {

                response = httpclient.execute(httpPost);
                StatusLine status = response.getStatusLine();
                int state = status.getStatusCode();
                if (state == HttpStatus.SC_OK) {
                    HttpEntity responseEntity = response.getEntity();
                    jsonString = EntityUtils.toString(responseEntity);
                } else {
                    System.err.println("请求返回:" + state + "(" + url + ")");
                }
            } finally {
                if (response != null) {
                    try {
                        response.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long end_time = System.currentTimeMillis();
            System.out.println("HttpClientUtil.doPostBody 调用" + url + " 耗时：" + (end_time - start_time));
        }
        return jsonString;
    }

    public static String doGet(String url) throws Exception {
        long start_time = System.currentTimeMillis();
        String result = "";
        HttpClient client;
        HttpMethod httpMethod = null;
        InputStreamReader in = null;
        BufferedReader br = null;
        try {
            client = new HttpClient();

            httpMethod = new GetMethod(url);
            httpMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

            client.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECTION_TIME_OUT);
            client.getHttpConnectionManager().getParams().setSoTimeout(SO_TIME_OUT);
            client.executeMethod(httpMethod);

            InputStream responseBody = httpMethod.getResponseBodyAsStream();
            in = new InputStreamReader(responseBody, "utf-8");
            br = new BufferedReader(in);
            StringBuffer stringBuffer = new StringBuffer();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            result = stringBuffer.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
            if (in != null) {
                in.close();
            }
            if (httpMethod != null) {
                httpMethod.releaseConnection();
            }
            long end_time = System.currentTimeMillis();
            System.err.println("HttpClientUtil.doGet 调用" + url + " 耗时：" + (end_time - start_time));
        }
        return result;
    }
}
