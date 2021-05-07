import javax.swing.*;

import Repository.dataRepository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAccFrame extends JFrame implements ActionListener {


    Container container = getContentPane();
    JLabel welcomeLabel = new JLabel("CREATE ACCOUNT");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel repeatPasswordLabel = new JLabel("RE-PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField repeatPasswordField= new JPasswordField();
    JButton createButton = new JButton("CREATE");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JRadioButton studentButton = new JRadioButton("Student");
    JRadioButton teacherButton = new JRadioButton("Teacher");
    ButtonGroup radioChoice = new ButtonGroup();
    loginFrame tempFrame;
    dataRepository dr = new dataRepository();


    createAccFrame(loginFrame lFrame) {
        tempFrame = lFrame;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        studentButton.setActionCommand("Student");
        teacherButton.setActionCommand("Teacher");
        radioChoice.add(studentButton);
        radioChoice.add(teacherButton);
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        welcomeLabel.setBounds(100,50,150,30);
        welcomeLabel.setFont(new Font("CREATE ACCOUNT",Font.PLAIN,16));
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        repeatPasswordLabel.setBounds(50, 290, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        repeatPasswordField.setBounds(150, 290, 150, 30);
        studentButton.setBounds(50,345,100,30);
        teacherButton.setBounds(150,345,100,30);
        showPassword.setBounds(150, 250, 150, 30);
        createButton.setBounds(50, 390, 100, 30);
        resetButton.setBounds(200, 390, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(welcomeLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(repeatPasswordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(repeatPasswordField);
        container.add(showPassword);
        container.add(createButton);
        container.add(resetButton);
        container.add(studentButton);
        container.add(teacherButton);
    }

    public void addActionEvent() {
        createButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String userText;
            char[] pwdText;
            char[] rpwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getPassword(); 
            rpwdText = repeatPasswordField.getPassword(); 
            String pass = "";
            String rpass = "";
            for (char c : pwdText) {
                pass+=c;
            }
            for (char ch : rpwdText) {
                rpass+=ch;
            }
            if(userText.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please enter a username,");
            }
            else if (pass.equals(rpass)) {
                
                dr.WriteToFile(userText, pass, radioChoice.getSelection().getActionCommand());
                JOptionPane.showMessageDialog(this, "Account created successful");
                this.setVisible(false);
                tempFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            repeatPasswordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }

    
}
}
