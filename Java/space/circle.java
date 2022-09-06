package space;

public class circle {
    public float r;
    final float pi = 3.1416f;

    // public circle(float radius) { // declare constucture name class == name method only
    //     r = radius;
    // }

    public float around() {
        return 2*pi*r;
    }

    public float area(){
        return pi*(r*r);
    }
}