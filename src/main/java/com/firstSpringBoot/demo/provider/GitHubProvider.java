package com.firstSpringBoot.demo.provider;

import com.alibaba.fastjson.JSON;
import com.firstSpringBoot.demo.bean.AccessTokenBean;
import com.firstSpringBoot.demo.bean.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author my
 */
@Component
public class GitHubProvider {

    //将code传给github获取token
    public String getAccessToken(AccessTokenBean accessTokenBean){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        //accessTokenBean 转json
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenBean),mediaType);

        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();

        try(Response response = client.newCall(request).execute()) {

            String responsetoken = response.body().string().split("&")[0].split("=")[1];
            System.out.println(responsetoken);
            return responsetoken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    //通过token获取得user信息
    public GitHubUser getGitHubUser(String accessToken){

        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                String userMsg= response.body().string();
                GitHubUser gitHubUser = JSON.parseObject(userMsg,GitHubUser.class);
                return gitHubUser;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }




}
