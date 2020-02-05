package com.yuyy.spider;

import com.yuyy.spider.service.Spider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Spider spider=new Spider();
        spider.crawling("https://www.51test.net/show/9386454.html");

    }
}
