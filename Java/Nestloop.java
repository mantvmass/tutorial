public class Nestloop {
    public static void main(String[] args) {
        int input = 50;
        for (int line = 0; line<input; line++){
            for(int space = input; space > line; space--){
                System.out.print(" ");
            }
            for(int item = 0; item <= line*2; item++){
                System.out.print("*");
            } System.out.println();
        }
    }
}
