// UserRepository.java
package com.example.materipakhuda.data.repository;

import android.content.Context;
import com.example.materipakhuda.data.AppDatabase;
import com.example.materipakhuda.data.dao.UserDao;
import com.example.materipakhuda.data.model.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        userDao = db.userDao();
    }

    public void insert(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> userDao.insert(user));
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteAll() {
        AppDatabase.databaseWriteExecutor.execute(userDao::deleteAll);
    }
}
