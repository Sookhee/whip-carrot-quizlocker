package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BackgroundActivity extends AppCompatActivity {

    ImageView imageView2;
    ImageView imageView3;

    Button bgl2;
    Button bgl3;

    int level = SaveSharedPreference.getPrefLevel(BackgroundActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background2);

        imageView2 = (ImageView) findViewById(R.id.lock2);
        imageView3 = (ImageView) findViewById(R.id.lock3);

    }

    public void gosetting(View v){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void onstage2(View v){
        bgl2 = (Button)findViewById(R.id.bg2);
        if(level>=10) {
            bgl2.setVisibility(View.GONE);
        }
    }
    public void onstage3(View v){
        bgl3 = (Button)findViewById(R.id.bg3);
        if(level>=20) {
            bgl3.setVisibility(View.GONE);
        }
    }

    public void onback(View v){
        onBackPressed();
    }
}
