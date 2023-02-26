package com.example.demo.service.spring.ioc.single;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gaonan1
 * @date 2020/10/16 10:24
 **/
@Service
public class DefaultTestService {

    @Resource
    private TestDao testDao;

    public Integer getCount() {
        return testDao.getCount();
    }

    public void incCount() {
        testDao.setCount(testDao.getCount()+1);
    }
    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }
}
