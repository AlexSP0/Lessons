package com.company;
import java.util.Random;
import java.util.Scanner;

//Проверка выигрыша реализована с помощью 4 методов isWinHorizontalLine, isWinVerticalLine, isWinDirectDiagonal, isWinDirectDiagonal
//каждый метод использует циклы для проверки всех возможных комбинации, начиная от последнего хода

//Задание под *
//Логика подебы универсальная и не зависит от от размера поля и количества фишек, все параметры задаются глобальными переменными
// DOTS_TO_WIN - количество фишек для выигрыша, SIZE - размеры поля. Все вышеперечисленные методы работают с этими параметрами.
// Для проверки этого задания необходимо SIZR установить в 5, а DOTS_TO_WIN  в 4.

//Задача под ***
//Блокировка ходов игрока осущетсвляется по анализу последнего хода, с использованием универсальных методов isExitsHorizontalLine,
// isExitsVerticalLine, isExitsDirectDiagonal, isExitsUndirectDiagonal с параметром поиска выигрышных позиций МЕНЬШЕ, чем DOTS_TO_WIN
// на DOTS_TO_BLOCK. Увеличивая DOTS_TO_BLOCK, мы можем задавать глубину блокировки. В текущем примере для выигрыша надо 5 фишек,
// DOTS_TO_BLOCK равно 2, значит блоикруются все варианты выигрыша, имеющие 3 (DOTS_TO_WIN - DOTS_TO_BLOCK = 3)точки. Если увеличивать
// DOTS_TO_BLOCK, то блокировать можно даже 2 потенциально выигрышные фишки. Таким образом блокировка осуществляется с любыми параметрами поля,
// любого количества выигршных фишек и с заданной глубиной.

public class Main {
    public static char [][] map;
    public static final int SIZE = 10; // размер квадратной карты
    public static final int DOTS_TO_WIN = 5; //количество точек для выигрыша
    public static final char DOT_EMPTY = '.'; //обозначение пустой клетки
    public static final char DOT_X = 'X'; // Обозначение хода человека
    private static final char DOT_O = '0'; // обозначение хода компьютера
    private static final int DOTS_TO_BLOCK = 2; //за сколько точек до выигрыша начинаем блокировать.
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int lastX; //координата Х последнего хода
    public static int lastY; //координата Y  последнего хода
    private static int BLOCK_FIGURE = 0; //Какую фигуру блокируем: 0 - никакую, 1 - горизонтальная прямая, 2 - вертикальная прямая
    // 3 - прямая диагональ, 4 - обратная диагональ

    public static void initMap() {
        map = new char [SIZE] [SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            printLineSeparator();
            printLine(i);
        }
        printLineSeparator();
    }

    public static void humanTurn() {
        int x,y;
        do {
            System.out.println("Введите координаты  X Y через пробел:");
            x = sc.nextInt();
            y = sc.nextInt();
        } while (!isCellValid(x,y));
        map[y-1][x-1] = DOT_X;
        lastX = x;
        lastY = y;
    }

    public static boolean isCellValid(int x, int y) {
        return ((x >= 1 && x <= SIZE) && (y >= 1 && y <= SIZE) && (map[y-1][x-1] == DOT_EMPTY));
    }

