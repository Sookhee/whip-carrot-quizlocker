package kr.hs.emirim.shookhee.quizlocker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

import kr.hs.emirim.shookhee.quizlocker.adapter.CollectionAdapter;
import kr.hs.emirim.shookhee.quizlocker.adapter.RankingAdapter;
import kr.hs.emirim.shookhee.quizlocker.model.User;

import static kr.hs.emirim.shookhee.quizlocker.adapter.RankingAdapter.*;

public class RankingActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    RankingAdapter adapter;

    ArrayList<User> userRanking = new ArrayList<User>();
    ArrayList<String> rankingKey = new ArrayList<String>();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userReference = database.getReference("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = (RecyclerView)findViewById(R.id.ranking_recyclerview);
        adapter = new RankingAdapter();
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        userReference.orderByChild("carrotCount").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                rankingKey.add(dataSnapshot.getKey());
                userRanking.add(dataSnapshot.getValue(User.class));
                User user = dataSnapshot.getValue(User.class);

                adapter.addItem(user);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                rankingKey.add(dataSnapshot.getKey());
                userRanking.add(dataSnapshot.getValue(User.class));

                User user = dataSnapshot.getValue(User.class);

                adapter.addItem(user);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void onClickBack(View view){
        super.onBackPressed();
    }

}