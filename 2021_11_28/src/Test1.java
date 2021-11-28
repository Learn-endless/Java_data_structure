import java.io.FileNotFoundException;
import java.io.IOException;

public class Test1 {

    public static void main(String[] args) {
        try {

            // do something that may cause an Exception

        } catch (FileNotFoundException ex) {

            System.out.print("FileNotFoundException!");

        } catch (IOException ex) {

            System.out.print("IOException!");

        } catch (Exception ex) {

            System.out.print("Exception!");

        }
    }


    private static void testMethod(){
        System.out.println("testMethod");
    }
    public static void main_1(String[] args) {
        ((Test1)null).testMethod();
    }
}
