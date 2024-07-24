package com.example.tanishq.flashcardquizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.tanishq.flashcardquizz.AddFlashcardActivity;
import com.example.tanishq.flashcardquizz.AppDatabase;
import com.example.tanishq.flashcardquizz.QuizActivity;
import com.example.tanishq.flashcardquizz.R;

public class MainActivity extends AppCompatActivity {

    public static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();

        findViewById(R.id.button_add_flashcard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddFlashcardActivity.class));
            }
        });

        findViewById(R.id.button_quiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });
    }
}
