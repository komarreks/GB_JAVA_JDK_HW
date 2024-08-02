package montyHoulParadox;

import java.util.*;

public class Main {
    private final static int COUNT_DOORS = 5;

    private static HashSet<Door> openedDoors = new HashSet<>();

    private static HashMap<String, Integer> statistic = new HashMap<>();

    public static void main(String[] args) {
        List<Door> doors = createDoors();

        statistic.put("Неверно", 0);

        boolean win = false;

        System.out.println("Создано дверей: " + COUNT_DOORS);

        while (!win){
            int doorNumber = new Random().nextInt(0, COUNT_DOORS);

            Door door = doors.get(doorNumber);

            if (!openedDoors.contains(door)){
                System.out.println("Компьютер выбрал " + door.toString());
                if (door.isGold()){
                    System.out.println("Компьюетр угадал с " + (statistic.get("Неверно") + 1) + " попыток дверь с золотом");
                    win = true;
                }else {
                    statistic.put("Неверно", statistic.get("Неверно") + 1);
                    System.out.println("... там нет золота");
                    openedDoors.add(door);
                }
            }
        }

    }

    private static List<Door> createDoors(){
        List<Door> doors = new ArrayList<>();

        for (int i = 0; i < COUNT_DOORS; i++) {
            doors.add(new Door(i+1));
        }

        int goldDoor = new Random().nextInt(0, COUNT_DOORS);

        doors.get(goldDoor).setGold(true);

        return doors;
    }
}
