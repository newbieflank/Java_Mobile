// UserViewModel.java
package com.example.materipakhuda.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;

import com.example.materipakhuda.data.repository.UserRepository;
import com.example.materipakhuda.data.model.user;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private final UserRepository userRepository;
    private final List<user> allUsers;

    public UserViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
    }

    public void insert(user us) {
        userRepository.insert(us);
    }

    public user getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public List<user> getAllUsers() {
        return allUsers;
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
