package com.andybrook.model.common;

import org.springframework.util.StringUtils;

import java.util.Locale;
import java.util.Objects;

public final class Address {

    private String streetNumber;
    private String streetName;
    private String city;
    private String country;
    private Integer zipCode;

    public Address(String streetNumber, String streetName, String city, String country, Integer zipCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String format(Locale locale) {
        StringBuilder sb = new StringBuilder();
        String number = ! StringUtils.isEmpty(streetNumber) ? streetNumber : "";
        String name = ! StringUtils.isEmpty(streetName) ? streetName : "";
        String cityName = ! StringUtils.isEmpty(city) ? city : "";
        String countryName = ! StringUtils.isEmpty(country) ? country : "";
        String zipCodeStr = zipCode != null ? zipCode.toString() : "";
        return Locale.FRANCE.equals(locale) || Locale.FRENCH.equals(locale)
                ? sb.append(number).append(", ").append(name).append(" - ").append(zipCodeStr).append(" ").append(cityName).append(" - ").append(countryName).toString()
                : sb.append(name).append(", ").append(number).append(" ").append(zipCodeStr).append(" ").append(cityName).append(" - ").append(countryName).toString();
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetNumber, address.streetNumber) &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country) &&
                Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName, city, country, zipCode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("streetNumber='").append(streetNumber).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", zipCode=").append(zipCode);
        sb.append('}');
        return sb.toString();
    }
}
