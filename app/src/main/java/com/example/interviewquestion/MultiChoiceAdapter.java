package com.example.interviewquestion;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewquestion.databinding.MultipleChoiceItemBinding;

import java.util.List;

public class MultiChoiceAdapter extends RecyclerView.Adapter<MultiChoiceViewHolder> {

    private List<Question> choices;

    private OnItemActionListener onItemActionListener;

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
    public void onBindViewHolder(@NonNull MultiChoiceViewHolder holder, int position) {
        Question question = choices.get(position);
        holder.binding.numberOfQuestionsTxt.setText(String.valueOf(position+1));
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onNumberClick(question);
        });
    }

    @Override
    public int getItemCount() {
        return choices.size();
    }
}
