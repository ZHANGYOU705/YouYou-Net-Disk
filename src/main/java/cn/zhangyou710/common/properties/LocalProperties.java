package cn.zhangyou710.common.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 本地上传配置资源类
 *
 * @author ZhangYou
 * @date 2023/10/10
 */
@Getter
@Setter
public class LocalProperties {

    private String uploadDir;
    private String uploadMapping;

    private String domain;
}
