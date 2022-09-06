/*
    Facebook: Phumin Maliwan
*/

import java.util.Scanner;



public class ArrayTwoD {

    public static String[][] account = new String[1000][2];

    public static boolean Show() {
        for (int i = 0; i < account.length; i++) {
            if (account[1][0] == null) { System.out.println("account is empty"); return false; }
            System.out.println("===============");
            System.out.println(account[i][0]);
            System.out.println(account[i][1]);
        }
        return true;
    }

    public static boolean Register(String username, String password) {
        int count = 0;
        for (int i = 0; i < account.length; i++) {
            if (username == account[i][0]) {
                return false;
            }
            count++;
        }
        account[count+1][0] = username;
        account[count+1][1] = password;
        return true;
    }
    public static boolean Login(String username, String password ) {

        for (int i = 0; i < account.length; i++) {
            if (account[i][0] == username && account[i][1] == password) {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int select;
        String username, password;

        do {

            System.out.println("========================");
            System.out.println(" ===== HelloWorld ===== ");
            System.out.println("========================");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Show");
            System.out.println("[0] Exit");
            System.out.print("===> ");
            select = scan.nextInt();


            switch (select) {
                case 1:

                    System.out.print("Enter usewrname: ");
                    username = scan.nextLine();

                    System.out.print("Enter password: ");
                    password = scan.nextLine();

                    boolean result = Login(username, password);

                    if (result == true) {
                        System.out.println("Login Success");
                    }
                    
                    break;
                case 2:
                    break;

                case 3:
                    Show();
                    break;
            
                default:
                    break;
            }
            scan.close();
            
        } while (select != 0);

    }
}