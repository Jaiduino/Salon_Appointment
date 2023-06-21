package com.example.saloon_version_0.pojo;

public class Appointements
{
    private String ServiceName;
    private String ServiceDate;
    private String ServicePrice;

    public Appointements(String serviceName, String serviceDate, String servicePrice) {
        ServiceName = serviceName;
        ServiceDate = serviceDate;
        ServicePrice = servicePrice;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getServiceDate() {
        return ServiceDate;
    }

    public void setServiceDate(String serviceDate) {
        ServiceDate = serviceDate;
    }

    public String getServicePrice() {
        return ServicePrice;
    }

    public void setServicePrice(String servicePrice) {
        ServicePrice = servicePrice;
    }
}
