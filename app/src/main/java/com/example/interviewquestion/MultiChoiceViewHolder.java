package com.example.interviewquestion;

import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewquestion.databinding.MultipleChoiceItemBinding;


public class MultiChoiceViewHolder extends RecyclerView.ViewHolder {

    MultipleChoiceItemBinding binding;

    public MultiChoiceViewHolder(MultipleChoiceItemBinding multipleChoiceItemBinding) {
        super(multipleChoiceItemBinding.getRoot());
        binding = multipleChoiceItemBinding;
    }
}
