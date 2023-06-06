package com.example.interviewquestion.baseapi;

import com.example.interviewquestion.Constants;
import com.example.interviewquestion.MultipleChoice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MultiChoiceService {

    @GET(Constants.END_POINT)
    Call<List<MultipleChoice>> getQuestionAndAnswers();

    @GET("questions")
    Call<MultipleChoice> getQuestions(@Query("question") int questionId);
}
