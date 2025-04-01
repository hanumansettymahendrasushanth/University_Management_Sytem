//package university.management.system;
//
//import javafx.scene.control.ComboBox;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class EnterMarks extends JFrame implements ActionListener {
//
//
//    Choice choicerollno;
//    JComboBox comboBox;
//
//    JButton submit,cancel;
//
//    JTextField sub1,sub2,sub3,sub4,sub5,mrk1,mrk2,mrk3,mrk4,mrk5;
//
//    EnterMarks()
//    {
//        getContentPane().setBackground(new Color(252,242,210));
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel img = new JLabel(i3);
//        img.setBounds(500,40,400,300);
//        add(img);
//
//        JLabel heading = new JLabel("Student Marks");
//        heading.setBounds(50,0,500,50);
//        heading.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(heading);
//
//        JLabel roll_no = new JLabel("Enter Students Roll No");
//        roll_no.setBounds(50,70,150,30);
//        add(roll_no);
//
//        choicerollno = new Choice();
//        choicerollno.setBounds(200,70,150,20);
//        add(choicerollno);
//
//        try
//        {
//            Conn c = new Conn();
//            ResultSet resultSet = c.statement.executeQuery("Select * from student");
//            while(resultSet.next())
//            {
//                choicerollno.add(resultSet.getString("roll_no"));
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//
//
//        JLabel sem = new JLabel("Semester");
//        sem.setBounds(50,110,150,30);
//        add(sem);
//
//        String semester [] = {"Sem-1","Sem-2","Sem-3","Sem-4","Sem-5","Sem-6","Sem-7","Sem-8"};
//        comboBox = new JComboBox(semester);
//        comboBox.setBounds(200,110,150,20);
//        comboBox.setBackground(Color.white);
//        add(comboBox);
//
//
//        JLabel subject = new JLabel("Subject");
//        subject.setBounds(100,150,200,40);
//        add(subject);
//
//        JLabel marks = new JLabel("Marks");
//        marks.setBounds(320,150,200,40);
//        add(marks);
//
//        sub1 = new JTextField();
//        sub1.setBounds(50,200,180,20);
//        add(sub1);
//
//        sub2 = new JTextField();
//        sub2.setBounds(50,230,180,20);
//        add(sub2);
//
//        sub3 = new JTextField();
//        sub3.setBounds(50,260,180,20);
//        add(sub3);
//
//        sub4 = new JTextField();
//        sub4.setBounds(50,290,180,20);
//        add(sub4);
//
//        sub5 = new JTextField();
//        sub5.setBounds(50,320,180,20);
//        add(sub5);
//
//        mrk1 = new JTextField();
//        mrk1.setBounds(280,200,150,20);
//        add(mrk1);
//
//        mrk2 = new JTextField();
//        mrk2.setBounds(280,230,150,20);
//        add(mrk2);
//
//        mrk3 = new JTextField();
//        mrk3.setBounds(280,260,150,20);
//        add(mrk3);
//
//        mrk4 = new JTextField();
//        mrk4.setBounds(280,290,150,20);
//        add(mrk4);
//
//        mrk5 = new JTextField();
//        mrk5.setBounds(280,320,150,20);
//        add(mrk5);
//
//        submit =new JButton("Submit");
//        submit.setBounds(70,360,150,25);
//        submit.setForeground(Color.white);
//        submit.setBackground(Color.black);
//        submit.addActionListener(this);
//        add(submit);
//
//
//        cancel =new JButton("Cancel");
//        cancel.setBounds(280,360,150,25);
//        cancel.setForeground(Color.white);
//        cancel.setBackground(Color.black);
//        cancel.addActionListener(this);
//        add(cancel);
//
//
//
//
//        setSize(1000,500);
//        setLayout(null);
//        setLocation(300,150);
//        setVisible(true);
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if(e.getSource()==submit)
//        {
//            try
//            {
//                Conn c = new Conn();
//                String q1 = "insert into subject values('"+choicerollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
//                String q2 = "insert into marks values('"+choicerollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+mrk1.getText()+"','"+mrk2.getText()+"','"+mrk3.getText()+"','"+mrk4.getText()+"','"+mrk5.getText()+"')";
//                c.statement.executeUpdate(q1);
//                c.statement.executeUpdate(q2);
//                System.out.println("Updated marks successfullyyy ");
//                JOptionPane.showMessageDialog(null,"Marks Updated!");
//                setVisible(false);
//            }
//
//
//            catch (Exception E)
//            {
//                E.printStackTrace();
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//        new EnterMarks();
//
//    }
//
//
//}


