package com.github.xfslove.service;

import com.github.xfslove.autoconfigure.shiro.model.Account;
import com.github.xfslove.autoconfigure.shiro.service.AccountService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanwen on 2018/8/8.
 */
@Service
public class MemAccountService implements AccountService, InitializingBean {

  private Map<String, Account> db = new ConcurrentHashMap<>(16);

  @Override
  public Account getByUsername(String username) {
    return db.get(username);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Account a1 = new Account();
    a1.setId(1L);
    a1.setEnabled(true);
    a1.setPassword("123");
    a1.setUsername("test1");
    a1.setRoleIds(Collections.singleton(1L));

    Account a2 = new Account();
    a2.setId(2L);
    a2.setEnabled(true);
    a2.setPassword("123456");
    a2.setUsername("test2");
    a2.setRoleIds(Collections.singleton(2L));

    db.put(a1.getUsername(), a1);
    db.put(a2.getUsername(), a2);
  }
}
