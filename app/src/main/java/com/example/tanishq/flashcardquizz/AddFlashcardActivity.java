package com.example.tanishq.flashcardquizz;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddFlashcardActivity extends AppCompatActivity {

    private EditText editTextQuestion;
    private EditText editTextAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flashcard);

        editTextQuestion = findViewById(R.id.editText_question);
        editTextAnswer = findViewById(R.id.editText_answer);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFlashcard();
                finish();
            }
        });
    }

    private void saveFlashcard() {
        String question = editTextQuestion.getText().toString();
        String answer = editTextAnswer.getText().toString();

        Flashcard flashcard = new Flashcard();
        flashcard.question = question;
        flashcard.answer = answer;

        MainActivity.db.flashcardDao().insertAll(flashcard);
    }
}
