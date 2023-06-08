package com.example.interviewquestion;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewquestion.databinding.MultipleChoiceItemBinding;

import java.util.List;

public class MultiChoiceAdapter extends RecyclerView.Adapter<MultiChoiceViewHolder> {

    private List<Question> choices;

    private OnItemActionListener onItemActionListener;

    private int currentQuestionPosition = 0;
    
    void setData(List<Question> choices) {
        this.choices = choices;
        notifyDataSetChanged();
    }


    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }
    @NonNull
    @Override
    public MultiChoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MultipleChoiceItemBinding binding = MultipleChoiceItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        MultiChoiceViewHolder multiChoiceViewHolder = new MultiChoiceViewHolder(binding);
        return multiChoiceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MultiChoiceViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Question question = choices.get(position);
        holder.binding.numberOfQuestionsTxt.setText(String.valueOf(position+1));
        holder.binding.getRoot().setOnClickListener(v -> {
            currentQuestionPosition = position;
            notifyDataSetChanged();
            onItemActionListener.onNumberClick(question);
        });
        if (currentQuestionPosition == position) {
            holder.binding.numberOfQuestionsTxt.setTextColor(Color.parseColor("#DD0202"));
        } else {
            holder.binding.numberOfQuestionsTxt.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return choices.size();
    }
}
