package com.example.interviewquestion;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

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
    private int currentQuestionPosition = 0;

    private Integer []  answerOptionsIndex;

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
        handleRadioGroup();

    }

    private void handleRadioGroup() {
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.answerARb.isChecked()) {
                    answerOptionsIndex[currentQuestionPosition] = 0;
                } else if (binding.answerBRb.isChecked()) {
                    answerOptionsIndex[currentQuestionPosition] = 1;
                } else if (binding.answerCRb.isChecked()) {
                    answerOptionsIndex[currentQuestionPosition] = 2;
                } else if (binding.answerDRbtn.isChecked()) {
                    answerOptionsIndex[currentQuestionPosition] = 3;
                } else if (binding.answerERb.isChecked()) {
                    answerOptionsIndex[currentQuestionPosition] = 4;
                } else if (binding.answerFfRb.isChecked()) {
                    answerOptionsIndex[currentQuestionPosition] = 5;
                }
            }
        });
    }

    public void showData(Question question) {
        showQuestion(question);
        setColor();
        previousBtnVisibility();
        nextBtnVisibility();
    }

    public void setColor() {
        multiChoiceAdapter.currentQuestionPosition = this.currentQuestionPosition;
        multiChoiceAdapter.notifyDataSetChanged();
    }

    public void previousBtnVisibility() {
        if (currentQuestionPosition == 0) {
            binding.previousBtn.setVisibility(View.INVISIBLE);
        } else {
            binding.previousBtn.setVisibility(View.VISIBLE);
        }
    }

    public void nextBtnVisibility() {
        if (currentQuestionPosition == questions.size()-1) {
            binding.nextBtn.setVisibility(View.INVISIBLE);
            binding.submitBtn.setVisibility(View.VISIBLE);
        } else {
            binding.nextBtn.setVisibility(View.VISIBLE);
            binding.submitBtn.setVisibility(View.INVISIBLE);
        }
    }

    private void setNextBtn() {
        binding.nextBtn.setOnClickListener(v -> {
            try {
                currentQuestionPosition++;
                multiChoiceAdapter.currentQuestionPosition = currentQuestionPosition;
                Question question = questions.get(currentQuestionPosition);
                showData(question);
            } catch (Exception exception) {
                showToast("Questions over");
            }
        });
    }

    private void setPreviousBtn() {
        binding.previousBtn.setOnClickListener(v -> {
        try {
            currentQuestionPosition--;
            multiChoiceAdapter.currentQuestionPosition = currentQuestionPosition;
            Question question = questions.get(currentQuestionPosition);
            showData(question);
        } catch (ArrayIndexOutOfBoundsException exception) {
            showToast("This is the first question");
        }
        });
    }

    public void showQuestion(Question question) {
        currentQuestionPosition = multiChoiceAdapter.currentQuestionPosition;
        binding.questionTxt.setText(question.getQuestion());
        binding.radioGroup.clearCheck();
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

        if (answerOptionsIndex[currentQuestionPosition] != null) {
            if (answerOptionsIndex[currentQuestionPosition] == 0) {
                binding.answerARb.setChecked(true);
            } else if (answerOptionsIndex[currentQuestionPosition] == 1) {
                binding.answerBRb.setChecked(true);
            } else if (answerOptionsIndex[currentQuestionPosition] == 2) {
                binding.answerCRb.setChecked(true);
            } else if (answerOptionsIndex[currentQuestionPosition] == 3) {
                binding.answerDRbtn.setChecked(true);
            } else if (answerOptionsIndex[currentQuestionPosition] == 4) {
                binding.answerERb.setChecked(true);
            } else if (answerOptionsIndex[currentQuestionPosition] == 5) {
                binding.answerFfRb.setChecked(true);
            }
        }
    }

    public void fetchQuestionAndAnswers() {
        Call<List<Question>> call = multiChoiceService.getQuestionAndAnswers();
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                questions = response.body();
                multiChoiceAdapter.setData(questions);
                answerOptionsIndex = new Integer[questions.size()];
                showData(questions.get(0));
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
               showData(question);
            }
        });
    }

    public void setupMultipleChoiceRv() {
        binding.multipleChoiceRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.multipleChoiceRv.setAdapter(multiChoiceAdapter);
    }
}
