//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Test3 {
//    public static String func(char[] str){
//        int count = str.length;
//        for (int i = 0; i < count-1;) {
//            if(str[i] == str[i+1]){
//                for (int j = i+1; j < count-1; j++) {
//                    str[j] = str[j+1];
//                }
//               count--;
//            }else{
//                i++;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String num = sc.nextLine();
//        char[] str = num.toCharArray();
//        Arrays.sort(str);
//        func(str);
//    }
//}
