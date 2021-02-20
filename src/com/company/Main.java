package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public <T> void  swap (T[] arr, int i1, int i2) {
        if(arr != null && i1<=0 && i2<=0 && i1!=i2) {
            T buff = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = buff;
        }
    }
    public <T> ArrayList arrayToArrayList (T[] arr) {
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



    }

}

