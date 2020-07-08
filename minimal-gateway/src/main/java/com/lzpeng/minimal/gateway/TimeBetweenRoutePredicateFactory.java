package com.lzpeng.minimal.gateway;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义路由谓词工厂当条件满足时才进入路由
 * 类名必须以 RoutePredicateFactory 结尾
 * @author: Lzpeng
 * @see org.springframework.cloud.gateway.handler.predicate.BetweenRoutePredicateFactory
 * 默认时间格式：
 * @see org.springframework.format.datetime.standard.DateTimeFormatterRegistrar#getgetFallbackFormatter(org.springframework.format.datetime.standard.DateTimeFormatterRegistrar.Type)
 * 时间格式注册：
 * @see org.springframework.format.datetime.standard.DateTimeFormatterRegistrar#registerFormatters
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenRoutePredicateFactory.Config> {

    public TimeBetweenRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        @NotNull final LocalTime start = config.getStart();
        @NotNull final LocalTime end = config.getEnd();
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                final LocalTime now = LocalTime.now();
                if (start.isBefore(end)) {
                    // 配置的 start 在 end 前, 如 上午9:00,下午5:00
                    return now.isAfter(start) && now.isBefore(end);
                } else {
                    // 配置的 start 在 end 后, 如 下午5:00,上午9:00
                    return now.isBefore(start) || now.isAfter(end);
                }
            }

            @Override
            public String toString() {
                return String.format("Between: %s and %s", start, end);
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        // 要和Config类中属性名相同
        // 第一个参数为 yml 配置文件中的第一个参数, 以此类推
        return Arrays.asList("start", "end");
    }

    /**
     * 测试时间格式
     * @param args ...
     * @see org.springframework.format.datetime.standard.DateTimeFormatterRegistrar#getFallbackFormatter(org.springframework.format.datetime.standard.DateTimeFormatterRegistrar.Type)
     */
    public static void main(String[] args) {
        //
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(dateTimeFormatter.format(LocalTime.now()));
    }

    @Validated
    @Data
    public static class Config {

        @NotNull
        private LocalTime start;

        @NotNull
        private LocalTime end;

    }
}