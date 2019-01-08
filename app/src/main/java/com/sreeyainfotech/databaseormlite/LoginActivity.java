package com.sreeyainfotech.databaseormlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.sreeyainfotech.databaseormlite.database.DatabaseHelper;
import com.sreeyainfotech.databaseormlite.model.Contact;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName, password;
    Button login_button;
    TextView showdata;
    private String UserName_str,Password_str;
    private DatabaseHelper helper;
    private Dao<Contact, Integer> loginDao;
    List<Contact> login_list=new ArrayList<>();
    Contact checkLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        helper = new DatabaseHelper(LoginActivity.this);

        findViewes();
    }

    private void findViewes() {
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        showdata = (TextView) findViewById(R.id.showdata);
        login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.login_button:
                LoginFunction();
                break;
        }

    }

    private void LoginFunction() {
        UserName_str=userName.getText().toString();
        Password_str=password.getText().toString();

        try {
            loginDao = helper.getContactDao();
            login_list = loginDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        checkLogin = getSelectedInfo(UserName_str, Password_str);
        if (checkLogin != null) {

            showdata.setText(checkLogin.getName()+"\n"+checkLogin.getAddress()+checkLogin.getMobile_Number()+"\n");
            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(LoginActivity.this, "Please Try again", Toast.LENGTH_SHORT).show();
        }
    }


    private Contact getSelectedInfo(String userName, String password) {

        if (login_list != null && login_list.size() > 0) {
            for (Contact autoFill : login_list) {
                if (userName.equals(autoFill.getEmail())) {

                    if (password.equals(autoFill.getPassword())) {
                        return autoFill;
                    }

                }
            }
        }
        return null;
    }


}
