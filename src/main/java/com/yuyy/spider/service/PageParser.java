package com.yuyy.spider.service;


import com.yuyy.spider.domain.Page;
import org.jsoup.select.Elements;

public class PageParser {

    /**
     * 获取所有目标元素
     * @param page
     * @param cssSelectors
     * @return
     */
    public Elements getTargetElements(Page page,String... cssSelectors){
        Elements resultElements=new Elements();
        for(String str:cssSelectors){
            Elements elements=page.getDocument().select(str);
            if(null!=elements&&elements.size()>0){
                resultElements.addAll(elements);
            }
        }
        return resultElements;
    }

}
