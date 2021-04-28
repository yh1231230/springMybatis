import com.mySM.mapper.ProductMapper;
import com.mySM.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mySM.mapper.CategoryMapper;
import com.mySM.pojo.Category;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSM {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;


    public void testAdd(){
        System.out.println("测试");
        Category category=new Category();
        category.setName("new category");
        categoryMapper.add(category);
    }

    @Test
    public void testAddP(){
        Product p=new Product();
        p.setId(8);
        p.setName("product e");
        p.setPrice(88.88f);
        p.setCategory(categoryMapper.get(1));

        productMapper.add(p);
    }

    @Test
    public void testList(){
        List<Category> categories=categoryMapper.list();
        for (Category c:categories
             ) {
            System.out.println(c);
            List<Product> products= c.getProducts();
            for (Product p:products
                 ) {
                System.out.println(p.getName());
            }
        }
    }



    public void testList2(){
        System.out.println();
        List<Product> ps=productMapper.list();
        for (Product p:ps
             ) {
            System.out.println(p+""+p.getCategory().getName());
        }
    }


}
