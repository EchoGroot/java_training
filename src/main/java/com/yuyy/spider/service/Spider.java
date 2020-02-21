package com.yuyy.spider.service;

import com.yuyy.spider.dao.Storage;
import com.yuyy.spider.domain.Page;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuyy
 * @date 2019/8/20 17:55
 */
public class Spider {


    PageVisitor pageVisitor = new PageVisitor();

    PageParser pageParser = new PageParser();

    public void crawling(String url){
        Page page = pageVisitor.visit(url);
        Elements elements = pageParser.getTargetElements(page, ".content-txt p");
        System.out.println("elements.text"+elements.text());
        Storage.method("C:\\Users\\Yuyy\\Desktop\\contentText.txt",elements.text());
    }
}
