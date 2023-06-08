package com.example.interviewquestion;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.interviewquestion.baseapi.BaseActivity;
import com.example.interviewquestion.databinding.ActivityMultipleChoiceBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultipleChoiceActivity extends BaseActivity {

    public List<Question> questions = new ArrayList<>();
    public ActivityMultipleChoiceBinding binding;
    public MultiChoiceAdapter multiChoiceAdapter;
    private int currentQuestionNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultipleChoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("QuestionsActivity");
        fetchQuestionAndAnswers();
        setupMultiChoiceAdapter();
        setupMultipleChoiceRv();
        setNextBtn();
        setPreviousBtn();
    }

    private void setNextBtn() {
        binding.nextBtn.setOnClickListener(v -> {
            try {
                currentQuestionNum = multiChoiceAdapter.currentQuestionPosition;
                currentQuestionNum++;
                Question question = questions.get(currentQuestionNum);
                showQuestion(question);
            } catch (Exception exception) {
                showToast("Questions over");
            }
            multiChoiceAdapter.currentQuestionPosition = currentQuestionNum;
            multiChoiceAdapter.notifyDataSetChanged();
        });
    }

    private void setPreviousBtn() {
        binding.previousBtn.setOnClickListener(v -> {
            currentQuestionNum--;
            Question question = questions.get(currentQuestionNum);
            showQuestion(question);
            multiChoiceAdapter.currentQuestionPosition = currentQuestionNum;
            multiChoiceAdapter.notifyDataSetChanged();
        });
    }

    public void showQuestion(Question question) {

        binding.questionTxt.setText(question.getQuestion());
        if (question.getAnswers().getAnswerA() == null) {
            binding.answerARb.setVisibility(View.GONE);
        } else {
            binding.answerARb.setVisibility(View.VISIBLE);
            binding.answerARb.setText(question.getAnswers().getAnswerA());
        }
        if (question.getAnswers().getAnswerB() == null) {
            binding.answerBRb.setVisibility(View.GONE);
        } else {
            binding.answerBRb.setVisibility(View.VISIBLE);
            binding.answerBRb.setText(question.getAnswers().getAnswerB());
        }
        if (question.getAnswers().getAnswerC() == null) {
            binding.answerCRb.setVisibility(View.GONE);
        } else {
            binding.answerCRb.setVisibility(View.VISIBLE);
            binding.answerCRb.setText(question.getAnswers().getAnswerC());
        }
        if (question.getAnswers().getAnswerD() == null) {
            binding.answerDRbtn.setVisibility(View.GONE);
        } else {
            binding.answerDRbtn.setVisibility(View.VISIBLE);
            binding.answerDRbtn.setText(question.getAnswers().getAnswerD());
        }
        if (question.getAnswers().getAnswerE() == null) {
            binding.answerERb.setVisibility(View.GONE);
        } else {
            binding.answerERb.setVisibility(View.VISIBLE);
            binding.answerERb.setText(question.getAnswers().getAnswerE());
        }
        if (question.getAnswers().getAnswerF() == null) {
            binding.answerFfRb.setVisibility(View.GONE);
        } else {
            binding.answerFfRb.setVisibility(View.VISIBLE);
            binding.answerFfRb.setText(question.getAnswers().getAnswerF());
        }
    }


    public void fetchQuestionAndAnswers() {
        Call<List<Question>> call = multiChoiceService.getQuestionAndAnswers();
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                questions = response.body();
                multiChoiceAdapter.setData(questions);
                showQuestion(questions.get(0));
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                showToast("Failed to get data");
            }
        });
    }


    public void setupMultiChoiceAdapter() {
        multiChoiceAdapter = new MultiChoiceAdapter();
        multiChoiceAdapter.setData(questions);
        multiChoiceAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onNumberClick(Question question) {
               showQuestion(question);
            }
        });
    }

    public void setupMultipleChoiceRv() {
        binding.multipleChoiceRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.multipleChoiceRv.setAdapter(multiChoiceAdapter);
    }
}
