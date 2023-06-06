package com.example.interviewquestion;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.interviewquestion.baseapi.BaseActivity;
import com.example.interviewquestion.databinding.ActivityMultipleChoiceBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultipleChoiceActivity extends BaseActivity {

    public ArrayList<MultipleChoice> multipleChoices = new ArrayList<>();
    public ActivityMultipleChoiceBinding binding;
    public MultiChoiceAdapter multiChoiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultipleChoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchQuestionAndAnswers();
        setupMultiChoiceAdapter();
        setupMultipleChoiceRv();
    }


    public void fetchQuestionAndAnswers() {
        Call<List<MultipleChoice>> call = multiChoiceService.getQuestionAndAnswers();
        call.enqueue(new Callback<List<MultipleChoice>>() {
            @Override
            public void onResponse(Call<List<MultipleChoice>> call, Response<List<MultipleChoice>> response) {
                List<MultipleChoice> multipleChoiceList = response.body();
                multiChoiceAdapter.setData(multipleChoiceList);
            }

            @Override
            public void onFailure(Call<List<MultipleChoice>> call, Throwable t) {

            }
        });
    }

    public void setupMultiChoiceAdapter() {
        multiChoiceAdapter = new MultiChoiceAdapter();
        multiChoiceAdapter.setData(multipleChoices);
    }

    public void setupMultipleChoiceRv() {
        binding.multipleChoiceRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.multipleChoiceRv.setAdapter(multiChoiceAdapter);
    }
}
