package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "\"wy_district_info\"")
public class District {
    @Id
    @Column(name = "\"DISTRICT_ID\"")
    private Integer districtId;

    @Column(name = "\"CITY_ID\"")
    private String cityId;

    @Column(name = "\"DISTRICT_NAME\"")
    private String districtName;

    @Column(name = "\"CREATE_STAFF_ID\"")
    private String createStaffId;

    @Column(name = "\"CREATE_DATE\"")
    private Date createDate;

    @Column(name = "\"UPDATE_STAFF_ID\"")
    private String updateStaffId;

    @Column(name = "\"UPDATE_DATE\"")
    private Date updateDate;

    @Column(name = "\"EPARCHY_CODE\"")
    private String eparchyCode;

    @Column(name = "\"CITY_CODE\"")
    private String cityCode;

    @Column(name = "\"CITY_NAME\"")
    private String cityName;

    @Column(name = "\"CITY_OR_NOTCITY\"")
    private String cityOrNotcity;

    /**
     * @return district_id
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * @return city_id
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * @return district_name
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * @return create_staff_id
     */
    public String getCreateStaffId() {
        return createStaffId;
    }

    /**
     * @param createStaffId
     */
    public void setCreateStaffId(String createStaffId) {
        this.createStaffId = createStaffId;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return update_staff_id
     */
    public String getUpdateStaffId() {
        return updateStaffId;
    }

    /**
     * @param updateStaffId
     */
    public void setUpdateStaffId(String updateStaffId) {
        this.updateStaffId = updateStaffId;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return eparchy_code
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
     * @return city_code
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
     * @return city_name
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
     * @return city_or_notcity
     */
    public String getCityOrNotcity() {
        return cityOrNotcity;
    }

    /**
     * @param cityOrNotcity
     */
    public void setCityOrNotcity(String cityOrNotcity) {
        this.cityOrNotcity = cityOrNotcity;
    }
}