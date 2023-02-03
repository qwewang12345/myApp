package com.example.demo.service.ql;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @author gaonan1
 * @date 2021/4/22 17:55
 **/
public class QLExpressTest {

    public static void main(String[] args) throws Exception {
        String a = "1000.00";
        int b = Double.valueOf(a).intValue();
        System.out.println(b);

        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a",1);
        context.put("b",2);
        context.put("c", 0.3);
        context.put("d", "B");
        String express = "a+b*c";
        if (express == "a+b*c") {
            System.out.println(true);
        }
        // String express1 = "e == \"hello world\"";
        String express1 = "d == \"B\"";
        String express2 = "c >= 0.2";
        Object r1 = runner.execute(express, context, null, true, false);
        Object r = runner.execute(express2, context, null, true, false);
        System.out.println(r1);
    }
}
