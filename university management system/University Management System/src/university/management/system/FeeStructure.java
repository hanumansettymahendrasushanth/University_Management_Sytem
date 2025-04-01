////package university.management.system;
////
////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////
////public class FeeStructure extends JFrame implements ActionListener {
////    FeeStructure()
////    {
////        getContentPane().setBackground(Color.white);
////
////        JLabel heading = new JLabel("Fee Structure");
////        heading.setBounds(400,10,400,30);
////        heading.setFont(new Font("Tahoma",Font.BOLD,30));
////        add(heading);
////
////        setSize(100,700);
////        setLocation(250,50);
////        setLayout(null);
////        setVisible(true);
////
////
////
////
////    }
////
////    @Override
////    public void actionPerformed(ActionEvent e) {
////
////    }
////
////    public static void main(String[] args) {
////        new FeeStructure();
////    }
////
////
////}
//
//
//
//package university.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class FeeStructure extends JFrame implements ActionListener {
//
//    Choice cRollNo;
//    JTextField textCourse, textAmount;
//    JButton loadButton, payButton, cancelButton;
//
//    FeeStructure() {
//        // Set gradient background
//        setContentPane(new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Graphics2D g2d = (Graphics2D) g;
//                GradientPaint gp = new GradientPaint(0, 0, new Color(216, 191, 216), 0, getHeight(), new Color(173, 216, 230));
//                g2d.setPaint(gp);
//                g2d.fillRect(0, 0, getWidth(), getHeight());
//            }
//        });
//
//        // Heading
//        JLabel heading = new JLabel("Pay Fees");
//        heading.setBounds(350, 30, 500, 50);
//        heading.setFont(new Font("Serif", Font.BOLD, 30));
//        heading.setForeground(new Color(51, 51, 51));
//        add(heading);
//
//        // Roll Number Selection
//        JLabel rollNoLabel = new JLabel("Select Roll No");
//        rollNoLabel.setBounds(40, 100, 150, 30);
//        rollNoLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        rollNoLabel.setForeground(new Color(51, 51, 51));
//        add(rollNoLabel);
//
//        cRollNo = new Choice();
//        cRollNo.setBounds(200, 105, 200, 30);
//        cRollNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
//        cRollNo.setBackground(new Color(255, 250, 205));
//        add(cRollNo);
//
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.statement.executeQuery("SELECT roll_no FROM student");
//            while (rs.next()) {
//                cRollNo.add(rs.getString("roll_no"));
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Load Button
//        loadButton = new JButton("Load Details");
//        loadButton.setBounds(420, 100, 150, 30);
//        loadButton.setBackground(new Color(70, 130, 180));
//        loadButton.setForeground(Color.WHITE);
//        loadButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                loadButton.setBackground(new Color(100, 149, 237));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                loadButton.setBackground(new Color(70, 130, 180));
//            }
//        });
//        loadButton.addActionListener(this);
//        add(loadButton);
//
//        // Course
//        JLabel courseLabel = new JLabel("Course");
//        courseLabel.setBounds(40, 150, 150, 30);
//        courseLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        courseLabel.setForeground(new Color(51, 51, 51));
//        add(courseLabel);
//
//        textCourse = new JTextField();
//        textCourse.setBounds(200, 150, 200, 30);
//        textCourse.setBackground(new Color(255, 250, 205));
//        textCourse.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
//        textCourse.setEditable(false);
//        add(textCourse);
//
//        // Amount Due
//        JLabel amountLabel = new JLabel("Amount Due (INR)");
//        amountLabel.setBounds(40, 200, 150, 30);
//        amountLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        amountLabel.setForeground(new Color(51, 51, 51));
//        add(amountLabel);
//
//        textAmount = new JTextField();
//        textAmount.setBounds(200, 200, 200, 30);
//        textAmount.setBackground(new Color(255, 250, 205));
//        textAmount.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
//        add(textAmount);
//
//        // Pay Button
//        payButton = new JButton("Pay Now");
//        payButton.setBounds(200, 260, 100, 35);
//        payButton.setBackground(new Color(50, 205, 50));
//        payButton.setForeground(Color.WHITE);
//        payButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                payButton.setBackground(new Color(60, 179, 113));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                payButton.setBackground(new Color(50, 205, 50));
//            }
//        });
//        payButton.addActionListener(this);
//        add(payButton);
//
//        // Cancel Button
//        cancelButton = new JButton("Cancel");
//        cancelButton.setBounds(320, 260, 100, 35);
//        cancelButton.setBackground(new Color(255, 69, 0));
//        cancelButton.setForeground(Color.WHITE);
//        cancelButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                cancelButton.setBackground(new Color(220, 20, 60));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                cancelButton.setBackground(new Color(255, 69, 0));
//            }
//        });
//        cancelButton.addActionListener(this);
//        add(cancelButton);
//
//        setSize(900, 350);
//        setLocation(350, 50);
//        setLayout(null);
//        setVisible(true);
//    }
//
//    private void loadStudentDetails(String rollNo) {
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.statement.executeQuery("SELECT course FROM student WHERE roll_no = '" + rollNo + "'");
//            if (rs.next()) {
//                textCourse.setText(rs.getString("course"));
//                // Dummy fee amount based on course (for simplicity)
//                String course = textCourse.getText();
//                switch (course) {
//                    case "B.TECH": textAmount.setText("50000"); break;
//                    case "BBA": textAmount.setText("40000"); break;
//                    case "BCA": textAmount.setText("45000"); break;
//                    case "MCA": textAmount.setText("60000"); break;
//                    case "B.COM": textAmount.setText("35000"); break;
//                    case "M.COM": textAmount.setText("50000"); break;
//                    case "MBA": textAmount.setText("75000"); break;
//                    case "MA": textAmount.setText("30000"); break;
//                    case "BA": textAmount.setText("25000"); break;
//                    default: textAmount.setText("0");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "No record found for Roll No: " + rollNo);
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error loading details: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == loadButton) {
//            String selectedRollNo = cRollNo.getSelectedItem();
//            if (selectedRollNo != null) {
//                loadStudentDetails(selectedRollNo);
//            } else {
//                JOptionPane.showMessageDialog(null, "Please select a Roll No");
//            }
//        } else if (e.getSource() == payButton) {
//            String rollNo = cRollNo.getSelectedItem();
//            String course = textCourse.getText();
//            String amount = textAmount.getText();
//            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//
//            if (rollNo == null || course.isEmpty() || amount.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Please load details and enter an amount");
//                return;
//            }
//
//            try {
//                String query = "INSERT INTO fee_payments (roll_no, course, amount, payment_date) VALUES ('" + rollNo + "', '" + course + "', '" + amount + "', '" + date + "')";
//                Conn c = new Conn();
//                c.statement.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Payment of INR " + amount + " successful for Roll No: " + rollNo);
//                System.out.println("Fee payment recorded for Roll No: " + rollNo);
//                setVisible(false);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error processing payment: " + ex.getMessage());
//            }
//        } else if (e.getSource() == cancelButton) {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new FeeStructure();
//    }
//}




package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FeeStructure extends JFrame implements ActionListener {

    JButton backButton;

    FeeStructure() {
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(216, 191, 216), 0, getHeight(), new Color(173, 216, 230));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        // Heading
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(400, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(new Color(51, 51, 51));
        add(heading);

        // Fetch data from the fee table
        ArrayList<Object[]> feeData = new ArrayList<>();
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM fee");
            while (rs.next()) {
                feeData.add(new Object[]{
                        rs.getString("course"),
                        rs.getString("semester1"),
                        rs.getString("semester2"),
                        rs.getString("semester3"),
                        rs.getString("semester4"),
                        rs.getString("semester5"),
                        rs.getString("semester6"),
                        rs.getString("semester7"),
                        rs.getString("semester8")
                });
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching fee structure: " + e.getMessage());
        }

        // Column names for the table
        String[] columnNames = {
                "Course", "Semester 1 (INR)", "Semester 2 (INR)", "Semester 3 (INR)", "Semester 4 (INR)",
                "Semester 5 (INR)", "Semester 6 (INR)", "Semester 7 (INR)", "Semester 8 (INR)"
        };

        // Convert ArrayList to 2D array for JTable
        Object[][] data = new Object[feeData.size()][9];
        for (int i = 0; i < feeData.size(); i++) {
            data[i] = feeData.get(i);
        }

        // Create and configure the table
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setBackground(new Color(255, 250, 205));
        table.setGridColor(new Color(169, 169, 169));
        table.setEnabled(false); // Read-only

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 900, 300);
        add(scrollPane);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(450, 420, 100, 35);
        backButton.setBackground(new Color(255, 69, 0));
        backButton.setForeground(Color.WHITE);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBackground(new Color(220, 20, 60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBackground(new Color(255, 69, 0));
            }
        });
        backButton.addActionListener(this);
        add(backButton);

        setSize(1000, 500); // Increased width for more columns
        setLocation(300, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}