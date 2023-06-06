package com.example.interviewquestion;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MultipleChoice {

    private Integer id;
    private String question;
    private String description;
    private Answers answers;
    private boolean multipleCorrectAnswers;
    @SerializedName("correct_answers")
    private CorrectAnswers correctAnswers;
    @SerializedName("correct_answer")
    private String correctAnswer;
    private String explanation;
    private String tip;
    private String category;
    private String difficulty;
    private ArrayList<Tag> tags;

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public boolean isMultipleCorrectAnswers() {
        return multipleCorrectAnswers;
    }

    public void setMultipleCorrectAnswers(boolean multipleCorrectAnswers) {
        this.multipleCorrectAnswers = multipleCorrectAnswers;
    }

    public CorrectAnswers getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(CorrectAnswers correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}

class Answers {
    @SerializedName("answer_a")
    private String answerA;
    @SerializedName("answer_b")
    private String answerB;
    @SerializedName("answer_c")
    private String answerC;
    @SerializedName("answer_d")
    private String answerD;
    @SerializedName("answer_e")
    private String answerE;
    @SerializedName("answer_f")
    private String answerF;

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerE() {
        return answerE;
    }

    public void setAnswerE(String answerE) {
        this.answerE = answerE;
    }

    public String getAnswerF() {
        return answerF;
    }

    public void setAnswerF(String answerF) {
        this.answerF = answerF;
    }
}

class CorrectAnswers {
    @SerializedName("answer_a_correct")
    private boolean answerACorrect;
    @SerializedName("answer_b_correct")
    private boolean answerBCorrect;
    @SerializedName("answer_c_correct")
    private boolean answerCCorrect;
    @SerializedName("answer_d_correct")
    private boolean answerDCorrect;
    @SerializedName("answer_e_correct")
    private boolean answerECorrect;
    @SerializedName("answer_f_correct")
    private boolean answerFCorrect;

    public boolean isAnswerACorrect() {
        return answerACorrect;
    }

    public void setAnswerACorrect(boolean answerACorrect) {
        this.answerACorrect = answerACorrect;
    }

    public boolean isAnswerBCorrect() {
        return answerBCorrect;
    }

    public void setAnswerBCorrect(boolean answerBCorrect) {
        this.answerBCorrect = answerBCorrect;
    }

    public boolean isAnswerCCorrect() {
        return answerCCorrect;
    }

    public void setAnswerCCorrect(boolean answerCCorrect) {
        this.answerCCorrect = answerCCorrect;
    }

    public boolean isAnswerDCorrect() {
        return answerDCorrect;
    }

    public void setAnswerDCorrect(boolean answerDCorrect) {
        this.answerDCorrect = answerDCorrect;
    }

    public boolean isAnswerECorrect() {
        return answerECorrect;
    }

    public void setAnswerECorrect(boolean answerECorrect) {
        this.answerECorrect = answerECorrect;
    }

    public boolean isAnswerFCorrect() {
        return answerFCorrect;
    }

    public void setAnswerFCorrect(boolean answerFCorrect) {
        this.answerFCorrect = answerFCorrect;
    }
}

class Tag{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


