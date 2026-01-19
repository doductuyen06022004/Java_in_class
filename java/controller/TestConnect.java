package controller;

import java.sql.*;
import java.util.Scanner;

public class TestConnect {
    public static void main(String[] args) {


        getAllPosition();
        createPosition();
      //  updatePositionById();
        deletePositionById();
        getAllPosition();
    }

    public static void getAllPosition() {

        String url = "jdbc:mysql://localhost:3306/testing_system";
        String user = "root";
        String password = "tuyen06022004";

        String sql = "SELECT id, name FROM position";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("Connect success!");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                " | Name: " + rs.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createPosition() {

        String url = "jdbc:mysql://localhost:3306/testing_system";
        String user = "root";
        String password = "tuyen06022004";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position name: ");
        String name = scanner.nextLine();

        String sql = "INSERT INTO `position` (name) VALUES (?)";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("Create position success!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
    public static void updatePositionById() {

        String url = "jdbc:mysql://localhost:3306/testing_system";
        String user = "root";
        String password = "tuyen06022004";

        String sql = "UPDATE position SET name = ? WHERE id = ?";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, "Dev");
            ps.setInt(2, 5);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Update position success!");
            } else {
                System.out.println("Position not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
    public static void deletePositionById() {

        String url = "jdbc:mysql://localhost:3306/testing_system";
        String user = "root";
        String password = "tuyen06022004";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position id to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM `position` WHERE id = ?";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Delete position success!");
            } else {
                System.out.println("Position not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}