    public static void aiTurn(){
        int x,y;
        System.out.println("COMP TURN!");
        boolean flag = compThink(DOT_X,DOT_O);
        if(!flag) {
            do {
                x = rand.nextInt(SIZE) + 1;
                y = rand.nextInt(SIZE) + 1;
            } while (!isCellValid(x, y));
            System.out.println(" Компьютер сходил " + (x) + "X" + (y));
            map[y-1][x-1] = DOT_O;
            lastX = x;
            lastY = y;
        } else { System.out.println("Комп сходил - (блокировка): " + lastX + " х " + lastY);}
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    // проверка выигрыша любой из сторон
    public static boolean checkWin(char symb) {
        if(isWinHorizontalLine(lastX, lastY, symb, DOTS_TO_WIN)) return true;
        if(isWinVerticalLine(lastX, lastY, symb, DOTS_TO_WIN)) return true;
        if(isWinDirectDiagonal(lastX, lastY, symb, DOTS_TO_WIN)) return true;
        if(isWinUndirectDiagonal(lastX, lastY, symb, DOTS_TO_WIN)) return true;
        return false;
    }
    //Служебный метод для печати разделителя строк
    public static void printLineSeparator() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("+---");
            if(i==(SIZE-1)) System.out.print("+");
        }
        System.out.println();
    }
    //Служебный метод для печати строки со значениями
    public static void printLine (int line) {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| " + map[line][i] + " ");
            if(i==(SIZE-1)) System.out.print("|");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if(checkWin(DOT_X)) {
                System.out.println("Вы победили!");
                break;
            }
            if(isMapFull()) {
                System.out.println("НИЧЬЯ!");
                break;
            }
            aiTurn();
            printMap();
            if(checkWin(DOT_O)) {
                System.out.println("Комп победил!");
                break;
            }
            if(isMapFull()) {
                System.out.println("НИЧЬЯ!");
                break;
            }
        }
        System.out.println("Игра закончена!");
    }
