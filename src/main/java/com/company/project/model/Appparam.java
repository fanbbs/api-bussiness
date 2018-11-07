package com.company.project.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by dongjb on 2018/11/7.
 */
@ConfigurationProperties(prefix = "appparam")
public class Appparam {
    private String coordoffsetPackfilePath;

    public String getCoordoffsetPackfilePath() {
        return coordoffsetPackfilePath;
    }

    public void setCoordoffsetPackfilePath(String coordoffsetPackfilePath) {
        this.coordoffsetPackfilePath = coordoffsetPackfilePath;
    }

}
