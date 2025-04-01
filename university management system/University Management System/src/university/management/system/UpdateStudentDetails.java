package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class UpdateStudentDetails extends JFrame implements ActionListener {

    JTextField textName, textFatherName, textRollNo, textAddress, textPhone, textEmail, textAadhar, textPercentage;
    JComboBox<String> comboQualifications, comboDepartments;
    JDateChooser cdob;
    JButton loadButton, uploadButton, submitButton, cancelButton;
    Choice cRollNo;

    UpdateStudentDetails() {
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

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(new Color(51, 51, 51));
        add(heading);

        JLabel rollNoLabel = new JLabel("Select Roll No");
        rollNoLabel.setBounds(40, 100, 150, 30);
        rollNoLabel.setFont(new Font("Serif", Font.BOLD, 20));
        rollNoLabel.setForeground(new Color(51, 51, 51));
        add(rollNoLabel);

        cRollNo = new Choice();
        cRollNo.setBounds(180, 105, 200, 30);
        cRollNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        cRollNo.setBackground(new Color(255, 250, 205));
        add(cRollNo);

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

        loadButton = new JButton("Load Details");
        loadButton.setBounds(400, 100, 150, 30);
        loadButton.setBackground(new Color(70, 130, 180));
        loadButton.setForeground(Color.WHITE);
        loadButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loadButton.setBackground(new Color(100, 149, 237));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loadButton.setBackground(new Color(70, 130, 180));
            }
        });
        loadButton.addActionListener(this);
        add(loadButton);

        JLabel name = new JLabel("Name");
        name.setBounds(40, 150, 100, 30);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setForeground(new Color(51, 51, 51));
        add(name);

        textName = new JTextField();
        textName.setBounds(180, 150, 200, 30);
        textName.setBackground(new Color(255, 250, 205));
        textName.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textName);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(40, 200, 150, 30);
        fatherName.setFont(new Font("Serif", Font.BOLD, 20));
        fatherName.setForeground(new Color(51, 51, 51));
        add(fatherName);

        textFatherName = new JTextField();
        textFatherName.setBounds(180, 200, 200, 30);
        textFatherName.setBackground(new Color(255, 250, 205));
        textFatherName.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textFatherName);

        JLabel rollNo = new JLabel("Roll_No");
        rollNo.setBounds(40, 250, 150, 30);
        rollNo.setFont(new Font("Serif", Font.BOLD, 20));
        rollNo.setForeground(new Color(51, 51, 51));
        add(rollNo);

        textRollNo = new JTextField();
        textRollNo.setBounds(180, 250, 200, 30);
        textRollNo.setEditable(false);
        textRollNo.setBackground(new Color(255, 250, 205));
        textRollNo.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textRollNo);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(40, 300, 150, 30);
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        dob.setForeground(new Color(51, 51, 51));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(180, 300, 200, 30);
        cdob.setBackground(new Color(255, 250, 205));
        cdob.setEnabled(false);
        add(cdob);

        JLabel address = new JLabel("Address");
        address.setBounds(400, 150, 100, 30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        address.setForeground(new Color(51, 51, 51));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(550, 150, 200, 30);
        textAddress.setBackground(new Color(255, 250, 205));
        textAddress.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textAddress);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 200, 150, 30);
        phone.setFont(new Font("Serif", Font.BOLD, 20));
        phone.setForeground(new Color(51, 51, 51));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(550, 200, 200, 30);
        textPhone.setBackground(new Color(255, 250, 205));
        textPhone.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(400, 250, 100, 30);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        email.setForeground(new Color(51, 51, 51));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(550, 250, 200, 30);
        textEmail.setBackground(new Color(255, 250, 205));
        textEmail.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textEmail);

        JLabel qualifications = new JLabel("Course");
        qualifications.setBounds(400, 300, 150, 30);
        qualifications.setFont(new Font("Serif", Font.BOLD, 20));
        qualifications.setForeground(new Color(51, 51, 51));
        add(qualifications);

        String[] qualificationOptions = {"B.TECH", "BBA", "BCA", "MCA", "B.COM", "M.COM", "MBA", "MA", "BA"};
        comboQualifications = new JComboBox<>(qualificationOptions);
        comboQualifications.setBounds(550, 300, 200, 30);
        comboQualifications.setBackground(new Color(255, 250, 205));
        add(comboQualifications);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(40, 350, 150, 30);
        aadhar.setFont(new Font("Serif", Font.BOLD, 20));
        aadhar.setForeground(new Color(51, 51, 51));
        add(aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(180, 350, 200, 30);
        textAadhar.setBackground(new Color(255, 250, 205));
        textAadhar.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textAadhar);

        JLabel percentage = new JLabel("12th %");
        percentage.setBounds(400, 350, 100, 30);
        percentage.setFont(new Font("Serif", Font.BOLD, 20));
        percentage.setForeground(new Color(51, 51, 51));
        add(percentage);

        textPercentage = new JTextField();
        textPercentage.setBounds(550, 350, 200, 30);
        textPercentage.setBackground(new Color(255, 250, 205));
        textPercentage.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169), 1));
        add(textPercentage);

        JLabel departments = new JLabel("Branch");
        departments.setBounds(40, 400, 150, 30);
        departments.setFont(new Font("Serif", Font.BOLD, 20));
        departments.setForeground(new Color(51, 51, 51));
        add(departments);

        String[] departmentOptions = {"CSE", "ECE", "CIVIL", "EEE", "MECH", "IT", "CSM", "CSC"};
        comboDepartments = new JComboBox<>(departmentOptions);
        comboDepartments.setBounds(180, 400, 200, 30);
        comboDepartments.setBackground(new Color(255, 250, 205));
        add(comboDepartments);

        JLabel uploadLabel = new JLabel("Upload Documents");
        uploadLabel.setBounds(400, 400, 200, 30);
        uploadLabel.setFont(new Font("Serif", Font.BOLD, 20));
        uploadLabel.setForeground(new Color(51, 51, 51));
        add(uploadLabel);

        uploadButton = new JButton("Upload");
        uploadButton.setBounds(580, 400, 100, 30);
        uploadButton.setBackground(new Color(70, 130, 180));
        uploadButton.setForeground(Color.WHITE);
        uploadButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                uploadButton.setBackground(new Color(100, 149, 237));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                uploadButton.setBackground(new Color(70, 130, 180));
            }
        });
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "PDF, DOC & Images", "pdf", "doc", "docx", "jpg", "png");
            fileChooser.setFileFilter(filter);
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getName();
                JOptionPane.showMessageDialog(null, "Selected file: " + fileName);
            }
        });
        add(uploadButton);

        submitButton = new JButton("Update");
        submitButton.setBounds(350, 460, 100, 35);
        submitButton.setBackground(new Color(50, 205, 50));
        submitButton.setForeground(Color.WHITE);
        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submitButton.setBackground(new Color(60, 179, 113));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitButton.setBackground(new Color(50, 205, 50));
            }
        });
        submitButton.addActionListener(this);
        add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460, 460, 100, 35);
        cancelButton.setBackground(new Color(255, 69, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancelButton.setBackground(new Color(220, 20, 60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelButton.setBackground(new Color(255, 69, 0));
            }
        });
        cancelButton.addActionListener(e -> setVisible(false));
        add(cancelButton);

        setSize(900, 550);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    private void loadStudentDetails(String rollNo) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM student WHERE roll_no = '" + rollNo + "'");
            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textFatherName.setText(rs.getString("fname"));
                textRollNo.setText(rs.getString("roll_no"));
                textAddress.setText(rs.getString("address"));
                textPhone.setText(rs.getString("phonenumber"));
                textEmail.setText(rs.getString("email"));
                textAadhar.setText(rs.getString("aadharnumber"));
                textPercentage.setText(rs.getString("xii"));
                comboQualifications.setSelectedItem(rs.getString("course"));
                comboDepartments.setSelectedItem(rs.getString("branch"));

                String dobStr = rs.getString("dob");
                if (dobStr != null && !dobStr.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cdob.setDate(sdf.parse(dobStr));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No record found for Roll No: " + rollNo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading student details: " + e.getMessage());
        }
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
        } else if (e.getSource() == submitButton) {
            String name = textName.getText();
            String fname = textFatherName.getText();
            String roll_no = textRollNo.getText();
            String address = textAddress.getText();
            String phonenumber = textPhone.getText();
            String email = textEmail.getText();
            String aadharnumber = textAadhar.getText();
            String xii = textPercentage.getText();
            String course = (String) comboQualifications.getSelectedItem();
            String branch = (String) comboDepartments.getSelectedItem();

            try {
                String query = "UPDATE student SET name = '" + name + "', fname = '" + fname + "', " +
                        "address = '" + address + "', phonenumber = '" + phonenumber + "', email = '" + email + "', " +
                        "aadharnumber = '" + aadharnumber + "', xii = '" + xii + "', course = '" + course + "', " +
                        "branch = '" + branch + "' WHERE roll_no = '" + roll_no + "'";
                Conn c = new Conn();
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                System.out.println("Student details updated in the database for Roll No: " + roll_no);
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating details: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new UpdateStudentDetails();
    }
}