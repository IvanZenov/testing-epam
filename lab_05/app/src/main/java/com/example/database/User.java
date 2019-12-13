package com.example.database;

import androidx.room.*;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "birth_date")
    public String birthDate;

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + birthDate;
    }
}