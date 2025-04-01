//package university.management.system;
//
//import com.toedter.calendar.JDateChooser;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//
//public class UpdateFaculty extends JFrame implements ActionListener {
//
//    JTextField textName, textFatherName, textEmpId, textAddress, textPhone, textEmail, textAadhar, textPercentage;
//    JComboBox<String> comboQualifications, comboDepartments;
//    JDateChooser cdob;
//    JButton submitButton, cancelButton;
//    String empId;
//
//    Choice cEmpId;
//
//    UpdateFaculty(String empId) {
//        this.empId = empId; // Store the EMP ID
//
//        setContentPane(new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Graphics2D g2d = (Graphics2D) g;
//                GradientPaint gp = new GradientPaint(0, 0, new Color(135, 206, 235), 0, getHeight(), new Color(72, 209, 204));
//                g2d.setPaint(gp);
//                g2d.fillRect(0, 0, getWidth(), getHeight());
//            }
//        });
//
//        // Heading
//        JLabel heading = new JLabel("Update Teacher Details");
//        heading.setBounds(310, 30, 500, 50);
//        heading.setFont(new Font("Serif", Font.BOLD, 30));
//        heading.setForeground(new Color(25, 25, 112));
//        add(heading);
//
//        // Left Column
//        JLabel name = new JLabel("Name");
//        name.setBounds(40, 100, 100, 30);
//        name.setFont(new Font("Serif", Font.BOLD, 20));
//        name.setForeground(Color.WHITE);
//        add(name);
//
//        textName = new JTextField();
//        textName.setBounds(180, 100, 200, 30);
//        textName.setBackground(new Color(245, 245, 220));
//        add(textName);
//
//        JLabel fatherName = new JLabel("Father's Name");
//        fatherName.setBounds(40, 150, 150, 30);
//        fatherName.setFont(new Font("Serif", Font.BOLD, 20));
//        fatherName.setForeground(Color.WHITE);
//        add(fatherName);
//
//        textFatherName = new JTextField();
//        textFatherName.setBounds(180, 150, 200, 30);
//        textFatherName.setBackground(new Color(245, 245, 220));
//        add(textFatherName);
//
//        JLabel empIdLabel = new JLabel("Employee ID");
//        empIdLabel.setBounds(40, 200, 150, 30);
//        empIdLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        empIdLabel.setForeground(Color.WHITE);
//        add(empIdLabel);
//
//        textEmpId = new JTextField(empId);
//        textEmpId.setBounds(180, 200, 200, 30);
//        textEmpId.setEditable(false); // EMP ID is not editable
//        textEmpId.setBackground(new Color(245, 245, 220));
//        add(textEmpId);
//
//        JLabel dob = new JLabel("Date of Birth");
//        dob.setBounds(40, 250, 150, 30);
//        dob.setFont(new Font("Serif", Font.BOLD, 20));
//        dob.setForeground(Color.WHITE);
//        add(dob);
//
//        cdob = new JDateChooser();
//        cdob.setBounds(180, 250, 200, 30);
//        cdob.setBackground(new Color(245, 245, 220));
//        add(cdob);
//
//        // Right Column
//        JLabel address = new JLabel("Address");
//        address.setBounds(400, 100, 100, 30);
//        address.setFont(new Font("Serif", Font.BOLD, 20));
//        address.setForeground(Color.WHITE);
//        add(address);
//
//        textAddress = new JTextField();
//        textAddress.setBounds(550, 100, 200, 30);
//        textAddress.setBackground(new Color(245, 245, 220));
//        add(textAddress);
//
//        JLabel phone = new JLabel("Phone Number");
//        phone.setBounds(400, 150, 150, 30);
//        phone.setFont(new Font("Serif", Font.BOLD, 20));
//        phone.setForeground(Color.WHITE);
//        add(phone);
//
//        textPhone = new JTextField();
//        textPhone.setBounds(550, 150, 200, 30);
//        textPhone.setBackground(new Color(245, 245, 220));
//        add(textPhone);
//
//        JLabel email = new JLabel("Email");
//        email.setBounds(400, 200, 100, 30);
//        email.setFont(new Font("Serif", Font.BOLD, 20));
//        email.setForeground(Color.WHITE);
//        add(email);
//
//        textEmail = new JTextField();
//        textEmail.setBounds(550, 200, 200, 30);
//        textEmail.setBackground(new Color(245, 245, 220));
//        add(textEmail);
//
//        JLabel qualifications = new JLabel("Qualifications");
//        qualifications.setBounds(400, 250, 150, 30);
//        qualifications.setFont(new Font("Serif", Font.BOLD, 20));
//        qualifications.setForeground(Color.WHITE);
//        add(qualifications);
//
//        String[] qualificationOptions = {"B.TECH", "BBA", "BCA", "MCA", "B.COM", "M.COM", "MBA", "MA", "BA"};
//        comboQualifications = new JComboBox<>(qualificationOptions);
//        comboQualifications.setBounds(550, 250, 200, 30);
//        comboQualifications.setBackground(new Color(245, 245, 220));
//        add(comboQualifications);
//
//        JLabel aadhar = new JLabel("Aadhar Number");
//        aadhar.setBounds(40, 300, 150, 30);
//        aadhar.setFont(new Font("Serif", Font.BOLD, 20));
//        aadhar.setForeground(Color.WHITE);
//        add(aadhar);
//
//        textAadhar = new JTextField();
//        textAadhar.setBounds(180, 300, 200, 30);
//        textAadhar.setBackground(new Color(245, 245, 220));
//        add(textAadhar);
//
//        JLabel percentage = new JLabel("12th %");
//        percentage.setBounds(400, 300, 100, 30);
//        percentage.setFont(new Font("Serif", Font.BOLD, 20));
//        percentage.setForeground(Color.WHITE);
//        add(percentage);
//
//        textPercentage = new JTextField();
//        textPercentage.setBounds(550, 300, 200, 30);
//        textPercentage.setBackground(new Color(245, 245, 220));
//        add(textPercentage);
//
//        JLabel departments = new JLabel("Department");
//        departments.setBounds(40, 350, 150, 30);
//        departments.setFont(new Font("Serif", Font.BOLD, 20));
//        departments.setForeground(Color.WHITE);
//        add(departments);
//
//        String[] departmentOptions = {"CSE", "ECE", "CIVIL", "EEE", "MECH", "IT", "CSM", "CSC"};
//        comboDepartments = new JComboBox<>(departmentOptions);
//        comboDepartments.setBounds(180, 350, 200, 30);
//        comboDepartments.setBackground(new Color(245, 245, 220));
//        add(comboDepartments);
//
//        // Submit Button
//        submitButton = new JButton("Update");
//        submitButton.setBounds(350, 400, 100, 30);
//        submitButton.setBackground(new Color(50, 205, 50));
//        submitButton.setForeground(Color.WHITE);
//        submitButton.addActionListener(this);
//        add(submitButton);
//
//        // Cancel Button
//        cancelButton = new JButton("Cancel");
//        cancelButton.setBounds(460, 400, 100, 30);
//        cancelButton.setBackground(new Color(220, 20, 60));
//        cancelButton.setForeground(Color.WHITE);
//        cancelButton.addActionListener(this);
//        add(cancelButton);
//
//        // Pre-populate fields with existing data
//        loadFacultyDetails();
//
//        setSize(900, 500);
//        setLocation(350, 50);
//        setLayout(null);
//        setVisible(true);
//    }
//
//    // Load existing faculty details from the database
//    private void loadFacultyDetails() {
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.statement.executeQuery("SELECT * FROM teacher WHERE empid = '" + empId + "'");
//            if (rs.next()) {
//                textName.setText(rs.getString("name"));
//                textFatherName.setText(rs.getString("fname"));
//                textAddress.setText(rs.getString("address"));
//                textPhone.setText(rs.getString("phonenumber"));
//                textEmail.setText(rs.getString("email"));
//                textAadhar.setText(rs.getString("aadharnumber"));
//                textPercentage.setText(rs.getString("xii"));
//                comboQualifications.setSelectedItem(rs.getString("course"));
//                comboDepartments.setSelectedItem(rs.getString("department"));
//
//                // Set DOB
//                String dobStr = rs.getString("dob");
//                if (dobStr != null && !dobStr.isEmpty()) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Adjust format as per your DB
//                    cdob.setDate(sdf.parse(dobStr));
//                }
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error loading faculty details: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == submitButton) {
//            String name = textName.getText();
//            String fname = textFatherName.getText();
//            String empid = textEmpId.getText();
//            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
//            String address = textAddress.getText();
//            String phonenumber = textPhone.getText();
//            String email = textEmail.getText();
//            String aadharnumber = textAadhar.getText();
//            String xii = textPercentage.getText();
//            String course = (String) comboQualifications.getSelectedItem();
//            String department = (String) comboDepartments.getSelectedItem();
//
//            try {
//                String query = "UPDATE teacher SET name = '" + name + "', fname = '" + fname + "', dob = '" + dob + "', " +
//                        "address = '" + address + "', phonenumber = '" + phonenumber + "', email = '" + email + "', " +
//                        "aadharnumber = '" + aadharnumber + "', xii = '" + xii + "', course = '" + course + "', " +
//                        "department = '" + department + "' WHERE empid = '" + empid + "'";
//                Conn c = new Conn();
//                c.statement.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
//                System.out.println("Teacher details updated in the database for EMP ID: " + empid);
//                setVisible(false);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error updating details: " + ex.getMessage());
//            }
//        } else if (e.getSource() == cancelButton) {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new UpdateFaculty("EMP12345"); // Example EMP ID for testing
//    }
//}




package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class UpdateFaculty extends JFrame implements ActionListener {

    JTextField textName, textFatherName, textEmpId, textAddress, textPhone, textEmail, textAadhar, textPercentage;
    JComboBox<String> comboQualifications, comboDepartments;
    JDateChooser cdob;
    JButton loadButton, submitButton, cancelButton;
    Choice cEmpId;

    UpdateFaculty() {
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(135, 206, 235), 0, getHeight(), new Color(72, 209, 204));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        // Heading
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(new Color(25, 25, 112));
        add(heading);

        // Employee ID Selection
        JLabel empIdLabel = new JLabel("Select Employee ID");
        empIdLabel.setBounds(40, 100, 200, 30);
        empIdLabel.setFont(new Font("Serif", Font.BOLD, 20));
        empIdLabel.setForeground(Color.WHITE);
        add(empIdLabel);

        cEmpId = new Choice();
        cEmpId.setBounds(250, 105, 200, 30);
        cEmpId.setFont(new Font("SansSerif", Font.PLAIN, 16));
        cEmpId.setBackground(new Color(245, 245, 220));
        add(cEmpId);


        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT empid FROM teacher");
            while (rs.next()) {
                cEmpId.add(rs.getString("empid"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        loadButton = new JButton("Load Details");
        loadButton.setBounds(460, 100, 150, 30);
        loadButton.setBackground(new Color(70, 130, 180));
        loadButton.setForeground(Color.WHITE);
        loadButton.addActionListener(this);
        add(loadButton);


        JLabel name = new JLabel("Name");
        name.setBounds(40, 150, 100, 30);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        add(name);

        textName = new JTextField();
        textName.setBounds(180, 150, 200, 30);
        textName.setBackground(new Color(245, 245, 220));
        add(textName);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(40, 200, 150, 30);
        fatherName.setFont(new Font("Serif", Font.BOLD, 20));
        fatherName.setForeground(Color.WHITE);
        add(fatherName);

        textFatherName = new JTextField();
        textFatherName.setBounds(180, 200, 200, 30);
        textFatherName.setBackground(new Color(245, 245, 220));
        add(textFatherName);

        JLabel empIdFieldLabel = new JLabel("Employee ID");
        empIdFieldLabel.setBounds(40, 250, 150, 30);
        empIdFieldLabel.setFont(new Font("Serif", Font.BOLD, 20));
        empIdFieldLabel.setForeground(Color.WHITE);
        add(empIdFieldLabel);

        textEmpId = new JTextField();
        textEmpId.setBounds(180, 250, 200, 30);
        textEmpId.setEditable(false); // EMP ID is not editable
        textEmpId.setBackground(new Color(245, 245, 220));
        add(textEmpId);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(40, 300, 150, 30);
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(180, 300, 200, 30);
        cdob.setBackground(new Color(245, 245, 220));
        add(cdob);


        JLabel address = new JLabel("Address");
        address.setBounds(400, 150, 100, 30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(550, 150, 200, 30);
        textAddress.setBackground(new Color(245, 245, 220));
        add(textAddress);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 200, 150, 30);
        phone.setFont(new Font("Serif", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(550, 200, 200, 30);
        textPhone.setBackground(new Color(245, 245, 220));
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(400, 250, 100, 30);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(550, 250, 200, 30);
        textEmail.setBackground(new Color(245, 245, 220));
        add(textEmail);

        JLabel qualifications = new JLabel("Qualifications");
        qualifications.setBounds(400, 300, 150, 30);
        qualifications.setFont(new Font("Serif", Font.BOLD, 20));
        qualifications.setForeground(Color.WHITE);
        add(qualifications);

        String[] qualificationOptions = {"B.TECH", "BBA", "BCA", "MCA", "B.COM", "M.COM", "MBA", "MA", "BA"};
        comboQualifications = new JComboBox<>(qualificationOptions);
        comboQualifications.setBounds(550, 300, 200, 30);
        comboQualifications.setBackground(new Color(245, 245, 220));
        add(comboQualifications);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(40, 350, 150, 30);
        aadhar.setFont(new Font("Serif", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(180, 350, 200, 30);
        textAadhar.setBackground(new Color(245, 245, 220));
        add(textAadhar);

        JLabel percentage = new JLabel("12th %");
        percentage.setBounds(400, 350, 100, 30);
        percentage.setFont(new Font("Serif", Font.BOLD, 20));
        percentage.setForeground(Color.WHITE);
        add(percentage);

        textPercentage = new JTextField();
        textPercentage.setBounds(550, 350, 200, 30);
        textPercentage.setBackground(new Color(245, 245, 220));
        add(textPercentage);

        JLabel departments = new JLabel("Department");
        departments.setBounds(40, 400, 150, 30);
        departments.setFont(new Font("Serif", Font.BOLD, 20));
        departments.setForeground(Color.WHITE);
        add(departments);

        String[] departmentOptions = {"CSE", "ECE", "CIVIL", "EEE", "MECH", "IT", "CSM", "CSC"};
        comboDepartments = new JComboBox<>(departmentOptions);
        comboDepartments.setBounds(180, 400, 200, 30);
        comboDepartments.setBackground(new Color(245, 245, 220));
        add(comboDepartments);

        // Submit Button
        submitButton = new JButton("Update");
        submitButton.setBounds(350, 450, 100, 30);
        submitButton.setBackground(new Color(50, 205, 50));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        add(submitButton);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460, 450, 100, 30);
        cancelButton.setBackground(new Color(220, 20, 60));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(900, 550); // Increased height to accommodate new layout
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    private void loadFacultyDetails(String empId) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM teacher WHERE empid = '" + empId + "'");
            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textFatherName.setText(rs.getString("fname"));
                textEmpId.setText(rs.getString("empid"));
                textAddress.setText(rs.getString("address"));
                textPhone.setText(rs.getString("phonenumber"));
                textEmail.setText(rs.getString("email"));
                textAadhar.setText(rs.getString("aadharnumber"));
                textPercentage.setText(rs.getString("xii"));
                comboQualifications.setSelectedItem(rs.getString("course"));
                comboDepartments.setSelectedItem(rs.getString("department"));


                String dobStr = rs.getString("dob");
                if (dobStr != null && !dobStr.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Adjust format as per your DB
                    cdob.setDate(sdf.parse(dobStr));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No record found for EMP ID: " + empId);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading faculty details: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {
            String selectedEmpId = cEmpId.getSelectedItem();
            if (selectedEmpId != null) {
                loadFacultyDetails(selectedEmpId);
            } else {
                JOptionPane.showMessageDialog(null, "Please select an Employee ID");
            }
        } else if (e.getSource() == submitButton) {
            String name = textName.getText();
            String fname = textFatherName.getText();
            String empid = textEmpId.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phonenumber = textPhone.getText();
            String email = textEmail.getText();
            String aadharnumber = textAadhar.getText();
            String xii = textPercentage.getText();
            String course = (String) comboQualifications.getSelectedItem();
            String department = (String) comboDepartments.getSelectedItem();

            try {
                String query = "UPDATE teacher SET name = '" + name + "', fname = '" + fname + "', dob = '" + dob + "', " +
                        "address = '" + address + "', phonenumber = '" + phonenumber + "', email = '" + email + "', " +
                        "aadharnumber = '" + aadharnumber + "', xii = '" + xii + "', course = '" + course + "', " +
                        "department = '" + department + "' WHERE empid = '" + empid + "'";
                Conn c = new Conn();
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                System.out.println("Teacher details updated in the database for EMP ID: " + empid);
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating details: " + ex.getMessage());
            }
        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateFaculty();
    }
}