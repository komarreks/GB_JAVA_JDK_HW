package ex3;

public class Pair <T,V>{
    private T t;
    private V v;

    public T getFirst(){
        return t;
    }

    public V getSecond(){
        return v;
    }

    @Override
    public String toString() {
        return "value 1: " + t
                + ", value 2: "+ v;
    }
}
