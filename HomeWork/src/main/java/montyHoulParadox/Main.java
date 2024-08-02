package montyHoulParadox;

import java.util.*;

public class Main {
    private final static int COUNT_DOORS = 5;

    private static HashSet<Door> openedDoors = new HashSet<>();

    private static HashMap<String, Integer> statistic = new HashMap<>();
    private static HashMap<Integer, String> steps = new HashMap<>();

    public static void main(String[] args) {
        List<Door> doors = createDoors();

        statistic.put("Неверно", 0);

        boolean win = false;

        System.out.println("Создано дверей: " + COUNT_DOORS);

        int step = 0;

        while (!win){
            int doorNumber = new Random().nextInt(0, COUNT_DOORS);

            Door door = doors.get(doorNumber);

            if (!openedDoors.contains(door)){
                step++;
                System.out.println("Компьютер выбрал " + door.toString());
                if (door.isGold()){
                    System.out.println("Компьютер угадал с " + (statistic.get("Неверно") + 1) + " попыток дверь с золотом");
                    steps.put(step , "угадал");
                    win = true;
                }else {
                    statistic.put("Неверно", statistic.get("Неверно") + 1);
                    System.out.println("... там нет золота");
                    openedDoors.add(door);
                    steps.put(step, "не верно");
                }
            }
        }

        System.out.println("Статистика шагов:");
        for (int key: steps.keySet()){
            System.out.println("шаг: " + key + ", результат - " + steps.get(key));
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
