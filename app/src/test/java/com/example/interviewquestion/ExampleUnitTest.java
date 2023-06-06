package com.example.interviewquestion;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.interviewquestion.baseapi.MultiChoiceApi;
import com.example.interviewquestion.baseapi.MultiChoiceService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMultipleChoice() throws IOException {
        MultiChoiceService multiChoiceService = new MultiChoiceApi().createMultiChoiceService();
        Call<List<MultipleChoice>> call = multiChoiceService.getQuestionAndAnswers();
        List<MultipleChoice>  multipleChoice= call.execute().body();
        assertNotNull(multipleChoice);
        assertFalse(multipleChoice.isEmpty());
        System.out.println(new Gson().toJson(multipleChoice));
    }

    @Test
    public void testQuestion() throws IOException {
        MultiChoiceService multipleChoiceService = new MultiChoiceApi().createMultiChoiceService();
        Call<MultipleChoice> call = multipleChoiceService.getQuestions(1);
        MultipleChoice multipleChoice = call.execute().body();
//        assertNotNull(multipleChoice);
        System.out.println(new Gson().toJson(multipleChoice));
    }
}