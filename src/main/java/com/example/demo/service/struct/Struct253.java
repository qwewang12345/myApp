package com.example.demo.service.struct;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gaonan1
 * @date 2021/8/30 9:50
 **/
public class Struct253 {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        // 按区间的start左侧排序,实现Comparator接口
        Arrays.asList(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            // 开始时间大于前面结束时间的最小值，说明后面的时间段也都是这样，前面已经按开始时间排序了
            // 说明可以和这个共用一个会议室，弹出
            if (!pq.isEmpty() && intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }
        return pq.size();
    }
}
