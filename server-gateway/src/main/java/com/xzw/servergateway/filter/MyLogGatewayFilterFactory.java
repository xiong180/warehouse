package com.xzw.servergateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

/**
 * MyLogGatewayFilterFactory;
 *
 * @author xzw
 * @date 2021/2/11 13:41
 */
@Component
public class MyLogGatewayFilterFactory extends AbstractGatewayFilterFactory<MyLogGatewayFilterFactory.Config> {
    private static final Log log = LogFactory.getLog(MyLogGatewayFilterFactory.class);
    private static final String MY_LOG_START_TIME = MyLogGatewayFilterFactory.class.getName() + "." + "startTime";

    public MyLogGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("enabled");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!config.isEnabled()) {
                return chain.filter(exchange);
            }
            exchange.getAttributes().put(MY_LOG_START_TIME, System.currentTimeMillis());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                Long startTime = exchange.getAttribute(MY_LOG_START_TIME);
                if (null != startTime) {
                    ServerHttpRequest serverHttpRequest = exchange.getRequest();
                    String sb = serverHttpRequest.getURI().getRawPath() +
                            " : " +
                            serverHttpRequest.getQueryParams() +
                            " : " +
                            (System.currentTimeMillis() - startTime) +
                            "ms";
                    log.info(sb);
                }
            }));
        };
    }

    public static class Config {
        /**
         * 是否开启
         */
        private boolean enabled;

        public Config() {
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
