package com;

import com.mySM.mapper.CategoryMapper;
import com.mySM.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Test {
    @Autowired
    private  CategoryMapper categoryMapper;


    public  void  list(){
        List<Category> categories= categoryMapper.list();
        for (Category c:categories
             ) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Test t1=new Test();
        t1.list();
    }
}
