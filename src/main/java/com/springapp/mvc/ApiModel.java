package com.springapp.mvc;

import java.util.List;

/**
 * Created by dengjing on 15/3/17.
 */
public class ApiModel {
    int error_code;
    List<String> misc;
    List<String> gpe;
    List<String> org;
    List<String> person;
    List<String> loc;

    public List<String> getMisc() {
        return misc;
    }

    public void setMisc(List<String> misc) {
        this.misc = misc;
    }

    public List<String> getGpe() {
        return gpe;
    }

    public void setGpe(List<String> gpe) {
        this.gpe = gpe;
    }

    public List<String> getOrg() {
        return org;
    }

    public void setOrg(List<String> org) {
        this.org = org;
    }

    public List<String> getPerson() {
        return person;
    }

    public void setPerson(List<String> person) {
        this.person = person;
    }

    public List<String> getLoc() {
        return loc;
    }

    public void setLoc(List<String> loc) {
        this.loc = loc;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ApiModel(){

    }
}
