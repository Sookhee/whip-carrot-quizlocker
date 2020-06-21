package kr.hs.emirim.shookhee.quizlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity {

    // Retrofit
    Retrofit retrofit = (new Retrofit.Builder()).baseUrl(WhipCarrotService.URL).addConverterFactory(GsonConverterFactory.create()).build();
    final WhipCarrotService apiService = retrofit.create(WhipCarrotService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        // Retrofit
//        Retrofit retrofit = (new Retrofit.Builder()).baseUrl(WhipCarrotService.URL).addConverterFactory(GsonConverterFactory.create()).build();
//        final WhipCarrotService apiService = retrofit.create(WhipCarrotService.class);
        final TextView tv = findViewById(R.id.carrotCnt);
        final Button btn = findViewById(R.id.carrotUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyTag","test");
                Call<User> apiCall = apiService.setUserCarrot("jeon1");
                apiCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        savecarrot();

                        tv.setText(user.getCarrot());

                        Log.d("MyTag", String.valueOf(user.getCarrot()));
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("MyTag",t.toString());
                    }
                });
            }
        });

    }

    public void savecarrot()
    {
        Call<User> apiCall = apiService.setUserCarrot("jeon1");
        apiCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.d("MyTag", "addCarrot");
                user.setCarrot(user.getCarrot()+1);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }
}