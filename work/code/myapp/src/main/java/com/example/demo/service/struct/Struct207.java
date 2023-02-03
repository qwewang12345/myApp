package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gaonan1
 * @date 2021/8/30 9:50
 **/
public class Struct207 {

    private List<List<Integer>> edges;
    // 对应课程，0代表未搜索，1代表搜索中，2代表已完成
    private int[] visited;
    private boolean valid = false;

    /**
     * 整体思路就是看所有节点是否能进行拓扑排序
     * 有向无环图可以组成拓扑排序，有环则不行
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        edges = new ArrayList<>();
        for (int[] p: prerequisites) {
            // 节点p[1]后面的节点有多少
            edges.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int i) {
        visited[i] = 1;
        for (int v : edges.get(i)) {
            // 后面节点未搜索，进行搜索
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                // 后面节点也在搜索中，说明有环，有环则说明不是拓扑排序
                valid = false;
                return;
            }
            // 后面节点已经搜索完成，说明有其它前置节点已经搜索过，并且已经搜索完成
        }
        visited[i] = 2;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 每个节点的入度
        int[] inCount = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 计算其中涉及到的边
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
            inCount[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inCount[i] == 0) {
                q.offer(i);
            }
        }
        int size = 0;
        while (!q.isEmpty()) {
            size++;
            int a = q.poll();
            List<Integer> nextList = edges.get(a);
            for (int next : nextList) {
                inCount[next] -= 1;
                if (inCount[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return size == numCourses;
    }
}
