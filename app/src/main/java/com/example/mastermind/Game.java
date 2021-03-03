package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class Game extends AppCompatActivity {
    // list of available fruit
    Fruit Banana = new Fruit("Banana", false, true, "url");
    Fruit Kiwi = new Fruit("Kiwi", false, true, "url");
    Fruit Strawberry = new Fruit("Strawberry", false, false, "url");
    Fruit Raspberry = new Fruit("Raspberry", false, false, "url");
    Fruit Grapes = new Fruit("Grapes", true, false, "url");
    Fruit Orange = new Fruit("Orange", false, true, "url");
    Fruit Lemon = new Fruit("Lemon", false, true, "url");
    Fruit Plum = new Fruit("Plum", true, false, "url");

    // Fruit basket = Fruits
    Fruit[] Fruits = {Banana, Kiwi, Strawberry, Raspberry, Grapes, Orange, Lemon, Plum};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        generate_answer();
    }

    public Fruit[] generate_answer() {
        int inserted_fruit = 0;
        Fruit[] result = new Fruit[4];

        while (inserted_fruit != 4) {
            Random rnd = new Random();
            int proposition = rnd.nextInt(Fruits.length);
            boolean isValid = true;

            for (int i = 0; i < result.length; i++) {
                if (result[i] != null) {
                    if (result[i].getName().equals(Fruits[proposition].getName())) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                result[inserted_fruit] = Fruits[proposition];
                inserted_fruit++;
            }
        }
        return result;
    }
}