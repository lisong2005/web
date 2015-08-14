package ls.demon.test;
/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PostFormTest.java, v 0.1 2015年8月13日 下午2:59:13 song.li@witontek.com Exp $
 */
public class PostFormTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(PostFormTest.class);

 

    @Test
    public void test_post_21() {

        String cs = "gb2312";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            httpclient.getParams().setParameter("http.protocol.content-charset", cs);

            HttpPost httppost = new HttpPost("http://localhost:8080/WebApp/tool/at.htm");

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("appId", "中文1"));
            params.add(new BasicNameValuePair("appSecret", "中文12222222222222222"));

            httppost.setEntity(new UrlEncodedFormEntity(params, cs));
            logger.info("{}", httppost.getEntity().toString());
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("1={}", EntityUtils.toString(httppost.getEntity(), "UTF-8"));
            logger.info("2={}", EntityUtils.toString(httppost.getEntity(), "gbk"));
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            HttpResponse response = httpclient.execute(httppost);

            logger.info("H={}", response.getEntity().getContentType());

            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info("c={}", responseBody);
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_post_22() {

        String cs = "utf-8";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            httpclient.getParams().setParameter("http.protocol.content-charset", cs);

            HttpPost httppost = new HttpPost("http://localhost:8080/WebApp/tool/at.htm");

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("appId", "中文1"));
            params.add(new BasicNameValuePair("appSecret", "中文12222222222222222"));

            httppost.setEntity(new UrlEncodedFormEntity(params, cs));
            logger.info("{}", httppost.getEntity().toString());
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("1={}", EntityUtils.toString(httppost.getEntity(), "UTF-8"));
            logger.info("2={}", EntityUtils.toString(httppost.getEntity(), "gbk"));
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            HttpResponse response = httpclient.execute(httppost);

            logger.info("H={}", response.getEntity().getContentType());

            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info("c={}", responseBody);
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_url_en() {
        String cs = "gbk";
        String cs2 = "utf-8";

        String appId = "中文1";
        String appSecret = "中文2";
        try {
            String url = "http://localhost:8080/WebApp/tool/at.htm";

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("appId", appId));
            params.add(new BasicNameValuePair("appSecret", appSecret));

            UrlEncodedFormEntity e = new UrlEncodedFormEntity(params, cs);
            logger.info("{}", EntityUtils.toString(e, cs));
            logger.info("{}", EntityUtils.toString(e, cs2));

            logger.info("{}?appId={}&appSecret={}", url, URLEncoder.encode(appId, cs),
                URLEncoder.encode(appSecret, cs));
            logger.info("{}?appId={}&appSecret={}", url, URLEncoder.encode(appId, cs2),
                URLEncoder.encode(appSecret, cs2));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_httpClient_post() {
        String cs = "gbk";
        String cs2 = "utf-8";

        try {
            String url = "http://localhost:8080/WebApp/tool/at.htm";

            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            httpclient.getParams().setParameter("http.protocol.content-charset", cs);

            HttpPost httpPost = new HttpPost(url);
            logger.info("post url:" + url);
            httpPost.setHeader("User-Agent", "SOHUWapRebot");
            httpPost.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
            httpPost.setHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.7");
            httpPost.setHeader("Connection", "keep-alive");

            MultipartEntity mutiEntity = new MultipartEntity();
            mutiEntity.addPart("appId", new StringBody("美丽的西双版纳", Charset.forName(cs)));
            mutiEntity.addPart("appSecret", new StringBody("美丽的西双版纳2", Charset.forName(cs2)));

            httpPost.setEntity(mutiEntity);
            HttpResponse httpResponse = httpclient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpEntity);

            logger.info("", content);
        } catch (ParseException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_httpClient_post_test() {
        String cs = "gbk";
        String cs2 = "utf-8";

        try {
            String url = "http://localhost:8080/WebApp/test_post";

            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            httpclient.getParams().setParameter("http.protocol.content-charset", cs);

            HttpPost httpPost = new HttpPost(url);
            logger.info("post url:" + url);
            httpPost.setHeader("User-Agent", "SOHUWapRebot");
            httpPost.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
            httpPost.setHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.7");
            httpPost.setHeader("Connection", "keep-alive");

            MultipartEntity mutiEntity = new MultipartEntity();
            mutiEntity.addPart("appId", new StringBody("美丽的西双版纳", Charset.forName(cs)));
            mutiEntity.addPart("appSecret", new StringBody("美丽的西双版纳2", Charset.forName(cs2)));

            httpPost.setEntity(mutiEntity);
            HttpResponse httpResponse = httpclient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpEntity);

            logger.info("{}", content);
        } catch (ParseException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        }
    }
}
