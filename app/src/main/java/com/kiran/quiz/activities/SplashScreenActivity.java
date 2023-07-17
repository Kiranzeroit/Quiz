package com.kiran.quiz.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kiran.quiz.MainActivity;
import com.kiran.quiz.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
    private ActivitySplashScreenBinding binding;
    private boolean handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        handler = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        },2000);
    }

    private void initView() {
        Shader textShader = new LinearGradient(0, 0, 0, binding.tvAppName.getTextSize(),
                new int[]{Color.RED, Color.BLUE},
                new float[]{0, 1}, Shader.TileMode.MIRROR);
        binding.tvAppName.getPaint().setShader(textShader);
    }
}
