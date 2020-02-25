package com.firstSpringBoot.demo.controller;
import com.firstSpringBoot.demo.bean.AccessTokenBean;
import com.firstSpringBoot.demo.bean.GitHubUser;
import com.firstSpringBoot.demo.bean.User;
import com.firstSpringBoot.demo.mapper.UserMapper;
import com.firstSpringBoot.demo.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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
    @Autowired
    private UserMapper userMapper;

    /**
     * @Author jc-qings
     * @Date 2020/2/25 11:29
     * @Description This is description of method
     * @Param [code, state, request]
     * @Return java.lang.String
     * @Since version-1.0
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request
                            ){
        AccessTokenBean accessTokenBean = new AccessTokenBean();
        accessTokenBean.setCode(code);
        accessTokenBean.setState(state);
        accessTokenBean.setRedirect_uri(redirectUri);
        accessTokenBean.setClient_secret(clientSecret);
        accessTokenBean.setClient_id(clientId);

        String token = gitHubProvider.getAccessToken(accessTokenBean);
        GitHubUser gitHubUser = gitHubProvider.getGitHubUser(token);
        if(null!=gitHubUser){
            User user = new User();
            user.setName(gitHubUser.getName());
            user.setAccount_id(gitHubUser.getId());
            user.setToken(UUID.randomUUID().toString());
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(System.currentTimeMillis());
            userMapper.insert(user);
            //写Session
            request.getSession().setAttribute("user",gitHubUser);
            return "redirect:/";
        }else{
            //flase
            return "redirect:/";
        }
    }



}

