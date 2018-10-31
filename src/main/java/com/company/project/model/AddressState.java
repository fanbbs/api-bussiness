package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "REP_ADDR_INFO_SALE")
public class AddressState {

    @Id
    @Column(name = "\"ADDRESS_ID\"")
    private Integer addressId;

    @Column(name = "\"NAME\"")
    private String name;

    @Column(name = "\"ADDRESS_TYPE\"")
    private String addressType;

    @Column(name = "\"PROV\"")
    private String prov;

    @Column(name = "\"LATN_NAME\"")
    private String latnName;

    @Column(name = "\"LATN_ID\"")
    private String latnId;

    @Column(name = "\"AREA_NAME\"")
    private String areaName;

    @Column(name = "\"AREA_ID\"")
    private BigDecimal areaId;

    @Column(name = "\"ZONE\"")
    private String zone;

    @Column(name = "\"CELLNUM\"")
    private BigDecimal cellnum;

    @Column(name = "\"HOUSENUM\"")
    private BigDecimal housenum;

    @Column(name = "\"MAXFLOOR\"")
    private BigDecimal maxfloor;

    @Column(name = "\"PLATENUM\"")
    private BigDecimal platenum;

    @Column(name = "\"DUTY_NAME\"")
    private String dutyName;

    @Column(name = "\"BUREAU_NAME\"")
    private String bureauName;

    @Column(name = "\"GRID_NAME\"")
    private String gridName;

    @Column(name = "\"B_DATE\"")
    private Date bDate;

    @Column(name = "\"FULL_NAME\"")
    private String fullName;

    @Column(name = "\"DUTY_ID\"")
    private BigDecimal dutyId;

    @Column(name = "\"BUREAU_ID\"")
    private String bureauId;

    @Column(name = "\"GRID_ID\"")
    private String gridId;

    /**
     * @return ADDRESS_ID
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * @param addressId
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return ADDRESS_TYPE
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * @param addressType
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * @return PROV
     */
    public String getProv() {
        return prov;
    }

    /**
     * @param prov
     */
    public void setProv(String prov) {
        this.prov = prov;
    }

    /**
     * @return LATN_NAME
     */
    public String getLatnName() {
        return latnName;
    }

    /**
     * @param latnName
     */
    public void setLatnName(String latnName) {
        this.latnName = latnName;
    }

    /**
     * @return LATN_ID
     */
    public String getLatnId() {
        return latnId;
    }

    /**
     * @param latnId
     */
    public void setLatnId(String latnId) {
        this.latnId = latnId;
    }

    /**
     * @return AREA_NAME
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return AREA_ID
     */
    public BigDecimal getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(BigDecimal areaId) {
        this.areaId = areaId;
    }

    /**
     * @return ZONE
     */
    public String getZone() {
        return zone;
    }

    /**
     * @param zone
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * @return CELLNUM
     */
    public BigDecimal getCellnum() {
        return cellnum;
    }

    /**
     * @param cellnum
     */
    public void setCellnum(BigDecimal cellnum) {
        this.cellnum = cellnum;
    }

    /**
     * @return HOUSENUM
     */
    public BigDecimal getHousenum() {
        return housenum;
    }

    /**
     * @param housenum
     */
    public void setHousenum(BigDecimal housenum) {
        this.housenum = housenum;
    }

    /**
     * @return MAXFLOOR
     */
    public BigDecimal getMaxfloor() {
        return maxfloor;
    }

    /**
     * @param maxfloor
     */
    public void setMaxfloor(BigDecimal maxfloor) {
        this.maxfloor = maxfloor;
    }

    /**
     * @return PLATENUM
     */
    public BigDecimal getPlatenum() {
        return platenum;
    }

    /**
     * @param platenum
     */
    public void setPlatenum(BigDecimal platenum) {
        this.platenum = platenum;
    }

    /**
     * @return DUTY_NAME
     */
    public String getDutyName() {
        return dutyName;
    }

    /**
     * @param dutyName
     */
    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    /**
     * @return BUREAU_NAME
     */
    public String getBureauName() {
        return bureauName;
    }

    /**
     * @param bureauName
     */
    public void setBureauName(String bureauName) {
        this.bureauName = bureauName;
    }

    /**
     * @return GRID_NAME
     */
    public String getGridName() {
        return gridName;
    }

    /**
     * @param gridName
     */
    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    /**
     * @return B_DATE
     */
    public Date getbDate() {
        return bDate;
    }

    /**
     * @param bDate
     */
    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    /**
     * @return FULL_NAME
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return DUTY_ID
     */
    public BigDecimal getDutyId() {
        return dutyId;
    }

    /**
     * @param dutyId
     */
    public void setDutyId(BigDecimal dutyId) {
        this.dutyId = dutyId;
    }

    /**
     * @return BUREAU_ID
     */
    public String getBureauId() {
        return bureauId;
    }

    /**
     * @param bureauId
     */
    public void setBureauId(String bureauId) {
        this.bureauId = bureauId;
    }

    /**
     * @return GRID_ID
     */
    public String getGridId() {
        return gridId;
    }

    /**
     * @param gridId
     */
    public void setGridId(String gridId) {
        this.gridId = gridId;
    }
}