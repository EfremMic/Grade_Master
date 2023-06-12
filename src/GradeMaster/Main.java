package GradeMaster;

/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList= new ArrayList<>();

        while (true) {
            System.out.println("EMenu");
            System.out.println("1. Set Student info");
            System.out.println("2. Show status");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student's full name:");
                    String fullName = scanner.nextLine();

                    System.out.println("Enter student's ID:");
                    String studentID = scanner.nextLine();

                    System.out.println("Enter subject ID:");
                    String subjectID = scanner.nextLine();

                    System.out.println("Enter test score:");
                    int grade = scanner.nextInt();
                    scanner.nextLine();

                    Student student = new Student(fullName, studentID, subjectID, grade);
                    JDBCManager.insertStudent(student);
                    studentList.add(student);
                    break;

                case 2:
                    System.out.println("********************************************");
                    for (Student s : studentList) {
                        System.out.println("Student name: " + s.getFullName());
                        System.out.println("Student ID: " + s.getStud_Id());
                        System.out.println("Subject ID: " + s.getSubject_Id());
                        System.out.println("Student score: " + s.getGrade());
                        System.out.println("********************************************");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

 */

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    private final List<Student> studentList;

    public Main() {
        setTitle("Grade Master");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentList = new ArrayList<>();


        showMenu();
    }

    private void showMenu() {
        while (true) {
            String[] options = {"Set Student Info", "Show Status", "Exit"};
            int choice = JOptionPane.showOptionDialog(this, "Student grade registry",
                    "Grade Master", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            switch (choice) {
                case 0:
                    JTextField fullNameField = new JTextField();
                    JTextField studentIDField = new JTextField();
                    JTextField subjectIDField = new JTextField();
                    JTextField gradeField = new JTextField();

                    JPanel inputPanel = new JPanel(new GridLayout(4, 2));
                    inputPanel.add(new JLabel("Full Name:"));
                    inputPanel.add(fullNameField);
                    inputPanel.add(new JLabel("Student ID:"));
                    inputPanel.add(studentIDField);
                    inputPanel.add(new JLabel("Subject ID:"));
                    inputPanel.add(subjectIDField);
                    inputPanel.add(new JLabel("Test Score:"));
                    inputPanel.add(gradeField);

                    inputPanel.setPreferredSize(new Dimension(400, 150));
                    inputPanel.setBackground(Color.YELLOW);


                    int result = JOptionPane.showConfirmDialog(this, inputPanel, "Register student`s grade",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        String fullName = fullNameField.getText();
                        String studentID = studentIDField.getText();
                        String subjectID = subjectIDField.getText();
                        int grade = Integer.parseInt(gradeField.getText());

                        Student student = new Student(fullName, studentID, subjectID, grade);
                        JDBCManager.insertStudent(student);
                        studentList.add(student);
                    }
                    break;

                case 1:
                    StringBuilder sb = new StringBuilder();
                    sb.append("********************************************\n");
                    for (Student s : studentList) {
                        sb.append("Student name: ").append(s.getFullName()).append("\n");
                        sb.append("Student ID: ").append(s.getStud_Id()).append("\n");
                        sb.append("Subject ID: ").append(s.getSubject_Id()).append("\n");
                        sb.append("Student score: ").append(s.getGrade()).append("\n");
                        sb.append("********************************************\n");
                    }
                    JTextArea textArea = new JTextArea(sb.toString());
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(600, 400));

                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    JOptionPane.showMessageDialog(this, scrollPane, "Show Status", JOptionPane.PLAIN_MESSAGE);
                    break;

                case 2:
                    JOptionPane.showMessageDialog(this, "Exiting the program...");
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(this, "Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}