package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice choicerollno;
    JComboBox<String> comboBox;
    JButton submit, cancel;
    JTextField sub1, sub2, sub3, sub4, sub5, mrk1, mrk2, mrk3, mrk4, mrk5;

    EnterMarks() {
        getContentPane().setBackground(new Color(252, 242, 210));
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen

        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Heading (Centered at top)
        JLabel heading = new JLabel("Enter Student Marks");
        heading.setBounds((screenWidth - 600) / 2, 20, 600, 60);
        heading.setFont(new Font("Tahoma", Font.BOLD, 36));
        heading.setForeground(new Color(51, 51, 51));
        add(heading);

        // Left Side: Form Components (shifted right and down)
        int leftX = 250; // Moved right from 50 to 250
        int startY = 150; // Shifted down from 100

        // Roll Number
        JLabel roll_no = new JLabel("Student Roll No:");
        roll_no.setBounds(leftX, startY, 200, 40);
        roll_no.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(roll_no);

        choicerollno = new Choice();
        choicerollno.setBounds(leftX, startY + 50, 250, 30);
        choicerollno.setFont(new Font("SansSerif", Font.PLAIN, 16));
        choicerollno.setBackground(Color.WHITE);
        add(choicerollno);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                choicerollno.add(resultSet.getString("roll_no"));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Semester
        JLabel sem = new JLabel("Semester:");
        sem.setBounds(leftX, startY + 100, 200, 40);
        sem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sem);

        String[] semester = {"Sem-1", "Sem-2", "Sem-3", "Sem-4", "Sem-5", "Sem-6", "Sem-7", "Sem-8"};
        comboBox = new JComboBox<>(semester);
        comboBox.setBounds(leftX, startY + 150, 250, 30);
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
        comboBox.setBackground(Color.WHITE);
        add(comboBox);

        // Subject and Marks Headers
        JLabel subject = new JLabel("Subject");
        subject.setBounds(leftX + 20, startY + 200, 200, 40);
        subject.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(subject);

        JLabel marks = new JLabel("Marks");
        marks.setBounds(leftX + 300, startY + 200, 200, 40);
        marks.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(marks);

        // Subject Fields (Enlarged)
        sub1 = new JTextField();
        sub1.setBounds(leftX, startY + 250, 250, 35);
        sub1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sub1.setBackground(new Color(255, 245, 238));
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(leftX, startY + 300, 250, 35);
        sub2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sub2.setBackground(new Color(255, 245, 238));
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(leftX, startY + 350, 250, 35);
        sub3.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sub3.setBackground(new Color(255, 245, 238));
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(leftX, startY + 400, 250, 35);
        sub4.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sub4.setBackground(new Color(255, 245, 238));
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(leftX, startY + 450, 250, 35);
        sub5.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sub5.setBackground(new Color(255, 245, 238));
        add(sub5);

        // Marks Fields (Enlarged)
        mrk1 = new JTextField();
        mrk1.setBounds(leftX + 280, startY + 250, 200, 35);
        mrk1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        mrk1.setBackground(new Color(255, 245, 238));
        add(mrk1);

        mrk2 = new JTextField();
        mrk2.setBounds(leftX + 280, startY + 300, 200, 35);
        mrk2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        mrk2.setBackground(new Color(255, 245, 238));
        add(mrk2);

        mrk3 = new JTextField();
        mrk3.setBounds(leftX + 280, startY + 350, 200, 35);
        mrk3.setFont(new Font("SansSerif", Font.PLAIN, 16));
        mrk3.setBackground(new Color(255, 245, 238));
        add(mrk3);

        mrk4 = new JTextField();
        mrk4.setBounds(leftX + 280, startY + 400, 200, 35);
        mrk4.setFont(new Font("SansSerif", Font.PLAIN, 16));
        mrk4.setBackground(new Color(255, 245, 238));
        add(mrk4);

        mrk5 = new JTextField();
        mrk5.setBounds(leftX + 280, startY + 450, 200, 35);
        mrk5.setFont(new Font("SansSerif", Font.PLAIN, 16));
        mrk5.setBackground(new Color(255, 245, 238));
        add(mrk5);

        // Buttons (Enlarged)
        submit = new JButton("Submit");
        submit.setBounds(leftX, startY + 520, 200, 40);
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(50, 205, 50));
        submit.setFont(new Font("Tahoma", Font.BOLD, 18));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(leftX + 280, startY + 520, 200, 40);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(220, 20, 60));
        cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        cancel.addActionListener(this);
        add(cancel);

        // Right Side: Image (Reduced Size)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenWidth / 3, screenHeight - 200, Image.SCALE_DEFAULT); // Reduced size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(screenWidth - (screenWidth / 3) - 50, 50, screenWidth / 3, screenHeight - 200); // Right side, smaller
        add(img);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                Conn c = new Conn();
                String q1 = "INSERT INTO subject VALUES('" + choicerollno.getSelectedItem() + "','" + comboBox.getSelectedItem() + "','" + sub1.getText() + "','" + sub2.getText() + "','" + sub3.getText() + "','" + sub4.getText() + "','" + sub5.getText() + "')";
                String q2 = "INSERT INTO marks VALUES('" + choicerollno.getSelectedItem() + "','" + comboBox.getSelectedItem() + "','" + mrk1.getText() + "','" + mrk2.getText() + "','" + mrk3.getText() + "','" + mrk4.getText() + "','" + mrk5.getText() + "')";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                System.out.println("Updated marks successfullyyy ");
                JOptionPane.showMessageDialog(null, "Marks Updated!");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}



