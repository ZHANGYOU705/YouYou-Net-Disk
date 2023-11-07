package cn.zhangyou710.common.config;

import cn.zhangyou710.common.properties.FileServerProperties;
import cn.zhangyou710.common.template.LocalTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 本地上传配置
 *
 * @author ZhangYou
 * @date 2023/10/14
 */
@Configuration
@ConditionalOnProperty(prefix = "zy.files-server", name = "type", havingValue = "local")
@RequiredArgsConstructor
public class LocalAutoConfigure {

    private final Environment environment;
    private final FileServerProperties fileProperties;

    @Bean
    public LocalTemplate localTemplate() {

        return new LocalTemplate(environment, fileProperties.getLocal());
    }
}
