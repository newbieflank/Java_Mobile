// UserRepository.java
package com.example.materipakhuda.data.repository;

import android.content.Context;
import com.example.materipakhuda.data.AppDatabase;
import com.example.materipakhuda.data.dao.UserDao;
import com.example.materipakhuda.data.model.user;

import java.util.List;
import java.util.concurrent.Executor;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        userDao = db.userDao();
    }

    public void insert(user user) {
        AppDatabase.databaseWriteExecutor.execute(() -> userDao.insert(user));
    }

    public user getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<user> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteAll() {
        AppDatabase.databaseWriteExecutor.execute(userDao::deleteAll);
    }
}
