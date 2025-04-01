//package university.management.system;
//
//import com.toedter.calendar.JDateChooser;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class AddFaculty extends JFrame {
//
//    JTextField textname;
//    JDateChooser cdob;
//
//    AddFaculty()
//    {
//
//        getContentPane().setBackground(new Color(166,164,252));
//
//
//
//
//        JLabel heading = new JLabel("New Teacher Details");
//        heading.setBounds(310,30,500,50);
//        heading.setFont(new Font("serif",Font.BOLD,30));
//        add(heading);
//
//        JLabel name = new JLabel("Name");
//        name.setBounds(50,150,100,30);
//        name.setFont(new Font("serif",Font.BOLD,20));
//        add(name);
//
//        textname = new JTextField();
//        textname.setBounds(200,150,200,30);
//        add(textname);
//
//        JLabel dob = new JLabel("Date of Birth");
//        dob.setBounds(200,200,100,30);
//        dob.setFont(new Font("serif",Font.BOLD,20));
//        add(dob);
//
//        cdob = new JDateChooser();
//        cdob.setBounds(600,200,150,30);
//        add(cdob);
//
//
//
//
//
//        setSize(900,700);
//        setLocation(350,50);
//        setLayout(null);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new AddFaculty();
//    }
//}






//package university.management.system;
//
//import com.toedter.calendar.JDateChooser;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Random;
//import javax.swing.filechooser.FileNameExtensionFilter;
//
//public class AddFaculty extends JFrame {
//
//    JTextField textName, textFatherName, textEmpId, textAddress, textPhone, textEmail, textQualifications,textaadhar;
//    JDateChooser cdob;
//    JButton uploadButton;
//
//    AddFaculty() {
//        // Set gradient background
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
//        JLabel heading = new JLabel("New Teacher Details");
//        heading.setBounds(310, 30, 500, 50);
//        heading.setFont(new Font("Serif", Font.BOLD, 30));
//        heading.setForeground(new Color(25, 25, 112)); // Midnight Blue
//        add(heading);
//
//        // Left Column
//        // Name
//        JLabel name = new JLabel("Name");
//        name.setBounds(40, 100, 100, 30);
//        name.setFont(new Font("Serif", Font.BOLD, 20));
//        name.setForeground(Color.WHITE);
//        add(name);
//
//        textName = new JTextField();
//        textName.setBounds(180, 100, 200, 30); // Adjusted x from 150 to 160
//        textName.setBackground(new Color(245, 245, 220));
//        add(textName);
//
//        // Father's Name
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
//        // Employee ID
//        JLabel empId = new JLabel("Employee ID");
//        empId.setBounds(40, 200, 150, 30);
//        empId.setFont(new Font("Serif", Font.BOLD, 20));
//        empId.setForeground(Color.WHITE);
//        add(empId);
//
//        Random rand = new Random();
//        int randomId = 10000 + rand.nextInt(90000);
//        textEmpId = new JTextField("EMP" + randomId);
//        textEmpId.setBounds(180, 200, 200, 30);
//        textEmpId.setEditable(false);
//        textEmpId.setBackground(new Color(245, 245, 220));
//        add(textEmpId);
//
//        // Date of Birth
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
//
//        // Address
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
//        // Phone Number
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
//        // Email
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
//        // Qualifications
//        JLabel qualifications = new JLabel("Qualifications");
//        qualifications.setBounds(400, 250, 150, 30);
//        qualifications.setFont(new Font("Serif", Font.BOLD, 20));
//        qualifications.setForeground(Color.WHITE);
//        add(qualifications);
//
//        textQualifications = new JTextField();
//        textQualifications.setBounds(550, 250, 200, 30);
//        textQualifications.setBackground(new Color(245, 245, 220));
//        add(textQualifications);
//
//        JLabel aadhar = new JLabel("Aadhar Number");
//        aadhar.setBounds(40, 300, 150, 30);
//        aadhar.setFont(new Font("Serif", Font.BOLD, 20));
//        aadhar.setForeground(Color.WHITE);
//        add(aadhar);
//
//        textaadhar = new JTextField();
//        textaadhar.setBounds(180, 300, 200, 30);
//        textaadhar.setBackground(new Color(245, 245, 220));
//        add(textaadhar);
//
//
//
//
//
//
//        // Upload Documents
//        JLabel uploadLabel = new JLabel("Upload Documents");
//        uploadLabel.setBounds(320, 350, 200, 30);
//        uploadLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        uploadLabel.setForeground(Color.WHITE);
//        add(uploadLabel);
//
//        uploadButton = new JButton("Upload");
//        uploadButton.setBounds(500, 350, 100, 30);
//        uploadButton.setBackground(new Color(255, 215, 0));
//        uploadButton.setForeground(Color.BLACK);
//        uploadButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser fileChooser = new JFileChooser();
//                FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                        "PDF, DOC & Images", "pdf", "doc", "docx", "jpg", "png");
//                fileChooser.setFileFilter(filter);
//                int returnVal = fileChooser.showOpenDialog(null);
//                if (returnVal == JFileChooser.APPROVE_OPTION) {
//                    String fileName = fileChooser.getSelectedFile().getName();
//                    JOptionPane.showMessageDialog(null, "Selected file: " + fileName);
//                }
//            }
//        });
//        add(uploadButton);
//
//        setSize(900, 500);
//        setLocation(350, 50);
//        setLayout(null);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new AddFaculty();
//    }
//}



