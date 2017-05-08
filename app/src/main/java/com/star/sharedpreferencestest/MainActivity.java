package com.star.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "data";

    private Button mSaveDataButton;
    private Button mLoadDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSaveDataButton = (Button) findViewById(R.id.save_data);
        mSaveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences(FILE_NAME, MODE_PRIVATE)
                        .edit()
                        .putString("name", "Tom")
                        .putInt("age", 28)
                        .putBoolean("married", false)
                        .apply();
            }
        });

        mLoadDataButton = (Button) findViewById(R.id.load_data);
        mLoadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);

                String name = sharedPreferences.getString("name", "");
                int age = sharedPreferences.getInt("age", 0);
                boolean married = sharedPreferences.getBoolean("married", false);

                Log.d("MainActivity", "name is " + name);
                Log.d("MainActivity", "age is " + age);
                Log.d("MainActivity", "married is " + married);
            }
        });
    }
}
