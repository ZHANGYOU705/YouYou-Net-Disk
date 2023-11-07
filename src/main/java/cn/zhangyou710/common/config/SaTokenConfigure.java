package cn.zhangyou710.common.config;

import cn.dev33.satoken.thymeleaf.dialect.SaTokenDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhangYou
 * @Date: 2023/6/29 17:39
 */
@Configuration
public class SaTokenConfigure {
    @Bean
    public SaTokenDialect getSaTokenDialect() {
        return new SaTokenDialect();
    }
}
