package controller;

import entities.*;
import ex1.TypeQuestion;
import services.PrintlnObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Department account = new Department(1, "tuyen","tuyen");

        PrintlnObject.println();
        // (entities.Question 3)
        System.out.println("entities.Department: " + );
        System.out.println("entities.Position: " + Position_3);
        System.out.println("entities.Account: " + account.address);
        System.out.println("entities.Group: " + group.name);
        System.out.println("ex1.TypeQuestion: " + typeQuestion.name);
        System.out.println("entities.CategoryQuestion: " + categoryQuestion.name);
        System.out.println("entities.Question: " + question.content);
        System.out.println("entities.Answer: " + ans1.content);
        System.out.println("entities.Exam: " + exam.title);
        System.out.println("entities.Exam entities.Question: " + examQuestion.question.content);

     // ex1
        if (account_2.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + account_2.department.name);
        }

        if (account_2.groups == null || account_2.groups.length == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (account_2.groups.length == 1 || account_2.groups.length == 2) {
            System.out.print("Group của nhân viên này là: ");
            for (Group g : account_2.groups) {
                System.out.print(g.name + " ");
            }
        } else if (account_2.groups.length == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        System.out.println(
                account_2.department == null
                        ? "Nhân viên này chưa có phòng ban"
                        : "Phòng ban của nhân viên này là " + account_2.department.name
        );

        System.out.println(
                account_2.position != null && account_2.position == Position.DEV
                        ? "Đây là Developer"
                        : "Người này không phải là Developer"
        );
      //Question 5:
        int count = (group.creator.groups == null) ? 0 : group.creator.groups.length;


        switch (count) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }
      //Question 6


        int groupCount = (account_2.groups == null) ? 0 : account_2.groups.length;

        switch (groupCount) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;

            case 1:
            case 2:
                System.out.print("Group của nhân viên này là: ");
                for (Group g : account_2.groups) {
                    System.out.print(g.name + " ");
                }
                System.out.println();
                break;

            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;

            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        // Question 7:


        switch (account_1.position) {
            case DEV:
                System.out.println("Đây là Developer");
                break;

            default:
                System.out.println("Người này không phải là Developer");
        }
        //Question 8:
        Account[] accounts = new Account[3];

        accounts[0] = account_1;
        accounts[1] = account_2;
        accounts[2] = account_3;
        for (Account acc : accounts) {
            System.out.println("Email: " + acc.email);
            System.out.println("Full name: " + acc.fullName);

            if (acc.department == null) {
                System.out.println("Department: Chưa có phòng ban");
            } else {
                System.out.println("Department: " + acc.department.name);
            }

            System.out.println("-----------------------");
        }
        // Question 9:
        Department[] departments = new Department[3];

        departments[0] = department_1;
        departments[1] = department_2;
        departments[2] = department_3;
        for (Department d : departments) {
            System.out.println("Department ID: " + d.id);
            System.out.println("Department Name: " + d.name);
            System.out.println("---------------------");
        }
        // Question 10 :
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
        }
        // Question 11 :
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].name);
        }
        // Question 12 :
        for (int i = 0; i < departments.length; i++) {
            if (i == 2) break;

            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].name);
        }
        // Question 13 :
        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) continue;

            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
        }
       // Question 14 :
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].id < 4) {
                System.out.println("Email: " + accounts[i].email);
                System.out.println("Full name: " + accounts[i].fullName);
            }
        }
      // Question 15 :
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
      // Question 16 :
        int i = 0;
        while (true) {
            if (i > 20) break;

            if (i % 2 != 0) {
                i++;
                continue;
            }

            System.out.println(i);
            i++;
        }
      //  Question 17 :
        int a = 0;
        do {
            if (a > 20) break;

            if (a % 2 == 0) {
                System.out.println(i);
            }
            a++;
        } while (true);
   //ex2
        // Question 1
        int number = 5;
        System.out.printf("Số nguyên là: %d%n", number);
        // Question 2
        int number_2 = 100_000_000;
        System.out.printf("Số nguyên là: %,d%n", number);
       // Question 3
        double number_3 = 5.567098;
        System.out.printf("Số thực là: %.4f%n", number_3);
      //Question 4
        String fullName = "Nguyễn Văn A";
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.%n", fullName);
      // Question 5


        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");

        System.out.printf("Thời gian hiện tại: %s%n", now.format(formatter));
      // Question 6
        System.out.printf("%-5s %-25s %-20s %-15s%n",
                "ID", "Email", "Full Name", "Department");
        System.out.println("---------------------------------------------------------------");

        for (Account acc : accounts) {
            System.out.printf("%-5d %-25s %-20s %-15s%n",
                    acc.id,
                    acc.email,
                    acc.fullName,
                    acc.department != null ? acc.department.name : "Chưa có");
        }
      // ex3
        // Question 1
        DateTimeFormatter vnFormatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Exam: " + exam.title);
        System.out.println("Ngày tạo: " + exam.createDate.format(vnFormatter));
        // Question 2
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatte =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(dateTime.format(formatte));
        // Question 3
        DateTimeFormatter yearFormatter =
                DateTimeFormatter.ofPattern("yyyy");

        System.out.println("Năm tạo Exam: " +
                exam.createDate.format(yearFormatter));
        // Question 4
        DateTimeFormatter monthYearFormatter =
                DateTimeFormatter.ofPattern("MM/yyyy");

        System.out.println("Tháng/Năm tạo Exam: " +
                exam.createDate.format(monthYearFormatter));
        // Question 5
        DateTimeFormatter mmddFormatter =
                DateTimeFormatter.ofPattern("MM-dd");

        System.out.println("Ngày tạo (MM-DD): " +
                exam.createDate.format(mmddFormatter));
        // ex4
        // Question 1
        Random random = new Random();
        int randomInt = random.nextInt();
        System.out.println("Số nguyên ngẫu nhiên: " + randomInt);
        // Question 2
        double randomDouble = random.nextDouble();
        System.out.println("Số thực ngẫu nhiên: " + randomDouble);
        // Question 3
        String[] names = {"An", "Bình", "Chi", "Dũng", "Hà"};

        int index = random.nextInt(names.length);
        System.out.println("Bạn được chọn là: " + names[index]);
        // Question 4
        LocalDate startDate = LocalDate.of(1995, 7, 24);
        LocalDate endDate = LocalDate.of(1995, 12, 20);

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = random.nextInt((int) days + 1);

        LocalDate randomDate = startDate.plusDays(randomDays);
        System.out.println("Ngày ngẫu nhiên: " + randomDate);
       // Question 5
        LocalDate today = LocalDate.now();
        LocalDate oneYearAgo = today.minusYears(1);

        long day = ChronoUnit.DAYS.between(oneYearAgo, today);
        long randomDay = random.nextInt((int) day + 1);

        LocalDate randomDate_1 = oneYearAgo.plusDays(randomDay);
        System.out.println("Ngày ngẫu nhiên trong 1 năm qua: " + randomDate_1);
        // Question 6
        LocalDate startDate_1 = LocalDate.of(1970, 1, 1);
        LocalDate today_1 = LocalDate.now();

        long day_1 = ChronoUnit.DAYS.between(startDate_1, today_1);
        long randomDays_3 = random.nextInt((int) day_1 + 1);

        LocalDate randomDate_3 = startDate.plusDays(randomDays_3);
        System.out.println("Ngày ngẫu nhiên trong quá khứ: " + randomDate_3);

       // Question 7
        int random3Digit = random.nextInt(900) + 100;
        System.out.println("Số ngẫu nhiên có 3 chữ số: " + random3Digit);
        //ex5
        // Question 1
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên thứ 1: ");
        int e = scanner.nextInt();

        System.out.print("Nhập số nguyên thứ 2: ");
        int b = scanner.nextInt();

        System.out.print("Nhập số nguyên thứ 3: ");
        int c = scanner.nextInt();

        System.out.println("3 số vừa nhập: " + a + ", " + b + ", " + c);
        // Question 2
        System.out.print("Nhập số thực thứ 1: ");
        double x = scanner.nextDouble();

        System.out.print("Nhập số thực thứ 2: ");
        double y = scanner.nextDouble();

        System.out.println("2 số thực vừa nhập: " + x + ", " + y);
        // Question 3
        scanner.nextLine(); // clear buffer
        System.out.print("Nhập họ và tên: ");
        String fullName_1 = scanner.nextLine();

        System.out.println("Họ tên: " + fullName_1);
        // Question 4
        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        String input = scanner.nextLine();

        LocalDate birthday = LocalDate.parse(input);
        System.out.println("Ngày sinh: " + birthday);
        // Question 5
        createAccount(scanner );
        // Question 6
        createDepartment(scanner);
        // Question 7
        Even_number();
        // Question 8
        createMenu();
        // Question 9 ;
         Group[] groups = new Group[10];
        //  Question 10 ;
        addGroupToAccount(accounts , groups , scanner );
        //  Question 11;
        addAccountToRandomGroup (accounts , groups , scanner ); //ex6
        // Question 1;
        printEvenNumbersLessThan10();
        // Question 2;
        printAccounts(accounts);
        // Question 3;
        printPositiveNumbersLessThan10();
        // Question_3_ex_3
        System.out.println(departments[0].toString());
    }



    public static void addGroupToAccount(
            Account[] accounts, Group[] groups, Scanner scanner) {

        System.out.println("Danh sách username:");
        for (Account acc : accounts) {
            System.out.println(acc.username);
        }

        System.out.print("Nhập username: ");
        String username = scanner.nextLine();

        Account selectedAcc = null;
        for (Account acc : accounts) {
            if (acc.username.equals(username)) {
                selectedAcc = acc;
                break;
            }
        }

        System.out.println("Danh sách group:");
        for (Group g : groups) {
            System.out.println(g.name);
        }

        System.out.print("Nhập tên group: ");
        String groupName = scanner.nextLine();

        for (Group g : groups) {
            if (g.name.equals(groupName)) {
                g.accounts.add(selectedAcc);
                System.out.println("Thêm group thành công");
                return;
            }
        }
    }


    public static Account createAccount(Scanner scanner) {
        Account acc = new Account();

        System.out.print("Nhập email: ");
        acc.email = scanner.nextLine();

        System.out.print("Nhập username: ");
        acc.username = scanner.nextLine();

        System.out.print("Nhập full name: ");
        acc.fullName = scanner.nextLine();

        System.out.print("Nhập Position (1.Dev 2.Test 3.ScrumMaster 4.PM): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: acc.position = Position.DEV; break;
            case 2: acc.position = Position.TEST; break;
            case 3: acc.position = Position.SCRUM_MASTER; break;
            case 4: acc.position = Position.PM; break;
            default: System.out.println("Sai Position"); break;
        }

        acc.createDate = LocalDate.now();
        return acc;
    }
    public static Department createDepartment(Scanner scanner) {
        Department dep = new Department(5, "sd","lang thuong");

        System.out.print("Nhập ID phòng ban: ");
        dep.id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên phòng ban: ");
        dep.name = scanner.nextLine();

        return dep;
    }

     public static void   Even_number (){
         int number;
         do {
             System.out.print("Nhập số chẵn: ");
             Scanner scanner = null;
             number = scanner.nextInt();
         } while (number % 2 != 0);

         System.out.println("Số chẵn hợp lệ: " + number);

     }
    public static void createMenu (

    ){
        while (true) {
            System.out.println("Mời bạn nhập chức năng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");

            Scanner scanner = null;
            int choose = scanner.nextInt();
            scanner.nextLine();

            if (choose == 1) {
                createAccount(scanner);
            } else if (choose == 2) {
                createDepartment(scanner);
            } else {
                System.out.println("Mời bạn nhập lại");
                continue;
            }
        }

    }
    public static void createMenu_1 (){
        while (true) {
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("3. Thêm Group vào Account");

            Scanner scanner = null;
            int choose = scanner.nextInt();
            scanner.nextLine();

            if (choose == 1) {
                createAccount(scanner);
            } else if (choose == 2) {
                createDepartment(scanner);
            } else if (choose == 3) {
              //  addGroupToAccount();

            } else {
                System.out.println("Sai chức năng");
                continue;
            }

            System.out.print("Bạn có muốn tiếp tục không? (Có/Không): ");
            String cont = scanner.nextLine();
            if (cont.equalsIgnoreCase("Không")) {
                return;
            }
        }

    }
    public static void addAccountToRandomGroup(
            Account[] accounts, Group[] groups, Scanner scanner) {

        System.out.println("Danh sách username:");
        for (Account acc : accounts) {
            System.out.println(acc.username);
        }

        System.out.print("Nhập username: ");
        String username = scanner.nextLine();

        Account selectedAcc = null;
        for (Account acc : accounts) {
            if (acc.username.equals(username)) {
                selectedAcc = acc;
                break;
            }
        }

        Random random = new Random();
        Group randomGroup = groups[random.nextInt(groups.length)];

        randomGroup.accounts.add(selectedAcc);
        System.out.println("Đã thêm vào group: " + randomGroup.name);
    }
    public static void printEvenNumbersLessThan10() {
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
    public static void printAccounts(Account[] accounts) {
        for (Account acc : accounts) {
            System.out.println("Email: " + acc.email);
            System.out.println("Full name: " + acc.fullName);

            if (acc.department != null) {
                System.out.println("Department: " + acc.department.name);
            } else {
                System.out.println("Department: Chưa có");
            }
            System.out.println("--------------------");
        }
    }
    public static void printPositiveNumbersLessThan10() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
    }

    // Question_3_ex_3



}








