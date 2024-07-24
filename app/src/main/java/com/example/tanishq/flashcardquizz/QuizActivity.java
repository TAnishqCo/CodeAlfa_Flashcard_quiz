package com.example.tanishq.flashcardquizz;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private EditText editTextAnswer;
    private List<Flashcard> flashcards;
    private int currentIndex = 0;
    private int score = 0;
    private int totalQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.textView_question);
        editTextAnswer = findViewById(R.id.editText_answer);

        // Get all flashcards from the database and shuffle them
        flashcards = MainActivity.db.flashcardDao().getAll();
        Collections.shuffle(flashcards);
        totalQuestions = flashcards.size();

        // Check if there are any flashcards available
        if (totalQuestions > 0) {
            showNextQuestion();
        } else {
            Toast.makeText(this, "No flashcards available. Please add some flashcards first.", Toast.LENGTH_LONG).show();
            finish();
        }

        findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void showNextQuestion() {
        if (currentIndex < totalQuestions) {
            Flashcard currentFlashcard = flashcards.get(currentIndex);
            textViewQuestion.setText(currentFlashcard.question);
        } else {
            showScore();
        }
    }

    private void checkAnswer() {
        String userAnswer = editTextAnswer.getText().toString().trim();
        String correctAnswer = flashcards.get(currentIndex).answer.trim();

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect! The correct answer is: " + correctAnswer, Toast.LENGTH_SHORT).show();
        }

        currentIndex++;
        editTextAnswer.setText("");
        showNextQuestion();
    }

    private void showScore() {
        String scoreMessage = "Quiz completed! Your score: " + score + " out of " + totalQuestions;
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
        finish();
    }
}
