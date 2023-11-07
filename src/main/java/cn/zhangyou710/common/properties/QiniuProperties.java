package cn.zhangyou710.common.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 七牛云配置资源类
 *
 * @author ZhangYou
 * @date 2023/10/10
 */
@Getter
@Setter
public class QiniuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String path;
}
