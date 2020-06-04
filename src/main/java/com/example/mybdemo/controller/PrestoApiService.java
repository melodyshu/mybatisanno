package com.example.mybdemo.controller;

import com.example.mybdemo.mapper.PrestoMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author zhanghui
 * @date 2020/6/1
 * @descirption
 */
@Service("prestoApiService")
public class PrestoApiService implements IPrestoApiService {

    private String prestoUrl;
    private String prestoUser;
    private String prestoPwd;
    private String prestoDriver;
    @Autowired
    private Environment env;

    @Autowired
    private PrestoMapper prestoMapper;


    @Override
    public List<String> selectList(String sqlId) {
        //return new ArrayList<>();
        return prestoMapper.selectList(sqlId);
    }
}
