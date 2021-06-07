package com.example.projectandroidthirdyear;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PlayTestActivity extends AppCompatActivity implements View.OnClickListener {
    // setting up quizzes

    // ----- HARRY POTTER ------
    String[] questionsPotter = {"Who gifted Harry the invisibility cloak?",
            "Who gifted Harry the invisibility cloak?",
            "Who was poisoned by the love potion?",
            "How many Harrys participated in Harry relocation operation?",
            "What type of dragon did Harry pull out in the first stage of Triwizard Tournament?"};

    String[][] answersPotter = {
            {"Ron Weasley","Albus Dumbledore", "Hermione Granger", "Severus Snape"},
            {"Quaffle", "Bludger", "Snitch", "Winger"},
            {"Ron Weasley", "Harry Potter", "Hermione Granger", "Neville Longbottom"},
            {"6", "7", "8", "9"},
            {"Chinese Fireball", "Swedish Short-Snout", "Common Welsh Green", "Hungarian Horntail"}};

    int[] picturesPotter = {R.drawable.quiz_1_1,
            R.drawable.quiz_1_2,
            R.drawable.quiz_1_3,
            R.drawable.quiz_1_4,
            R.drawable.quiz_1_5,};

    String[] correctPotter = { "Albus Dumbledore",
            "Snitch",
            "Ron Weasley",
            "7",
            "Hungarian Horntail"};

    String[] resultPotter = {
            "Have you ever watched the movies?\n" + "If you want to keep up with Harry Potter universe, you have to (re)watch all of them!",
            "You definitely watched the whole movie series!\n" + "But you missed some interesting details, don't you want to arrange Harry Potter movie series marathon?",
            "You’re a huge Harry Potter movies fan! \n" + "You have watched every movie several times and you know every detail very well, you can be proud!"
    };

    Quiz quizPotter = new Quiz(1, "How well do you know Harry Potter movies?",
            questionsPotter,
            answersPotter,
            picturesPotter,
            correctPotter,
            resultPotter);
    // ----- HARRY POTTER ------

    // ----- MOVIES ------

    String[] questionsMovie = {"What movie is this?",
            "What is this one?",
            "From what movie is this frame?",
            "Name the movie:",
            "What is the last one?"};

    String[][] answersMovie = {
            {"Captain America","V for Vendetta", "The Matrix", "Transformers"},
            {"The Lord of the Rings", "Harry Potter", "The King", "King Arthur"},
            {"Star Trek", "The Avengers", "Star Wars", "The Space Odyssey"},
            {"It", "Friday the 13th", "Scream", "The Shining"},
            {"Donnie Darko", "The Eternal Sunshine of a Spotless Mind", "The Fight Club", "The Fight Club"}
    };

    int[] picturesMovie = {R.drawable.quiz_2_1,
            R.drawable.quiz_2_2,
            R.drawable.quiz_2_3,
            R.drawable.quiz_2_4,
            R.drawable.quiz_2_5,};

    String[] correctMovie = {"The Matrix",
            "The Lord of the Rings",
            "Star Wars",
            "The Shining",
            "The Fight Club"
    };

    String[] resultMovie = {
            "You don't know the basics!\n" + "But you can change it, you just have to start, it's worth it!",
            "You've watched a lot of movies!" + "But there's something you could miss, you have to fill the gap to keep up!",
            "You're a movie maniac!"+ "You know all the classic and popular movies, that's a very good result!",
    };

    Quiz quizMovie = new Quiz(2, "Guess the movie",
            questionsMovie,
            answersMovie,
            picturesMovie,
            correctMovie,
            resultMovie);
    // ----- MOVIES ------

    // ----- PI edition ------

    String[] questionsPI = {"Who said that: \"Что-то сосисками запахло\"?",
            "Who's the one that wrote \"Тест тест тест )) ура, тест! ждемс начинаемс\"?",
            "\"Опять пиво пьете на парах\" - who said it?",
            "Whose words are these: \"Ежики не летают, пока не пнешь\"?",
            "Who said that: \"Поблагодарим докладчика за интересный доклад\"?"};

    String[][] answersPI = {
            {"Lutkovskaya", "Zorina", "Dmitriev", "Lebedev"},
            {"Petrushin", "Shabalin", "Balahchi", "Markina"},
            {"Lutkovskaya", "Socerdotova", "Rabinovich", "Alexandrovich"},
            {"Ambrosov", "Petrushin", "Zorina", "Sobolev"},
            {"Vesnin", "Petrushin", "Balahchi", "Kiselev"}
    };

    int[] picturesPI = {R.drawable.quiz_3_1,
            R.drawable.quiz_3_2,
            R.drawable.quiz_3_3,
            R.drawable.quiz_3_4,
            R.drawable.quiz_3_5,};

    String[] correctPI = {"Lebedev",
            "Shabalin",
            "Lutkovskaya",
            "Zorina",
            "Petrushin"
    };

    String[] resultPI = {
            "Are you even in PI?\n" + "Or maybe you didn't attend the lessons so you missed all the memes :(",
            "You know some memes but not all of them!" +
            "Somehow you missed some memes but you know the most part that's a good result!",
            "You know some memes but not all of them!"+
            "Somehow you missed some memes but you know the most part that's a good result!"
    };

    Quiz quizPI = new Quiz(3, "Who said that? (PI edition)",
            questionsPI,
            answersPI,
            picturesPI,
            correctPI,
            resultPI);

    // ----- PI edition ------

    // ----- Guess the country ------

    String[] questionsCountry = {"What country is on the picture?",
            "What is this one?",
            "What is this country?",
            "Guess the next one:",
            "And the last one?"};

    String[][] answersCountry = {
            {"Spain", "Portugal", "Italy", "Mexico"},
            {"Austria","Australia", "Switzerland", "Norway"},
            {"Sweden", "Norway", "Holland", "Switzerland"},
            {"Sweden", "Norway", "Canada", "USA"},
            {"China", "Bali", "Thailand", "Vietnam"}
    };

    int[] picturesCountry = {R.drawable.quiz_4_1,
            R.drawable.quiz_4_2,
            R.drawable.quiz_4_3,
            R.drawable.quiz_4_4,
            R.drawable.quiz_4_5,};

    String[] correctCountry = {"Italy",
            "Australia",
            "Switzerland",
            "Canada",
            "Bali"
    };

    String[] resultCountry = {
            "Did you miss geographic lesions?\n" + "You know not a lot about different countries, please improve your knowledge!",
            "Good job!" + "But there's some more things you can learn!",
            "You have a really good knowledge in geographic!\n" + "Congrats, you know everything about countries and cultures, well done!"
    };

    Quiz quizCountry = new Quiz(4, "Guess the country",
            questionsCountry,
            answersCountry,
            picturesCountry,
            correctCountry,
            resultCountry);

    // ----- Guess the country ------
    // end setting up the quizzes

    // realisation

    Button answer1, answer2, answer3, answer4;
    TextView question;
    int score, index;
    ImageView picture;
    int step;
    int questions_len;

    private Quiz current_quiz;
    private String q_answer;
    String account_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_test);

        step = 0;

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            index = extras.getInt("indexINTENT");
            account_name = extras.getString("accountINTENT");
        }

        Log.d("INDEX", " " + index);

        switch (index) {
            case 1:
                current_quiz = new Quiz(quizPotter);
                break;
            case 2:
                current_quiz = new Quiz(quizMovie);
                break;
            case 3:
                current_quiz = new Quiz(quizPI);
                break;
            case 4:
                current_quiz = new Quiz(quizCountry);
                break;
        }

        Log.d("CURRENT", " " + current_quiz.toString());

        questions_len = current_quiz.questions.length;

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        question = findViewById(R.id.question);

        picture = findViewById(R.id.img_q);
        if (step == 5) {
            goToResult();
        }
        updateQuestion(step);

    }

    private void goToResult() {
        Intent intent = new Intent(PlayTestActivity.this, ResultTestActivity.class);
        intent.putExtra("titleINTENT", current_quiz.getTitle());
        intent.putExtra("scoreINTENT", String.valueOf(score));
        intent.putExtra("accountINTENT", account_name);
        intent.putExtra("imageINTENT", current_quiz.getPicture(1));
        if (score <= 1){
            intent.putExtra("resultINTENT", current_quiz.getResults(0));
        } else if (score>=2 && score <=3) {
            intent.putExtra("resultINTENT", current_quiz.getResults(1));
        } else {
            intent.putExtra("resultINTENT", current_quiz.getResults(2));
        }
        startActivity(intent);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.answer1:{
                score = CheckAnswer(answer1);
                step++;
                if (step < 5) {
                    updateQuestion(step);
                } else { goToResult(); }

                break;}
            case R.id.answer2:{
                score = CheckAnswer(answer2);
                step++;
                if (step < 5) {
                    updateQuestion(step);
                } else { goToResult(); }
                break;}
            case R.id.answer3:{
                score = CheckAnswer(answer3);
                step++;
                if (step < 5) {
                    updateQuestion(step);
                } else { goToResult(); }
                break;}
            case R.id.answer4:{
                score = CheckAnswer(answer4);
                step++;
                if (step < 5) {
                    updateQuestion(step);
                } else { goToResult(); }
                break;}
        }
    }

    private void updateQuestion(int num) {

        if (index ==  5) {
            goToResult();
        }

        question.setText(current_quiz.getQuestions(num));

        picture.setImageResource(current_quiz.getPicture(num));

        answer1.setText(current_quiz.getChoice1(num));
        answer2.setText(current_quiz.getChoice2(num));
        answer3.setText(current_quiz.getChoice3(num));
        answer4.setText(current_quiz.getChoice4(num));

        q_answer = current_quiz.getCorrectAnswers(num);

        Log.d("SCORE", " " + score);
        Log.d("STEP", " " + step);

    }

    private int CheckAnswer(Button button){
        if (button.getText() == q_answer) {
            score++;
        }
        return score;
    }
}