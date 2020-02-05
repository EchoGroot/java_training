package com.yuyy.spider.service;

import com.yuyy.spider.domain.Page;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author yuyy
 * @date 2019/8/20 18:15
 */
public class PageVisitor {
    public PageVisitor() {
    }

    public Page visit(String url){
        //创建客户端 配置HttpClient
        RequestConfig config=RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();
        CloseableHttpClient client= HttpClients.custom()
                .setDefaultRequestConfig(config)
                .setRetryHandler(new DefaultHttpRequestRetryHandler())
                .setUserAgent("Mozilla/5.0(Windows;U;Windows NT 5.1;en-US;rv:0.9.4)")
                .build();
        try{
            System.out.println("visit url:"+url);
            CloseableHttpResponse response=client.execute(RequestBuilder.get(url).build());
            if ( response.getStatusLine().getStatusCode()!=200){
                System.out.println("请求"+url+"失败");
            }else{
                byte[] responseBody= EntityUtils.toByteArray(response.getEntity());
                Header contentType=response.getEntity().getContentType();
                Page page=new Page(responseBody,url,contentType.getName());
                return page;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
