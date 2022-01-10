package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;

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

    @Override
    public List<Student> test02(String[] arr) {
        List<Student> sList=studentDao.test02(arr);
        return sList;
    }

    @Override
    public Student test03(Student s) {
        Student s1=studentDao.test03(s);
        return s1;
    }
}
