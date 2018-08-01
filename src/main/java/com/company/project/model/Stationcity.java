package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_2I2C_STAFF_CITY")
public class Stationcity {
    @Id
    @Column(name = "PARENT_CITY_CODE")
    private String parentCityCode;

    @Column(name = "CITY_CODE")
    private String cityCode;

    @Column(name = "STATION_CNT")
    private Integer stationCnt;

    @Column(name = "USER_CNT")
    private Integer userCnt;

    @Column(name = "STATION_CNT_NOT_2I2C")
    private Integer stationCntNot2i2c;

    @Column(name = "STATION_CNT_FREE")
    private Integer stationCntFree;

    @Column(name = "STATION_CNT_NORMAL")
    private Integer stationCntNormal;

    @Column(name = "USER_CNT_QF")
    private Integer userCntQf;

    @Column(name = "USER_CNT_XH")
    private Integer userCntXh;

    @Column(name = "CITY_LEVEL")
    private Short cityLevel;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "DATA_TIME")
    private Integer dataTime;

    /**
     * @return PARENT_CITY_CODE
     */
    public String getParentCityCode() {
        return parentCityCode;
    }

    /**
     * @param parentCityCode
     */
    public void setParentCityCode(String parentCityCode) {
        this.parentCityCode = parentCityCode;
    }

    /**
     * @return CITY_CODE
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * @return STATION_CNT
     */
    public Integer getStationCnt() {
        return stationCnt;
    }

    /**
     * @param stationCnt
     */
    public void setStationCnt(Integer stationCnt) {
        this.stationCnt = stationCnt;
    }

    /**
     * @return USER_CNT
     */
    public Integer getUserCnt() {
        return userCnt;
    }

    /**
     * @param userCnt
     */
    public void setUserCnt(Integer userCnt) {
        this.userCnt = userCnt;
    }

    /**
     * @return STATION_CNT_NOT_2I2C
     */
    public Integer getStationCntNot2i2c() {
        return stationCntNot2i2c;
    }

    /**
     * @param stationCntNot2i2c
     */
    public void setStationCntNot2i2c(Integer stationCntNot2i2c) {
        this.stationCntNot2i2c = stationCntNot2i2c;
    }

    /**
     * @return STATION_CNT_FREE
     */
    public Integer getStationCntFree() {
        return stationCntFree;
    }

    /**
     * @param stationCntFree
     */
    public void setStationCntFree(Integer stationCntFree) {
        this.stationCntFree = stationCntFree;
    }

    /**
     * @return STATION_CNT_NORMAL
     */
    public Integer getStationCntNormal() {
        return stationCntNormal;
    }

    /**
     * @param stationCntNormal
     */
    public void setStationCntNormal(Integer stationCntNormal) {
        this.stationCntNormal = stationCntNormal;
    }

    /**
     * @return USER_CNT_QF
     */
    public Integer getUserCntQf() {
        return userCntQf;
    }

    /**
     * @param userCntQf
     */
    public void setUserCntQf(Integer userCntQf) {
        this.userCntQf = userCntQf;
    }

    /**
     * @return USER_CNT_XH
     */
    public Integer getUserCntXh() {
        return userCntXh;
    }

    /**
     * @param userCntXh
     */
    public void setUserCntXh(Integer userCntXh) {
        this.userCntXh = userCntXh;
    }

    /**
     * @return CITY_LEVEL
     */
    public Short getCityLevel() {
        return cityLevel;
    }

    /**
     * @param cityLevel
     */
    public void setCityLevel(Short cityLevel) {
        this.cityLevel = cityLevel;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return DATA_TIME
     */
    public Integer getDataTime() {
        return dataTime;
    }

    /**
     * @param dataTime
     */
    public void setDataTime(Integer dataTime) {
        this.dataTime = dataTime;
    }
}