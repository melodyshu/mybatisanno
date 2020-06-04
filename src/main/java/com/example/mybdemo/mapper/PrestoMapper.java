package com.example.mybdemo.mapper;

import com.example.mybdemo.domain.PrestoCacheBean;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @Author: huangzhimao
 * @Date: 2020-06-03
 * @Description:
 */
@Repository
public interface PrestoMapper {

  void save(List<PrestoCacheBean> list);

  List<String> selectList(String sqlId);
}
