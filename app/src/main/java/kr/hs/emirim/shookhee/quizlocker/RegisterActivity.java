package kr.hs.emirim.shookhee.quizlocker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import kr.hs.emirim.shookhee.quizlocker.model.User;


public class RegisterActivity extends AppCompatActivity {

    String email, passwd, passwdRe, nickName;
    // Firebase
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    private DatabaseReference userDatabaseReference = FirebaseDatabase.getInstance().getReference().child("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = firebaseAuth.getInstance();

        TextView goLogin = (TextView)findViewById(R.id.goLogin);
        final EditText etNickName = (EditText)findViewById(R.id.nickNameEditText);
        final EditText etEmail = (EditText)findViewById(R.id.emailEditText);
        final EditText etPasswd = (EditText)findViewById(R.id.passwdEditText);
        final EditText etPasswdRe = (EditText)findViewById(R.id.passwdReEditText);
        Button registerBtn = (Button)findViewById(R.id.registerButton);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etEmail.getText().toString();
                passwd = etPasswd.getText().toString().trim();
                passwdRe = etPasswdRe.getText().toString().trim();
                nickName = etNickName.getText().toString().trim();

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "올바른 이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
                } else if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,15}.$", passwd)) {
                    Toast.makeText(getApplicationContext(), "올바른 비밀번호 형식이 아닙니다", Toast.LENGTH_SHORT).show();
                } else {

                    firebaseAuth.createUserWithEmailAndPassword(email, passwd)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {

                                        User user = new User(nickName, email, 0);
                                        userDatabaseReference.child(email).push().setValue(user);

//                                        Map<String, User> users = new HashMap<>();
//                                        users.put(email, new User(nickName, email, 0));
//
//                                        userDatabaseReference.child(email).push().setValue(users);

                                        Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_SHORT).show();

                                        finish();
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "이미 가입된 메일입니다", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                }
                            });
                }
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}