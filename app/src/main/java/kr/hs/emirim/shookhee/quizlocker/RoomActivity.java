package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

    }

    public void onback(View v){
        onBackPressed();
    }

    public void goBackground(View v){
        Intent intent = new Intent(RoomActivity.this, BackgroundActivity.class);
        startActivity(intent);
    }

    public void goIllust(View v){
        Intent intent = new Intent(RoomActivity.this, Illust.class);
        startActivity(intent);
    }
}
