package com.example.interviewquestion.baseapi;

import com.example.interviewquestion.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MultiChoiceApi {

    public MultiChoiceService createMultiChoiceService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MultiChoiceService multiChoiceService = retrofit.create(MultiChoiceService.class);
        return multiChoiceService;
    }
}
