package com.udacity.gradle.jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeManager {

    private Random random;
    private List<String> jokes;
    private static JokeManager ourInstance = new JokeManager();

    private int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public String getJoke() {
        return jokes.get(randInt(0, jokes.size() - 1));
    }

    public static JokeManager getInstance() {
        return ourInstance;
    }

    private JokeManager() {
        random = new Random();
        jokes = new ArrayList<>();
        jokes.add("Teacher asked the students to tell the most common word used by students in a classroom.\n" +
                "Suddenly a student got up and said “Can’t Sir”!\n" +
                "Brilliant! You are right, the teacher said!");
        jokes.add("Shibha asked to Kiara what they will do that night.\n" +
                "Shibha said “we will flip a coin”\n" +
                "Then Kiara said “If it comes head, we will go for movies. If tails, we will play cards, if it stands on edge, we will study”!");

    }
}
