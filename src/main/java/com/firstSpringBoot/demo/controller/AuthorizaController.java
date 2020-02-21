package com.firstSpringBoot.demo.controller;

import com.firstSpringBoot.demo.bean.AccessTokenBean;
import com.firstSpringBoot.demo.bean.GitHubUser;
import com.firstSpringBoot.demo.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizaController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    //返回到callback页面
    @GetMapping("/callback")
    public String callBack(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenBean accessTokenBean = new AccessTokenBean();
        accessTokenBean.setCode(code);
        accessTokenBean.setState(state);
        accessTokenBean.setRedirect_uri(redirectUri);
        accessTokenBean.setClient_secret(clientSecret);
        accessTokenBean.setClient_id(clientId);

        String token = gitHubProvider.getAccessToken(accessTokenBean);
        GitHubUser gitHubUser = gitHubProvider.getGitHubUser(token);
        System.out.println(gitHubUser.getName());
        return "index";
    }
}

