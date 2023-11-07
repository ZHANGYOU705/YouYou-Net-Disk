package cn.zhangyou710.common.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import cn.zhangyou710.common.properties.FileServerProperties;
import cn.zhangyou710.common.template.OssTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云配置
 *
 * @author ZhangYou
 * @date 2023/10/14
 */
@Configuration
@ConditionalOnProperty(prefix = "zy.files-server", name = "type", havingValue = "oss")
@RequiredArgsConstructor
public class OssAutoConfigure {

    private final FileServerProperties fileProperties;


    @Bean
    public OSS ossClient() {

        return new OSSClientBuilder().build(fileProperties.getOss().getEndpoint(), fileProperties.getOss().getAccessKey(), fileProperties.getOss().getSecretKey());
    }

    @Bean
    public OssTemplate ossTemplate() {

        return new OssTemplate(ossClient(), fileProperties.getOss());
    }
}
