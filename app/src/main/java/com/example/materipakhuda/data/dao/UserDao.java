// UserDao.java
package com.example.materipakhuda.data.dao;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import  com.example.materipakhuda.data.model.user;

import java.util.List;

@Dao
@Entity(tableName = "user_table")
public interface UserDao {

    @Insert
    void insert(user user);

    @Query("SELECT * FROM user WHERE id = :id")
    user getUserById(int id);

    @Query("SELECT * FROM user")
    List<user> getAllUsers();

    @Query("DELETE FROM user")
    void deleteAll();
}
