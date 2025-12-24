package ex1;

public class Question_5_ex_5 {
    public static void main(String[] args) {
        Department[] departments = new Department[3];

        departments[0] = new Department(1, "Phòng A", "Hà Nội");
        departments[1] = new Department(2, "Phòng A", "Hồ Chí Minh");
        departments[2] = new Department(3, "Phòng C", "Đà Nẵng");

        // So sánh phòng ban thứ 1 và thứ 2
        if (departments[0].name
                .equals(departments[1].name)) {
            System.out.println("Hai phòng ban bằng nhau");
        } else {
            System.out.println("Hai phòng ban không bằng nhau");
        }

    }
}
