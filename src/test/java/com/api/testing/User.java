package test.java.com.api.testing;

import com.google.gson.JsonObject;
import main.java.com.api.dto.BasicDTO;
import main.java.com.api.dto.UserRequest;
import main.java.com.api.workflow.UserWorkflow;
import main.java.com.api.workflow.MainTest;
import org.apache.http.HttpStatus;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class User extends MainTest {

    private UserRequest userRequest;
    private UserWorkflow userWorkflow;

    public User() {
        userRequest = new UserRequest();
        userWorkflow = new UserWorkflow();
    }

//    @Test(enabled = false, groups = {"public_api.p1"})
//    public void createAnswer() throws IOException {
//        answerRequest.setValue("Answer" + getUniqueNumber(0, 10));
//        Response<BasicDTO<UserRequest>> createAnswerResponse = answerWorkflow.createAnswer(authorization, answerRequest);
//        String answerId = createAnswerResponse.body().getData().getId();
//        Assert.assertEquals(createAnswerResponse.code(), HttpStatus.SC_OK, "Response code's do not match");
//        Assert.assertEquals(createAnswerResponse.body().getData().getValue(), answerRequest.getValue(), "Value's do not match");
//        //Delete Answer
//        this.deleteAnswer(answerId, authorization);
//    }

    @Test(enabled = true)
    public void getUser() throws IOException{
        System.out.println("Inside test method");
        Response<BasicDTO<UserRequest>> getUserResponse = userWorkflow.getUser();

        //JSONObject profileFileUploadResponse = new JSONObject(String.valueOf(response.body()));

        System.out.println(getUserResponse.body().getData()[0].getId());
        System.out.println(getUserResponse.body().getData()[0].getEmail());
        Assert.assertEquals(getUserResponse.code(),HttpStatus.SC_OK,"Response code's do not match");
        Assert.assertEquals(getUserResponse.body().getData()[0].getId(),1,"Id's do not match");
        Assert.assertEquals(getUserResponse.body().getData()[0].getEmail(),"george.bluth@reqres.in","Email's do not match");

    }


//    public void deleteAnswer(String answerId, String authorization) throws IOException {
//        Response deleteAnswer = answerWorkflow.deleteAnswer(answerId, authorization);
//        Assert.assertEquals(deleteAnswer.code(), HttpStatus.SC_OK, "Delete answer API response do not match");
//    }
}
