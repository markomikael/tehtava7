package com.example.tehtava7;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {MyEntity.class},version = 3)
public abstract class tietokanta extends RoomDatabase {

    public  static final String NIMI = "tietoa";
    public abstract  tauluDao tauluDao();












}


