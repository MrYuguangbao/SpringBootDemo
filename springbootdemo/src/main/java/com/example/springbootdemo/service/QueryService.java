package com.example.springbootdemo.service;

import com.example.springbootdemo.model.FileVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QueryService {

    List<FileVO> queryFileList();
}
