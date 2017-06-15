package com.mycompany.interviews;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class App
{
    public static void main( String[] args ) throws InterruptedException {

        try {
            WordDictionary dictionary = new WordDictionary();
            dictionary.load(list -> {  });
            CountDownLatch lock = new CountDownLatch(1);
            lock.await(2, TimeUnit.SECONDS);

            IAnagramGame game = new AnagramGame("areallylongword", dictionary);

            game.submitWord("no");
            game.submitWord("grow");
            game.submitWord("woolly");
            System.out.print(game.getWordAtPosition(0) + "-");
            System.out.print(game.getScoreAtPosition(0) + ", ");
            System.out.print(game.getWordAtPosition(1) + "-");
            System.out.print(game.getScoreAtPosition(1) + ", ");
            System.out.print(game.getWordAtPosition(2) + "-");
            System.out.print(game.getScoreAtPosition(2) + ", ");

//            assertHighscoreEntry(0, "woolly", 6);
//            assertHighscoreEntry(1, "grow", 4);
//            assertHighscoreEntry(2, "no", 2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        while (true) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
