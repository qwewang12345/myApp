package com.example.demo.service.struct;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author gaonan1
 * @date 2021/8/30 9:50
 **/
public class Struct239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
            // 默认是小顶堆，所以这里比较按相反来
            return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[len - k + 1];
        ans[0] = pq.peek()[0];
        // j代表窗口的末尾
        for (int j = k; j < len; j++) {
            pq.offer(new int[]{nums[j], j});
            while (pq.peek()[1] < j - k + 1) {
                pq.poll();
            }
            ans[j - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        int[] ans = new int[len - k + 1];
        ans[0] = nums[deque.peekFirst()];
        // j代表窗口的末尾
        for (int j = k; j < len; j++) {
            while (!deque.isEmpty() && nums[j] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(j);
            while (deque.peekFirst() < j - k + 1) {
                deque.pollFirst();
            }
            ans[j - k + 1] = nums[deque.pollFirst()];
        }
        return ans;
    }
}
