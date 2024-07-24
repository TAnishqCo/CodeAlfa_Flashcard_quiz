package com.example.tanishq.flashcardquizz;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Flashcard {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String question;
    public String answer;

}
