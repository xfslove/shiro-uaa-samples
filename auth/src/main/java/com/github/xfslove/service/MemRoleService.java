package com.github.xfslove.service;

import com.github.xfslove.autoconfigure.shiro.model.AccessClient;
import com.github.xfslove.autoconfigure.shiro.model.Account;
import com.github.xfslove.autoconfigure.shiro.model.Role;
import com.github.xfslove.autoconfigure.shiro.service.AccessClientService;
import com.github.xfslove.autoconfigure.shiro.service.AccountService;
import com.github.xfslove.autoconfigure.shiro.service.RoleService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanwen on 2018/8/8.
 */
@Service
public class MemRoleService implements RoleService, InitializingBean {

  private Map<Long, Role> db = new ConcurrentHashMap<>(16);

  @Autowired
  private AccountService accountService;

  @Autowired
  private AccessClientService accessClientService;

  @Override
  public Set<String> getPermCodes(String clientId, String username) {
    Account account = accountService.getByUsername(username);
    AccessClient client = accessClientService.getByClient(clientId);
    Set<Long> roleIds = account.getRoleIds();
    Set<String> perms = new HashSet<>();
    for (Long id : db.keySet()) {
      if (roleIds.contains(id) && db.get(id).getAccessClientId().equals(client.getId())) {
        perms.addAll(db.get(id).getPermCodes());
      }
    }
    return perms;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Role r1 = new Role();
    r1.setId(1L);
    r1.setAccessClientId(1L);
    r1.setEnabled(true);
    r1.setName("role1");
    r1.setPermCodes(new HashSet<>(Arrays.asList("perm1", "perm2")));

    Role r2 = new Role();
    r2.setId(2L);
    r2.setAccessClientId(1L);
    r2.setEnabled(true);
    r2.setName("role2");
    r2.setPermCodes(new HashSet<>(Arrays.asList("perm3", "perm4")));

    db.put(r1.getId(), r1);
    db.put(r2.getId(), r2);
  }
}
