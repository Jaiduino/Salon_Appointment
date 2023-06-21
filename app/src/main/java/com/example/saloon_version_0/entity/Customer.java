package com.example.saloon_version_0.entity;

public class Customer {
    private int customer_Id;
    private String fullName;
    private String email_Id;
    private String mobileNo;
    private String gender;
    private String building_No;
    private String area_Name;
    private int pincode;
    private String password;
    private int enabled;

    public Customer() {
    }

    public Customer(int customer_Id, String fullName, String email_Id, String mobileNo, String gender, String buildingNo, String areaName, int pincode, String password, int enabled) {
        this.customer_Id = customer_Id;
        this.fullName = fullName;
        this.email_Id = email_Id;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.building_No = buildingNo;
        this.area_Name = areaName;
        this.pincode = pincode;
        this.password = password;
        this.enabled = enabled;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail_Id() {
        return email_Id;
    }

    public void setEmail_Id(String email_Id) {
        this.email_Id = email_Id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBuildingNo() {
        return building_No;
    }

    public void setBuildingNo(String buildingNo) {
        this.building_No = buildingNo;
    }

    public String getAreaName() {
        return area_Name;
    }

    public void setAreaName(String areaName) {
        this.area_Name = areaName;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_Id=" + customer_Id +
                ", fullName='" + fullName + '\'' +
                ", email_Id='" + email_Id + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", gender='" + gender + '\'' +
                ", buildingNo='" + building_No + '\'' +
                ", areaName='" + area_Name + '\'' +
                ", pincode=" + pincode +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
