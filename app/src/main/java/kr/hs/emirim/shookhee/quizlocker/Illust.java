package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Illust extends AppCompatActivity {

    Button lock2;
    Button lock3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illust);
    }

    int level=SaveSharedPreference.getPrefLevel(Illust.this);

    public void onillu2(View v){
        lock2 = (Button)findViewById(R.id.illurock2);
        if(level>=10) {
            lock2.setVisibility(View.GONE);
        }
    }
    public void onillu3(View v){
        lock3 = (Button)findViewById(R.id.illurock3);
        if(level>=20) {
            lock3.setVisibility(View.GONE);
        }
    }

    public void onback(View v){
        onBackPressed();
    }

    public void gosetting(View v){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}
