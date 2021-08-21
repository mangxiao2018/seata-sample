package com.mangxiao.seata.purchase.sample.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j(topic = "c.OkHttpUtil")
public class OkHttpUtil {
    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final int TIMEOUT = 3000;

    public String sendGetRequest(String url){
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e){
            log.debug("ERROR:" + e.getMessage());
        }
        return "";
    }
}
