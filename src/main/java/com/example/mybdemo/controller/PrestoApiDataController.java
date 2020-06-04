package com.example.mybdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangzhimao
 * @Date: 2020-06-03
 * @Description:
 */
@RestController
@RequestMapping("/bigdata/prestoApiData")
public class PrestoApiDataController {

  @Autowired
  private IPrestoApiService prestoApiService;

  @PostMapping("/queryList")
  @ResponseBody
  public List queryList() {
    List<String> list = prestoApiService.selectList("hzmsql001");
    return list;
  }

}
