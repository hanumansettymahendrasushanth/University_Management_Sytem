//package university.management.system;
//
//import net.proteanit.sql.DbUtils;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.print.PrinterException;
//import java.sql.ResultSet;
//
//public class TeacherDetails extends JFrame implements ActionListener {
//
//    Choice choice;
//
//    JTable table;
//
//    JButton searchButton, printButton, addButton, updateButton, cancelButton;
//
//    TeacherDetails()
//    {
//
//        getContentPane().setBackground(new Color(192, 164, 252));
//
//        // Heading
//        JLabel heading = new JLabel("Search By EMP ID");
//        heading.setBounds(20, 20, 200, 30);
//        heading.setFont(new Font("Serif", Font.BOLD, 20));
//        add(heading);
//
//
//        choice = new Choice();
//        choice.setBounds(220, 25, 150, 25);
//        choice.setBackground(Color.WHITE);
//        add(choice);
//
//
//        try {
//            Conn c = new Conn();
//            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM teacher");
//            while (resultSet.next()) {
//                choice.add(resultSet.getString("empid"));
//            }
//            resultSet.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error loading roll numbers: " + e.getMessage());
//        }
//
//        // Search Button
//        searchButton = new JButton("Search");
//        searchButton.setBounds(380, 25, 100, 30);
//        searchButton.setBackground(new Color(70, 130, 180));
//        searchButton.setForeground(Color.WHITE);
//        searchButton.addActionListener(this);
//        add(searchButton);
//
//        // Print Button
//        printButton = new JButton("Print");
//        printButton.setBounds(20, 70, 100, 30);
//        printButton.setBackground(new Color(50, 205, 50)); // Green
//        printButton.setForeground(Color.WHITE);
//        printButton.addActionListener(this);
//        add(printButton);
//
//        // Add Button
//        addButton = new JButton("Add");
//        addButton.setBounds(140, 70, 100, 30);
//        addButton.setBackground(new Color(255, 215, 0)); // Yellow
//        addButton.setForeground(Color.BLACK);
//        addButton.addActionListener(this);
//        add(addButton);
//
//        // Update Button
//        updateButton = new JButton("Update");
//        updateButton.setBounds(260, 70, 100, 30);
//        updateButton.setBackground(new Color(70, 130, 180)); // Blue
//        updateButton.setForeground(Color.WHITE);
//        updateButton.addActionListener(this);
//        add(updateButton);
//
//        // Cancel Button
//        cancelButton = new JButton("Cancel");
//        cancelButton.setBounds(380, 70, 100, 30);
//        cancelButton.setBackground(new Color(220, 20, 60)); // Red
//        cancelButton.setForeground(Color.WHITE);
//        cancelButton.addActionListener(this);
//        add(cancelButton);
//
//        // Table
//        table = new JTable();
//        try {
//            Conn c = new Conn();
//            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM teacher");
//            table.setModel(DbUtils.resultSetToTableModel(resultSet));
//            resultSet.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage());
//        }
//
//        JScrollPane js = new JScrollPane(table);
//        js.setBounds(0, 120, 880, 560);
//        add(js);
//
//
//        setSize(900, 700);
//        setLocation(300, 100);
//        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == searchButton) {
//            String selectedRoll = choice.getSelectedItem();
//            try {
//                Conn c = new Conn();
//                String query = "SELECT * FROM teacher WHERE empid = '" + selectedRoll + "'";
//                ResultSet resultSet = c.statement.executeQuery(query);
//                table.setModel(DbUtils.resultSetToTableModel(resultSet));
//                resultSet.close();
//            }
//            catch (Exception ex) {
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error searching student: " + ex.getMessage());
//            }
//        }
//        else if (e.getSource() == printButton) {
//            try {
//                table.print();
//            } catch (PrinterException ex) {
//                JOptionPane.showMessageDialog(null, "Error printing: " + ex.getMessage());
//            }
//        } else if (e.getSource() == addButton) {
//            new AddFaculty();
//
//        } else if (e.getSource() == updateButton) {
//            int selectedRow = table.getSelectedRow();
//            if (selectedRow >= 0) {
//                String rollNo = (String) table.getValueAt(selectedRow, 2);
//                new UpdateStudent(rollNo);
//            } else {
//                JOptionPane.showMessageDialog(null, "Please select a student to update!");
//            }
//        } else if (e.getSource() == cancelButton) {
//            setVisible(false);
//        }
//
//    }
//
//    public static void main(String[] args) {
//        new TeacherDetails();
//        System.out.println("Executed the Teacher Details");
//    }
//
//
//}


