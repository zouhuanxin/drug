package com.example.drug.http;

import okhttp3.*;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpUtil {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public interface HttpCallBack {
        void Error();

        void Success(String str);
    }

    public void doGet(String url, HttpCallBack httpCallBack) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .build();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                httpCallBack.Error();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response == null) {
                    httpCallBack.Error();
                    return;
                }
                if (response.body() == null) {
                    httpCallBack.Error();
                    return;
                }
                String str = response.body().string();
                if (str == null || str.equals("")) {
                    httpCallBack.Error();
                    return;
                }
                httpCallBack.Success(str);
            }
        });
    }

    public void doPost(String url, String json,HttpCallBack httpCallBack) {
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .build();
        Request request = new Request.Builder()
                .header("X-Bmob-Application-Id","931aa07205e9cddf2cd85458d029af79")
                .header("X-Bmob-REST-API-Key","9e1c0370c480f4c47053d155b6d3b251")
                .post(body)
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                httpCallBack.Error();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response == null) {
                    httpCallBack.Error();
                    return;
                }
                if (response.body() == null) {
                    httpCallBack.Error();
                    return;
                }
                String str = response.body().string();
                if (str == null || str.equals("")) {
                    httpCallBack.Error();
                    return;
                }
                httpCallBack.Success(str);
            }
        });
    }

    public Response doPost(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .build();
        Request request = new Request.Builder()
                .header("X-Bmob-Application-Id","931aa07205e9cddf2cd85458d029af79")
                .header("X-Bmob-REST-API-Key","9e1c0370c480f4c47053d155b6d3b251")
                .post(body)
                .url(url)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
