package com.mycompany.interviews;


import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.load(list -> {
        });

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
