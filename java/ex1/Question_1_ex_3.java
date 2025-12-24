package ex1;

public class Question_1_ex_3 {
    public static void main(String[] args) {

        // Khởi tạo lương kiểu Integer
        Integer salary = 5000;

        // Convert Integer sang float
        float salaryFloat = salary.floatValue();

        // Hiển thị lương với 2 chữ số thập phân
        System.out.printf("Lương: %.2f", salaryFloat);
    }
}
