package com.digitalmirko.dicethree;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // File to hold the roll result text
    TextView rollResult;

    // Field to hold the roll button
    Button rollButton;

    // Field to hold the score
    int score;

    // Field to hold random number generator
    Random rand;

    // Fields to hold the die value
    int die1,die2,die3;

    //  ArrayList to hold all three dice values
    ArrayList<Integer> dice;

    // ArrayList to hold all three dice images
    ArrayList<ImageView> diceImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Set initial score
        score = 0;

        rollResult = (TextView) findViewById(R.id.rollResult);
        rollButton = (Button) findViewById(R.id.rollButton);

        // Initialize the random number generator
        rand = new Random();

        // Create ArrayList container for the dice values
        dice = new ArrayList<Integer>();

        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);

        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);


        // Create greeting
        Toast.makeText(getApplicationContext(),"Welcome to DiceOut!",Toast.LENGTH_SHORT).show();
    }

    public void rollDice (View v) {
        rollResult.setText("Clicked");

        // Roll dice
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        // Set dice values into an ArrayList
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        // Rolled message with the result
        String msg = "You rolled a " + die1 + ", a " + die2 + ", and a " + die3;



        // Update the app to display the result message
        rollResult.setText(msg);




        // Not needed any more
//        int num = rand.nextInt(6)+1;
//        String randomValue = "Number generated: " + num;
//        Toast.makeText(getApplicationContext(),randomValue,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
