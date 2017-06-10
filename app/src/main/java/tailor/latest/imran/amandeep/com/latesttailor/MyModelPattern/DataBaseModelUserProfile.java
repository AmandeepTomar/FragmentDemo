package tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern;

import java.io.Serializable;

/**
 * Created by admin on 9/27/2016.
 */

public class DataBaseModelUserProfile implements Serializable {
    private String userId;
    private String userName;
    private String userMailId;
    private String password;
    private String mobileNo;
    private String image;
    private String createdOn;
    private String userDeviceId;

    public DataBaseModelUserProfile() {
    }

    public DataBaseModelUserProfile(String userId,String userName, String userMailId, String password,
                                    String mobileNo, String image,String createdOn,String userDeviceId) {
        this.userId=userId;
        this.userName = userName;
        this.userMailId = userMailId;
        this.password = password;
        this.mobileNo = mobileNo;
        this.image = image;
        this.createdOn=createdOn;
        this.userDeviceId=userDeviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMailId() {
        return userMailId;
    }

    public void setUserMailId(String userMailId) {
        this.userMailId = userMailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUserDeviceId() {
        return userDeviceId;
    }

    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }
}
