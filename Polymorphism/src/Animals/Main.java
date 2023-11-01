package Animals;

public class Main {
    public static void main(String[] args) {
       Animal animal1 = new Cat("Tommy", "Jerry");
        System.out.println(animal1.explainSelf());

        animal1 = new Dog("Rex", "Tommy");
        System.out.println(animal1.explainSelf());
    }
}
