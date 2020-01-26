package KursJavaRzeszow2020.Bartek3;

import java.util.stream.Stream;

public class Silnia {
    public static void main(String[] args){
        System.out.println("6! =" +silnia(6));
        System.out.println("6! =" +silniaRecursive(6));
    }

    public static int silnia(int arg2) {
        int silnia = 1;
        while (arg2 > 1){
            silnia *= arg2--;
        }
        return silnia;
    }

    public static int silniaRecursive(int arg) {
        return arg> 1
                ? silniaRecursive(arg-1) * arg
                :1;
    }
}
