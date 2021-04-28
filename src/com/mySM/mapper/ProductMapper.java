package com.mySM.mapper;

import com.mySM.pojo.Category;
import com.mySM.pojo.Product;
import com.sun.scenario.effect.impl.prism.PrDrawable;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Insert("insert into product (id,name,price,cid) values (#{id},#{name},#{price},#{category.id})")
    public int add(Product product);

    @Delete("delete from product where id = #{id}")
    public void delete(int id);

    @Select("select * from product where id = #{id}")
    public Product get(int id);

    @Select("select * from product where cid= #{cid}")
    public List<Product> getListByCid(int cid);

    @Select("select * from product ")
    @Results({
            @Result(property = "category" ,javaType = Category.class, column = "cid",
                    one = @One(select = "com.mySM.mapper.CategoryMapper.get"))
    })
    public List<Product> list();
}
