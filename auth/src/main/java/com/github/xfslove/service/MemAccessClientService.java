package com.github.xfslove.service;

import com.github.xfslove.autoconfigure.shiro.model.AccessClient;
import com.github.xfslove.autoconfigure.shiro.service.AccessClientService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanwen on 2018/8/8.
 */
@Service
public class MemAccessClientService implements AccessClientService, InitializingBean {

  private Map<String, AccessClient> db = new ConcurrentHashMap<>(16);

  @Override
  public AccessClient getByClient(String s) {
    return db.get(s);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    AccessClient client = new AccessClient();
    client.setClientId("cli1");
    client.setClientSecret("cli1");
    client.setEnabled(true);
    client.setName("cli1");
    client.setId(1L);
    db.put(client.getClientId(), client);
  }
}
