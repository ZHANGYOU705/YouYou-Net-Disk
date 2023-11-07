package cn.zhangyou710;

import cn.zhangyou710.common.properties.FileServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 云享存 - 佑佑云盘
 *
 * @author ZhangYou
 * @date 2023/10/16
 */
@SpringBootApplication
@EnableConfigurationProperties({FileServerProperties.class})
@Slf4j
public class RunApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RunApplication.class, args);
        log.info("云享存-佑佑云盘 运行成功! 访问连接: {}", "http://127.0.0.1:8081");
    }

}
