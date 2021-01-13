package com.example.contactapp.modual;

import java.security.PrivateKey;

public class ContactDetails {
    private String orgnization ;
    private String relation ;
    private String description ;

    public ContactDetails(String orgnization, String relation, String description) {
        this.orgnization = orgnization;
        this.relation = relation;
        this.description = description;
    }

    public String getOrgnization() {
        return orgnization;
    }

    public void setOrgnization(String orgnization) {
        this.orgnization = orgnization;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
