package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_2i2c_station")
public class B2i2cStation {
    @Id
    @Column(name = "\"OBJECTID\"")
    private Integer objectid;

    @Column(name = "\"MONTH_ID\"")
    private Integer monthId;

    @Column(name = "\"DATA_TIME\"")
    private Integer dataTime;

    @Column(name = "\"EPARCHY_NAME\"")
    private String eparchyName;

    @Column(name = "\"CITY_NAME\"")
    private String cityName;

    @Column(name = "\"TOWNS_NAME\"")
    private String townsName;

    @Column(name = "\"STATION_ATTR\"")
    private String stationAttr;

    @Column(name = "\"STATION_ID\"")
    private String stationId;

    @Column(name = "\"STATION_NAME\"")
    private String stationName;

    @Column(name = "\"NET_TYPE_CODE\"")
    private String netTypeCode;

    @Column(name = "\"STATE\"")
    private Integer state;

    @Column(name = "\"USER_CNT\"")
    private Integer userCnt;

    @Column(name = "\"USER_CNT_ZW\"")
    private Integer userCntZw;

    @Column(name = "\"USER_CNT_QF\"")
    private Integer userCntQf;

    @Column(name = "\"USER_CNT_XH\"")
    private Integer userCntXh;

    @Column(name = "\"ADDR_INFO\"")
    private String addrInfo;

    @Column(name = "\"STATE_MSG\"")
    private String stateMsg;

    @Column(name = "\"DISCNT_CODE\"")
    private String discntCode;

    @Column(name = "\"DISCNT_NAME\"")
    private String discntName;

    @Column(name = "\"EPARCHY_CODE\"")
    private String eparchyCode;

    @Column(name = "\"CITY_CODE\"")
    private String cityCode;

    @Column(name = "\"TOWNS_CODE\"")
    private String townsCode;

    @Column(name = "\"UPDATE_TIME\"")
    private Date updateTime;

    @Column(name = "\"CS_VOLUME\"")
    private String csVolume;

    @Column(name = "\"RLC_VOLUME\"")
    private String rlcVolume;

    @Column(name = "\"NEW_BUILD_STATION\"")
    private String newBuildStation;

    private Double x;

    private Double y;

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
     * @return MONTH_ID
     */
    public Integer getMonthId() {
        return monthId;
    }

    /**
     * @param monthId
     */
    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
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
     * @return CITY_NAME
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return TOWNS_NAME
     */
    public String getTownsName() {
        return townsName;
    }

    /**
     * @param townsName
     */
    public void setTownsName(String townsName) {
        this.townsName = townsName;
    }

    /**
     * @return STATION_ATTR
     */
    public String getStationAttr() {
        return stationAttr;
    }

    /**
     * @param stationAttr
     */
    public void setStationAttr(String stationAttr) {
        this.stationAttr = stationAttr;
    }

    /**
     * @return STATION_ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * @param stationId
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
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
     * @return NET_TYPE_CODE
     */
    public String getNetTypeCode() {
        return netTypeCode;
    }

    /**
     * @param netTypeCode
     */
    public void setNetTypeCode(String netTypeCode) {
        this.netTypeCode = netTypeCode;
    }

    /**
     * @return STATE
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
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
     * @return USER_CNT_ZW
     */
    public Integer getUserCntZw() {
        return userCntZw;
    }

    /**
     * @param userCntZw
     */
    public void setUserCntZw(Integer userCntZw) {
        this.userCntZw = userCntZw;
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
     * @return ADDR_INFO
     */
    public String getAddrInfo() {
        return addrInfo;
    }

    /**
     * @param addrInfo
     */
    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    /**
     * @return STATE_MSG
     */
    public String getStateMsg() {
        return stateMsg;
    }

    /**
     * @param stateMsg
     */
    public void setStateMsg(String stateMsg) {
        this.stateMsg = stateMsg;
    }

    /**
     * @return DISCNT_CODE
     */
    public String getDiscntCode() {
        return discntCode;
    }

    /**
     * @param discntCode
     */
    public void setDiscntCode(String discntCode) {
        this.discntCode = discntCode;
    }

    /**
     * @return DISCNT_NAME
     */
    public String getDiscntName() {
        return discntName;
    }

    /**
     * @param discntName
     */
    public void setDiscntName(String discntName) {
        this.discntName = discntName;
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
     * @return TOWNS_CODE
     */
    public String getTownsCode() {
        return townsCode;
    }

    /**
     * @param townsCode
     */
    public void setTownsCode(String townsCode) {
        this.townsCode = townsCode;
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
     * @return CS_VOLUME
     */
    public String getCsVolume() {
        return csVolume;
    }

    /**
     * @param csVolume
     */
    public void setCsVolume(String csVolume) {
        this.csVolume = csVolume;
    }

    /**
     * @return RLC_VOLUME
     */
    public String getRlcVolume() {
        return rlcVolume;
    }

    /**
     * @param rlcVolume
     */
    public void setRlcVolume(String rlcVolume) {
        this.rlcVolume = rlcVolume;
    }

    /**
     * @return NEW_BUILD_STATION
     */
    public String getNewBuildStation() {
        return newBuildStation;
    }

    /**
     * @param newBuildStation
     */
    public void setNewBuildStation(String newBuildStation) {
        this.newBuildStation = newBuildStation;
    }

    /**
     * @return x
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
     * @return y
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
}