//Служебный метод для проверки, существует ли горизонтальная линия символов symbol с координатами x, y и длиной z слева направо
    public static boolean isExitsHorizontalLine(int x, int y, int lenghtLine, char symbol) {
        boolean flag = true;
        if(isCoordValid(x,y)) {
            for (int i = 0; i < lenghtLine; i++) {
                if (!isCoordValid(x+i,y) || (map[y - 1][(x - 1) + i] != symbol)) {
                    flag = false;
                    break;
                }
            }
        } else flag = false;
        return flag;
    }
    // служебный метод проверки, есть ли вертикальная линия символов symbol с координатами x, y и длиной z сверху вниз
    public static boolean isExitsVerticalLine (int x, int y, int lenghtLine, char symbol) {
        boolean flag = true;
        if(isCoordValid(x,y)) {
            for (int i = 0; i < lenghtLine; i++) {
                if (!isCoordValid(x,y+i) || (map[(y - 1) + i][x - 1] != symbol)) {
                    flag = false;
                    break;
                }
            }
        } else flag = false;
        return flag;
    }
    //служебный метод проверки, есть ли диагональ символов symbol сверху-вниз, слева-направо
    public static boolean isExitsDirectDiagonal (int x, int y, int lenghtDiagonal, char symbol) {
        boolean flag = true;
        if (isCoordValid(x,y)) {
            for (int i = 0; i < lenghtDiagonal; i++) {
                if (!isCoordValid(x+i,y+i)|| (map[(y - 1) + i][(x - 1) + i] != symbol)) {
                    flag = false;
                    break;
                }
            }
        } else flag = false;
        return flag;
    }
    //служебный метод проверки, есть ли диагональ из символов symbol сверху-вниз, справа-налево
    public static boolean isExitsUndirectDiagonal(int x, int y, int lenghtDiagonal, char symbol) {
        boolean flag = true;
        if (isCoordValid(x,y)) {
            for (int i = 0; i < lenghtDiagonal; i++) {
                if (!isCoordValid(x-i, y+i) || (map[(y - 1) + i][(x - 1) - i]) != symbol){
                    flag = false;
                    break;
                }
            }
        } else flag = false;
        return flag;
    }
    //служебный метод для проверки выигрыша по горизонтальной прямой
    public static boolean isWinHorizontalLine(int x, int y, char symbol, int dots) {
        boolean flag = false;
        for (int i = 0; i < dots; i++) {
            if(isExitsHorizontalLine(x-i,y, dots, symbol)) {
                flag=true;
                break;
            }
        }
        return flag;
    }
    //служебный метод для проверки выигрыша по вертикальной линии
    public static boolean isWinVerticalLine(int x, int y, char symbol, int dots) {
        boolean flag = false;
        for (int i = 0; i < dots; i++) {
            if(isExitsVerticalLine(x,y-i, dots, symbol)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    //служебный метод для проверки выигрыша для прямой диагнали
    public static boolean isWinDirectDiagonal (int x, int y, char symb, int dots) {
        boolean flag = false;
        for (int i = 0; i < dots; i++) {
            if(isExitsDirectDiagonal(x-i,y-i, dots, symb)) {
                flag = true;
                break;
            }
        }
        return  flag;
    }
    //служебный метод для проверки выигрыша обратной диагонали
    public static boolean isWinUndirectDiagonal(int x, int y, char symb, int dots) {
        boolean flag = false;
        for (int i = 0; i < dots; i++) {
            if(isExitsUndirectDiagonal(x+i, y-i, dots, symb)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    // Возвращает true, если координаты валидные и false, если невалидные
    public static boolean isCoordValid (int x, int y) {
    return (x-1 >=0 && x-1 < SIZE && y-1 >= 0 && y-1 <SIZE);
    }

    //Метод для расчета хода компа. Расчет ведем от последнего хода человека
    //Критерий блокировки - наличие выигрышных вариантов c длиной на DOTS_TO_BLOCK меньше, чем выигрышная DOTS_TO_WIN
    //возвращает true, если был сделан ход по блокировке, и false - если не сделана блокировка
    public static boolean compThink (char checkSymbol, char setSymbol) {
        int dotsToSearch = DOTS_TO_WIN - DOTS_TO_BLOCK;
        BLOCK_FIGURE = 0;
        if(dotsToSearch <=1) return false; //блокировать одиночный символ нет смысла
        //ищем потенциальные выигрышниые позиции по последнему ходу, если находим, то блокируем.
        if(isWinHorizontalLine(lastX, lastY, checkSymbol, dotsToSearch)) {BLOCK_FIGURE = 1;}
        if(isWinVerticalLine(lastX, lastY, checkSymbol, dotsToSearch)) {BLOCK_FIGURE = 2;}
        if(isWinDirectDiagonal(lastX, lastY, checkSymbol, dotsToSearch)) {BLOCK_FIGURE = 3;}
        if(isWinUndirectDiagonal(lastX, lastY, checkSymbol, dotsToSearch)) {BLOCK_FIGURE = 4;}
        if(BLOCK_FIGURE != 0) {return blockWin(setSymbol);}
        return false;

    }
    //symbol - символ, которым блокируем.
    //возвращает true, если заблокировали и false, если не удалось
    public static boolean blockWin(char symbol) {
        boolean flag = false;
        int dotsToSearch = DOTS_TO_WIN - DOTS_TO_BLOCK;
        switch (BLOCK_FIGURE) {
            case 0:
                flag = false;
                break;
            case 1: //Блокируем горизонтальную линию
                if(isCellValid(lastX+1, lastY)) { map[lastY-1][lastX] = symbol; lastX = lastX+1; flag = true;}
                else if(isCellValid(lastX -1, lastY))
                {map [lastY-1] [lastX-2] = symbol; lastX = lastX-1; flag = true; } else
                { flag = false;}
                break;
            case 2: //Блокируем вертикальную линию
                if(isCellValid(lastX, lastY+1)) {map[lastY][lastX-1]=symbol; lastY = lastY+1; flag = true;}
                else if(isCellValid(lastX, lastY-1))
                {map[lastY-2][lastX-1] = symbol; lastY = lastY-1; flag = true;} else
                {flag = false;}
                break;
            case 3: // блокируем прямую диагональ
                if(isCellValid(lastX+1, lastY+1)) {map[lastY][lastX] = symbol; lastX=lastX+1; lastY=lastY+1; flag = true;}
                else if(isCellValid(lastX-1, lastY-1))
                {map[lastY-1][lastX-1] = symbol; lastX = lastX-1; lastY = lastY-1; flag = true;} else
                {flag = false;}
                break;
            case 4: // блокируем обратную диагональ
                if(isCellValid(lastX-1, lastY+1)) {map[lastY][lastX-2] = symbol; lastX = lastX-1; lastY = lastY+1; flag = true;}
                else if (isCellValid(lastX+1, lastY-1))
                {map[lastY-2][lastX] = symbol; lastX = lastX+1; lastY = lastY-1; flag = true;} else
                {flag = false;}
                break;
            default: // ничего не блокируем, выходим
                flag = false;
                break;
        }
        return flag;
    }
}

