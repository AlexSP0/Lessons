package com.company;


public class Main {
    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if(arr.length !=4) {
            throw new MyArraySizeException("Неверное количество строк в массиве! ");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].length !=4) {
                    throw new MyArraySizeException("Неверное количество элементов в строке №" + i);
                }
            }
        }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        sum = sum + Integer.parseInt(arr[i][j]);
                    } catch(NumberFormatException e) {
                        throw new MyArrayDataException("Неверные данные лежат  ячейке: " + i + "," + j);
                    }
                }
            }
        return sum;
    }
    // метод для тестирования массивов на ошибки(создан, чтобы не дублировать код try-catch
    public static void testArray (String[][] arr) {
        int s;
        try {
            s = sumArray(arr);
            System.out.println("Сумма равна: " + s);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        //Три массива для тестирования, один правильный, два других с ошибкой для проверки.

        String[][] rightArray = {{"1","2","3","4"}, {"1","2","3","4"}, {"1","2","3","4"}, {"1","2","3","4"}};
        String[][] wrongSizeArray = {{"1","2","3","4"}, {"1","2","3","4","4"}, {"1","2","3","4"}, {"1","2","3","4"}};
        String[][] wrongDataArray = {{"1","2","3","4"}, {"1","2","3","gggg"}, {"1","2","3","4"}, {"1","2","3","4"}};

        //по умолчанию проверяется и суммируется массив с правильными элементами
        //для тестирования "непрвильных" массивов, надо раскомментить строки с запуском функции testArray
        testArray(rightArray);
        //testArray(wrongSizeArray);
        //testArray(wrongDataArray);

    }
}

