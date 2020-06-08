package kr.hs.emirim.shookhee.quizlocker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatMain extends AppCompatActivity {
    private ListView listVIew;
    private Button btn_create;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arr_roomList = new ArrayList<>();
    private DatabaseReference reference = FirebaseDatabase.getInstance()
            .getReference().getRoot();
    private String name;

    private String str_name;
    private String str_room;

    Map<String, Object> map = new HashMap<String, Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTitle("랜덤채팅");
        setContentView(R.layout.activity_chatmain);


        //로그인 화면에서 닉네임 가져오기
        Intent intent = getIntent();
        str_name = intent.getStringExtra("name");

        listVIew = (ListView) findViewById(R.id.list);
        btn_create = (Button) findViewById(R.id.btn_create);


        //채팅방 리스트 보여주기
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arr_roomList);
        listVIew.setAdapter(arrayAdapter);

        btn_create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final EditText et_inDialog = new EditText(ChatMain.this);
                final AlertDialog.Builder builder = new AlertDialog.Builder(ChatMain.this);
                builder.setTitle("채팅방 이름 입력");
                builder.setView(et_inDialog);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_room = et_inDialog.getText().toString();
                        map.put(str_room,"");
                        reference.updateChildren(map);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        //특정 경로의 전체 내용에 대한 변경 사항을 읽고 수신 대기함
        //onDataChange는 Database가 변경되었을때 호출되고
        //onCancelled는 취소됐을떄 호출됨
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                Set<String> set= new HashSet<String>();
                Iterator i = dataSnapshot.getChildren().iterator();

                while (i.hasNext()){
                    set.add(((DataSnapshot) i.next()).getKey());
                }

                arr_roomList.clear();
                arr_roomList.addAll(set);

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //리스트뷰의 채팅방을 클릭했을때
        //채팅방의 이름과 입장하는 유저의 이름 전달

        listVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                intent.putExtra("room_name", ((TextView) view).getText().toString());
                intent.putExtra("user_name", str_name);
                startActivity(intent);
            }
        });
    }
}
