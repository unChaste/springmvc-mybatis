package com.ay.test;

import com.ay.dao.AyUserDao;
import com.ay.dao.ProductDao;
import com.ay.model.AyUser;
import com.ay.model.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class AyUserDaoTest extends BaseJUnit4Test {
    @Resource
    private AyUserDao ayUserDao;

    @Test
    public void testFindAll() {
        List<AyUser> ayUserList = ayUserDao.findAll();
        for (AyUser ayUser : ayUserList) {
            System.out.println("(" + ayUser.getId() + ", " + ayUser.getName() + ", " + ayUser.getPassword() + ")");

        }
    }

    @Test
    public void testFindById() {
        AyUser ayUser = ayUserDao.findById(1);
        Assert.assertEquals(1, ayUser.getId().intValue());
    }

    @Test
    public void testFindByName() {
        List<AyUser> ayUserList = ayUserDao.findByNameAndPassword4("阿里4", null);
        Assert.assertEquals(1, ayUserList.size());
    }

    @Test
    public void testCountByName() {
        int count = ayUserDao.countByName("阿里");
        Assert.assertEquals(1, count);
    }

    @Test
    public void testInsert() {
        for (int i = 1; i < 51; i++) {
            AyUser ayUser = new AyUser();
            ayUser.setId(i);
            ayUser.setName("阿里" + i);
            ayUser.setPassword("asdfjkll" + i);
            int result = ayUserDao.insert(ayUser);
        }
//        Assert.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = ayUserDao.delete(10);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testUpdate() {
        AyUser ayUser = ayUserDao.findById(1);
        ayUser.setName("阿里巴巴");
        ayUser.setPassword("asdfjkll");
        int result = ayUserDao.update(ayUser);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testFindByNameAndPassword() {
        List<AyUser> ayUserList = ayUserDao.findByNameAndPassword4("阿里巴巴", "");
        Assert.assertEquals(1, ayUserList.size());
    }

    @Test
    public void testFindByIds() {
        List<AyUser> ayUserList = ayUserDao.findByIds(new int[]{1, 2});
        Assert.assertEquals(2, ayUserList.size());
    }

    @Test
    public void testFindById3() {
        AyUser ayUser = ayUserDao.findById3(3);
        System.out.println(ayUser.getId());
        Assert.assertEquals(2, ayUser.getAyUserAddressList().size());
    }

    @Test
    public void testPagehelper() {
        PageHelper.startPage(2, 10);

        List<AyUser> userList = ayUserDao.findAll();

        PageInfo pageInfo = new PageInfo(userList);

        System.out.println(pageInfo);
    }

    @Test
    public void testFind() {
        int pageNumber = 2;
        int pageSize = 10;
        int startRow = (pageNumber - 1) * pageSize;
        int total = ayUserDao.count();
        List<AyUser> userList = ayUserDao.find(startRow, pageSize);
        System.out.println(userList);
    }

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testCacheLevelOne() throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AyUserDao ayUserDao = sqlSession.getMapper(AyUserDao.class);

        AyUser ayUserOne = ayUserDao.findById(1);
        System.out.println(ayUserOne);

//        ayUserDao.update(ayUserOne);


        AyUser ayUserTwo = ayUserDao.findById(1);
        System.out.println(ayUserTwo);


        System.out.println("缓存返回的实例是否一样：" + (ayUserOne == ayUserTwo));

        sqlSession.close();
    }

    @Autowired
    private ProductDao productDao;

    @Test
    public void testCacheLevelTwo() {
        AyUser ayUserOne = ayUserDao.findById(1);
        System.out.println(ayUserOne);

//        ayUserDao.update(ayUserOne);
        Product product = productDao.findById(30);
//        System.out.println(product);
        productDao.updateProduct(product);

        AyUser ayUserTwo = ayUserDao.findById(1);
        System.out.println(ayUserTwo);

        System.out.println("缓存返回的实例是否一样：" + (ayUserOne == ayUserTwo));
    }

}
