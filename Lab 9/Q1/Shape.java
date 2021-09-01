package Q1;

public class Shape {
    private String name;
    protected double perimeter, area;
    
    public Shape(String type){
        name = type;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }


    public void display(){
        System.out.printf("Shape: %s\nPerimeter: %.2f\nArea: %.2f\n",name,perimeter,area);
    }
}
