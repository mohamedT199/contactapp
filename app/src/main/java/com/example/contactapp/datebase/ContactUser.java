package com.example.contactapp.datebase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.contactapp.modual.ContactDetails;

@Entity
public class ContactUser {
    public ContactUser() {
    }

    @PrimaryKey(autoGenerate = true)
    private int id ;


    private ContactDetails contactDetails ;

    private String name ;

    @ColumnInfo(index = true)
    private String phone ;

    public ContactUser(ContactDetails contactDetails, String name, String phone) {
        this.contactDetails = contactDetails;
        this.name = name;
        this.phone = phone;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
