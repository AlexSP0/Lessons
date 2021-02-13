package com.company;


public class Main {
    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if(arr.length !=4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].length !=4) {
                    throw new MyArraySizeException();
                }
            }
        }
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    sum = sum + Integer.valueOf(arr[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException();
        }
        return sum;
    }
    public static void main(String[] args) {
        String[][] array = {{"1","2","3","4"}, {"1","2","3","4"}, {"1","2","3","4"}, {"1","2","3","4"}};
        int s;
        try {
            s = sumArray(array);
            System.out.println("Сумма равна: " + s);
        } catch (MyArraySizeException e) {
            System.out.println("Массив неверного размера!");
        } catch (MyArrayDataException e) {
            System.out.println("В массиве не только числа!");
        } finally {

        }

    }

}

