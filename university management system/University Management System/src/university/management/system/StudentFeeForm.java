//package university.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class StudentFeeForm extends JFrame implements ActionListener {
//    StudentFeeForm()
//    {
//        getContentPane().setBackground(new Color(210,252,251));
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel img = new JLabel(i3);
//        img.setBounds(415,50,450,300);
//        add(img);
//
//        setSize(900,500);
//        setLocation(300,100);
//        setLayout(null);
//        setVisible(true);
//
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//

//    }
//
//    public static void main(String[] args) {
//        new StudentFeeForm();
//    }
//
//
//}




package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice cRollNo;
    JTextField textName, textFatherName, textDOB, textDepartment, textCourse, textFeeAmount;
    JComboBox<String> semesterCombo;
    JButton loadButton, payButton, cancelButton;

    StudentFeeForm() {
        getContentPane().setBackground(new Color(210, 252, 251));

        // Heading
        JLabel heading = new JLabel("Student Fee Form");
        heading.setBounds(350, 20, 300, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 25));
        heading.setForeground(new Color(51, 51, 51));
        add(heading);

        // Roll Number Selection
        JLabel rollNoLabel = new JLabel("Select Roll No:");
        rollNoLabel.setBounds(50, 60, 120, 30);
        rollNoLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(rollNoLabel);

        cRollNo = new Choice();
        cRollNo.setBounds(180, 65, 150, 30);
        cRollNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        cRollNo.setBackground(new Color(255, 250, 205));
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT roll_no FROM student");
            while (rs.next()) {
                cRollNo.add(rs.getString("roll_no"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(cRollNo);

        // Load Button
        loadButton = new JButton("Load Details");
        loadButton.setBounds(350, 60, 120, 30);
        loadButton.setBackground(new Color(70, 130, 180));
        loadButton.setForeground(Color.WHITE);
        loadButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { loadButton.setBackground(new Color(100, 149, 237)); }
            @Override
            public void mouseExited(MouseEvent e) { loadButton.setBackground(new Color(70, 130, 180)); }
        });
        loadButton.addActionListener(this);
        add(loadButton);

        // Student Details
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(nameLabel);

        textName = new JTextField();
        textName.setBounds(150, 100, 200, 30);
        textName.setBackground(new Color(255, 250, 205));
        textName.setEditable(false);
        add(textName);

        JLabel fatherNameLabel = new JLabel("Father's Name:");
        fatherNameLabel.setBounds(50, 140, 100, 30);
        fatherNameLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(fatherNameLabel);

        textFatherName = new JTextField();
        textFatherName.setBounds(150, 140, 200, 30);
        textFatherName.setBackground(new Color(255, 250, 205));
        textFatherName.setEditable(false);
        add(textFatherName);

        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(50, 180, 100, 30);
        dobLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(dobLabel);

        textDOB = new JTextField();
        textDOB.setBounds(150, 180, 200, 30);
        textDOB.setBackground(new Color(255, 250, 205));
        textDOB.setEditable(false);
        add(textDOB);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(50, 220, 100, 30);
        deptLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(deptLabel);

        textDepartment = new JTextField();
        textDepartment.setBounds(150, 220, 200, 30);
        textDepartment.setBackground(new Color(255, 250, 205));
        textDepartment.setEditable(false);
        add(textDepartment);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 260, 100, 30);
        courseLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(courseLabel);

        textCourse = new JTextField();
        textCourse.setBounds(150, 260, 200, 30);
        textCourse.setBackground(new Color(255, 250, 205));
        textCourse.setEditable(false);
        add(textCourse);

        // Payment Section
        JLabel semesterPayLabel = new JLabel("Pay Semester:");
        semesterPayLabel.setBounds(50, 300, 120, 30);
        semesterPayLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(semesterPayLabel);

        String[] semesters = {"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
        semesterCombo = new JComboBox<>(semesters);
        semesterCombo.setBounds(180, 300, 150, 30);
        semesterCombo.setBackground(new Color(255, 250, 205));
        semesterCombo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateFeeAmount();
            }
        });
        add(semesterCombo);

        JLabel feeAmountLabel = new JLabel("Amount (INR):");
        feeAmountLabel.setBounds(350, 300, 120, 30);
        feeAmountLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(feeAmountLabel);

        textFeeAmount = new JTextField();
        textFeeAmount.setBounds(470, 300, 100, 30);
        textFeeAmount.setBackground(new Color(255, 250, 205));
        textFeeAmount.setEditable(false);
        add(textFeeAmount);

        // Buttons
        payButton = new JButton("Pay");
        payButton.setBounds(180, 350, 100, 35);
        payButton.setBackground(new Color(50, 205, 50));
        payButton.setForeground(Color.WHITE);
        payButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { payButton.setBackground(new Color(60, 179, 113)); }
            @Override
            public void mouseExited(MouseEvent e) { payButton.setBackground(new Color(50, 205, 50)); }
        });
        payButton.addActionListener(this);
        add(payButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300, 350, 100, 35);
        cancelButton.setBackground(new Color(255, 69, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { cancelButton.setBackground(new Color(220, 20, 60)); }
            @Override
            public void mouseExited(MouseEvent e) { cancelButton.setBackground(new Color(255, 69, 0)); }
        });
        cancelButton.addActionListener(this);
        add(cancelButton);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(600, 150, 300, 200);
        add(img);

        setSize(950, 450);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    private void loadStudentDetails(String rollNo) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT name, fname, dob, branch, course FROM student WHERE roll_no = '" + rollNo + "'");
            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textFatherName.setText(rs.getString("fname"));
                textDOB.setText(rs.getString("dob"));
                textDepartment.setText(rs.getString("branch"));
                textCourse.setText(rs.getString("course"));
                updateFeeAmount(); // Update fee amount based on selected semester
            } else {
                JOptionPane.showMessageDialog(null, "No student found for Roll No: " + rollNo);
                clearStudentDetails();
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading details: " + e.getMessage());
        }
    }

    private void updateFeeAmount() {
        String course = textCourse.getText();
        int selectedSemester = semesterCombo.getSelectedIndex();
        if (course.isEmpty() || selectedSemester < 0) {
            textFeeAmount.setText("");
            return;
        }

        try {
            Conn c = new Conn();
            String query = "SELECT semester" + (selectedSemester + 1) + " FROM fee WHERE course = '" + course + "'";
            ResultSet feeRs = c.statement.executeQuery(query);
            if (feeRs.next()) {
                String fee = feeRs.getString("semester" + (selectedSemester + 1));
                if (fee != null && !fee.trim().isEmpty()) {
                    textFeeAmount.setText(fee);
                } else {
                    textFeeAmount.setText("N/A");
                }
            } else {
                textFeeAmount.setText("N/A");
                JOptionPane.showMessageDialog(null, "No fee data found for course: " + course);
            }
            feeRs.close();
        } catch (Exception e) {
            e.printStackTrace();
            textFeeAmount.setText("Error");
            JOptionPane.showMessageDialog(null, "Error fetching fee: " + e.getMessage());
        }
    }

    private void clearStudentDetails() {
        textName.setText("");
        textFatherName.setText("");
        textDOB.setText("");
        textDepartment.setText("");
        textCourse.setText("");
        textFeeAmount.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {
            String selectedRollNo = cRollNo.getSelectedItem();
            if (selectedRollNo != null) {
                loadStudentDetails(selectedRollNo);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a Roll No");
            }
        } else if (e.getSource() == payButton) {
            String rollNo = cRollNo.getSelectedItem();
            String course = textCourse.getText();
            String semester = (String) semesterCombo.getSelectedItem();
            String amount = textFeeAmount.getText();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            if (rollNo == null || course.isEmpty() || amount.isEmpty() || amount.equals("N/A") || amount.equals("Error")) {
                JOptionPane.showMessageDialog(null, "Please load valid student details and select a payable semester");
                return;
            }

            try {
                String query = "INSERT INTO fee_payments (roll_no, course, semester, amount, payment_date) VALUES ('" + rollNo + "', '" + course + "', '" + semester + "', '" + amount + "', '" + date + "')";
                Conn c = new Conn();
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Payment of INR " + amount + " for " + semester + " successful");
                System.out.println("Fee payment recorded for Roll No: " + rollNo + ", Semester: " + semester);
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error processing payment: " + ex.getMessage());
            }
        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}