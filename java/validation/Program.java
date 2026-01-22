package validation;

import com.vti.entity.Department;
import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.entity.Position;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {

        // ===== Exercise 1: Department =====
        Department dep1 = new Department(1, "IT");
        Department dep2 = new Department(2, "Sale");

        System.out.println("Department 1: id = " + dep1.getId() + ", name = " + dep1.getName());
        System.out.println("Department 2: id = " + dep2.getId() + ", name = " + dep2.getName());

        // ===== Exercise 2: Account =====

        // a) Không có parameters
        Account account1 = new Account();

        // b) Có id, email, username, firstname, lastname
        Account account2 = new Account(
                1,
                "a@gmail.com",
                "user1",
                "Nguyen",
                "An"
        );

        // c) Có position, createDate = now
        Account account3 = new Account(
                2,
                "b@gmail.com",
                "user2",
                "Tran",
                "Binh",
                Position.DEV
        );

        // d) Có position và createDate
        Account account4 = new Account(
                3,
                "c@gmail.com",
                "user3",
                "Le",
                "Cuong",
                Position.MANAGER,
                LocalDate.of(2024, 1, 1)
        );

        // ===== Exercise 3: Group =====

        // Creator
        Account creator = account2;

        // a) Không parameters
        Group group1 = new Group();

        // b) Account[]
        Account[] accounts = { account2, account3 };

        Group group2 = new Group(
                "Java Fresher",
                creator,
                accounts,
                LocalDate.now()
        );

        // c) usernames[]
        String[] usernames = { "user4", "user5" };

        Group group3 = new Group(
                "Backend Team",
                creator,
                usernames,
                LocalDate.of(2024, 1, 1)
        );
    }
}
