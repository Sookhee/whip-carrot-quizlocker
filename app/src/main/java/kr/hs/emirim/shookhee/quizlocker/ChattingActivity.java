package kr.hs.emirim.shookhee.quizlocker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kr.hs.emirim.shookhee.quizlocker.adapter.ChatAdapter;
import kr.hs.emirim.shookhee.quizlocker.model.Chat;
import java.util.ArrayList;
import java.util.List;

public class ChattingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Chat> chatList;


    int[] imageID = {
            R.drawable.carrot_character01, R.drawable.carrot_character02, R.drawable.carrot_character03,
            R.drawable.carrot_character04, R.drawable.carrot_character05, R.drawable.carrot_character06,
            R.drawable.carrot_character07, R.drawable.carrot_character08, R.drawable.carrot_character09,
            R.drawable.carrot_character10
    };

    private EditText EditText_chat;
    private Button Button_send;
    private String str_user_name;
    private String str_room_name;
    private int profileID;
   // private DatabaseReference myRef;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        str_room_name = getIntent().getExtras().get("room_name").toString();
        str_user_name = getIntent().getExtras().get("str_name").toString();
        profileID = Integer.parseInt(getIntent().getExtras().get("profileID").toString());

        reference = FirebaseDatabase.getInstance().getReference("chat").child(str_room_name);

        Button_send = findViewById(R.id.Button_send);
        EditText_chat = findViewById(R.id.EditText_chat);

        Button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = EditText_chat.getText().toString(); //msg

                if (msg != null) {
                    Chat chat = new Chat();
                    chat.setProfile_id(imageID[profileID-1]);
                    chat.setChat_user(str_user_name);
                    chat.setChat_message(msg);
                    reference.push().setValue(chat);
                }

            }
        });


        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        chatList = new ArrayList<>();
        mAdapter = new ChatAdapter(chatList, ChattingActivity.this, str_user_name);

        mRecyclerView.setAdapter(mAdapter);

        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //myRef = database.getReference();


        //caution!!!

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("CHATCHAT", dataSnapshot.getValue().toString());
                Chat chat = dataSnapshot.getValue(Chat.class);
                ((ChatAdapter) mAdapter).addChat(chat);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

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

        //1. recyclerView - 반복
        //2. 디비 내용을 넣는다
        //3. 상대방폰에 채팅 내용이 보임 - get

        //1-1. recyclerview - chat data
        //1. message, nickname - Data Transfer Object

    }
}
