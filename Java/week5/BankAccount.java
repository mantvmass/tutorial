public class BankAccount {

    // Encapsulation - Infomation hidding
    private int id;
    private String owner, signature;
    private float balance;

    public BankAccount(int _id, String _owner, float _balance, String _signatrue){
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

    public void withdraw(float money, String pin) {
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

    public void deposit(float money) {
        balance += money;
        System.out.println("Deposit done.");
    }
}
