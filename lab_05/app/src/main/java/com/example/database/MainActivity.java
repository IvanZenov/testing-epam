package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
        userDao = db.userDao();

    }

    public void insertInfo(View view) {
        User user = new User();
        user.firstName = ((TextView) findViewById(R.id.firstName)).getText().toString();
        user.lastName = ((TextView) findViewById(R.id.lastName)).getText().toString();
        user.birthDate = ((TextView) findViewById(R.id.birthDate)).getText().toString();
        userDao.insertAll(user);
    }

    public void findUser(View view) {
        EditText editTextFirstName = findViewById(R.id.editTextSearchFirstName);
        EditText editTextLastName = findViewById(R.id.editTextSearchLastName);

        String findUserFirstName = editTextFirstName.getText().toString();
        String findUserLastName = editTextLastName.getText().toString();
        User getUser = userDao.findByName(findUserFirstName, findUserLastName);
        TextView textView = findViewById(R.id.textViewFindInfo);
        textView.setText(getUser.toString());
    }

    public void getUsers(View view) {
        List<User> getUsers = userDao.getAll();
        TextView textView = findViewById(R.id.textViewGetInfo);
        String tableString = "";
        StringBuilder sb = new StringBuilder(tableString);
        for (int i = 0; i < getUsers.size(); i++) {
            sb.append(getUsers.get(i).toString());
            sb.append("\n");
        }
        textView.setText(sb);
    }

    public void deleteUsers(View view) {
        EditText editTextFirstName = findViewById(R.id.editTextSearchFirstName);
        EditText editTextLastName = findViewById(R.id.editTextSearchLastName);
        String findUserFirstName = editTextFirstName.getText().toString();
        String findUserLastName = editTextLastName.getText().toString();
        User getUser = userDao.findByName(findUserFirstName, findUserLastName);
        userDao.delete(getUser);
    }
}