package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton searchButton, printButton, addButton, updateButton, cancelButton;

    TeacherDetails() {
        getContentPane().setBackground(new Color(192, 164, 252));
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        JLabel heading = new JLabel("Teacher Details");
        heading.setBounds((screenWidth - 600) / 2, 20, 600, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 48));
        heading.setForeground(new Color(25, 25, 112));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        int leftX = 50;
        int startY = 100;

        // Search By EMP ID and Search Option
        JLabel empIdLabel = new JLabel("Search By EMP ID:");
        empIdLabel.setBounds(leftX, startY, 200, 40);
        empIdLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        add(empIdLabel);

        choice = new Choice();
        choice.setBounds(leftX, startY + 40, 250, 30);
        choice.setFont(new Font("SansSerif", Font.PLAIN, 16));
        choice.setBackground(Color.WHITE);
        add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM teacher");
            while (resultSet.next()) {
                choice.add(resultSet.getString("empid"));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading EMP IDs: " + e.getMessage());
        }

        searchButton = new JButton("Search");
        searchButton.setBounds(leftX + 260, startY + 40, 150, 30);
        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Serif", Font.BOLD, 16));
        searchButton.addActionListener(this);
        add(searchButton);


        int buttonY = startY + 80;
        printButton = new JButton("Print");
        printButton.setBounds(leftX, buttonY, 120, 30);
        printButton.setBackground(new Color(50, 205, 50));
        printButton.setForeground(Color.WHITE);
        printButton.setFont(new Font("Serif", Font.BOLD, 16));
        printButton.addActionListener(this);
        add(printButton);

        addButton = new JButton("Add");
        addButton.setBounds(leftX + 140, buttonY, 120, 30); // 20px gap
        addButton.setBackground(new Color(255, 215, 0));
        addButton.setForeground(Color.BLACK);
        addButton.setFont(new Font("Serif", Font.BOLD, 16));
        addButton.addActionListener(this);
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(leftX + 280, buttonY, 120, 30); // 20px gap
        updateButton.setBackground(new Color(70, 130, 180));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Serif", Font.BOLD, 16));
        updateButton.addActionListener(this);
        add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(leftX + 420, buttonY, 120, 30); // 20px gap
        cancelButton.setBackground(new Color(220, 20, 60));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Serif", Font.BOLD, 16));
        cancelButton.addActionListener(this);
        add(cancelButton);

        table = new JTable();
        loadTableDataVertically();

        JScrollPane js = new JScrollPane(table);
        js.setBounds(10, buttonY + 50, screenWidth - 20, screenHeight - (buttonY + 70)); // 50px space above table
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setBackground(new Color(255, 245, 238));
        add(js);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadTableDataVertically() {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM teacher");
            ArrayList<String[]> teacherData = new ArrayList<>();
            ArrayList<String> empIds = new ArrayList<>();

            while (resultSet.next()) {
                String[] row = new String[11]; // Assuming 11 columns in teacher table
                row[0] = resultSet.getString("name");
                row[1] = resultSet.getString("fname");
                row[2] = resultSet.getString("empid");
                row[3] = resultSet.getString("dob");
                row[4] = resultSet.getString("address");
                row[5] = resultSet.getString("phonenumber");
                row[6] = resultSet.getString("email");
                row[7] = resultSet.getString("aadharnumber");
                row[8] = resultSet.getString("xii");
                row[9] = resultSet.getString("course");
                row[10] = resultSet.getString("department");
                teacherData.add(row);
                empIds.add(row[2]); // Store empid for reference
            }
            resultSet.close();

            String[] columnNames = {"Field", "Value"};
            Object[][] data = new Object[11][2]; // 11 fields
            String[] fields = {"Name", "Father's Name", "EMP ID", "DOB", "Address", "Phone Number", "Email", "Aadhar Number", "XII", "Course", "Department"};

            table.setModel(DbUtils.resultSetToTableModel(c.statement.executeQuery("SELECT * FROM teacher")));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String selectedEmpId = choice.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM teacher WHERE empid = '" + selectedEmpId + "'");
                // Transpose for vertical display
                if (resultSet.next()) {
                    Object[][] data = new Object[11][2];
                    String[] fields = {"Name", "Father's Name", "EMP ID", "DOB", "Address", "Phone Number", "Email", "Aadhar Number", "XII", "Course", "Department"};
                    data[0][0] = fields[0]; data[0][1] = resultSet.getString("name");
                    data[1][0] = fields[1]; data[1][1] = resultSet.getString("fname");
                    data[2][0] = fields[2]; data[2][1] = resultSet.getString("empid");
                    data[3][0] = fields[3]; data[3][1] = resultSet.getString("dob");
                    data[4][0] = fields[4]; data[4][1] = resultSet.getString("address");
                    data[5][0] = fields[5]; data[5][1] = resultSet.getString("phonenumber");
                    data[6][0] = fields[6]; data[6][1] = resultSet.getString("email");
                    data[7][0] = fields[7]; data[7][1] = resultSet.getString("aadharnumber");
                    data[8][0] = fields[8]; data[8][1] = resultSet.getString("xii");
                    data[9][0] = fields[9]; data[9][1] = resultSet.getString("course");
                    data[10][0] = fields[10]; data[10][1] = resultSet.getString("department");
                    table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Field", "Value"}));
                }
                resultSet.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error searching teacher: " + ex.getMessage());
            }
        } else if (e.getSource() == printButton) {
            try {
                table.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, "Error printing: " + ex.getMessage());
            }
        } else if (e.getSource() == addButton) {
            new AddFaculty();
        } else if (e.getSource() == updateButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String empId = (String) table.getValueAt(2, 1); // EMP ID is at row 2 in vertical layout
                new UpdateTeacher(empId);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a teacher to update!");
            }
        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
        System.out.println("Executed the Teacher Details");
    }
}

// Placeholder for UpdateTeacher class
class UpdateTeacher extends JFrame {
    UpdateTeacher(String empId) {
        JOptionPane.showMessageDialog(null, "Update functionality for EMP ID: " + empId + " not implemented yet!");
        // Add your update form logic here
    }
}

