package kr.hs.emirim.shookhee.quizlocker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CollectionPopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //상태바제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_collection_popup);

        TextView answerNum = findViewById(R.id.answerNum);
        Intent secondIntent = getIntent();
        String message = secondIntent.getStringExtra("메시지");

        answerNum.setText(message);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        //바깥레이어 클릭해도 안닫히게..
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        //안드로이드 백버튼 막기
        return;
    }

    public void popupCancel(View v){
        finish();
    }
}
