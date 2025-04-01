//package university.management.system;
//
//import net.proteanit.sql.DbUtils;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class StudentDetails extends JFrame implements ActionListener {
//
//    Choice choice;
//
//    JTable table;
//    StudentDetails()
//    {
//        getContentPane().setBackground(new Color(210,252,218));
//
//        JLabel heading = new JLabel("Search By Roll Number");
//        heading.setBounds(20,20,150,20);
//        add(heading);
//
//
//        choice = new Choice();
//        choice.setBounds(180,20,150,20);
//        add(choice);
//
//        try {
//            Conn c = new Conn();
//            ResultSet resultSet = c.statement.executeQuery("select * from student");
//            while(resultSet.next())
//            {
//                choice.add(resultSet.getString("roll_no"));
//
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        table = new JTable();
//        try
//        {
//            Conn c = new Conn();
//            ResultSet resultSet = c.statement.executeQuery("select * from student");
//            System.out.println("details have been loaded in resulset");
//            table.setModel(DbUtils.resultSetToTableModel(resultSet));
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        JScrollPane js = new JScrollPane(table);
//        js.setBounds(0,100,900,900);
//        add(js);
//
//
//        setLayout(null);
//        setSize(900,100);
//        setLocation(300,100);
//        setVisible(true);
//
//
//
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//
//
//    public static void main(String[] args) {
//        new StudentDetails();
//
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

public class StudentDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton searchButton, printButton, addButton, updateButton, cancelButton;

    StudentDetails() {
        // Set background
        getContentPane().setBackground(new Color(210, 252, 218));

        // Heading
        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20, 20, 200, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        add(heading);

        // Choice (Dropdown)
        choice = new Choice();
        choice.setBounds(220, 25, 150, 25);
        choice.setBackground(Color.WHITE);
        add(choice);

        // Populate Choice with roll numbers
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                choice.add(resultSet.getString("roll_no"));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading roll numbers: " + e.getMessage());
        }

        // Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(380, 25, 100, 30);
        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(this);
        add(searchButton);

        // Print Button
        printButton = new JButton("Print");
        printButton.setBounds(20, 70, 100, 30);
        printButton.setBackground(new Color(50, 205, 50)); // Green
        printButton.setForeground(Color.WHITE);
        printButton.addActionListener(this);
        add(printButton);

        // Add Button
        addButton = new JButton("Add");
        addButton.setBounds(140, 70, 100, 30);
        addButton.setBackground(new Color(255, 215, 0)); // Yellow
        addButton.setForeground(Color.BLACK);
        addButton.addActionListener(this);
        add(addButton);

        // Update Button
        updateButton = new JButton("Update");
        updateButton.setBounds(260, 70, 100, 30);
        updateButton.setBackground(new Color(70, 130, 180)); // Blue
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);
        add(updateButton);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(380, 70, 100, 30);
        cancelButton.setBackground(new Color(220, 20, 60)); // Red
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        // Table
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage());
        }

        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 120, 880, 560); // Moved down to make space for buttons
        add(js);


        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String selectedRoll = choice.getSelectedItem();
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM student WHERE roll_no = '" + selectedRoll + "'";
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
                resultSet.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error searching student: " + ex.getMessage());
            }
        }
        else if (e.getSource() == printButton) {
            try {
                table.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, "Error printing: " + ex.getMessage());
            }
        } else if (e.getSource() == addButton) {
            new AddStudent();

        } else if (e.getSource() == updateButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String rollNo = (String) table.getValueAt(selectedRow, 2); // Assuming roll_no is 3rd column
                new UpdateStudent(rollNo);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a student to update!");
            }
        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}

// Placeholder for UpdateStudent class
class UpdateStudent extends JFrame {
    UpdateStudent(String rollNo) {
        JOptionPane.showMessageDialog(null, "Update functionality for Roll No: " + rollNo + " not implemented yet!");
        // Add your update form logic here
    }
}