package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {

    main_class()
    {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/thirdd.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu newInfo = new JMenu("Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

    //details


        JMenu details = new JMenu("Details");
        details.setForeground(Color.BLACK);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);


        //leave

        JMenu Leave = new JMenu("Leave");
        Leave.setForeground(Color.BLACK);
        mb.add(Leave);

        JMenuItem facultyleave = new JMenuItem("Apply For Leave(Faculty)");
        facultyleave.setBackground(Color.WHITE);
        Leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Apply For Leave(Student)");
        studentleave.setBackground(Color.WHITE);
        Leave.add(studentleave);


        //Exams

        JMenu Exam = new JMenu("Examination");
        Exam.setForeground(Color.BLACK);
        mb.add(Exam);

        JMenuItem Examinationdetails  = new JMenuItem("Examination Results");
        Examinationdetails.setBackground(Color.WHITE);
        Examinationdetails.addActionListener(this);
        Exam.add(Examinationdetails);

        JMenuItem Entermarks = new JMenuItem("Enter Marks");
        Entermarks.setBackground(Color.WHITE);
        Entermarks.addActionListener(this);
        Exam.add(Entermarks);

        //update

        JMenu updateInfo = new JMenu("Update Information");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);

        JMenuItem UpdateFacultyinfo  = new JMenuItem("Update Faculty Information");
        UpdateFacultyinfo.setBackground(Color.WHITE);
        UpdateFacultyinfo.addActionListener(this);
        updateInfo.add(UpdateFacultyinfo);

        JMenuItem UpdateStudentinfo = new JMenuItem("Update Student details");
        UpdateStudentinfo.setBackground(Color.WHITE);
        UpdateStudentinfo.addActionListener(this);
        updateInfo.add(UpdateStudentinfo);


        //Fees

        JMenu Fees = new JMenu("Fees");
        Fees.setForeground(Color.BLACK);
        mb.add(Fees);

        JMenuItem  Feesstructure  = new JMenuItem("Fee Structure");
        Feesstructure.setBackground(Color.WHITE);
        Feesstructure.addActionListener(this);
        Fees.add(Feesstructure);

        JMenuItem FeeForm = new JMenuItem("Fee Form");
        FeeForm.setBackground(Color.WHITE);
        FeeForm.addActionListener(this);
        Fees.add(FeeForm);

        JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.BLACK);
        mb.add(Exit);


        JMenuItem logout = new JMenuItem("LOGOUT");
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        Exit.add(logout);




        setSize(1540,850);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String out = e.getActionCommand();
        if(out.equals("LOGOUT"))
        {
            System.out.println("Logout Successful");
            System.exit(0);

        }
        else if(out.equals("New Faculty Information"))
        {
            new AddFaculty();
        }
        else if(out.equals("New Student Information"))
        {
            new AddStudent();
        }
        else if(out.equals("Faculty Details"))
        {
            new TeacherDetails();
        } else if (out.equals("Student Details")) {
            new StudentDetails();
        }
        else if(out.equals("Examination Result"))
        {
            new ExaminationDetails();
        }
        else if(out.equals("Enter Marks"))
        {
            new EnterMarks();
        }
        else if(out.equals("Update Faculty Information"))
        {
            new UpdateFaculty();
        }
        else if(out.equals("Update Student details"))
        {
            new UpdateStudentDetails();
        }
        else if(out.equals("Fee Structure"))
        {
            new FeeStructure();
        }
        else if(out.equals("Fee Form"))
        {
            new StudentFeeForm();
        }


    }

    public static void main(String[] args) {

        new main_class();
    }


}
