package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        int level = SaveSharedPreference.getPrefLevel(RoomActivity.this);;
        TextView userlv = findViewById(R.id.userLevel);
        userlv.setText(String.valueOf(level));

    }

    public void onback(View v){
        onBackPressed();
    }

    public void goBackground(View v){
        Intent intent = new Intent(this, BackgroundActivity.class);
        startActivity(intent);
    }

    public void goIlust(View v){
        Intent intent = new Intent(this, Illust.class);
        startActivity(intent);
    }

    public void gosetting(View v){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}
