import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * 给你一个 m 行 n列的二维网格grid和一个整数k。你需要将grid迁移k次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
 * 位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
 * 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
 * 请你返回k 次迁移操作后最终得到的 二维网格。
 */
public class TestDemo2 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //计算二维网格的列数
        int col = grid[0].length;
        //计算二维网格的行数
        int row = grid.length;
        //用来存放迁移后的数据
        int[] tmp = new int[row*col];
        //遍历放置迁移后的数据
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //两层含义：
                //1. 当迁移的个数大于元素个数时，进行处理
                //2. 定位迁移后的位置:
                //   k < 元素个数时，取余数从下标为k的位置放
                //   k = 元素个数时，k = 0,放到数组开头
                //   k > 元素个数时，取余同样从下标为k的位置放
                k %= col*row;
                tmp[k] = grid[i][j];
                k++;
            }
        }
        k = 0;
        //定义一个集合，用来存放整个二维网络
        List<List<Integer>> list1 = new ArrayList<>();
        //循环添加元素（一行一行的添加元素）
        for(int i = 0; i < grid.length ; i++){
            //准备用来存放当前这行的数据
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < grid[0].length; j++){
                list.add(tmp[k]);
                k++;
            }
            //将当前这行存放完成的数据，存放到总的集合中
            list1.add(list);
        }
        return list1;
    }
}
