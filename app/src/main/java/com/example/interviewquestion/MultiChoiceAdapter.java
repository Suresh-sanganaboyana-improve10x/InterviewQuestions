package com.example.interviewquestion;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewquestion.databinding.MultipleChoiceItemBinding;

import java.util.List;

public class MultiChoiceAdapter extends RecyclerView.Adapter<MultiChoiceViewHolder> {

    public List<MultipleChoice> choices;
    void setData(List<MultipleChoice> choices) {
        this.choices = choices;
        notifyDataSetChanged();
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
        MultipleChoice multipleChoice = choices.get(position);
        holder.binding.numberOfQuestionsTxt.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return choices.size();
    }
}
