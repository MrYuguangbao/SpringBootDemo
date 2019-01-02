package com.example.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileVO {

    private int id;
    private String title;
    private String author;
    private String content;
    private String type;
    private String createTime;
}
