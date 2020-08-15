package main.java.com.api.endpoint;

import main.java.com.api.dto.BasicDTO;
import main.java.com.api.dto.UserRequest;
import retrofit2.Call;
import retrofit2.http.*;

public interface UsersEndpoint {
    @POST("answers")
    Call<BasicDTO<UserRequest>> createAnswer(@Header("Authorization") String authorization, @Body UserRequest answerRequest);

    @GET("users")
    Call<BasicDTO<UserRequest>> getUser();


}
