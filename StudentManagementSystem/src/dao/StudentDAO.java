package dao;

import db.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // CREATE
    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO students(name, age, course, email) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getEmail());

            ps.executeUpdate();

            System.out.println("✅ Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // READ
    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setCourse(rs.getString("course"));
                s.setEmail(rs.getString("email"));

                list.add(s);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return list;
    }

    // UPDATE
    public void updateStudent(int id, String course, String email) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE students SET course=?, email=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, course);
            ps.setString(2, email);
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("✅ Student Updated");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // DELETE
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("❌ Student Deleted");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}