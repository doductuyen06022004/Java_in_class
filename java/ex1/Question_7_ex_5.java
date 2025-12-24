package ex1;

import java.util.Arrays;

public class Question_7_ex_5 {
    public static void main(String[] args) {
        Department[] departments = new Department[5];


        // Sắp xếp theo tên phòng ban (A → Z, không phân biệt hoa thường)
        Arrays.sort(departments, (d1, d2) ->
                d1.name.compareToIgnoreCase(d2.name)
        );

        // In ra danh sách sau khi sắp xếp
        System.out.println("Danh sách phòng ban sau khi sắp xếp:");
        for (Department d : departments) {
            System.out.println(d);

        }
    }
}
