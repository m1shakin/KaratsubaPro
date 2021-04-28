package com.company;

public class Main {

    public static long Karatsuba(long i, long j){
        if (i < 10 || j < 10)
            return i*j;
        double n = getLength(Math.max(i,j));
        if (n%2 == 1)
            n++;
        long a = (long) (i/Math.pow(10,(n/2)));
        long b = (long) (i%Math.pow(10,(n/2)));
        long c = (long) (j/Math.pow(10,(n/2)));
        long d = (long) (j%Math.pow(10,(n/2)));

        long first = Karatsuba(a, c);
        long second = Karatsuba(b, d);
        long third = Karatsuba(a + b, c + d);

        return ((long) ((first * Math.pow(10, n)) + ((third - first - second) * Math.pow(10, (n/2))) + second));
    }

    public static int getLength( long a){
        String b = Long.toString(a);
        return b.length();
    }

    public static void main(String[] args) {
        long a = 275923741;
        long b = 123816127;
        System.out.print("Сложение: " + a + " * " + b +" = ");
        System.out.println(Karatsuba(a,b));
    }
}
