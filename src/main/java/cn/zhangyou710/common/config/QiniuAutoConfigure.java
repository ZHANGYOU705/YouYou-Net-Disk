package cn.zhangyou710.common.config;

import cn.zhangyou710.common.properties.FileServerProperties;
import cn.zhangyou710.common.template.QiniuTemplate;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 七牛云配置
 *
 * @author ZhangYou
 * @date 2023/10/10
 */
@Configuration
@ConditionalOnProperty(prefix = "zy.files-server", name = "type", havingValue = "qiniu")
@RequiredArgsConstructor
public class QiniuAutoConfigure {

    private final FileServerProperties fileProperties;

    /**
     * 指定华南机房,配置自己空间所在的区域
     */
    @Bean
    public com.qiniu.storage.Configuration qiniuConfig() {
        return new com.qiniu.storage.Configuration(Zone.zone2());
    }

    /**
     * 构建一个七牛上传工具实例
     */
    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }

    /**
     * 认证信息实例
     *
     * @return
     */
    @Bean
    public Auth auth() {
        return Auth.create(fileProperties.getQiniu().getAccessKey(), fileProperties.getQiniu().getSecretKey());
    }

    /**
     * 构建七牛空间管理实例
     */
    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(), qiniuConfig());
    }

    @Bean
    public QiniuTemplate qiniuTemplate() {

        return new QiniuTemplate(uploadManager(), bucketManager(), auth(), fileProperties.getQiniu());
    }
}
