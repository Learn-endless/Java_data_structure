package com.test.demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-01
 * Time: 17:12
 */
public class HashBuck3 {
    static class Node{
        public int key;
        public int value;
        public Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public Node[] array;
    public int userSize;

    public static final double DEFAULT_LOAD_FACTOR = 0.75;

    public HashBuck3(){
        array = new Node[10];
    }

    public void put(int key){

    }

}
