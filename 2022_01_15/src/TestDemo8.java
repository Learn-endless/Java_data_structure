public class TestDemo8 {
    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
     * 例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
     *
     * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
     * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
     * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
     * 给定一个罗马数字，将其转换成整数。
     * @param s  罗马数字字符串
     * @return 返回一个整数
     */
    public int romanToInt(String s) {
        //存放总的值
        int value = 0;
        //前指针
        int n1 = 0;
        //后指针
        int n2 = 0;
        //遍历整个字符串
        for(int i = s.length()-1; i >= 0; i--){
            //根据当前字符，提供n1的值
            switch(s.charAt(i)){
                case 'I':n1 = 1;break;
                case 'V':n1 = 5;break;
                case 'X':n1 = 10;break;
                case 'L':n1 = 50;break;
                case 'C':n1 = 100;break;
                case 'D':n1 = 500;break;
                case 'M':n1 = 1000;break;
            }
            //判断n1是不是在n2左边
            if(n1 >= n2){
                //是的直接累加
                value += n1;
            }else{
                //不是说明需要减掉
                value -= n1;
            }
            //更新n2的值，总是记录n1后面的值的大小
            n2 = n1;
        }
        return value;
    }
}
