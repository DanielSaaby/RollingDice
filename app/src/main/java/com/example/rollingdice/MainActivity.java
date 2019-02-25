package com.example.rollingdice;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button rollBtn;
    LinearLayout lLayout;
    ImageView imageView4, imageView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        onClickRoll();

    }

    String generateNumber()
    {
        Random rng = new Random();
        int number = rng.nextInt(6)+1;
        String numberInString = String.valueOf(number);
        return numberInString;
    }
    void onClickRoll()
    {

        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        rollBtn = findViewById(R.id.rollBtn);
        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TESTSSS", "onClick: ");

                String n1 = generateNumber();
                String n2 = generateNumber();
                imageView4.setImageResource(getResources().getIdentifier("d" + n1, "drawable", getPackageName()));
                imageView5.setImageResource(getResources().getIdentifier("d" + n2, "drawable", getPackageName()));

                lastestResult(n1, n2);
            }
        });

    }

    void lastestResult(String dice1, String dice2)
    {
        lLayout = findViewById(R.id.lLayout);

        ConstraintLayout.LayoutParams lparams = new Constraints.LayoutParams(
        ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        TextView tv=new TextView(this);
        tv.setLayoutParams(lparams);
        tv.setText("Latests result: " + dice1 + " + " + dice2);
        this.lLayout.addView(tv);
    }

}
