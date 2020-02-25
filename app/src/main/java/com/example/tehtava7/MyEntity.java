package com.example.tehtava7;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity

public class MyEntity {

    @PrimaryKey(autoGenerate = true)
    public int avain;
    public boolean screen;
    public String aika;




}
