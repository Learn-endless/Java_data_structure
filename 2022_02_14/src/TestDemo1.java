import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-14
 * Time: 17:40
 */
public class TestDemo1 {
    //topK问题：求一组数据中前 k 个最小的数据
    public static int[] topK(int[] array, int k){
        if(array == null || k == 0){
            return null;
        }
        //先将前k个元素建一个大根堆
        PriorityQueue<Integer> p = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if(p.size() < k){
                //先将前k个元素放入队列
                p.offer(array[i]);
            }else{
                //进行比较
                if(array[i] < p.peek()){
                    p.poll();
                    p.offer(array[i]);
                }
            }
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = p.poll();
        }
        return tmp;
    }

    public static void main1(String[] args) {
        //给一组数
        int[] data = {98,45,78,62,14,12,33,45,10,9};
        int k = 3;
        int[] ret = topK(data,k);
        System.out.println(Arrays.toString(ret));
    }

    //leetcode查找和最小的 K 对数字(运行超时)
    public static List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || k == 0){
            return null;
        }
        //建大根堆
        PriorityQueue<List<Integer>> p = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));
            }
        });

        for (int i = 0; i < Math.min(nums1.length,k); i++) {
            for(int j = 0; j < Math.min(nums2.length,k); j++){
                if(p.size() < k){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    p.offer(list);
                }else{
                    if(p.peek().get(0)+p.peek().get(1) > nums1[i]+nums2[j]){
                        p.poll();

                        List<Integer> list = new ArrayList<>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        p.offer(list);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < k && !p.isEmpty(); i++){
            list.add(p.poll());
        }
        return list;
    }

    //leetcode查找和最小的 K 对数字(正确写法)
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //建一个小根堆，用来每次拿到当前堆中指向最小数据的下标
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //比较条件
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            }
        });
        //用来存放前 k 个最小数据
        List<List<Integer>> ans = new ArrayList<>();
        //统计两个数组的长度
        int m = nums1.length;
        int n = nums2.length;
        //先将下标[0,0]、[1,0]、[2,0]...[k-1,0]放到队列中去
        //i表示 nums1 的下标
        //j表示 nums2 的下标
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        //需要多少组数据，就循环从队列中弹出多少组数据的下标
        while (k-- > 0 && !pq.isEmpty()) {
            //弹出队首
            int[] top = pq.poll();
            //创建一个List集合，用来存放当前从队列中弹出的数组下标所指向的数据
            List<Integer> list = new ArrayList<>();
            //通过队首的下标，在 nums1 和 nums2 中找到相对应的数据
            list.add(nums1[top[0]]);
            list.add(nums2[top[1]]);
            //将list添加到总集合中
            ans.add(list);
            //同时将当前top这个下标数组中的j加1，然后将新的下标数组重新入队
            if (top[1] + 1 < n) {  //前提：新数组j的下标不能超过nums2的元素个数

                pq.offer(new int[]{top[0], top[1] + 1});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] n = {1,7,11};
        int[] m = {2,4,6};
        List<List<Integer>> ret = kSmallestPairs(n, m, 3);
        System.out.println(ret);
    }

}
