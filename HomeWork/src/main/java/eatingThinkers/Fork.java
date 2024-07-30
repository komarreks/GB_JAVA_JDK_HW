package eatingThinkers;

import java.util.concurrent.atomic.AtomicBoolean;

public class Fork {
    private AtomicBoolean free = new AtomicBoolean(true);

    public Boolean isFree(){
        return free.get();
    }

    public void occupied(Boolean flag){
        free.set(!flag);
    }
}
