package com.whhx.handler;

import com.whhx.config.SpringContextBeanService;
import com.whhx.exception.MyAccountNotFoundException;
import com.whhx.service.UserService;
import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;

import javax.security.auth.login.CredentialExpiredException;
import java.security.GeneralSecurityException;
import java.util.Map;
/**
 * @Author: jiangwei
 * @Date: 2019-05-29
 * @Desc:
 */
public class Customhandler extends AbstractPreAndPostProcessingAuthenticationHandler {


    private UserService userService;

    public Customhandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }


    /**
     * 用于判断用户的Credential(换而言之，就是登录信息)，是否是能处理的
     * 就是有可能是，子站点的登录信息中不止有用户名密码等信息，还有部门信息的情况
     */
    @Override
    public boolean supports(Credential credential) {
        //判断传递过来的Credential 是否是自己能处理的类型
        return credential instanceof UsernamePasswordCredential;
    }

    @Override
    protected AuthenticationHandlerExecutionResult doAuthentication(Credential credential) throws GeneralSecurityException, PreventedException {
        if (this.userService == null) {
            this.userService = SpringContextBeanService.getBean(UserService.class);
        }

        UsernamePasswordCredential myCredential = (UsernamePasswordCredential) credential;

        //获取传递过来的用户名和密码
        String username = myCredential.getUsername();
        Map<String, Object> user = userService.findByUserName(username);

        if (user == null) {
            throw new MyAccountNotFoundException("用户不存在");
        }

        //可以在这里直接对用户名校验,或者调用 CredentialsMatcher 校验
        if (!user.get("password").equals(myCredential.getPassword())) {
            throw new CredentialExpiredException("用户名或密码错误！");
        }
        //允许登录，并且通过this.principalFactory.createPrincipal来返回用户属性
        return createHandlerResult(credential, this.principalFactory.createPrincipal(username, user));
        //if(username.startsWith("admin")) {
        //直接返回去了
        //}else if (username.startsWith("lock")) {
        //    //用户锁定
        //    throw new AccountLockedException();
        //} else if (username.startsWith("disable")) {
        //    //用户禁用
        //    throw new AccountDisabledException();
        //} else if (username.startsWith("invali")) {
        //    //禁止登录该工作站登录
        //    throw new InvalidLoginLocationException();
        //} else if (username.startsWith("passorwd")) {
        //    //密码错误
        //    throw new FailedLoginException();
        //} else if (username.startsWith("account")) {
        //    //账号错误
        //    throw new AccountLockedException();
        //}
        //return null;
    }
}
