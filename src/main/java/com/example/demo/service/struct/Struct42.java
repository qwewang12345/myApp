package com.example.demo.service.struct;

import java.util.Stack;

/**
 * 接雨水问题
 *
 * @author gaonan1
 * @date 2021/7/15 9:20
 **/
public class Struct42 {

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int count = trap(height);
        System.out.println(count);
    }

    public static int trap(int[] height) {
        int sum = 0;
        // 用来做单调栈，想要接雨水，就要出现两边高，中间低的情况，
        // 所以这个当做一个单调递减栈，遇到大于等于栈顶的，就进行出栈，计算雨水容量
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            // 栈顶大于当前元素，当前元素入栈
            if (height[stack.peek()] > height[i]) {
                stack.push(i);
            }
            // 栈顶等于当前元素，栈顶出栈，当前元素入栈，因为后面取水时遇到相同高度的柱子，
            // 以右边的为主
            if (height[stack.peek()] == height[i]) {
                // 这里不pop的话，如果相同的柱子作为凹槽，那么会出现左边柱子和最小值相同，
                // 先会计算面积为0，后面找到大于最小值的再计算
                stack.pop();
                stack.push(i);
            }
            if (height[stack.peek()] < height[i]) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int m = stack.pop();
                    if (!stack.isEmpty()) {
                        int minHeight = Math.min(height[i], height[stack.peek()]);
                        sum += (i - stack.peek() - 1) * (minHeight - height[m]);
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
