// UserDao.java
package com.example.materipakhuda.data.dao;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.materipakhuda.data.model.User;

import java.util.List;

@Dao
@Entity(tableName = "user_table")
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM User WHERE id = :id")
    User getUserById(int id);

    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Query("DELETE FROM User")
    void deleteAll();
}
