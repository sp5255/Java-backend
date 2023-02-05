package com.test.restaurent.model;

public class RestaurentModal {
 
    private int number, totalStaff;    
    private String name, address,specility;

    
    public RestaurentModal(int number, String name, String address, int totalStaff, String specility) {
        this.number = number;
        this.name = name;
        this.address = address;
        this.totalStaff = totalStaff;
        this.specility = specility;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getTotalStaff() {
        return totalStaff;
    }
    public void setTotalStaff(int totalStaff) {
        this.totalStaff = totalStaff;
    }
    public String getSpecility() {
        return specility;
    }
    public void setSpecility(String specility) {
        this.specility = specility;
    }

    
}
