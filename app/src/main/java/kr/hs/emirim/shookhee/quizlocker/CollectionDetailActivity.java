package kr.hs.emirim.shookhee.quizlocker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class CollectionDetailActivity extends AppCompatActivity {

    String name;
    String info;
    String userKey;
    int img;
    int carrotPosition;
    String temp_user_email ="";
    String key="";

    // Firebase
    FirebaseAuth firebaseAuth;
    private DatabaseReference userDatabaseReference = FirebaseDatabase.getInstance().getReference().child("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_detail);

        firebaseAuth = firebaseAuth.getInstance();

        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);

        temp_user_email = pref.getString("userEmail", "");
        userKey = pref.getString("userKey", "");


        ImageView ivCarrotImage = (ImageView)findViewById(R.id.carrotImageView);
        Button btnCarrotName = (Button)findViewById(R.id.carrotNameButton);
        TextView tvCarrotInfo = (TextView)findViewById(R.id.carrotInfoTextView);

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        info = intent.getExtras().getString("info");
        img = intent.getExtras().getInt("img");
        carrotPosition = intent.getExtras().getInt("carrotPosition");

        ivCarrotImage.setBackgroundResource(img);
        btnCarrotName.setText(name);
        tvCarrotInfo.setText(info);

        Button setIamgeBtn = findViewById(R.id.setImage);
        setIamgeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Map<String, Object> profileIdMap = new HashMap<String, Object>();
                profileIdMap.put("profileId", carrotPosition);
                userDatabaseReference.child(userKey).updateChildren(profileIdMap);

                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("profileId", carrotPosition);
                editor.commit();

                Toast.makeText(CollectionDetailActivity.this, "대표 당근으로 설정되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClickBack(View view){
        super.onBackPressed();
    }
}