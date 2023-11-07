package cn.zhangyou710.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.zhangyou710.model.FilePojo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资源文件表mapper接口
 *
 * @author ZhangYou
 * @date 2023/10/12
 */
@Mapper
public interface FileMapper extends BaseMapper<FilePojo> {

}
