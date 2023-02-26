package com.example.demo.service.struct;

import java.util.*;

public class ExpireLruCache {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        LruCache l = new LruCache(3, 1);
        l.add("a", 1);
        l.add("b", 2);
        l.add("c", 3);
        int v = l.get("a");
        l.add("d", 4);
        System.out.println(l);
    }

    static class LruCache {
        int capacity;
        long expireTimeSeconds;
        Map<String, Node> lruMap;
        int count;
        Node header;
        Node last;
        public LruCache(int capacity, long expireTimeSeconds) {
            this.capacity = capacity;
            this.expireTimeSeconds = expireTimeSeconds;
            this.lruMap = new HashMap<>(capacity);
            this.count = 0;
            this.header = new Node();
            this.last = new Node();
            header.next = last;
            last.pre = header;
        }

        public void add(String key, int value) {
            long now = System.currentTimeMillis() / 1000;
            if (lruMap.get(key) != null) {
                Node oldNode = lruMap.get(key);
                oldNode.value = value;
                oldNode.expireTimeSeconds = now + expireTimeSeconds;
                lruMap.put(key, oldNode);
                moveNodeToHead(oldNode);
            } else {
                Node n = new Node(key, value, now + expireTimeSeconds);
                lruMap.put(key, n);
                addNodeToHeader(n);
                count++;
                if (count > capacity) {
                    // 删除尾部元素
                    String deleteKey = deleteTailNode();
                    lruMap.remove(deleteKey);
                    count--;
                }
            }
        }

        public int get(String key) {
            long now = System.currentTimeMillis() / 1000;
            Node n = lruMap.get(key);
            if (Objects.isNull(n)) {
                return -1;
            }
            if (n.expireTimeSeconds <= now) {
                deleteNode(n);
                lruMap.remove(n.key);
                count--;
                return -1;
            }
            moveNodeToHead(n);
            return n.value;
        }

        public void deleteNode(Node n) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
        }

        public String deleteTailNode() {
            Node temp = last.pre;
            last.pre.pre.next = last;
            last.pre = last.pre.pre;
            return temp.key;
        }

        public void addNodeToHeader(Node n) {
            Node next = header.next;
            header.next = n;
            n.pre = header;
            n.next = next;
            next.pre = n;
        }

        public void moveNodeToHead(Node n) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            addNodeToHeader(n);
        }

    }

    static class Node {
        Node pre;
        Node next;
        String key;
        int value;
        long expireTimeSeconds;
        public Node() {

        }

        public Node(String key, int value, long expireTimeSeconds) {
            this.key = key;
            this.value = value;
            this.expireTimeSeconds = expireTimeSeconds;
        }
    }
}

