package com.example.amit_retail_app.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class RoomFactory {
    private RoomFactory(){

    }

    private static ProductDatabase productDatabase;
    public static ProductDatabase createRoomObject(Context context)
    {
        if(productDatabase==null)
        {
         productDatabase= Room.databaseBuilder(context,ProductDatabase.class,"products_database").build();
        }
return productDatabase;
    }
}
