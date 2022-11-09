package com.boribori.bookserver;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {

        // 숫자를 10번 입력 받는다. 홀수면 10번 출력 짝수면 5번 출력
        gogo();

        // c + d 출력
        cPlusD();

        // 숫자를 10번 입력 받는다. 홀수면 10번 출력 짝수면 5번 출력
        gogo();

        // c + d 출력
        cPlusD();

        // 숫자를 10번 입력 받는다. 홀수면 10번 출력 짝수면 5번 출력
        gogo();

        // c + d 출력
        cPlusD();

    }
    static void minus(int first, int second) {
        System.out.println(first - second);
    }

    static void gogo(){
        Scanner sc = new Scanner(System.in);
        // 숫자를 10번 입력 받는다. 홀수면 10번 출력 짝수면 5번 출력
        for (int j = 0; j < 2; j++) {
            int i = sc.nextInt();
            if(i % 2 == 1){
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
            }else{
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
                System.out.println(i);
            }
        }
    }

    static void cPlusD(){
        int c = 10;
        int d = 11;

        System.out.println(c + d);
    }

    static void callA10(int a){
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
    }
}
