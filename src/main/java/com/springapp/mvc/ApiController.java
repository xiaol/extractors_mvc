package com.springapp.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ApiController {

    @RequestMapping(value = "/api/getImg")
    public ApiImgModel getImgApi(HttpServletRequest request){
        ApiImgModel returnApi = new ApiImgModel();
        ImageExtractorMain imgEx = new ImageExtractorMain();
        String url = request.getParameter("url");
        List<String> strs = null;
        try {
             strs = imgEx.getImages(url);
        } catch (Exception e) {
            e.printStackTrace();
            returnApi.setError_code(1);
            return returnApi;
        }
        returnApi.setError_code(0);
        returnApi.setImgs(strs);
        return returnApi;
    }

    @RequestMapping(value = "/api/getText")
    public ApiTextModel getTextApi(HttpServletRequest request){
        ApiTextModel returnApi = new ApiTextModel();
        ImageExtractorMain imgEx = new ImageExtractorMain();
        String url = request.getParameter("url");
        String strs = null;
        try {
            strs = imgEx.getTexts(url);
        } catch (Exception e) {
            e.printStackTrace();
            returnApi.setError_code(1);
            return returnApi;
        }
        returnApi.setError_code(0);
        returnApi.setText(strs);
        return returnApi;
    }
}
