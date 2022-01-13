/**
 * 997. 找到小镇的法官
 *
 *小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 *如果小镇法官真的存在，那么：
 *小镇法官不会信任任何人。
 *每个人（除了小镇法官）都信任这位小镇法官。
 *只有一个人同时满足属性 1 和属性 2 。
 *给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 *如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 */
public class TestDemo1 {
    public int findJudge(int n, int[][] trust) {
        //用l1统计信任他人的次数
        int[] l1 = new int[n+1];
        //用l2统计被他人信任的次数
        int[] l2 = new int[n+1];
        //遍历trust数组
        for(int[] m:trust){
            //进行统计
            l1[m[0]]++;
            l2[m[1]]++;
        }
        //找出法官
        for(int i = 1; i < l1.length; i++){
            //通过条件进行判断
            if(l1[i] == 0 && l2[i] == n-1){
                //满足不信任任何人，其他人都信任它
                return i;
            }
        }
        return -1;
    }
}
