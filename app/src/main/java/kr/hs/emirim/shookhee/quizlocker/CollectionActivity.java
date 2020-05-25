package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class CollectionActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GridLayoutManager mLayoutManager;
    CollectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        recyclerView = (RecyclerView)findViewById(R.id.collection_recycler);
        adapter = new CollectionAdapter();
        mLayoutManager = new GridLayoutManager(this, 3);
//        mLayoutManager.setReverseLayout(true);
//        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.addItem(new Carrot("당근 1", "설명 1", R.drawable.carrot_character01));
        adapter.addItem(new Carrot("당근 2", "설명 2", R.drawable.carrot_character02));
        adapter.addItem(new Carrot("당근 3", "설명 3", R.drawable.carrot_character03));
        adapter.addItem(new Carrot("당근 4", "설명 4", R.drawable.carrot_character04));
        adapter.addItem(new Carrot("당근 5", "설명 5", R.drawable.carrot_character05));
        adapter.addItem(new Carrot("당근 6", "설명 6", R.drawable.carrot_character06));
        adapter.addItem(new Carrot("당근 7", "설명 7", R.drawable.carrot_character07));
        adapter.addItem(new Carrot("당근 8", "설명 8", R.drawable.carrot_character08));
        adapter.addItem(new Carrot("당근 9", "설명 9", R.drawable.carrot_character09));
        adapter.addItem(new Carrot("당근 10", "설명 10", R.drawable.carrot_character10));


        ImageView setting = (ImageView)findViewById(R.id.gosetting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectionActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goback(View v){
        super.onBackPressed();
    }
}
