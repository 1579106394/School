package com.school.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 权限控制的Realm
 * @author 杨德石
 * @date 2018/11/28
 */
public class SchoolRealm extends AuthorizingRealm {

    /**
     * 授权方法
     * @param principalCollection
     * @author 杨德石
     * @date 2018/11/28
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("============授权方法执行了===========");

        // 先写在这里，保证授权都能过去，
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        return info;
    }

    /**
     * 认证方法
     * @param token
     * @author 杨德石
     * @date 2018/11/28
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 先写在这里，保证认证都能过去
        AuthenticationInfo info = new SimpleAuthenticationInfo();

        return info;
    }
}
