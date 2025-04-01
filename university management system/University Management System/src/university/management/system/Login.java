package university.management.system;

import javafx.scene.control.PasswordField;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textFieldName,textFieldName_2;
    JPasswordField passwordField;
    JButton Login,Back;
    Login()
    {
        JLabel labelName = new JLabel("UserName");
        labelName.setBounds(40,20,100,20);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150,20,150,20);
        add(textFieldName);

        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(40,70,100,20);
        add(labelpass);


        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,20);
        add(passwordField);

        Login = new JButton("Login");
        Login.setBounds(40,140,120,30);
        Login.setBackground(Color.black);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);

        Back = new JButton("Back");
        Back.setBounds(180,140,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(0,0,600,300);
        add(imgg);

        setSize(600,300);
        setLocation(500,250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==Login)
            {
                String username = textFieldName.getText();
                String password = passwordField.getText();


                String query ="select * from login where username= '"+username+"'and password = '"+password+"'";
                System.out.println("Query: " + query);


                try
                {
                    Conn c = new Conn();
                    if(c.statement == null) {
                        System.out.println("Statement is null - connection failed!");
                        return;
                    }
                    ResultSet resultset = c.statement.executeQuery(query);

                    if(resultset.next())
                    {
                        System.out.println("Login successful!");
                        setVisible(false);
                        new main_class();

                    }
                    else {
                        System.out.println("No matching record found.");
                        JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    }
                }
                catch(Exception E)
                {
                    System.out.println("Query execution failed!");
                    E.printStackTrace();
                }
            }
            else {
                setVisible(false);

            }
    }

    public static void main(String[] args) {
        new Login();

    }
}





