package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;

public class test01 {
    public static void main(String[] args) {
        StudentService ss= (StudentService) ServiceFactory.factory(new StudentServiceImpl());
            Student s=ss.getById("A0002");
            System.out.println(s.getName());
    }
}
