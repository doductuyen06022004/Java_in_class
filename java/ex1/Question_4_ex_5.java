package ex1;

public class Question_4_ex_5 {
    public static void main(String[] args) {
        Department[] departments = new Department[3];

        departments[0] = new Department(1, "Phòng A", "Hà Nội");
        departments[1] = new Department(2, "Phòng B", "Hồ Chí Minh");
        departments[2] = new Department(3, "Phòng C", "Đà Nẵng");

        // Kiểm tra phòng ban thứ 1
        if ("Phòng A".equals(departments[0].name)) {
            System.out.println("Phòng ban thứ 1 có tên là Phòng A");
        } else {
            System.out.println("Phòng ban thứ 1 không phải là Phòng A");
        }
    }
}
