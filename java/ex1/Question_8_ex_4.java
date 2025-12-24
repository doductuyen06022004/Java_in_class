package ex1;

public class Question_8_ex_4 {
    public static void main(String[] args) {
        String[] groups = {
                "Java Basic",
                "Java Advanced",
                "Python Group",
                "Frontend",
                "Java Backend",
                "DevOps"
        };

        System.out.println("Các group có chứa chữ 'Java':");
        for (String group : groups) {
            if (group.contains("Java")) {
                System.out.println(group);
            }
        }
    }
    }

