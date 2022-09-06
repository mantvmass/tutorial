import space.circle; // file space/cirvle.java

public class testSpace {
    public static void main(String[] args) {
        // circle c1 = new circle(12.00f); use with constucture
        circle c1 = new circle();
        c1.r = 10;
        System.out.println(c1.area());
    }
}
