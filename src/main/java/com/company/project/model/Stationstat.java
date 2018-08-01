package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_2I2C_EPARCHY_USER_STAION")
public class Stationstat {
    @Column(name = "DATA_TIME")
    private Integer dataTime;

    @Id
    @Column(name = "EPARCHY_CODE")
    private String eparchyCode;

    @Column(name = "EPARCHY_NAME")
    private String eparchyName;

    @Column(name = "STATION_CNT_4G")
    private String stationCnt4g;

    @Column(name = "USER_CNT")
    private String userCnt;

    @Column(name = "USER_CNT_2I2C")
    private String userCnt2i2c;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

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

    /**
     * @return EPARCHY_CODE
     */
    public String getEparchyCode() {
        return eparchyCode;
    }

    /**
     * @param eparchyCode
     */
    public void setEparchyCode(String eparchyCode) {
        this.eparchyCode = eparchyCode;
    }

    /**
     * @return EPARCHY_NAME
     */
    public String getEparchyName() {
        return eparchyName;
    }

    /**
     * @param eparchyName
     */
    public void setEparchyName(String eparchyName) {
        this.eparchyName = eparchyName;
    }

    /**
     * @return STATION_CNT_4G
     */
    public String getStationCnt4g() {
        return stationCnt4g;
    }

    /**
     * @param stationCnt4g
     */
    public void setStationCnt4g(String stationCnt4g) {
        this.stationCnt4g = stationCnt4g;
    }

    /**
     * @return USER_CNT
     */
    public String getUserCnt() {
        return userCnt;
    }

    /**
     * @param userCnt
     */
    public void setUserCnt(String userCnt) {
        this.userCnt = userCnt;
    }

    /**
     * @return USER_CNT_2I2C
     */
    public String getUserCnt2i2c() {
        return userCnt2i2c;
    }

    /**
     * @param userCnt2i2c
     */
    public void setUserCnt2i2c(String userCnt2i2c) {
        this.userCnt2i2c = userCnt2i2c;
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
}