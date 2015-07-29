package com.springapp.mvc;

import de.l3s.boilerpipe.BoilerpipeExtractor;
import de.l3s.boilerpipe.document.Image;
import de.l3s.boilerpipe.extractors.ChineseArticleExtractor;
import de.l3s.boilerpipe.extractors.CommonExtractors;
import de.l3s.boilerpipe.sax.ImageExtractor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dengjing on 15/3/25.
 */
public class ImageExtractorMain {

    private final BoilerpipeExtractor extractor = CommonExtractors.CHINESE_ARTICLE_EXTRACTOR;
    private final ImageExtractor ie = ImageExtractor.INSTANCE;
    private final ChineseArticleExtractor ae = ChineseArticleExtractor.INSTANCE;

    public List<String> getImages(String address) throws Exception {
        URL url = new URL(address);
        List<Image> imgUrls = ie.process(url, extractor);
        Collections.sort(imgUrls);
        List<String> results=new ArrayList<String>();
        for (Image img : imgUrls) {
            results.add(img.getSrc());
        }
        Collections.reverse(results);
        return results;
    }

    public String getTexts(String address) throws Exception {
        URL url = new URL(address);
        return ae.getText(url);
    }

    public static void main(String[] args) throws Exception {
        ImageExtractorMain app = new ImageExtractorMain();
        List<String> strs = app.getImages("http://hznews.hangzhou.com.cn/shehui/content/2015-03/25/content_5702863.htm");
        for(int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
        System.out.println(app.getTexts("http://hznews.hangzhou.com.cn/shehui/content/2015-03/25/content_5702863.htm"));
    }
}
