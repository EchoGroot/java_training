package com.yuyy.spider.domain;

import com.yuyy.spider.common.CharsetDetector;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;

public class Page {

    private byte[] content;
    private String url;
    private Document document;
    private String html;
    private String contentType;
    private String charSet;

    public Page() {
    }

    public Page(byte[] content, String url, String contentType) {
        this.content = content;
        this.url = url;
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取网页源码字符串
     * @return
     */
    public String getHtml() {
        if(null!=html){
            return html;
        }
        if(null==content){
            return null;
        }
        if(charSet==null){
            charSet= CharsetDetector.guessEncoding(content);
        }
        try{
            this.html=new String(content,charSet);
            return this.html;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * 得到文档对象
     * @return
     */
    public Document getDocument(){
        if (null!=this.document){
            return this.document;
        }
        try{
            this.document= Jsoup.parse(getHtml(),url);
            return this.document;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
