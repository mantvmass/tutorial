public class AppStu {
    public static void main(String[] args) {
        
        student std01 = new student();
        foreigner std02 = new foreigner();


        std01.id = "64122420220";
        std01.name = "Phumin Maliwan";
        std01.address = new address("123", "ubon24", "Mueang", "Ubon", "34000");
        std01.addressinfo();
    }
}
