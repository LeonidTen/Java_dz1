//1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//Пункты реализовать в методе main
//*Пункты реализовать в разных методах
//
//int i = new Random().nextInt(k); //это кидалка случайных чисел!)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int i = new Random().nextInt(2001);
        int n = getHighestBit(i);
        short[] m1 = getMultiplesOfN(i, n);
        short[] m2 = getNonMultiplesOfN(i, n);
        
        System.out.println("i = " + i);
        System.out.println("n = " + n);
        System.out.println("Multiples of n:");
        System.out.println(Arrays.toString(m1));
        System.out.println("Non-multiples of n:");
        System.out.println(Arrays.toString(m2));
    }
    
    // Метод для получения номера старшего значащего бита числа
    private static int getHighestBit(int num) {
        int highestBit = 0;
        while (num > 0) {
            num >>= 1;
            highestBit++;
        }
        return highestBit;
    }
    
    // Метод для получения массива кратных чисел
    private static short[] getMultiplesOfN(int start, int n) {
        List<Short> multiples = new ArrayList<>();
        for (int i = start; i <= Short.MAX_VALUE; i++) {
            if (i % (1 << (n-1)) == 0) {
                multiples.add((short)i);
            }
        }
        short[] result = new short[multiples.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = multiples.get(i);
        }
        return result;
    }
    
    // Метод для получения массива некратных чисел
    private static short[] getNonMultiplesOfN(int end, int n) {
        List<Short> nonMultiples = new ArrayList<>();
        for (int i = Short.MIN_VALUE; i < end; i++) {
            if (i % (1 << (n-1)) != 0) {
                nonMultiples.add((short)i);
            }
        }
        short[] result = new short[nonMultiples.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nonMultiples.get(i);
        }
        return result;
    }
}