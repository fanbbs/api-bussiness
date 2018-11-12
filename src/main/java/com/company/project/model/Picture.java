package com.company.project.model;

import javax.persistence.*;

public class Picture {

//    @SequenceGenerator(name="id_seq",sequenceName="seq_picture", allocationSize=1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_seq")

    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select SEQ_PICTURE.nextval from dual")
    @Id
    @Column(name = "\"PICTURE_ID\"")
    private Integer pictureId;

    @Column(name = "\"ADDRESS_ID\"")
    private Integer addressId;

    @Column(name = "\"PICTURE_PATH\"")
    private String picturePath;

    @Column(name = "\"USE_TYPE\"")
    private String useType;

    /**
     * @return PICTURE_ID
     */
    public Integer getPictureId() {
        return pictureId;
    }

    /**
     * @param pictureId
     */
    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

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
     * @return PICTURE_PATH
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     * @param picturePath
     */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    /**
     * @return USE_TYPE
     */
    public String getUseType() {
        return useType;
    }

    /**
     * @param useType
     */
    public void setUseType(String useType) {
        this.useType = useType;
    }

}