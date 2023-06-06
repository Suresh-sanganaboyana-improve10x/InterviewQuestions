package com.example.interviewquestion.baseapi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected MultiChoiceService multiChoiceService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMultiChoiceApiService();
    }

    private void setMultiChoiceApiService() {
        MultiChoiceApi multiChoiceApi = new MultiChoiceApi();
        multiChoiceService = multiChoiceApi.createMultiChoiceService();
    }
}
