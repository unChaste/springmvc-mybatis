package com.ay.test;

import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;

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
        AyUser ayUser = ayUserDao.findById2(1);
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

}
