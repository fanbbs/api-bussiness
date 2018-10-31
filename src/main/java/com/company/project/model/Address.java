package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

//@Table(name = "DJB_ADDRESS")
@Table(name = "ADDRESS")
public class Address {
//    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select SEQ_ADDRESS.nextval from dual")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select nextval('SEQ_ADDRESS')")
    @Id
    @Column(name = "\"ADDRESS_ID\"")
    private Integer addressId;

    @Column(name = "\"ADDR_TYPE_CD\"")
    private Integer addrTypeCd;

    @Column(name = "\"ADDR_STATUS_CD\"")
    private Integer addrStatusCd;

    @Column(name = "\"GEOGRAPHY_LOC_ID\"")
    private Long geographyLocId;

    @Column(name = "\"UP_GEO_LOC_ID\"")
    private Long upGeoLocId;

    @Column(name = "\"AREA_ID\"")
    private Integer areaId;

    @Column(name = "\"SIMPLE_SPELL\"")
    private String simpleSpell;

    @Column(name = "\"NAME\"")
    private String name;

    @Column(name = "\"DISPLAY_NAME\"")
    private String displayName;

    @Column(name = "\"FULL_NAME\"")
    private String fullName;

    @Column(name = "\"FULL_SIMPLE_SPELL\"")
    private String fullSimpleSpell;

    @Column(name = "\"IS_KEY_NAME\"")
    private String isKeyName;

    @Column(name = "\"DESCRIPTION\"")
    private String description;

    @Column(name = "\"CREATED_DT\"")
    private Date createdDt;

    @Column(name = "\"EXP_DT\"")
    private Date expDt;

    @Column(name = "\"VERSION\"")
    private Date version;

    @Column(name = "\"STAFF_ID\"")
    private String staffId;

    @Column(name = "\"PUB_DICT_ID\"")
    private Long pubDictId;

    @Column(name = "\"PUB_DICT_VALU_ID\"")
    private Short pubDictValuId;

    @Column(name = "\"IS_USERADDR\"")
    private String isUseraddr;

    @Column(name = "\"IS_RSC\"")
    private Short isRsc;

    @Column(name = "\"DISPLAY_TYPE_CD\"")
    private Integer displayTypeCd;

    @Column(name = "\"CHOICE_MESSAGE\"")
    private String choiceMessage;

    @Column(name = "\"OLD_ADDRESS_ID\"")
    private String oldAddressId;

    @Column(name = "\"DATA_SOURCE\"")
    private Integer dataSource;

    @Column(name = "\"WASH_FLAG\"")
    private Integer washFlag;

    @Column(name = "\"ADDRESS_TYPE\"")
    private Integer addressType;

    @Column(name = "\"IS_LEAF\"")
    private Short isLeaf;

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
     * @return ADDR_TYPE_CD
     */
    public Integer getAddrTypeCd() {
        return addrTypeCd;
    }

    /**
     * @param addrTypeCd
     */
    public void setAddrTypeCd(Integer addrTypeCd) {
        this.addrTypeCd = addrTypeCd;
    }

    /**
     * @return ADDR_STATUS_CD
     */
    public Integer getAddrStatusCd() {
        return addrStatusCd;
    }

    /**
     * @param addrStatusCd
     */
    public void setAddrStatusCd(Integer addrStatusCd) {
        this.addrStatusCd = addrStatusCd;
    }

    /**
     * @return GEOGRAPHY_LOC_ID
     */
    public Long getGeographyLocId() {
        return geographyLocId;
    }

    /**
     * @param geographyLocId
     */
    public void setGeographyLocId(Long geographyLocId) {
        this.geographyLocId = geographyLocId;
    }

    /**
     * @return UP_GEO_LOC_ID
     */
    public Long getUpGeoLocId() {
        return upGeoLocId;
    }

    /**
     * @param upGeoLocId
     */
    public void setUpGeoLocId(Long upGeoLocId) {
        this.upGeoLocId = upGeoLocId;
    }

