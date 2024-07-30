package eatingThinkers;

import java.util.Random;

public class Thinker extends Thread{
    private Fork fork1;
    private Fork fork2;
    private int eatCount;
    private String name;

    public Thinker(String name, Fork fork1, Fork fork2){
        this.name = name;
        this.fork1 = fork1;
        this.fork2 = fork2;
    }

    @Override
    public void run() {
        while (eatCount < 3){
            System.out.println(name + ": Время подумать...");

            try {
                sleep(new Random().nextInt(1000,3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            takeForks();
            System.out.println(name + ": нужно перекусить");

            try {
                sleep(new Random().nextInt(1000,3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            putForks();
            eatCount++;
        }
        System.out.println(name + ": наелся и ушел");
    }

    private void putForks(){
        fork1.occupied(false);
        fork2.occupied(false);
        System.out.println(name + ": вилки положил");
    }

    private void takeForks(){
        while (!fork1.isFree() && !fork2.isFree()){
            try {
                System.out.println(name + ": вилки заняты...");
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        fork1.occupied(true);
        fork2.occupied(true);
        System.out.println(name + ": вилки взял!");
    }
}
