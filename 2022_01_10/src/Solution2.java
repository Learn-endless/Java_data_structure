/**
 * 剑指 Offer 63. 股票的最大利润（java实现）
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        //先将数组的第一个数当作最小值
        int min = prices[0];
        //存放利润
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            //如果当前这个数比min还小，更新
            if(prices[i] < min){
                min = prices[i];
            }else{
                //不小，先求出当前值与min的差值
                int tmp = prices[i] - min;
                //差值与res比较
                if(res < tmp){
                    //res小就更新
                    res = tmp;
                }
            }
        }
        //最终res存放的就是最大的差值
        return res;
    }
}
