package com.sreeyainfotech.databaseormlite;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;
import com.sreeyainfotech.databaseormlite.database.DatabaseHelper;
import com.sreeyainfotech.databaseormlite.model.Contact;

import java.sql.SQLException;
import java.util.List;

public class SortingActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private DatabaseHelper helper;
    private Dao<Contact, Integer> contactsDao;
    private List<Contact> contactdbList;
    private LinearLayout selection_name_lyt;
    private TextView selected_name_txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorting_screen);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        helper = new DatabaseHelper(SortingActivity.this);

        try {

            contactsDao = helper.getContactDao();
            contactdbList = contactsDao.queryForAll();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        findViewes();
    }

    private void findViewes() {
        selection_name_lyt = (LinearLayout) findViewById(R.id.selection_name_lyt);
        selection_name_lyt.setOnClickListener(this);

        selected_name_txt=(TextView)findViewById(R.id.selected_name_txt);
    }

    private void spinner() {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(SortingActivity.this);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SortingActivity.this, R.layout.simple_textview);
        builderSingle.setTitle("Select Name");

        arrayAdapter.clear();
        if (contactdbList != null && contactdbList.size() > 0) {
            for (Contact c : contactdbList) {
                arrayAdapter.add(c.getName());
            }
        }

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                selected_name_txt.setText("");

            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String strName = arrayAdapter.getItem(which);
                selected_name_txt.setText(strName);
                selected_name_txt.setTag(which);
                dialog.dismiss();
            }
        });


        AlertDialog dialog = builderSingle.create();
        ListView listView = dialog.getListView();
        listView.setVerticalScrollBarEnabled(false);
        listView.setDivider(new ColorDrawable(Color.parseColor("#44BDC8")));
        listView.setDividerHeight(1);
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.selection_name_lyt:
                spinner();
                break;
        }
    }
}
