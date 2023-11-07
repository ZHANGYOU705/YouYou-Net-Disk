package cn.zhangyou710.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文件上传配置资源类
 *
 * @author ZhangYou
 * @date 2023/10/10
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "zy.files-server")
public class FileServerProperties {

    /**
     * 自动化配置
     * type：oss or qiniu
     */
    private String type = "qiniu";

    /**
     * 本地上传配置
     */
    LocalProperties local = new LocalProperties();

    /**
     * 七牛配置
     */
    QiniuProperties qiniu = new QiniuProperties();

    /**
     * oss配置
     */
    OssProperties oss = new OssProperties();
}
