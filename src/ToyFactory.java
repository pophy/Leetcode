/**
 * Created by Fei on 2/17/2018.
 */
public class ToyFactory {
}

interface Toy {
    void talk();
}

class Dog implements Toy {

    public void talk() {
        System.out.println("Wow");
    }
}

class Cat implements Toy {

    @Override
    public void talk() {

    }
}