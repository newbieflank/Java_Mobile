package com.example.materipakhuda.ui.Home;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import com.example.materipakhuda.R;
import com.example.materipakhuda.viewmodel.UserViewModel;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    //viewModel
    private UserViewModel userViewModel;

    //element
    private EditText editFullname, editEmail, editUsername, editPassword, editNumber, editAddress, datePick;
    private Spinner genderPick;
    private Button btnRegister, dateChoose;
    private String username, email, fullname, date, password, address, gender, birth, number;

    //handler
    private boolean isBackPressedOnce = false; // Flag to track back button press
    private Handler backPressHandler = new Handler(); // Handler to reset the flag


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        hideSystemUI();

//        userViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(UserViewModel.class);

        //edit text
        editFullname = findViewById(R.id.edit_Fullname);
        editEmail = findViewById(R.id.edit_Email);
        editUsername = findViewById(R.id.edit_Username);
        editPassword = findViewById(R.id.edit_password);
        editAddress = findViewById(R.id.edit_Address);
        genderPick = findViewById(R.id.gender_pick);
        editNumber = findViewById(R.id.edit_number);

        //date pick
        datePick = findViewById(R.id.date_pick);


        //button
        btnRegister = findViewById(R.id.btn_register);
        dateChoose = findViewById(R.id.date_choose);



        //listener
        dateChoose.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Create and show the DatePickerDialog
            new DatePickerDialog(HomeActivity.this, (view, year1, month1, dayOfMonth) -> {
                // Handle date chosen
                date = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                datePick.setText(date);
            }, year, month, day).show();
        });





        btnRegister.setOnClickListener(v -> {

            //value
            username = editUsername.getText().toString();
            email = editEmail.getText().toString();
            fullname = editFullname.getText().toString();
            password = editPassword.getText().toString();
            birth = datePick.getText().toString();
            address = editAddress.getText().toString();
            number = editNumber.getText().toString();
            gender = genderPick.getSelectedItem().toString();


            try {
//                user user = new user();
//                user.setUsername(username);
//                user.setEmail(email);
//                user.setAddress(address);
//                user.setBirth(birth);
//                user.setFullname(fullname);
//                user.setGender(gender);
//                user.setPassword(password);
//                user.setNumber(Integer.parseInt(number));
//                userViewModel.insert(user);
                showToast("Welcome " + username + ", your email is" + email + "\n" +
                        "and your date of birth " + birth);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void hideSystemUI() {
        // Hide both the status bar and the navigation bar with IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI(); // Reapply immersive mode if focus is regained
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.isBackPressedOnce = true;
        showToast("Press back again to exit");

        //reset after 2 sec
        backPressHandler.postDelayed(() -> isBackPressedOnce = false, 2000);
    }

}