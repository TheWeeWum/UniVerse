package com.entity.building;

import com.entity.JsonRepresentation;

public class Address implements JsonRepresentation {
    private final String street;
    private final String city;
    private final String province;
    private final String country;
    private final String postal;

    /**
     * @param street the street this building is on.
     * @param city the city this building is in.
     * @param province the province this building is in.
     * @param country the country this building is in.
     * @param postal the postal code of this buildings address.
     */
    public Address(String street, String city, String province, String country, String postal) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postal = postal;
    }

    /**
     * Gets the street this building is on.
     * @return the street this building is on.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Gets the city this building is in.
     * @return the city this building is in.
     */
    public String getCity() {
        return city;
    }

    /**
     * the province this building is in.
     * @return the province this building is in.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Gets the country this building is in.
     * @return the country this building is in.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the postal code of this buildings address.
     * @return the postal code of this buildings address.
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Gets the Json representation of the Address Object in the following format.
     * <pre>
     * {
     *     street: String,
     *     city: String,
     *     province: String,
     *     country: String,
     *     postal: String
     * }
     * </pre>
     * @return String in Json format.
     */
    @Override
    public String getJsonRepresentation() {
        return "{" +
                "street: " + street +
                "," +
                "city: " + city +
                "," +
                "province: " + province +
                "," +
                "country: " + country +
                "," +
                "postal: " + postal +
                "}";
    }

    /**
     * Gets the Json representation of the Address Object in the following format.
     * <pre>
     * {
     *     street: String,
     *     city: String,
     *     province: String,
     *     country: String,
     *     postal: String
     * }
     * </pre>
     * @return String in Json format.
     */
    @Override
    public String getDeadEndJson() {
        return getJsonRepresentation();
    }
}
