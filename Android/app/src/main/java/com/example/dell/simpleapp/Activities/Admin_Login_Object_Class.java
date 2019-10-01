package com.example.dell.simpleapp.Activities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin_Login_Object_Class {

    int admin_Id;
    String phoneNo;
    String email;
    String encryptedPassword;
    String resetPasswordToken;
    String signInCount;
    String CurrentSignInAt;
    String lastsignInAt;
    String failedAttempts;
    String locked_At;
    String role;
    String name;
    Boolean isActive;
    Boolean isDeleted;
    String CreatedOn;
    String CreatedBy;
    String UpdateOn;
    String updatedBy;


    public  static  Admin_Login_Object_Class shared = new Admin_Login_Object_Class();

    public int getAdmin_id() {
        return admin_Id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_Id = admin_id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(String signInCount) {
        this.signInCount = signInCount;
    }

    public String getCurrentSignInAt() {
        return CurrentSignInAt;
    }

    public void setCurrentSignInAt(String currentSignInAt) {
        CurrentSignInAt = currentSignInAt;
    }

    public String getLastsignInAt() {
        return lastsignInAt;
    }

    public void setLastsignInAt(String lastsignInAt) {
        this.lastsignInAt = lastsignInAt;
    }

    public String getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(String failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public String getLocked_At() {
        return locked_At;
    }

    public void setLocked_At(String locked_At) {
        this.locked_At = locked_At;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getUpdateOn() {
        return UpdateOn;
    }

    public void setUpdateOn(String updateOn) {
        UpdateOn = updateOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
