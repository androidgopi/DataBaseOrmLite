package com.sreeyainfotech.databaseormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Contact.TABLE_NAME_USERS)
public class Contact {

    public static final String TABLE_NAME_USERS = "ContactsTable";

    public static final String FIELD_NAME_Name = "Name";
    public static final String FIELD_NAME_Mobile_Number = "Mobile_Number";
    public static final String FIELD_NAME_Email = "Email";
    public static final String FIELD_NAME_Address = "Address";
    public static final String FIELD_NAME_PASSWORD = "Password";

    @DatabaseField(columnName = FIELD_NAME_Name)
    @SerializedName("Name")
    String Name;

    @DatabaseField(columnName = FIELD_NAME_Mobile_Number,  id=true)
    @SerializedName("Mobile_Number")
    String Mobile_Number;

    @DatabaseField(columnName = FIELD_NAME_Email)
    @SerializedName("Email")
    String Email;

    @DatabaseField(columnName = FIELD_NAME_Address)
    @SerializedName("Address")
    String Address;

    @DatabaseField(columnName = FIELD_NAME_PASSWORD)
    @SerializedName("Password")
    String Password;

    public static String getTableNameUsers() {
        return TABLE_NAME_USERS;
    }

    public static String getFIELD_NAME_Name() {
        return FIELD_NAME_Name;
    }

    public static String getFIELD_NAME_Mobile_Number() {
        return FIELD_NAME_Mobile_Number;
    }

    public static String getFIELD_NAME_Email() {
        return FIELD_NAME_Email;
    }

    public static String getFIELD_NAME_Address() {
        return FIELD_NAME_Address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(String mobile_Number) {
        Mobile_Number = mobile_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public static String getFieldNamePassword() {
        return FIELD_NAME_PASSWORD;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
