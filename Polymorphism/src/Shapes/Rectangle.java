package Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        super.setArea(this.calculateArea());
        super.setPerimeter(this.calculatePerimeter());
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public Double calculateArea() {
        super.setArea(width * height);
        return super.getArea();
//        return width * height;
    }
}