package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName, textFatherName, textEmpId, textAddress, textPhone, textEmail, textAadhar, textPercentage;
    JComboBox<String> comboQualifications, comboDepartments;
    JDateChooser cdob;


    JButton uploadButton, submitButton, cancelButton;

    AddFaculty() {
        // Set gradient background
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
        JLabel heading = new JLabel("New Faculty Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(new Color(25, 25, 112)); // Midnight Blue
        add(heading);


        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 100, 30);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        add(name);

        textName = new JTextField();
        textName.setBounds(180, 100, 200, 30);
        textName.setBackground(new Color(245, 245, 220));
        add(textName);

        // Father's Name
        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(40, 150, 150, 30);
        fatherName.setFont(new Font("Serif", Font.BOLD, 20));
        fatherName.setForeground(Color.WHITE);
        add(fatherName);

        textFatherName = new JTextField();
        textFatherName.setBounds(180, 150, 200, 30);
        textFatherName.setBackground(new Color(245, 245, 220));
        add(textFatherName);

        // Employee ID
        JLabel empId = new JLabel("Employee ID");
        empId.setBounds(40, 200, 150, 30);
        empId.setFont(new Font("Serif", Font.BOLD, 20));
        empId.setForeground(Color.WHITE);
        add(empId);

        Random rand = new Random();
        int randomId = 10000 + rand.nextInt(90000);
        textEmpId = new JTextField("EMP" + randomId);
        textEmpId.setBounds(180, 200, 200, 30);
        textEmpId.setEditable(false);
        textEmpId.setBackground(new Color(245, 245, 220));
        add(textEmpId);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(40, 250, 150, 30);
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(180, 250, 200, 30);
        cdob.setBackground(new Color(245, 245, 220));
        add(cdob);

        // Right Column
        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(400, 100, 100, 30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(550, 100, 200, 30);
        textAddress.setBackground(new Color(245, 245, 220));
        add(textAddress);

        // Phone Number
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 150, 150, 30);
        phone.setFont(new Font("Serif", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(550, 150, 200, 30);
        textPhone.setBackground(new Color(245, 245, 220));
        add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(400, 200, 100, 30);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(550, 200, 200, 30);
        textEmail.setBackground(new Color(245, 245, 220));
        add(textEmail);

        // Qualifications
        JLabel qualifications = new JLabel("Qualifications");
        qualifications.setBounds(400, 250, 150, 30);
        qualifications.setFont(new Font("Serif", Font.BOLD, 20));
        qualifications.setForeground(Color.WHITE);
        add(qualifications);

        String[] qualificationOptions = {"B.TECH", "BBA", "BCA", "MCA", "B.COM", "M.COM", "MBA", "MA", "BA"};
        comboQualifications = new JComboBox<>(qualificationOptions);
        comboQualifications.setBounds(550, 250, 200, 30);
        comboQualifications.setBackground(new Color(245, 245, 220));
        add(comboQualifications);

        // Aadhar Number
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(40, 300, 150, 30);
        aadhar.setFont(new Font("Serif", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(180, 300, 200, 30);
        textAadhar.setBackground(new Color(245, 245, 220));
        add(textAadhar);

        // 12th Percentage
        JLabel percentage = new JLabel("12th %");
        percentage.setBounds(400, 300, 100, 30);
        percentage.setFont(new Font("Serif", Font.BOLD, 20));
        percentage.setForeground(Color.WHITE);
        add(percentage);

        textPercentage = new JTextField();
        textPercentage.setBounds(550, 300, 200, 30);
        textPercentage.setBackground(new Color(245, 245, 220));
        add(textPercentage);

        // Departments
        JLabel departments = new JLabel("Department");
        departments.setBounds(40, 350, 150, 30);
        departments.setFont(new Font("Serif", Font.BOLD, 20));
        departments.setForeground(Color.WHITE);
        add(departments);

        String[] departmentOptions = {"CSE", "ECE", "CIVIL", "EEE", "MECH", "IT", "CSM", "CSC"};
        comboDepartments = new JComboBox<>(departmentOptions);
        comboDepartments.setBounds(180, 350, 200, 30);
        comboDepartments.setBackground(new Color(245, 245, 220));
        add(comboDepartments);

        // Upload Documents
        JLabel uploadLabel = new JLabel("Upload Documents");
        uploadLabel.setBounds(400, 350, 200, 30);
        uploadLabel.setFont(new Font("Serif", Font.BOLD, 20));
        uploadLabel.setForeground(Color.WHITE);
        add(uploadLabel);

        uploadButton = new JButton("Upload");
        uploadButton.setBounds(580, 350, 100, 30);
        uploadButton.setBackground(new Color(255, 215, 0));
        uploadButton.setForeground(Color.BLACK);
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "PDF, DOC & Images", "pdf", "doc", "docx", "jpg", "png");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String fileName = fileChooser.getSelectedFile().getName();
                    JOptionPane.showMessageDialog(null, "Selected file: " + fileName);
                }
            }
        });
        add(uploadButton);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(350, 400, 100, 30);
        submitButton.setBackground(new Color(50, 205, 50)); // Lime Green
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);

        add(submitButton);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460, 400, 100, 30);
        cancelButton.setBackground(new Color(220, 20, 60)); // Crimson
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Closes the window
            }
        });
        add(cancelButton);

        setSize(900, 500);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()== submitButton )
            {
                String name = textName.getText();
                String fname = textFatherName.getText();
                String empid = textEmpId.getText();
                String dob = ((JTextField)cdob.getDateEditor().getUiComponent()).getText();
                String address = textAddress.getText();
                String phonenumber = textPhone.getText();
                String email = textEmail.getText();
                String aadharnumber = textAadhar.getText();
                String xii = textPercentage.getText();
                String course = (String)  comboQualifications.getSelectedItem();
                String department = (String) comboDepartments.getSelectedItem();

                try
                {
                    String q = "insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phonenumber+"','"+email+"','"+aadharnumber+"','"+xii+"','"+course+"','"+department+"')";
                    Conn c = new Conn();
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details are Updated Successfully");
                    System.out.println("Details Have been Updated into the Database");
                    setVisible(false);


                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
            else {
                setVisible(false);
            }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }


}

