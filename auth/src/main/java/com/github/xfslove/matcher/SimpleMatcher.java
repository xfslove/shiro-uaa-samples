package com.github.xfslove.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * Created by hanwen on 2018/8/8.
 */
@Component
public class SimpleMatcher implements CredentialsMatcher {

  @Override
  public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    UsernamePasswordToken t = (UsernamePasswordToken) token;
    String credentials = (String) info.getCredentials();
    return new String(t.getPassword()).equals(credentials);
  }
}
