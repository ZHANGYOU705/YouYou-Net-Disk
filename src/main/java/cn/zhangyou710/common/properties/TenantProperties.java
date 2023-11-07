package cn.zhangyou710.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 多租户配置
 *
 * @author ZhangYou
 * @date 2023/10/10
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "zy.tenant")
public class TenantProperties {

    /**
     * 是否开启多租户
     */
    private Boolean enable = false;

    /**
     * 配置不进行多租户隔离的表名
     */
    private List<String> ignoreTables = new ArrayList<>();

    /**
     * 配置不进行多租户隔离的sql
     */
    private List<String> ignoreSqls = new ArrayList<>();

}
