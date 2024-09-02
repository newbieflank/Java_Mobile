package com.example.materipakhuda.Home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.example.materipakhuda.R;

public class HomeActivity extends AppCompatActivity {

    EditText editFullname, editEmail;
    Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        editFullname = findViewById(R.id.editFullname);
        editEmail = findViewById(R.id.editEmail);
        btnLogin = findViewById(R.id.button);


        String Value = editFullname.getText().toString();
        String val = editEmail.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(Value);
            }
        });
    }



    private void showToast(String Name) {
        Toast.makeText(HomeActivity.this, "Anda Berhasil Nyasar" + Name, Toast.LENGTH_SHORT).show();
    }
}