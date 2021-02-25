package com.company;


public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    //заполняем указанный массив единицами
    public static void fillArrayWith1(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
    }
    //первый метод из задания
    public static float[] firstMethod() {
        float[] arr = new float[SIZE];

        //заполнение массива единицами
        fillArrayWith1(arr);

        //Вычисления по формуле
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        return arr;
    }
    //второй метод из задания
    public static float[] secondMethod() {
        float[] arr = new float[SIZE];
        //заполнение массива единицами
        fillArrayWith1(arr);

        Thread th1 = new ComputeArray(arr, 0);
        Thread th2 = new ComputeArray(arr, 1);
        long a = System.currentTimeMillis();
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            System.out.println("Не дождались.. что-то поломалось");
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - a);
        return arr;
    }
    public static void main(String[] args) {
        float[] first = firstMethod();
        float[] second = secondMethod();
        compareArrays(first, second); //проверяем, равны ли полученные массивы для тестирования

    }
    //метод сравнивания полученных массивов, как способ тестирования полученных результатов
    public static void compareArrays (float[] f, float []s) {
        for (int i = 0; i < f.length; i++) {
            if(f[i] != s[i]) {
                System.out.println("Элементы неравны под индексом: " + i );
                System.out.println(f[i]);
                System.out.println(s[i]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

