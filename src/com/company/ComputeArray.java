package com.company;

//чтобы не дублировать код, создаем новый класс, который делит и склеивает массив, выполняет вычисления в укажанной половине
public class ComputeArray extends Thread {
    float[] arr; //исходный массив
    float[] buffArray; //массив для расчетов
    int half;
    public ComputeArray(float[] arr, int half) { //получаем массив и номер половины (если 0 - первая половину обсчитываем, 1 обсчитываем вторую половину)
        this.arr = arr;
        this.half = half; //с какой половиной массива работаем(0 - первая поливна, 1 - вторая половина)
        buffArray = new float[arr.length/2];

    }
    public void mergerArr() { //склеиваем
        System.arraycopy(buffArray, 0, arr, half*arr.length/2, arr.length/2);
    }
    public void divideArray() { //делим массив и берем нужную половину
        System.arraycopy(arr, half*arr.length/2,  buffArray , 0, arr.length/2);
    }
    @Override
    public void run() {
        divideArray();
        for (int i = 0; i < buffArray.length; i++) {
            int j = half*arr.length/2 + i; //вынуждены считать, так как в итоговой формуле результат зависит от индекса массива, а тут у нас ПОЛОВИНА МАССИВА!
            buffArray[i] = (float)(buffArray[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        mergerArr();
    }
}
