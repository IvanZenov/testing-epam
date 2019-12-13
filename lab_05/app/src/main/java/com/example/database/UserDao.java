package com.example.database;

import androidx.room.*;
import java.util.*;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE uid = :userId")
    User getById(long userId);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Query("SELECT * FROM user WHERE first_name LIKE :first LIMIT 1")
    User findByName(String first);

    @Insert
    void insertAll(User user);

    @Delete
    void delete(User user);
}