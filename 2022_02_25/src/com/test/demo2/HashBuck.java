package com.test.demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-26
 * Time: 16:21
 */
public class HashBuck {
        static class Node {
            public int key;
            public int val;
            public Node next;

            public Node(int key,int val) {
                this.key = key;
                this.val = val;
            }
        }

        public Node[] array;
        public int usedSize;

        public static final double DEFAULT_LOAD_FACTOR = 0.75;

        public HashBuck() {
            this.array = new Node[10];
        }

        /**
         * put函数
         * @param key
         * @param val
         */
        public void put(int key,int val) {
            //1、找到Key所在的位置
            int index = key % this.array.length;
            //2、遍历这个下标的链表，看是不是有相同的key。有 要更新val值的
            Node cur = array[index];
            while (cur != null) {
                if(cur.key == key) {
                    cur.val = val;//更新val值
                    return;
                }
                cur = cur.next;
            }
            //3、没有这个key这个元素，头插法
            Node node = new Node(key, val);
            node.next = array[index];
            array[index] = node;
            this.usedSize++;
            //4、插入元素成功之后，检查当前散列表的负载因子
            if(loadFactor() >= DEFAULT_LOAD_FACTOR) {
                resize();//
            }
        }

        private void resize() {
            Node[] newArray = new Node[array.length*2];
            for (int i = 0; i < array.length; i++) {
                Node cur = array[i];
                while (cur != null) {
                    int index = cur.key % newArray.length;//获取新的下标 11
                    //就是把cur这个节点，以头插/尾插的形式 插入到新的数组对应下标的链表当中
                    Node curNext = cur.next;
                    cur.next = newArray[index];//先绑定后面
                    newArray[index] = cur;//绑定前面
                    cur = curNext;
                }
            }
            array = newArray;
        }

        private double loadFactor() {
            return 1.0*usedSize/array.length;
        }

        /**
         * 根据key获取val值
         * @param key
         * @return
         */
        public int get(int key) {
            //1、找到Key所在的位置
            int index = key % this.array.length;
            //2、遍历这个下标的链表，看是不是有相同的key。有 要更新val值的
            Node cur = array[index];
            while (cur != null) {
                if(cur.key == key) {
                    return cur.val;
                }
                cur = cur.next;
            }
            return -1;
        }

        public static void main(String[] args) {
            HashBuck hashBuck = new HashBuck();
            hashBuck.put(1,1);
            hashBuck.put(12,12);
            hashBuck.put(3,3);
            hashBuck.put(6,6);
            hashBuck.put(7,7);
            hashBuck.put(2,2);
            hashBuck.put(11,11);
            hashBuck.put(8,8);
            System.out.println(hashBuck.get(11));
        }
}
