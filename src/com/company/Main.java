package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static <T> void  swap (T[] arr, int i1, int i2) {
        if(arr != null && i1>=0 && i2>=0 && i1!=i2) {
            T buff = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = buff;
        }
    }
    public static <T> ArrayList arrayToArrayList (T[] arr) {
        if(arr != null) {
            ArrayList<T> arrList = new ArrayList<>();
            for (T i : arr) {
                arrList.add(i);
            }
            return arrList;
        }
        return null;
    }
    public static void main(String[] args) {
        Apple[] apples = new Apple[3];
        apples[0] = new Apple();
        apples[1] = new Apple();
        apples[2] = new Apple();

        //Task 1
        printArray(apples);
        swap(apples, 1,2);
        System.out.println("После обмена элементов:");
        printArray(apples);
        //Task 2
        ArrayList<Apple> applesArrayList = arrayToArrayList(apples);
        //Task 3

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> apple2Box = new Box<>();
        System.out.println();
        System.out.println("Коробки только созданы, они пустые ");
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        //добавляем фрукты в коробку
        appleBox.add(apples[0]);
        appleBox.add(apples[1]);
        appleBox.add(apples[2]);
        orangeBox.add(orange1);
        orangeBox.add(orange2);
        orangeBox.add(orange3);
        System.out.println("После добавления фруктов в коробки их вес: ");
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с яблоками №2:  " + apple2Box.getWeight());
        System.out.println("Перекладываем яблоки в корзину 2");
        appleBox.transfer(apple2Box);
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с яблоками №2:  " + apple2Box.getWeight());

    }

    public static <T> void printArray(T[] arr) {
        for (T i: arr) {
            System.out.println(i);
        }
    }
}

