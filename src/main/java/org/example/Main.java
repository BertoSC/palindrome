package org.example;

import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // array de palabras iniciales
        String [] palabras = {"kayak", "deificado", "rotador", "repaper", "deed", "pío", "wow", "mediodía", "civic", "coche de carreras", "nivel", "mamá"};

        HashSet<Callable> c = new HashSet<Callable>(palabras.length);
        Callable [] cal = new PalindromeCallable[12];
        FutureTask [] task = new FutureTask[12];
        HashSet<FutureTask> ft = new HashSet<FutureTask>(palabras.length);
        Thread [] t = new Thread[palabras.length];

        for (int i=0; i<palabras.length;i++) {
            c.add(new PalindromeCallable(palabras[i]));
            cal[i] = new PalindromeCallable(palabras[i]);
            //task[i] = new FutureTask(cal[i]);
            ft.add(new FutureTask<>(cal[i]));
        }

        for (FutureTask f: ft) {
            Thread th = new Thread(f);
            th.start();
        }

        for (FutureTask f: ft) {

            String pa = (String) f.get();
            System.out.println(pa);
        }


    }
}