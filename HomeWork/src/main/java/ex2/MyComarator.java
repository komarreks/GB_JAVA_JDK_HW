package ex2;

public class MyComarator {

    public static Boolean compareArrays(Object[] arr1, Object[] arr2){
        if (arr1.length != arr2.length){
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].getClass().equals(arr2[i].getClass())){
                return false;
            }
        }
        return true;
    }
}
