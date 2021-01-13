package com.example.contactapp.datebase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = {ContactUser.class} , version = 5 , exportSchema = false)
@TypeConverters(Converter.class)
public abstract class ContactDatebase extends RoomDatabase {
    private static ContactDatebase contactDatebase ;
    private static final String DB_NAME = "ContactDatebase" ;
    public abstract UserQuery GetQuery();


    public static ContactDatebase getContactDatebaseInstance(Context con ) {
        if (contactDatebase == null )
        {
            contactDatebase = Room.databaseBuilder(con , ContactDatebase.class , DB_NAME ).
                    allowMainThreadQueries().
                    fallbackToDestructiveMigration().
                    build();
        }
        return contactDatebase;
    }
}
