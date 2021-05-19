
import javax.swing.*;

import Repository.dataRepository;
import models.UserModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class loginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel welcomeLabel = new JLabel("LOGIN");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JButton createAccount = new JButton("Create Account");
    dataRepository dRepository = new dataRepository();


    loginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        welcomeLabel.setBounds(150,50,150,30);
        welcomeLabel.setFont(new Font("LOGIN",Font.PLAIN,16));
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        createAccount.setBounds(100,400,150,30);


    }

    public void addComponentsToContainer() {
        container.add(welcomeLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(createAccount);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        createAccount.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            char[] pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getPassword();
            String pass = "";
            for (char c : pwdText) {
                pass+=c;
            }
            UserModel user = dRepository.CheckCredentials(userText, pass);
            if (user != null) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                this.setVisible(false);
                courseFrame courseF=new courseFrame(user);
                courseF.setTitle("Courses");
                courseF.setVisible(true);
                courseF.setBounds(10,10,1000,700);
                courseF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                courseF.setResizable(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
        if(e.getSource() == createAccount)
        {
            this.setVisible(false);
            createAccFrame crAccF=new createAccFrame(this);
            crAccF.setTitle("Create Account Form");
            crAccF.setVisible(true);
            crAccF.setBounds(10,10,370,600);
            crAccF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            crAccF.setResizable(false);
        }
    }

}