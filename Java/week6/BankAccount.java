public class BankAccount {

    private int id; // Infomation hidding
    protected String owner, signature; // อนุญาติให้เข้าถึงภายในคลาส หรือ คลาสที่สืบทอดคลาสนี้
    protected float balance; // อนุญาติให้เข้าถึงภายในคลาส หรือ คลาสที่สืบทอดคลาสนี้

    public BankAccount(){ // overloading method / constructor
        System.out.println("enter data");
        // overloading method คือมี methods ที่ชื่อเหมือนกันภายในคลาสเดียวกัน
        // เงื่อนไขการใช้คือ method ที่ชื่อเหมือนกัน parameter/argument ต้องไม่เท่ากัน/ไม่เหมือนกัน
    }

    public BankAccount(int _id, String _owner, float _balance, String _signatrue){ // overloading method / constructor
        id = _id;
        owner = _owner;
        balance = _balance;
        signature = _signatrue;
    }

    public String[] info() {
        // String result[] = new String[5];
        String result[] = { Integer.toString(id), owner, Float.toString(balance)};
        return result;
    }

    public void withdraw(float money, String pin) { // overloading method
        if (pin.equals(signature)) {
            if (money <= balance) {
                balance -= money;
                System.out.println("Withdraw done.");
            } else {
                System.out.println("Withdraw failed.");
            }
        } else {
            System.out.println("Incorrect pin.");
        }
        
    }
    
    public void withdraw(float money) { // overloading method
        // overloading method คือมี methods ที่ชื่อเหมือนกันภายในคลาสเดียวกัน
        // เงื่อนไขการใช้คือ method ที่ชื่อเหมือนกัน parameter/argument ต้องไม่เท่ากัน/ไม่เหมือนกัน
    }

    public void deposit(float money) {
        balance += money;
        System.out.println("Deposit done.");
    }
}

// public class vipBankAccount extends BankAccount { // error = // overloading method }

class vipBankAccount extends BankAccount {
    public vipBankAccount(int _id, String _owner, Float _balance, String _signatrue){
        super(_id, _owner, _balance, _signatrue);
    }

    // public void deposit(float money){ // เพิ่มดอกเบี่ย 1% ให้ผู้ใช้ vip เมื่อฝากเงิน
    //     super.deposit(money+(money*0.01f)); // เรียก method จากคลาสแม่
    // }

    @Override // Override คือการเขียนทับ method เดิมที่มีอยู่ // หรือการเพิ่มการทำงานของ methhod
    public void deposit(float money) {
        // TODO Auto-generated method stub
        super.deposit(money+(money*0.01f)); // เพิ่มการทำงานของ method โดยเรียกคุณสมบัติจาก method super หรือ method จากคลาสแม่มาใช้ด้วย
 
        // ถ้าเขียนทับหรือเขียนทับทั้งหมดโดยไม่ใช้คุณสมบัติจาก method จาก class แม่จะไม่เรียกใช้ super.deposit เช่น // การเขียนทับ
        balance += money+(money*0.01f); // protected variable
    } 
}