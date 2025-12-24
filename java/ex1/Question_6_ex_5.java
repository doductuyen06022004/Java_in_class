package ex1;

import java.util.Arrays;
import java.util.Comparator;

public class Question_6_ex_5 {
    public static void main(String[] args) {
        Department[] departments = new Department[5];

        departments[0] = new Department(1, "Sale", "asd");
        departments[1] = new Department(2, "Accounting", "sdad");
        departments[2] = new Department(3, "Marketing", "sdasd");
        departments[3] = new Department(4, "Waiting room", "sdas");
        departments[4] = new Department(5, "Boss of director", "sdad");

        // Sắp xếp tăng dần theo tên phòng ban
        Arrays.sort(departments, Comparator.comparing(d -> d.name)
        );

        // In ra danh sách sau khi sắp xếp
        System.out.println("Danh sách phòng ban sau khi sắp xếp:");
        for (Department d : departments) {
            System.out.println(d);
        }
    }
}
