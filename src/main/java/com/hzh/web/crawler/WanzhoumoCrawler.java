package com.hzh.web.crawler;

import com.hzh.web.constant.Client;
import com.hzh.web.constant.RequestHeaders;
import com.hzh.web.util.CookieUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class WanzhoumoCrawler implements Runnable {

    private static final String HOME_PAGE = "https://m.wanzhoumo.com/";
    private static final String REFERER = "https://www.wanzhoumo.com/";
    private static final String HOST = "m.wanzhoumo.com";

    private Logger logger = LoggerFactory.getLogger(WanzhoumoCrawler.class);

    private void crawl() throws IOException {
        Map<String, String> headers = RequestHeaders.get();
        headers.put("Host", HOST);
        Document doc = Jsoup.connect(HOME_PAGE).userAgent(Client.USER_AGENT).referrer(REFERER).cookies(CookieUtils.parse(Client.COOKIE)).get();
        System.out.println(doc.html());
    }

    @Override
    public void run() {
        try {
            crawl();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
