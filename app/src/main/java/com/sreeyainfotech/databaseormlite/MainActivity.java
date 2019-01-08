package com.sreeyainfotech.databaseormlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button create_contact,contacts_list;
    private Button spinner_btn;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        }

    private void findViewById() {
        create_contact=(Button)findViewById(R.id.create_contact);
        create_contact.setOnClickListener(this);

        contacts_list=(Button)findViewById(R.id.contacts_list);
        contacts_list.setOnClickListener(this);

        spinner_btn=(Button)findViewById(R.id.spinner_btn);
        spinner_btn.setOnClickListener(this);

        login_btn=(Button)findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.create_contact:
                Intent intent=new Intent(MainActivity.this,CreateContact.class);
                startActivity(intent);
                break;

            case R.id.contacts_list:
                Intent intent1=new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(intent1);
                break;

            case R.id.spinner_btn:
                Intent i1=new Intent(MainActivity.this,SortingActivity.class);
                startActivity(i1);
                break;

            case R.id.login_btn:
                Intent login=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(login);
                break;
        }

    }

    // delete paticuler row get adapeter to take postion and model; class
  //  modelDao.delete(scannedBarcode);

    // i.e total deleting database
   // mContext.deleteDatabase("TOC.db");

}
