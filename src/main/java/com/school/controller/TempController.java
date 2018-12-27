package com.school.controller;

import com.school.mapper.TempMapper;
import com.school.utils.SchoolResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * git不能提交空目录，用这玩意占位一下保证都能提交
 * @author
 * @date
 */
@Controller
public class TempController {

    @Autowired
    private TempMapper tempMapper;

    @RequestMapping("/test")
    @ResponseBody
    public SchoolResult test() {
        return SchoolResult.ok(tempMapper.test());
    }

}
