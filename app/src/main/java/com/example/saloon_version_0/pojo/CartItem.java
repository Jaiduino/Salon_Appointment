package com.example.saloon_version_0.pojo;

public class CartItem
{
    private int SrNo;
    private String ServiceName;
    private String ServicePrice;

    public CartItem(int srNo, String serviceName, String servicePrice)
    {
        SrNo = srNo;
        ServiceName = serviceName;
        ServicePrice = servicePrice;
    }

    public int getSrNo()
    {
        return SrNo;
    }

    public void setSrNo(int srNo) {
        SrNo = srNo;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getServicePrice() {
        return ServicePrice;
    }

    public void setServicePrice(String servicePrice) {
        ServicePrice = servicePrice;
    }
}
