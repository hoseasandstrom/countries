package com.studenttheironyard;


/**
 * Created by hoseasandstrom on 5/26/16.
 */
public class Country {
    String countryCode;
    String country;

    public Country(String countryCode, String country) {
        this.countryCode = countryCode;
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "*" + countryCode +  "-" + country;
    }
}



