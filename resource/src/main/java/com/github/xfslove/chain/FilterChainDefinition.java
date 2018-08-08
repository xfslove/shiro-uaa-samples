package com.github.xfslove.chain;

import com.github.xfslove.autoconfigure.shiro.filter.CustomFilterChainDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * Created by hanwen on 2018/8/8.
 */
@Component
public class FilterChainDefinition implements CustomFilterChainDefinition {

  private static final Logger LOGGER = LoggerFactory.getLogger(FilterChainDefinition.class);

  @Override
  public LinkedHashMap<String, String> getFilterChainMap() {
    LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    filterChainDefinitionMap.put("/favicon.ico", "anon");
    filterChainDefinitionMap.put("/error", "anon");
    filterChainDefinitionMap.put("/", "anon");

    LOGGER.info("uaa filter chain: {} {}", "/favicon.ico", "anon");
    LOGGER.info("uaa filter chain: {} {}", "/error", "anon");
    LOGGER.info("uaa filter chain: {} {}", "/", "anon");
    return filterChainDefinitionMap;
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
