package eatingThinkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int COUNT_THINKERS = 5;
    private static final List<String> thinkersName = new ArrayList<>(Arrays.asList("Аристотель", "Платон", "Сократ", "Диоген", "Петрович"));


    public static void main(String[] args) {

        List<Fork> forks = new ArrayList<>();
        putForks(forks);

        List<Thinker> thinkers = new ArrayList<>();
        seatThinkers(thinkers, forks);

        for (Thinker thinker : thinkers){
            thinker.start();
        }
    }

    private static void putForks(List<Fork> forks){
        while (forks.size()<COUNT_THINKERS){
            forks.add(new Fork());
        }
    }

    private static void seatThinkers(List<Thinker> thinkers, List<Fork> forks){
        while (thinkers.size()<COUNT_THINKERS){
            thinkers.add(new Thinker(thinkersName.get(thinkers.size()),
                    forks.get(thinkers.size()),
                    thinkers.size() == COUNT_THINKERS - 1? forks.get(0) : forks.get(thinkers.size() + 1)));
        }
    }
}
