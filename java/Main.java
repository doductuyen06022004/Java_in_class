import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Khai báo và khởi tạo lương
        float salaryAccount1 = 5240.5f;
        float salaryAccount2 = 10970.055f;

        // Làm tròn lương
        int roundSalary1 = Math.round(salaryAccount1);
        int roundSalary2 = Math.round(salaryAccount2);

        // In kết quả
        System.out.println("Lương Account 1 sau khi làm tròn: " + roundSalary1);
        System.out.println("Lương Account 2 sau khi làm tròn: " + roundSalary2);


        /*Question 2:*/
        Random random = new Random();
        // Lấy số ngẫu nhiên từ 0 đến 99999
        int number = random.nextInt(100000);
        // Format thành 5 chữ số (thêm 0 phía trước nếu cần)
        String fiveDigitNumber = String.format("%05d", number);
        System.out.println("Số ngẫu nhiên 5 chữ số: " + fiveDigitNumber);

        /*Question 3:*/
        // cach 2
        String lastTwoDigits = fiveDigitNumber.substring(3);

        System.out.println("2 số cuối là: " + lastTwoDigits);

        int number1 = 4829; // 04829
        // cach 1
        int lastTwoDigit = number1 % 100;
        /*Question 4:*/
        System.out.println("2 số cuối là: " + lastTwoDigit);
        float result = divide(10, 3);
        System.out.println("Thương của a và b là: " + result);
    }
    public static float divide(int a, int b) {
        if (b == 0) {
            System.out.println("Không thể chia cho 0");
            return 0;
        }
        return (float) a / b;
    }
    /*Exercise 2: Default value*/
    

}

