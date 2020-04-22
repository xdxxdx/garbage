package com.xdx.garbage.druid;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class CustomFilter extends FilterEventAdapter {
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("连接开始前");
    }

    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("连接连接结束后");
    }
}
