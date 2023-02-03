package com.example.demo.service.struct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaonan1
 * @date 2021/9/27 9:45
 **/
public class Struct399 {

    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int size = equations.size();
            Map<String, Integer> indexMap = new HashMap<>(size * 2);
            return null;
        }

        private class UnionFind {
            // 父节点是哪个
            private int[] parent;
            // 以当前点为起始点，parent对应的值为终点，对应的权重边
            private double[] weight;

            public UnionFind(int n) {
                this.parent = new int[n];
                this.weight = new double[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    weight[i] = 1.0d;
                }
            }

            // 寻找x对应的根节点，并计算到根节点的权重值
            public int find(int x) {
                while (x != parent[x]) {
                    int origin = parent[x];
                    parent[x] = find(parent[x]);
                    weight[x] *= weight[origin];
                }
                return parent[x];
            }

            public void union(int x, int y, double value) {
                int RootX = find(x);
                int RootY = find(y);
                if (RootX == RootY) {
                    return;
                }

                parent[RootX] = RootY;
                weight[RootX] = value * weight[y] / weight[x];
            }

            public double isConnected(int x, int y) {
                int RootX = find(x);
                int RootY = find(y);
                if (RootX == RootY) {
                    return weight[x] / weight[y];
                } else {
                    return -1.0d;
                }
            }
        }
    }
}
