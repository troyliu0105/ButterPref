package me.iolab.butterpreferencesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.iolab.butterpreferencesample.settingacti.SettingAtivity;
import me.iolab.butterpreferencesample.settingfrag.SettingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSettingFragment(View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void openSettingActivity(View view) {
        Intent intent = new Intent(this, SettingAtivity.class);
        startActivity(intent);
    }
}
