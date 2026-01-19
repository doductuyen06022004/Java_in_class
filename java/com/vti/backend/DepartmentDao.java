package com.vti.backend;

import com.vti.entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    private final String url = "jdbc:mysql://localhost:3306/testing_system";
    private final String user = "root";
    private final String password = "tuyen06022004";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Question 1: get list departments
    public List<Department> getDepartments() throws Exception {
        List<Department> departments = new ArrayList<>();

        String sql = "SELECT id, name FROM Department";

        try (
                Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                departments.add(
                        new Department(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
                );
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

        return departments;
    }

    // Question 2 & 3: get department by id
    public Department getDepartmentById(int id) throws Exception {

        String sql = "SELECT id, name FROM Department WHERE id = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Department(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            } else {
                throw new Exception("Cannot find department which has id = " + id);
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    // Question 4: check department name exists
    public boolean isDepartmentNameExists(String name) throws Exception {

        String sql = "SELECT 1 FROM Department WHERE name = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    // Question 5: create department
    public void createDepartment(String name) throws Exception {

        if (isDepartmentNameExists(name)) {
            throw new Exception("Department Name is Exists!");
        }

        String sql = "INSERT INTO Department(name) VALUES (?)";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateDepartmentName(int updateId, String newName) throws Exception {

        // Check ID tồn tại
        if (!isDepartmentIdExists(updateId)) {
            throw new Exception("Cannot find department which has id = " + updateId);
        }

        // Check name trùng
        if (isDepartmentNameExists(newName)) {
            throw new Exception("Department Name is Exists!");
        }

        String sql = "UPDATE Department SET name = ? WHERE id = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, newName);
            ps.setInt(2, updateId);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    private boolean isDepartmentIdExists(int updateId) throws Exception {

        String sql = "SELECT 1 FROM Department WHERE id = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, updateId);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // true: tồn tại | false: không tồn tại

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

}
