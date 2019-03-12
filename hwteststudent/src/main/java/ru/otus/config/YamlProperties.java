package ru.otus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class YamlProperties {
    private String qaPath;
    private String fileExt;
    private String localeLang;
    private String localeCountry;

    public String getQaPath() {
        return qaPath;
    }

    public void setQaPath(String qaPath) {
        this.qaPath = qaPath;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getLocaleLang() {
        return localeLang;
    }

    public void setLocaleLang(String localeLang) {
        this.localeLang = localeLang;
    }

    public String getLocaleCountry() {
        return localeCountry;
    }

    public void setLocaleCountry(String localeCountry) {
        this.localeCountry = localeCountry;
    }

    public String getFullPath(){
        return qaPath+localeLang+fileExt;
    }
}
