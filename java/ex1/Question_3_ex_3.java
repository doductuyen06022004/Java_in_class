package ex1;

public class Question_3_ex_3 {
    public static void main(String[] args) {

        // Khởi tạo Integer từ String
        Integer numberInteger = Integer.valueOf("1234567");

        // Convert Integer sang int
        int numberInt = numberInteger.intValue();

        // In kết quả
        System.out.println("Giá trị int là: " + numberInt);
    }
}