    /**
     * @return AREA_ID
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * @return SIMPLE_SPELL
     */
    public String getSimpleSpell() {
        return simpleSpell;
    }

    /**
     * @param simpleSpell
     */
    public void setSimpleSpell(String simpleSpell) {
        this.simpleSpell = simpleSpell;
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
     * @return DISPLAY_NAME
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
     * @return FULL_SIMPLE_SPELL
     */
    public String getFullSimpleSpell() {
        return fullSimpleSpell;
    }

    /**
     * @param fullSimpleSpell
     */
    public void setFullSimpleSpell(String fullSimpleSpell) {
        this.fullSimpleSpell = fullSimpleSpell;
    }

    /**
     * @return IS_KEY_NAME
     */
    public String getIsKeyName() {
        return isKeyName;
    }

    /**
     * @param isKeyName
     */
    public void setIsKeyName(String isKeyName) {
        this.isKeyName = isKeyName;
    }

    /**
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return CREATED_DT
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * @param createdDt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * @return EXP_DT
     */
    public Date getExpDt() {
        return expDt;
    }

    /**
     * @param expDt
     */
    public void setExpDt(Date expDt) {
        this.expDt = expDt;
    }

    /**
     * @return VERSION
     */
    public Date getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Date version) {
        this.version = version;
    }

    /**
     * @return STAFF_ID
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * @return PUB_DICT_ID
     */
    public Long getPubDictId() {
        return pubDictId;
    }

    /**
     * @param pubDictId
     */
    public void setPubDictId(Long pubDictId) {
        this.pubDictId = pubDictId;
    }

    /**
     * @return PUB_DICT_VALU_ID
     */
    public Short getPubDictValuId() {
        return pubDictValuId;
    }

    /**
     * @param pubDictValuId
     */
    public void setPubDictValuId(Short pubDictValuId) {
        this.pubDictValuId = pubDictValuId;
    }

    /**
     * @return IS_USERADDR
     */
    public String getIsUseraddr() {
        return isUseraddr;
    }

    /**
     * @param isUseraddr
     */
    public void setIsUseraddr(String isUseraddr) {
        this.isUseraddr = isUseraddr;
    }

    /**
     * @return IS_RSC
     */
    public Short getIsRsc() {
        return isRsc;
    }

    /**
     * @param isRsc
     */
    public void setIsRsc(Short isRsc) {
        this.isRsc = isRsc;
    }

    /**
     * @return DISPLAY_TYPE_CD
     */
    public Integer getDisplayTypeCd() {
        return displayTypeCd;
    }

    /**
     * @param displayTypeCd
     */
    public void setDisplayTypeCd(Integer displayTypeCd) {
        this.displayTypeCd = displayTypeCd;
    }

    /**
     * @return CHOICE_MESSAGE
     */
    public String getChoiceMessage() {
        return choiceMessage;
    }

    /**
     * @param choiceMessage
     */
    public void setChoiceMessage(String choiceMessage) {
        this.choiceMessage = choiceMessage;
    }

    /**
     * @return OLD_ADDRESS_ID
     */
    public String getOldAddressId() {
        return oldAddressId;
    }

    /**
     * @param oldAddressId
     */
    public void setOldAddressId(String oldAddressId) {
        this.oldAddressId = oldAddressId;
    }

    /**
     * @return DATA_SOURCE
     */
    public Integer getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource
     */
    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return WASH_FLAG
     */
    public Integer getWashFlag() {
        return washFlag;
    }

    /**
     * @param washFlag
     */
    public void setWashFlag(Integer washFlag) {
        this.washFlag = washFlag;
    }

    /**
     * @return ADDRESS_TYPE
     */
    public Integer getAddressType() {
        return addressType;
    }

    /**
     * @param addressType
     */
    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    /**
     * @return IS_LEAF
     */
    public Short getIsLeaf() {
        return isLeaf;
    }

    /**
     * @param isLeaf
     */
    public void setIsLeaf(Short isLeaf) {
        this.isLeaf = isLeaf;
    }
}