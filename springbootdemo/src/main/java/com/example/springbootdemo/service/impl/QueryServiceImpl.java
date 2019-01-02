package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.QueryDao;
import com.example.springbootdemo.model.FileVO;
import com.example.springbootdemo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryDao queryDao;

    @Override
    public List<FileVO> queryFileList() {
        return queryDao.queryFileList();
    }
}
