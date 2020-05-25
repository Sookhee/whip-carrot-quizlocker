package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class CollectionInfoAcivity extends AppCompatActivity {

    String name;
    String info;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_info_acivity);

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        info = intent.getExtras().getString("info");
        img = intent.getExtras().getInt("img");

        Toast.makeText(getApplicationContext(), name + " " + info + " " + img, Toast.LENGTH_SHORT).show();

    }
}
