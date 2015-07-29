package com.springapp.mvc;

import java.util.List;

/**
 * Created by dengjing on 15/3/25.
 */
public class ApiImgModel {
    int error_code;
    List<String> imgs;

    public ApiImgModel(int error_code, List<String> imgs) {
        this.error_code = error_code;
        this.imgs = imgs;
    }

    public ApiImgModel() {
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
