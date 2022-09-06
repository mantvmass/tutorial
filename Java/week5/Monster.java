public class Monster {

    private String name; // set monter
    private int hp, atk, def; // set monter

    public Monster(String name, int hp, int atk, int def){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public void walk(){
        System.out.println("now, i\'m stop.");
    }
    public void stop(){
        System.out.println("now, i\'m stop.");
    }
    public void speak(){
        System.out.println("Hello my name is " + this.name);
    }

}

class airMonster extends Monster { // extends = สืบถอดคลาส จากคลาส Monster หรือ คลาสแม่ ของมัน

    int speed;

    public airMonster(String name, int hp, int atk, int def, int speed){
        super(name, hp, atk, def); // ส่งต่อ constucture ไปยัง class แม่
        this.speed = speed;
    }

    public void fly(){
        System.out.println("i\'m fly");
    }

}
