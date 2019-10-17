package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DailyQuizActivity extends AppCompatActivity {

//    Firebase2
//    FirebaseDatabase database;
//    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_quiz);

//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("story").child("0");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String line1 = dataSnapshot.child("line1").getValue(String.class);
//                String line2 = dataSnapshot.child("line2").getValue(String.class);
//                String line3 = dataSnapshot.child("line3").getValue(String.class);
//                String line4 = dataSnapshot.child("line4").getValue(String.class);
//
//                TextView Line1 = findViewById(R.id.quiz_title);
//                Line1.setText(line1);
//                TextView Line2 = findViewById(R.id.quiz_quiz);
//                Line2.setText(line2);
//                TextView Line3 = findViewById(R.id.quiz_input_ex);
//                Line3.setText(line3);
//                TextView Line4 = findViewById(R.id.quiz_output2);
//                Line4.setText(line4);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("DetailActivitys", "Failed to read value.", error.toException());
//            }
//        });

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