public class student {
    String id;
    String name;
    address address; // type is address class // student has a address

    public void addressinfo(){
        System.out.println(address.No);
        System.out.println(address.Road);
        System.out.println(address.District);
        System.out.println(address.Province);
        System.out.println(address.Zipcode);
    }
}

class foreigner extends student { // foreigner is a student // เป็น class ที่สืบทอดมาจาก class student

}

class address { // เป็นส่วนหนึ่งของ class student
    String No;
    String Road;
    String District;
    String Province;
    String Zipcode;

    public address(String No, String Road, String District, String Province, String Zipcode){ // constructor
        this.No = No;
        this.Road = Road;
        this.District = District;
        this.Province = Province;
        this.Zipcode = Zipcode;
    }
}