import java.util.Scanner;
public class Asmax {
    public static void main(String[] args) {
        int max = 0, n = 0;
        char cont = 'y'; // "" is String '' is Char
        Scanner reader = new Scanner(System.in);
        while (cont == 'y' || cont != 'n') {//  use if cont <-[char valiable] == ''[<- '' is char] 
            System.out.print("Enter number: ");
            n = reader.nextInt();
            if (n > max) max = n;
            System.out.print("Continue (y/n): ");
            cont = reader.next().charAt(0);
            cont = Character.toLowerCase(cont);
        }
        reader.close();
        System.out.println("The max value is "+max);
    }
}