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

    private final BoilerpipeExtractor extractor = CommonExtractors.CHINESE_IMAGE_EXTRACTOR;
    private final ImageExtractor ie = ImageExtractor.INSTANCE;
    private final ChineseArticleExtractor ae = ChineseArticleExtractor.INSTANCE;

    public class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

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
        final String text = address.trim();
        final String addressLC = text.toLowerCase();
        if(addressLC.contains(".tv")
                || address.contains("wasu.cn")
                || address.contains("youku.com")
                || address.contains("v.ifeng.com")){
            return "";
        }
        if(!text.startsWith("http://")){
            address= "http://"+address;
        }
        URL url = new URL(address);
        String result = ae.getText(url);
        String[] pa = result.split("\n");
        ArrayList<Tuple<Integer, Integer>> pairs = new ArrayList<Tuple<Integer, Integer>>();
        for(int i = 0; i < pa.length; i++){
            for( int j = i+1; j < pa.length; j++){
                String ti = pa[i].replaceAll("\\s+","");
                String tj = pa[j].replaceAll("\\s+","");
                if(ti.equals(tj) || ti.contains(tj) || tj.contains(ti)){
                    pairs.add(new Tuple(i,j));
                }
            }
        }

        for (int i = 0; i < pairs.size(); i++) {
            pa[pairs.get(i).y] = null;
        }
        StringBuilder builder = new StringBuilder();
        for(int n = 0; n < pa.length; n++){
            if(pa[n] != null){
                builder.append(pa[n]);
                builder.append("\n");
            }
        }
        result = builder.toString();
        if(result.length() <= 30){
            return "";
        }else{
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        ImageExtractorMain app = new ImageExtractorMain();
        List<String> strs = app.getImages("http://ent.ifeng.com/a/20150830/42483754_0.shtml");
        for(int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
        System.out.println(app.getTexts("http://ent.ifeng.com/a/20150830/42483754_0.shtml"));
    }
}
