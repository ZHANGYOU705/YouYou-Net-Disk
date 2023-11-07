package cn.zhangyou710.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.zhangyou710.common.exception.BusinessException;
import cn.zhangyou710.common.template.QiniuTemplate;
import cn.zhangyou710.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 七牛业务实现
 *
 * @author ZhangYou
 * @date 2023/10/6
 */
@Service
@ConditionalOnProperty(prefix = "zy.files-server", name = "type", havingValue = "qiniu")
public class QiniuService extends AbstractIFileService {

    @Resource
    private QiniuTemplate qiniuTemplate;

    @Override
    protected FilePojo uploadFile(MultipartFile file) {
        return qiniuTemplate.upload(file);
    }

    @Override
    protected FilePojo uploadFileSharding(MultipartFile file, HttpSession session) {
        throw new BusinessException("分片上传目前只支持OSS，七牛还未实现！");
    }

    @Override
    protected void deleteFile(String objectPath) {
        if (StrUtil.isNotEmpty(objectPath)) {
            qiniuTemplate.delete(objectPath);
        }
    }

    @Override
    public void download(String url, HttpServletResponse response) {
        qiniuTemplate.download(url, response);
    }
}
