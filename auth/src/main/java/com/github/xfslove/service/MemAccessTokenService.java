package com.github.xfslove.service;

import com.github.xfslove.autoconfigure.shiro.model.AccessToken;
import com.github.xfslove.autoconfigure.shiro.service.AccessTokenService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanwen on 2018/8/8.
 */
@Service
public class MemAccessTokenService implements AccessTokenService {

  private Map<String, AccessToken> db = new ConcurrentHashMap<>(64);

  @Override
  public void save(AccessToken accessToken) {
    db.put(accessToken.getAccessToken(),accessToken);
  }

  @Override
  public AccessToken getByAccessToken(String accessToken) {
    return db.get(accessToken);
  }

  @Override
  public AccessToken getByRefreshToken(String accessToken) {
    for (AccessToken value : db.values()) {
      if (value.getRefreshToken().equals(accessToken)) {
        return value;
      }
    }
    return null;
  }

  @Override
  public AccessToken getBySession(String sessionId, String clientId) {
    for (AccessToken value : db.values()) {
      if (value.getSessionId().equals(sessionId) && value.getClientId().equals(clientId)) {
        return value;
      }
    }
    return null;
  }

  @Override
  public List<AccessToken> getBySession(String sessionId) {
    List<AccessToken> result = new ArrayList<>();
    for (AccessToken value : db.values()) {
      if (value.getSessionId().equals(sessionId)) {
        result.add(value);
      }
    }
    return result;
  }

  @Override
  public boolean remove(String accessToken) {
    return db.remove(accessToken) != null;
  }
}
