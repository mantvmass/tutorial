Encapsulation
-------------
การซ้อน ตัวแปร หรือ ซ้อน methods จากภายนอก ของ class ของเรา
```java
// Test.java
public class Test{
    public int test1; // No Encapsulation
    private int test2; // Encapsulation

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