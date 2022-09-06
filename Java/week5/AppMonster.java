public class AppMonster {

    public static void main(String[] args) {
        Monster mon1 = new Monster("Tee", 100, 20, 10);
        airMonster mon2 = new airMonster("Man", 100, 20, 10, 10);

        mon1.speak();
        // mon1.fly(); // noty fond

        mon2.speak();
        mon2.fly();
    }
    
}
