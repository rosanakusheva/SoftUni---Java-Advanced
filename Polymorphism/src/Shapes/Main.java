package Shapes;

public class Main {
    public static void main(String[] args) {
     Shape shape = new Rectangle(1.2, 2.3);
        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());

        shape = new Circle(10.00);
    }
}
