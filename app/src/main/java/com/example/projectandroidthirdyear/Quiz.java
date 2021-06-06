package com.example.projectandroidthirdyear;

import java.util.Arrays;

public class Quiz {
    int index;
    String title;
    String[] questions;
    String[][] answers;
    int[] pictures;
    String[] correctAnswers;
    String[] results;

    public Quiz(int index,
                String title,
                String[] questions,
                String[][] answers,
                int[] pictures,
                String[] correctAnswers,
                String[] results) {
        this.index = index;
        this.title = title;
        this.questions = questions;
        this.answers = answers;
        this.pictures = pictures;
        this.correctAnswers = correctAnswers;
        this.results = results;
    }

    Quiz(Quiz c) {
        this.index = c.index;
        this.title = c.title;
        this.questions = c.questions;
        this.answers = c.answers;
        this.pictures = c.pictures;
        this.correctAnswers = c.correctAnswers;
        this.results = c.results;
    }

    public String getQuestions(int a) {
        String question = questions[a];
        return question;
    }

    public String getTitle(){
        return title;
    }

    public String setQuestions(int a) {
        String question = questions[a];
        return question;
    }

    public int getPicture(int a) {
        int picture = pictures[a];
        return picture;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", questions=" + Arrays.toString(questions) +
                ", answers=" + Arrays.toString(answers) +
                ", pictures=" + Arrays.toString(pictures) +
                ", correctAnswers=" + Arrays.toString(correctAnswers) +
                ", results=" + Arrays.toString(results) +
                '}';
    }

    // to refactor later i cant think of anything better

    public String getChoice1(int a) {
        String choice = answers[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = answers[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = answers[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = answers[a][3];
        return choice;
    }
     // end to refactor later block

    public String getCorrectAnswers(int a) {
        String answer = correctAnswers[a];
        return answer;
    }

    public String getResults(int a){
        String result = results[a];
        return result;
    }
}
