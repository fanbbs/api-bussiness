package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Picture {

//    @SequenceGenerator(name="id_seq",sequenceName="seq_picture", allocationSize=1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_seq")

    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select SEQ_PICTURE.nextval from dual")
    @Id
    @Column(name = "PICTURE_ID")
    private Integer pictureId;

    @Column(name = "ADDRESS_ID")
    private Integer addressId;

//    @Column(name = "PICTURE_NAME")
//    private String pictureName;

    @Column(name = "PICTURE_PATH")
    private String picturePath;

//    @Column(name = "THUMBNAIL_PATH")
//    private String thumbnailPath;
//
//    @Column(name = "NET_PICTURE_PATH")
//    private String netPicturePath;
//
//    @Column(name = "NET_THUMBNAIL_PATH")
//    private String netThumbnailPath;
//
//    @Column(name = "UPDATE_DATE")
//    private Date updateDate;

    @Column(name = "USE_TYPE")
    private String useType;

//    @Column(name = "STATUS")
//    private Short status;

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

//    /**
//     * @return PICTURE_NAME
//     */
//    public String getPictureName() {
//        return pictureName;
//    }
//
//    /**
//     * @param pictureName
//     */
//    public void setPictureName(String pictureName) {
//        this.pictureName = pictureName;
//    }

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

//    /**
//     * @return THUMBNAIL_PATH
//     */
//    public String getThumbnailPath() {
//        return thumbnailPath;
//    }
//
//    /**
//     * @param thumbnailPath
//     */
//    public void setThumbnailPath(String thumbnailPath) {
//        this.thumbnailPath = thumbnailPath;
//    }
//
//    /**
//     * @return NET_PICTURE_PATH
//     */
//    public String getNetPicturePath() {
//        return netPicturePath;
//    }
//
//    /**
//     * @param netPicturePath
//     */
//    public void setNetPicturePath(String netPicturePath) {
//        this.netPicturePath = netPicturePath;
//    }
//
//    /**
//     * @return NET_THUMBNAIL_PATH
//     */
//    public String getNetThumbnailPath() {
//        return netThumbnailPath;
//    }
//
//    /**
//     * @param netThumbnailPath
//     */
//    public void setNetThumbnailPath(String netThumbnailPath) {
//        this.netThumbnailPath = netThumbnailPath;
//    }
//
//    /**
//     * @return UPDATE_DATE
//     */
//    public Date getUpdateDate() {
//        return updateDate;
//    }
//
//    /**
//     * @param updateDate
//     */
//    public void setUpdateDate(Date updateDate) {
//        this.updateDate = updateDate;
//    }

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

//    /**
//     * @return STATUS
//     */
//    public Short getStatus() {
//        return status;
//    }
//
//    /**
//     * @param status
//     */
//    public void setStatus(Short status) {
//        this.status = status;
//    }
}