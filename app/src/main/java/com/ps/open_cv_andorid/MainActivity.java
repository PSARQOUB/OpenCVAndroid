package com.ps.open_cv_andorid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ps.android_open_cv.OpenCvClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenCvClass.initOpenCV();
    }
}