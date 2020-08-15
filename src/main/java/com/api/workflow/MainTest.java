package main.java.com.api.workflow;

import main.java.com.api.util.config;
import main.java.com.api.util.credential;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.function.BiFunction;

/**
 * Created by Ashlin Karkada on 16-06-2017.
 */
public class MainTest {
    //final String authorization = config.get(credential.DEFAULT_ADMIN_ACCESS_TOKEN);
    //final String adminId=config.get(credential.DEFAULT_ADMIN_ID);

    static final String BASE_URL = config.get(credential.APP_BASE_URL);

    static final okhttp3.OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();

    OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static Retrofit retrofit() {
        return retrofit;
    }

//    public static APIError parseError(Response<?> response) throws IOException {
//        Converter<ResponseBody, APIError> converter = MainTest.retrofit()
//                .responseBodyConverter(APIError.class, new Annotation[0]);
//        APIError error = converter.convert(response.errorBody());
//        return error;
//    }

    public String getUniqueNumber(int startIndex, int endIndex) {
        return UUID.randomUUID().toString().substring(startIndex, endIndex).replace("-", "");
    }
    //protected BiFunction<Integer, Integer, String> bi = (startIndex, endIndex) -> UUID.randomUUID().toString().substring(startIndex, endIndex).replace("-", "");



    @BeforeSuite(enabled = true)
    public void beforeSuiteMethod() throws IOException{
        System.out.println("Before suite executed");
    }

}

