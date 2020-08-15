package main.java.com.api.workflow;

import main.java.com.api.dto.BasicDTO;
import main.java.com.api.dto.UserRequest;
import main.java.com.api.endpoint.UsersEndpoint;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class UserWorkflow extends MainTest {

    UsersEndpoint service;


    public UserWorkflow() {
        service=createService(UsersEndpoint.class);
    }

//    public Response createAnswer(String authorization, UserRequest answerRequest) throws IOException{
//        Call<BasicDTO<UserRequest>> call=service.createAnswer(authorization, answerRequest);
//        return call.execute();
//    }

    public Response getUser() throws IOException{
        Call<BasicDTO<UserRequest>> call=service.getUser();
        return call.execute();
    }

//    public Response editAnswer(String id,String authorization, UserRequest answerRequest) throws IOException{
//        Call<BasicDTO<UserRequest>> call=service.editAnswer(id,authorization, answerRequest);
//        return call.execute();
//    }
//
//    public Response deleteAnswer(String id,String authorization) throws IOException{
//        Call<ResponseBody> call=service.deleteAnswer(id, authorization);
//        return call.execute();
//    }



}
