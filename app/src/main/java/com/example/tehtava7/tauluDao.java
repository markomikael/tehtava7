package com.example.tehtava7;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Dao;

import java.util.List;

@Dao

public interface tauluDao {

    @Query("SELECT * FROM myentity ORDER BY avain desc")
    List<MyEntity> getAllInDescendingOrder();

    @Insert
    void InsertMyEntity(MyEntity myEntity);

    @Delete
    void DeleteMyEntity(MyEntity myentity);
}








