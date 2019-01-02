package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.FileVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QueryDao {

    @Select("select * from t_file")
    List<FileVO> queryFileList();
}
