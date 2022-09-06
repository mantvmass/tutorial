import java.util.Scanner;
public class MinMax {
    public static void main(String[] args) {
        int data[] = new int[10];
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < data.length; i++) {
            System.out.print("input data["+i+"] = ");
            data[i] = reader.nextInt();    
        }
        int result[][] = new int[2][2]; // array 2d
        /* MAX */ result[0][0] = data[0]; result[0][1] = 0;
        /* MIN */ result[1][0] = data[0]; result[1][1] = 0;
        for (int i = 0; i < data.length; i++){
            if (result[0][0] < data[i]){  // find max and index of max
                result[0][0] = data[i]; result[0][1] = i;
            }
            if (result[1][0] > data[i]) {  // find min and index of min
                result[1][0] = data[i]; result[1][1] = i;
            }
        }
        System.out.println("Max is " + result[0][0] + " Index of max is " + result[0][1] + "\nMin is " + result[1][0] + " Index of max is " + result[1][1]);

        reader.close();
    }
    
}
