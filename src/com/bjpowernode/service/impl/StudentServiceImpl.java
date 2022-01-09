package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

public class StudentServiceImpl implements StudentService {
StudentDao studentDao= SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
    @Override
    public Student getById(String id) {
        Student s=studentDao.getById(id);
        return s;
    }

    @Override
    public void save(Student s) {
        studentDao.save(s);
    }
}
