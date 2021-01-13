package com.example.contactapp.datebase;


import androidx.room.TypeConverter;

import com.example.contactapp.modual.ContactDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Converter {


    @TypeConverter
    public String ConverToGeson(ContactDetails contactDetails)
    {
        return new Gson().toJson(contactDetails);
    }

    @TypeConverter
    public ContactDetails ConverFromGeson(String gson)
    {
        return new Gson().fromJson(gson , ContactDetails.class );
    }


}
