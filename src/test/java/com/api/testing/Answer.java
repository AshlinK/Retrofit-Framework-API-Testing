package test.java.com.api.testing;

import main.java.com.api.dto.AnswerRequest;
import main.java.com.api.util.config;
import main.java.com.api.util.credential;
import main.java.com.api.workflow.AnswerWorkflow;
import main.java.com.api.workflow.MainTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class Answer extends MainTest {

    private final String authorization, userAuthorization;
    private String answerId;
    private AnswerRequest answerRequest, updateAnswerRequest;
    private AnswerWorkflow answerWorkflow;

    public Answer() {
        answerRequest = new AnswerRequest();
        answerWorkflow = new AnswerWorkflow();
        updateAnswerRequest = new AnswerRequest();
        authorization = config.get(credential.DEFAULT_ADMIN_ACCESS_TOKEN);
        userAuthorization = config.get(credential.DEFAULT_USER_ACCESS_TOKEN);
    }

    @Test(enabled = true, groups = {"public_api.p1"})
    public void createAnswer() throws IOException {
        answerRequest.setValue("Answer" + getUniqueNumber(0, 10));
        Response<BasicDTO<AnswerRequest>> createAnswerResponse = answerWorkflow.createAnswer(authorization, answerRequest);
        String answerId = createAnswerResponse.body().getData().getId();
        Assert.assertEquals(createAnswerResponse.code(), HttpStatus.SC_OK, "Response code's do not match");
        Assert.assertEquals(createAnswerResponse.body().getData().getValue(), answerRequest.getValue(), "Value's do not match");
        //Delete Answer
        this.deleteAnswer(answerId, authorization);
    }


    public void deleteAnswer(String answerId, String authorization) throws IOException {
        Response deleteAnswer = answerWorkflow.deleteAnswer(answerId, authorization);
        Assert.assertEquals(deleteAnswer.code(), HttpStatus.SC_OK, "Delete answer API response do not match");
    }
}
