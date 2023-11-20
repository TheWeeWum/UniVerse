package com.entity.building;

public class Address {
    private final String street;
    private final String city;
    private final String province;
    private final String country;
    private final String postal;
    public Address(String street, String city, String province, String country, String postal) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postal = postal;
    }

    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getProvince() {
        return province;
    }
    public String getCountry() {
        return country;
    }
    public String getPostal() {
        return postal;
    }
}
