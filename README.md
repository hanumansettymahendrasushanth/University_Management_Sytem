# University_Management_Sytem
# 🎓 University Management System

Welcome to the **University Management System** – a sleek, Java-powered desktop application built with Swing to streamline university operations! Whether you're managing student records, tracking fees, or handling teacher data, this app has got you covered. Dive in and explore a world of organized chaos turned into seamless efficiency! 🚀

---

## ✨ Features That Shine

- **Student Management** 📚  
  Update student details, track their academic journey, and manage fee payments with ease.
- **Fee Management** 💰  
  View fee structures, process semester payments, and keep financial records in check.
- **Teacher Records** 👩‍🏫  
  Store and manage teacher information effortlessly.
- **Interactive UI** 🖥️  
  A clean, intuitive Swing interface that makes navigation a breeze.

---

## 🛠️ Tech Stack

- **Language**: Java (Swing for GUI)  
- **Database**: MySQL  
- **Dependencies**: `jcalendar-x.x.x.jar` (for date pickers)  
- **IDE**: Any Java-supported IDE (e.g., IntelliJ, Eclipse)

---

## 🚀 Getting Started

Ready to take this system for a spin? Follow these steps to set it up on your machine!

### Prerequisites
- **Java**: JDK 8 or higher installed  
- **MySQL**: Server running (e.g., MySQL Workbench, XAMPP)  
- **JCalendar**: Download `jcalendar-x.x.x.jar` [here](https://toedter.com/jcalendar/) if using date pickers

### Step 1: Clone the Repository
```bash
git clone https://github.com/yourusername/UniversityManagementSystem.git
cd UniversityManagementSystem


Step 2: Set Up the Database
Open your MySQL client (e.g., MySQL Workbench or terminal).
Run the following SQL script to create the database and tables:
sql

Collapse

Wrap

Copy
-- Create the database
CREATE DATABASE universitymanagement;
USE universitymanagement;

-- Login table
CREATE TABLE login (
    username VARCHAR(30),
    password VARCHAR(30)
);
INSERT INTO login VALUES ('sushanth', 'Sushanth@99');

-- Teacher table
CREATE TABLE teacher (
    name VARCHAR(100) NOT NULL,
    fname VARCHAR(100),
    empid VARCHAR(20) PRIMARY KEY,
    dob VARCHAR(40),
    address VARCHAR(200),
    phonenumber VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    aadharnumber VARCHAR(12) UNIQUE,
    xii VARCHAR(50),
    course VARCHAR(100),
    department VARCHAR(100)
);

-- Student table
CREATE TABLE student (
    name VARCHAR(100) NOT NULL,
    fname VARCHAR(100),
    roll_no VARCHAR(20),
    dob VARCHAR(40),
    address VARCHAR(200),
    phonenumber VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    aadharnumber VARCHAR(12) UNIQUE,
    xii VARCHAR(50),
    course VARCHAR(100),
    branch VARCHAR(100)
);

-- Subject table
CREATE TABLE subject (
    roll_no VARCHAR(30),
    semester VARCHAR(20),
    sub1 VARCHAR(20),
    sub2 VARCHAR(20),
    sub3 VARCHAR(20),
    sub4 VARCHAR(20),
    sub5 VARCHAR(20)
);

-- Marks table
CREATE TABLE marks (
    roll_no VARCHAR(30),
    semester VARCHAR(20),
    mrk1 VARCHAR(20),
    mrk2 VARCHAR(20),
    mrk3 VARCHAR(20),
    mrk4 VARCHAR(20),
    mrk5 VARCHAR(20)
);

-- Fee table
CREATE TABLE fee (
    course VARCHAR(20),
    semester1 VARCHAR(20),
    semester2 VARCHAR(20),
    semester3 VARCHAR(20),
    semester4 VARCHAR(20),
    semester5 VARCHAR(20),
    semester6 VARCHAR(20),
    semester7 VARCHAR(20),
    semester8 VARCHAR(20)
);

-- Insert fee data
INSERT INTO fee VALUES ('BTech', '49000', '43000', '43000', '43000', '43000', '43000', '43000', '43000');
INSERT INTO fee VALUES ('Bsc', '44000', '35000', '35000', '35000', '35000', '35000', '', '');
INSERT INTO fee VALUES ('BCA', '39000', '34000', '34000', '34000', '34000', '34000', '', '');
INSERT INTO fee VALUES ('MTech', '70000', '60000', '60000', '60000', '', '', '', '');
INSERT INTO fee VALUES ('MSc', '44000', '45000', '45000', '45000', '', '', '', '');
INSERT INTO fee VALUES ('MCA', '66000', '42000', '42000', '49000', '', '', '', '');
INSERT INTO fee VALUES ('Bcom', '32000', '20000', '20000', '20000', '20000', '20000', '', '');
INSERT INTO fee VALUES ('Mcom', '46000', '30000', '30000', '30000', '', '', '', '');

-- Fee payments table
CREATE TABLE fee_payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    roll_no VARCHAR(20),
    course VARCHAR(100),
    semester VARCHAR(20),
    amount VARCHAR(10),
    payment_date VARCHAR(40),
    FOREIGN KEY (roll_no) REFERENCES student(roll_no)
);
Verify tables:
sql

Collapse

Wrap

Copy
SELECT * FROM login;
SELECT * FROM teacher;
SELECT * FROM student;
SELECT * FROM subject;
SELECT * FROM marks;
SELECT * FROM fee;
SELECT * FROM fee_payments;
Step 3: Configure Database Connection
Edit Conn.java (or equivalent) with your MySQL credentials:
java

Collapse

Wrap

Copy
String url = "jdbc:mysql://localhost:3306/universitymanagement";
String username = "root"; // Your MySQL username
String password = "yourpassword"; // Your MySQL password
Step 4: Compile and Run
Compile all Java files:
bash

Collapse

Wrap

Copy
javac -cp ".;path/to/jcalendar.jar" university/management/system/*.java
Run the app (e.g., StudentFeeForm):

bash
java -cp ".;path/to/jcalendar.jar" university.management.system.StudentFeeForm




Replace path/to/jcalendar.jar with the actual path if needed.

🎉 How It Works

Login: Use sushanth / Sushanth@99 to access the system (if implemented).
Student Management: Update student details or view records.
Fee Handling: Check fees by course and semester, then process payments.
Teacher Data: Manage teacher profiles with ease.


🌟 Pro Tips
Course Consistency: Ensure course names in student and fee match (e.g., "BTech" not "B.TECH").
Add Sample Data: Insert some students and teachers to test:



sql

INSERT INTO student (name, fname, roll_no, dob, course, branch) 

VALUES ('John Doe', 'Mike Doe', 'EMP12345', '2000-01-01', 'BTech', 'CSE');

INSERT INTO teacher (name, fname, empid, dob, department) 

VALUES ('Jane Smith', 'Tom Smith', 'T001', '1980-05-15', 'CSE');

Explore Features: Try UpdateStudent, FeeStructure, and more!
🤝 Contributing
Got ideas to make this even better? Fork the repo, tweak the code, and submit a pull request! Let’s build something amazing together. 🌍

📢 Troubleshooting
Database Error? Check your MySQL connection in Conn.java.
"N/A" Fees? Verify course names match between student and fee tables.
Swing Issues? Ensure Java and dependencies are correctly installed.
🌈 Future Enhancements
Web version with Spring Boot & React 🌐
User authentication overhaul 🔒
Reports and analytics 📊

Made with ❤️ by Mahendra Sushanth | Let’s manage universities like pros!
