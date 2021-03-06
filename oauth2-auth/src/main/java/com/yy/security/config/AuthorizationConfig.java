package com.yy.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.stereotype.Component;

/**
 * @Author ywl
 * @Date 2021/5/20 19:53
 * @Description 授权服务器
 */
@Component
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单提交
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // appid
                .withClient("mayikt")
                // appsecret
                .secret(passwordEncoder.encode("mayikt_secret"))
                // 授权码
                .authorizedGrantTypes("authorization_code")
                // 作用域
                .scopes("all")
                // 资源的id
                .resourceIds("mayikt_resource")
                // 回调地址
                .redirectUris("https://www.baidu.com");

    }
}
