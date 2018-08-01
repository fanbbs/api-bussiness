package com.company.project.model;

import javax.persistence.*;

@Table(name = "V_STATION_USER_DETAIL")
public class StationUserDetail {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Object id;

    @Column(name = "EPARCHY_CODE")
    private String eparchyCode;

    @Column(name = "NET_TYPE_CODE")
    private String netTypeCode;

    @Column(name = "STATION_ID")
    private String stationId;

    @Column(name = "STATION_NAME")
    private String stationName;

    @Column(name = "EPARCHY_NAME")
    private String eparchyName;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "X")
    private Double x;

    @Column(name = "Y")
    private Double y;

    @Column(name = "STATE")
    private Short state;

    @Column(name = "STATION_ATTR")
    private String stationAttr;

    @Column(name = "STATE_MSG")
    private String stateMsg;

    @Column(name = "USER_CNT")
    private Integer userCnt;

    @Column(name = "USER_CNT_ZW")
    private Integer userCntZw;

    @Column(name = "USER_CNT_QF")
    private Integer userCntQf;

    @Column(name = "USER_CNT_XH")
    private Integer userCntXh;

    @Column(name = "CS_VOLUME")
    private String csVolume;

    @Column(name = "RLC_VOLUME")
    private String rlcVolume;

    @Column(name = "DATA_TIME")
    private Integer dataTime;

    /**
     * @return ID
     */
    public Object getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Object id) {
        this.id = id;
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
     * @return STATE
     */
    public Short getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Short state) {
        this.state = state;
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