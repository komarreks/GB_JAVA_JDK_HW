package montyHoulParadox;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Door {
    private int doorNumber;
    private boolean gold;

    public Door(int doorNumber){
        this.doorNumber = doorNumber;
    }

    @Override
    public String toString() {
        return "Дверь - " + doorNumber;
    }
}
