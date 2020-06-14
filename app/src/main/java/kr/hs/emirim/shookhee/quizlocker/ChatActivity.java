package kr.hs.emirim.shookhee.quizlocker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {
    private ListView lv_chating;
    private EditText et_send;
    private Button btn_send;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arr_room = new ArrayList<>();

    private String str_room_name;
    private String str_user_name;


    private DatabaseReference reference;
    private String key;
    private String chat_user;
    private String chat_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        et_send = (EditText) findViewById(R.id.et_send);
        lv_chating = (ListView) findViewById(R.id.lv_chatting);
        btn_send = (Button) findViewById(R.id.btn_send);

        str_room_name = getIntent().getExtras().get("room_name").toString();
        str_user_name = getIntent().getExtras().get("user_name").toString();
        reference = FirebaseDatabase.getInstance().getReference().child(str_room_name);

        setTitle(str_room_name + " 채팅방");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_room);
        lv_chating.setAdapter(arrayAdapter);
        //리스트뷰가 갱신될떄 하단으로 자동 스크롤
        lv_chating.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //map을 사용해 name과 메세지를 가져오고, key에 값 요청
                Map<String, Object> map = new HashMap<>();
                key = reference.push().getKey();
                reference.updateChildren(map);

                DatabaseReference root = reference.child(key);

                //updateChildren을 호출해 database 최종 업데이트
                Map<String, Object> objectMap = new HashMap<String, Object>();
                objectMap.put("name", str_user_name);
                objectMap.put("message", et_send.getText().toString());


                root.updateChildren(objectMap);

                et_send.setText("");
            }


        });

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                chatConversation(dataSnapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                chatConversation(dataSnapshot);
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

    //addChildEventListener를 통해 실제 데이터에 변경된 값이 있으면,
    //화면에 보여지고있는 LISTVIEW의 값을 갱신

    private void chatConversation(DataSnapshot dataSnapshot) {
        Iterator i = dataSnapshot.getChildren().iterator();

        while (i.hasNext()) {
            chat_message = (String) ((DataSnapshot) i.next()).getValue();
            chat_user = (String) ((DataSnapshot) i.next()).getValue();

            arrayAdapter.add(chat_user + " : " + chat_message);
        }

        arrayAdapter.notifyDataSetChanged();
    }
}