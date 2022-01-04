package first;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExample {

    public static void main(String args[]) {
        List<String> myList = new ArrayList<>();
        List<String> copyList = new CopyOnWriteArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        copyList.addAll(myList);

        Iterator<String> it2 = myList.iterator();
        iterate(it2,copyList);

        Iterator<String> it1 = myList.iterator();
        iterate(it1,myList);

    }

    public static void iterate(Iterator<String> it,List<String> myList){
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals("3")) {
                myList.remove("4");
                myList.add("6");
                myList.add("7");
            }
        }
        System.out.println("List Size:" + myList.size());
        System.out.println("--------------------");
    }
}
