package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            System.out.println("hello");
        }
        int a =-9,b=10;
        AdditionClass add = new AdditionClass();
        int ans = add.add(a,b);
        System.out.println(ans);
    }
}