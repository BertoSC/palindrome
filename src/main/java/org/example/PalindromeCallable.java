package org.example;

import java.util.concurrent.Callable;

public class PalindromeCallable implements Callable {
    String palabra;

    public PalindromeCallable(String p){
        this.palabra = p;
    }

    public String isPalindrome (String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();

        if (s.equals(rev)){
            return palabra + " es palíndromo";
        } else {
            return palabra + " no es palindromo";
        }
    }

    @Override
    public Object call() throws Exception {
        return isPalindrome(palabra);
    }
}
