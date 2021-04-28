package com.mySM.mapper;

import com.mySM.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryMapper {
    @Insert("insert into category (id,name) values (#{id},#{name})")
    public int add(Category category);

    @Delete("delete from category where id = #{id}")
    public void delete(int id);

    @Select("select * from category where id = #{id}")
    public Category get(int id);

    @Update("update category set name= #{name} where id = #{id}")
    public int update(Category category);


    @Select("select * from category ")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",javaType = List.class,property = "products",
                    many = @Many(select = "com.mySM.mapper.ProductMapper.getListByCid"))
    })
    public List<Category> list();

    @Select("select count(id) from category")
    public int count();

    @Select("select id from category")
    public int getId();

}
