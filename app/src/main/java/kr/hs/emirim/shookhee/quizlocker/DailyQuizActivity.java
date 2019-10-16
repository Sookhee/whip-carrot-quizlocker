package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DailyQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_quiz);
    }

    public void gosetting(View v){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
    public void onback(View v){
        onBackPressed();
    }

    public void onanswer(View v){
        Toast.makeText(getApplicationContext(), "클릭", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AnswerActivity.class);
        startActivity(intent);
    }
}