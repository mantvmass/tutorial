public class AppBank {
    public static void main(String[] args) {

        BankAccount acc01 = new BankAccount(1, "Phumin Maliwan", 500, "password");
        BankAccount acc02 = new BankAccount(2, "Phumin Maliwan", 500, "password");

        String re01[] = acc01.info();
        String re02[] = acc02.info();
  
        System.out.println(re01[0] + "-" + re01[1] + " has " + re01[2] + " bath.");
        System.out.println(re02[0] + "-" + re02[1] + " has " + re02[2] + " bath.");

        acc01.withdraw(200, "phumin");
        acc02.deposit(400);

        String re011[] = acc01.info();
        String re022[] = acc02.info();
  
        System.out.println(re011[0] + "-" + re011[1] + " has " + re011[2] + " bath.");
        System.out.println(re022[0] + "-" + re022[1] + " has " + re022[2] + " bath.");



    }
}
