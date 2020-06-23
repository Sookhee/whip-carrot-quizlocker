package kr.hs.emirim.shookhee.quizlocker;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WhipCarrotService {
    String URL = "http://10.96.123.15:3001";

    @GET("/{user_id}/carrot")
    Call<User> getUserCarrot(@Path("user_id") String user_id);

    @POST("/{user_id}/carrot_up")
    Call<User> setUserCarrot(@Path("user_id") String user_id);

}
