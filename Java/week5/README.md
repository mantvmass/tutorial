Encapsulation
-------------
Encapsulation คือการปกป้องข้อมูล/การปรับปรุงข้อมมูลโดยมีเงื่อนไข
```java
public class Test{
    private int test; // Infomation hiding
    public void test01(int pass){ // Encapsulation ปรับปรุงข้อมมูลโดยมีเงื่อนไข
        if(pass == 1234){
            test = 20;
        }
    }
}
```

Infomation hiding
-----------------
การซ้อน ตัวแปร หรือ ซ้อน methods จากภายนอก ของ class ของเรา
```java
public class Test{
    public int test1; // No Infomation hiding
    private int test2; // Infomation hiding

    public void test01(){
        // Code ..
    }

    private void test02(){
        // Code ..
    }
}
```
```java
// myApp.java
// import Test.java

public class myApp {
    public static void main(String[] args){
        Test myclass = new Test(); // use Test class in Test.java file 

        myclass.test1 = 10; // varible found
        myclass.test2 = 10; // varible not found

        myclass.test01(); // method found
        myclass.test02(); // method not found
    }
}
```

Inheritance
-----------
การสืบถอดคลาส
