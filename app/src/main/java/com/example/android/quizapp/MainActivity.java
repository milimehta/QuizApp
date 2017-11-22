package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int Q3_ANSWER = R.id.question_3_first_radio;
    final int Q4_ANSWER = R.id.question_4_first_radio;
    final String Q5_ANSWER = "alien";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkQuiz(View v) {
        ArrayList<String> incorrectAnswersList = new ArrayList<>();

        int numberOfQuestionsCorrect = 0;

        if( checkQuestion1() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 1");
        }

        if( checkQuestion2() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 2");
        }

        if( checkQuestion3() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 3");
        }

        if( checkQuestion4() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 4");
        }

        if( checkQuestion5() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 5");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList)
        {
            sb.append(s);
            sb.append("\n");
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfQuestionsCorrect + "/5  answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private boolean checkQuestion1() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_1_first_checkbox);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_1_second_checkbox);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_1_third_checkbox);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_1_fourth_checkbox);

        if (c1.isChecked() && c2.isChecked() && !c3.isChecked() && !c4.isChecked()) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion2() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_2_first_checkbox);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_2_second_checkbox);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_2_third_checkbox);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_2_fourth_checkbox);

        if (c1.isChecked() && c2.isChecked() && !c3.isChecked() && !c4.isChecked()) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion3() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_3_radio_group);

        if (rg.getCheckedRadioButtonId() == Q3_ANSWER) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_4_radio_group);

        if (rg.getCheckedRadioButtonId() == Q4_ANSWER) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion5() {
        EditText et = (EditText) findViewById(R.id.question_5_edit_text);

        return et.getText().toString().equalsIgnoreCase(Q5_ANSWER);
    }

}
