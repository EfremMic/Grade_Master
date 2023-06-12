package GradeMaster;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/schoolgrademaster";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Xpdy2222";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }


    public static void insertStudent(Student student) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO students (fullName, stud_id, subject_id, grade) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, student.getFullName());
            stmt.setString(2, student.getStud_Id());
            stmt.setString(3, student.getSubject_Id());
            stmt.setInt(4, student.getGrade());
            stmt.executeUpdate();
            System.out.println("Student data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                String stud_Id = rs.getString("stud_id");
                String subject_Id = rs.getString("subject_id");
                int grade = rs.getInt("grade");

                Student student = new Student(fullName, stud_Id, subject_Id, grade);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}




