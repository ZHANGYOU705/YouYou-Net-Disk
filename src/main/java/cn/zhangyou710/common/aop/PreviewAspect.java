package cn.zhangyou710.common.aop;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cn.zhangyou710.common.annotation.Preview;
import cn.zhangyou710.common.exception.BusinessException;
import cn.zhangyou710.model.FilePojo;
import cn.zhangyou710.service.FileService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 演示环境拦截器
 *
 * @author ZhangYou
 * @date 2023/10/16
 */
@Aspect
@Component
public class PreviewAspect {

    @Autowired
    private FileService fileService;

    @Before("@annotation(preview)")
    public void doBefore(JoinPoint point, Preview preview) {
        Long id = StpUtil.getLoginIdAsLong();
        long fileCount = fileService.count(new LambdaQueryWrapper<FilePojo>()
                .eq(FilePojo::getIsDir, 0)
                .eq(FilePojo::getUserId, id));
        System.out.println(fileCount);
        if (fileCount >= preview.count()) {
            throw new BusinessException("演示环境限制每个用户最多上传" + preview.count() + "个文件");
        }
    }
}
