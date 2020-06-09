package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CollectionInfoAcivity extends AppCompatActivity {
    String name;
    String info;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_info_acivity);

        ImageView ivCarrotImage = (ImageView)findViewById(R.id.carrotImageView);
        Button btnCarrotName = (Button)findViewById(R.id.carrotNameButton);
        TextView tvCarrotInfo = (TextView)findViewById(R.id.carrotInfoTextView);

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        info = intent.getExtras().getString("info");
        img = intent.getExtras().getInt("img");

        ivCarrotImage.setBackgroundResource(img);
        btnCarrotName.setText(name);
        tvCarrotInfo.setText(info);
    }

    public void onBackClick(View view){
        super.onBackPressed();
    }
}
