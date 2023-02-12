import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Task13{
    public static void main(String[]args){
        Cat barsik = new Cat();
        barsik.name = "Barsik";
        barsik.age = 2;
        Cat boris = new Cat("scotland", 2, "Boris", "black");
        HashSet<Cat> arr = new HashSet<>(Arrays.asList(barsik, boris));
//        Iterator<Iterator>
        for (Cat a: arr) {
            System.out.println(a);
        }
//        arr.add(barsik);
//        arr.add(boris);

    }

}

public class Cat {
    Integer age;
    String breed;
    String name;
    String color;

    Cat(String breed, Integer age, String name, String color){
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.color = color;
    }
    Cat(){

    }
}


