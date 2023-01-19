package com.mubashshirkhan.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {"1. In an instance method or a constructor, \"this\" is a reference to the current object.","2. Garbage Collection is manual process.","3. All binary operators except for the assignment operators are evaluated from Left to Right","4. Java has abstract classes?","5. Java supports interface?","Java was first released in 1995","6. Object Oriented Programming is useless in Java","more than 7 billion devices run Java" , "It is owned by Oracle"};
    private boolean[] answers = {true , false , true , true , true , true , false , false , true };
    private int score = 0;
    Button yes;
    Button no;
    TextView question;

    private int index = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Text view number 1 to add hyperlink
        TextView linkTextView = findViewById(R.id.textView5);

        // method to redirect to provided link
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());


        // Text view number 2 to add hyperlink
        TextView linkTextView2 = findViewById(R.id.textView6);

        // method to redirect to provided link
        linkTextView2.setMovementMethod(LinkMovementMethod.getInstance());



        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index<= questions.length-1) {

                    if (answers[index] == true) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: "+score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index<= questions.length-1) {
                   
                    if (answers[index] == false) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: "+score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}