package com.example.tehtava7;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.room.Room;

public class IntentPalvelu extends IntentService {

    tauluDao td;
    MyEntity myEntity;


    public IntentPalvelu(String name) {
        super(name);

    }

    public IntentPalvelu(){
        super("kissakoirahevonen");

    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        boolean screen = intent.getBooleanExtra("tila",false);
        String aika = intent.getStringExtra("aika");
        MyEntity myEntity = new MyEntity();
        tietokanta db = Room.databaseBuilder(getApplicationContext(),
                tietokanta.class, "tietoa").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        this.td = db.tauluDao();

        myEntity.aika = aika;
        myEntity.screen = screen;

        td.InsertMyEntity(myEntity);


    }
}
