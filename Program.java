import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {

        // Department
        Department d1 = new Department();
        d1.id = 1;
        d1.name = "Sale";

        Department d2 = new Department();
        d2.id = 2;
        d2.name = "Marketing";

        Department d3 = new Department();
        d3.id = 3;
        d3.name = "IT";

        // Position
        Position p1 = new Position();
        p1.id = 1;
        p1.name = "Dev";

        Position p2 = new Position();
        p2.id = 2;
        p2.name = "Test";

        Position p3 = new Position();
        p3.id = 3;
        p3.name = "PM";

        // Account
        Account a1 = new Account();
        a1.id = 1;
        a1.email = "a@gmail.com";
        a1.username = "user1";
        a1.fullName = "Nguyen Van A";
        a1.department = d1;
        a1.position = p1;
        a1.createDate = LocalDate.now();

        Account a2 = new Account();
        a2.id = 2;
        a2.email = "b@gmail.com";
        a2.username = "user2";
        a2.fullName = "Tran Thi B";
        a2.department = d2;
        a2.position = p2;
        a2.createDate = LocalDate.now();

        Account a3 = new Account();
        a3.id = 3;
        a3.email = "c@gmail.com";
        a3.username = "user3";
        a3.fullName = "Le Van C";
        a3.department = d3;
        a3.position = p3;
        a3.createDate = LocalDate.now();

        // Group
        Group g1 = new Group();
        g1.id = 1;
        g1.name = "Java Fresher";
        g1.creator = a1;
        g1.createDate = LocalDate.now();

        Group g2 = new Group();
        g2.id = 2;
        g2.name = "SQL Basic";
        g2.creator = a2;
        g2.createDate = LocalDate.now();

        Group g3 = new Group();
        g3.id = 3;
        g3.name = "Testing";
        g3.creator = a3;
        g3.createDate = LocalDate.now();

        // TypeQuestion
        TypeQuestion t1 = new TypeQuestion();
        t1.id = 1;
        t1.name = "Essay";

        TypeQuestion t2 = new TypeQuestion();
        t2.id = 2;
        t2.name = "Multiple Choice";

        TypeQuestion t3 = new TypeQuestion();
        t3.id = 3;
        t3.name = "True/False";

        // CategoryQuestion
        CategoryQuestion c1 = new CategoryQuestion();
        c1.id = 1;
        c1.name = "Java";

        CategoryQuestion c2 = new CategoryQuestion();
        c2.id = 2;
        c2.name = "SQL";

        CategoryQuestion c3 = new CategoryQuestion();
        c3.id = 3;
        c3.name = ".NET";

        // Question
        Question q1 = new Question();
        q1.id = 1;
        q1.content = "Java là gì?";
        q1.category = c1;
        q1.type = t1;
        q1.creator = a1;
        q1.createDate = LocalDate.now();

        Question q2 = new Question();
        q2.id = 2;
        q2.content = "SQL JOIN dùng để làm gì?";
        q2.category = c2;
        q2.type = t2;
        q2.creator = a2;
        q2.createDate = LocalDate.now();

        Question q3 = new Question();
        q3.id = 3;
        q3.content = "OOP có bao nhiêu tính chất?";
        q3.category = c1;
        q3.type = t2;
        q3.creator = a3;
        q3.createDate = LocalDate.now();

        // Answer
        Answer ans1 = new Answer();
        ans1.id = 1;
        ans1.content = "Java là ngôn ngữ lập trình";
        ans1.question = q1;
        ans1.isCorrect = true;

        // Exam
        Exam e1 = new Exam();
        e1.id = 1;
        e1.code = "EX001";
        e1.title = "Java Basic Test";
        e1.category = c1;
        e1.duration = 60;
        e1.creator = a1;
        e1.createDate = LocalDate.now();

        // ExamQuestion
        ExamQuestion eq1 = new ExamQuestion();
        eq1.exam = e1;
        eq1.question = q1;

        // (Question 3)
        System.out.println("Department: " + d1.name);
        System.out.println("Position: " + p1.name);
        System.out.println("Account: " + a1.fullName);
        System.out.println("Group: " + g1.name);
        System.out.println("TypeQuestion: " + t1.name);
        System.out.println("CategoryQuestion: " + c1.name);
        System.out.println("Question: " + q1.content);
        System.out.println("Answer: " + ans1.content);
        System.out.println("Exam: " + e1.title);
        System.out.println("Exam Question: " + eq1.question.content);
    }
}
