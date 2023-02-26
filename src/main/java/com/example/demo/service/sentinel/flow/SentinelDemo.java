package com.example.demo.service.sentinel.flow;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaonan
 * @date 2023/1/6 下午4:56
 */
public class SentinelDemo {

    public static void main(String[] args) {
        // 配置规则.
        initFlowRules();

        while (true) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性
            try (Entry entry = SphU.entry("HelloWorld")) {
                try (Entry entry1 = SphU.entry("abc")) {
                    System.out.println("abc");
                    Thread.sleep(100);
                } catch (BlockException | InterruptedException ex) {
                    System.out.println("blocked!");
                }
                // 被保护的逻辑
                System.out.println("hello world");
                Thread.sleep(100);
            } catch (BlockException | InterruptedException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
        }
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);

        FlowRule rule1 = new FlowRule();
        rule1.setResource("abc");
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule1.setCount(20);
        rules.add(rule1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
