package com.cc68.beans;

import java.io.Serializable;

/**
  * 一个专门属于方言的bean，预估被组合在DictBean中
  */
public class DialectBean implements Serializable {
    //方言的地区
    private String area;
    //字词
    private String data;
    //语音路径
    private String voiceUrl;
    //读音
    private String pronunciation;
    //备注
    private String notes;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DialectBean(){}

    public DialectBean(String area, String data, String voiceUrl, String pronunciation, String notes) {
        this.area = area;
        this.data = data;
        this.voiceUrl = voiceUrl;
        this.pronunciation = pronunciation;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "DialectBean{" +
                "area='" + area + '\'' +
                ", data='" + data + '\'' +
                ", voiceUrl='" + voiceUrl + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
