package com.example.interviewquestion.baseapi;

import com.example.interviewquestion.Constants;
import com.example.interviewquestion.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MultiChoiceService {

    @GET(Constants.END_POINT)
    Call<List<Question>> getQuestionAndAnswers();

    @GET("questions")
    Call<Question> getQuestions(@Query("question") int questionId);
}
