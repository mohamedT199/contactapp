package com.example.contactapp.datebase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserQuery {

    @Insert
    long PutUser(ContactUser contactUser);


    @Query("select * from ContactUser  ")
    List<ContactUser> GetEveryContact();
}
