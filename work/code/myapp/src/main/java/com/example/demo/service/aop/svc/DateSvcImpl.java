package com.example.demo.service.aop.svc;

import com.example.demo.service.aop.svc.DateSvc;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaonan1
 * @date 2020/5/14
 **/
@Service("dateSvc")
public class DateSvcImpl implements DateSvc {

    @Override
    public void printDate(Date date) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }
}
