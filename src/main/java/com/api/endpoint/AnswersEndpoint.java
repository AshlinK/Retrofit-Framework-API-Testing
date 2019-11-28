package main.java.com.api.endpoint;

import main.java.com.api.dto.AnswerRequest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface AnswersEndpoint {
    @POST("answers")
    Call<BasicDTO<AnswerRequest>> createAnswer(@Header("Authorization") String authorization, @Body AnswerRequest answerRequest);

    @GET("answers/{id}")
    Call<BasicDTO<AnswerRequest>> getAnswer(@Path("id") String id, @Header("Authorization")String authorization);

    @PATCH("answers/{id}")
    Call<BasicDTO<AnswerRequest>> editAnswer(@Path("id")String id,@Header("Authorization")String authorization,@Body AnswerRequest answerRequest);

    @DELETE("answers/{id}")
    Call<ResponseBody> deleteAnswer(@Path("id") String id, @Header("Authorization")String authorization);


}
