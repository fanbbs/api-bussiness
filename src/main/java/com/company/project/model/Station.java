package com.company.project.model;

import javax.persistence.*;

@Table(name = "V_STATION_HEAT")
public class Station {

    @Id
    @Column(name = "OBJECTID")
    private Integer objectid;

    @Column(name = "STATION_NAME")
    private String stationName;

    @Column(name = "X")
    private Double x;

    @Column(name = "Y")
    private Double y;

    @Column(name = "USER_CNT")
    private Integer userCnt;

    @Column(name = "EPARCHY_CODE")
    private String eparchyCode;

    /**
     * @return OBJECTID
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * @param objectid
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * @return STATION_NAME
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * @return X
     */
    public Double getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * @return Y
     */
    public Double getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(Double y) {
        this.y = y;
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
}