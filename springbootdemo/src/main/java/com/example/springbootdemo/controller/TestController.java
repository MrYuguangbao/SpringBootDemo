package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.common.CommonResult;
import com.example.springbootdemo.model.FileVO;
import com.example.springbootdemo.service.QueryService;
import com.example.springbootdemo.utils.MyDateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api("swagger 测试")
@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private QueryService queryService;


    @RequestMapping("/modelandview")
    public ModelAndView show(){
        logger.info("{},call show ! ",MyDateUtil.formatDate(new Date()));
        ModelAndView modelAndView = new ModelAndView("result");
        List<FileVO> list = Lists.newArrayList();
        for (int i = 1; i <= 5; i++) {
            FileVO fileVO = new FileVO(i,"标题"+i,"作者"+i,"正文"+i,"文档类型"+i,"创建时间"+i);
            list.add(fileVO);
        }
        modelAndView.addObject("resultList",list);
        modelAndView.addObject("resultJson",JSON.toJSONString(list));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(){
        logger.info("----------------------- {},call index ! ",MyDateUtil.formatDate(new Date()));
        Map<String,String> map = Maps.newHashMap();
        map.put("param1","result1");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("indexResult",map);
        return modelAndView;
    }
//
//    @RequestMapping("/hello")
//    public String hello(Model model,String name){
//        logger.info("--------------------------------- call hello !");
//        model.addAttribute("name",name);
//        return "hello";
//    }

    @ResponseBody
    @RequestMapping(value = "/responseBodyDemo",method = RequestMethod.POST)
    public CommonResult requestBodyDemo(@RequestBody(required = false) FileVO fileVO){
        FileVO result = new FileVO(2,"title_ajax","author_ajax","content_ajax","type_ajax","createtime_ajax");
        if(fileVO != null){
            result = new FileVO(fileVO.getId(),fileVO.getTitle(),fileVO.getAuthor(),fileVO.getContent(),fileVO.getType(),fileVO.getCreateTime());
        }
        return CommonResult.success(result);
    }

    @ResponseBody
    @RequestMapping(value = "/requestParamDemo")
    public CommonResult requestParamDemo(@RequestParam(value = "author") String author){
        List<FileVO> list = Lists.newArrayList();
        if(StringUtils.isNotEmpty(author)){
            list = queryService.queryFileList();
        }
        return CommonResult.success(list);
    }

//    @ApiOperation(value = "测试 pathVariable 注解",notes = "在路径中添加变量")
//    @RequestMapping(value = "/pathVariableDemo/{author}",method = RequestMethod.GET)
//    public CommonResult pathVariableDemo(@PathVariable String author){
//        return CommonResult.success(author);
//    }

}
