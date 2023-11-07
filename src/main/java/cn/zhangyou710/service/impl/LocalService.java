package cn.zhangyou710.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.zhangyou710.common.exception.BusinessException;
import cn.zhangyou710.common.template.LocalTemplate;
import cn.zhangyou710.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 本地上传业务实现
 *
 * @author ZhangYou
 * @date 2023/10/6
 */
@Service
@ConditionalOnProperty(prefix = "zy.files-server", name = "type", havingValue = "local")
public class LocalService extends AbstractIFileService {

    @Resource
    private LocalTemplate localTemplate;

    @Override
    protected FilePojo uploadFile(MultipartFile file) {
        return localTemplate.upload(file);
    }


    @Override
    protected FilePojo uploadFileSharding(MultipartFile file, HttpSession session) {
        throw new BusinessException("分片上传目前只支持OSS，本地模式还未实现！");
    }

    @Override
    protected void deleteFile(String url) {
        if (StrUtil.isNotEmpty(url)) {
            localTemplate.delete(url);
        }
    }

    @Override
    public void download(String url, HttpServletResponse response) {
        localTemplate.download(url, response);
    }
}
