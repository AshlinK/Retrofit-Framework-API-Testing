package main.java.com.api.workflow;

import main.java.com.api.dto.AnswerRequest;
import main.java.com.api.endpoint.AnswersEndpoint;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOError;
import java.io.IOException;

public class AnswerWorkflow extends MainTest {

    AnswersEndpoint service;


    public AnswerWorkflow() {
        service=createService(AnswersEndpoint.class);
    }

    public Response createAnswer(String authorization, AnswerRequest answerRequest) throws IOException{
        Call<BasicDTO<AnswerRequest>> call=service.createAnswer(authorization, answerRequest);
        return call.execute();
    }

    public Response getAnswer(String id,String authorization) throws IOException{
        Call<BasicDTO<AnswerRequest>> call=service.getAnswer(id,authorization);
        return call.execute();
    }

    public Response editAnswer(String id,String authorization, AnswerRequest answerRequest) throws IOException{
        Call<BasicDTO<AnswerRequest>> call=service.editAnswer(id,authorization, answerRequest);
        return call.execute();
    }

    public Response deleteAnswer(String id,String authorization) throws IOException{
        Call<ResponseBody> call=service.deleteAnswer(id, authorization);
        return call.execute();
    }






}
