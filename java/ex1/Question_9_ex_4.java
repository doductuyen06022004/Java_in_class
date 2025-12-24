package ex1;

public class Question_9_ex_4 {
    public static void main(String[] args) {
        String[] groups = {
                "Java",
                "Java Basic",
                "Python",
                "Java",
                "Frontend",
                "java"
        };

        System.out.println("Các group có tên là 'Java':");
        for (String group : groups) {
            if (group.equals("Java")) {
                System.out.println(group);
            }
        }
    }
}
