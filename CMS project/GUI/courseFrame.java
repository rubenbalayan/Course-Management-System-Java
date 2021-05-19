import javax.swing.*;

import Repository.courseRepository;
import models.CourseModel;
import models.UserModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class courseFrame extends JFrame implements ActionListener{

    Container container = getContentPane();
    private UserModel user;
    private courseRepository csrp = new courseRepository();
    private java.util.List courses = csrp.GetAll();
    JButton createCourse = new JButton("CREATE COURSE");



    courseFrame(UserModel user){
        this.user = user;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        createCourse.setBounds(10, 10, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(createCourse);
        for(int i =0; i< courses.size();i++){
        JTextArea comp = new JTextArea(10, 25);  // row and columns
        comp.setBackground(new Color(200, 200, 200));
        comp.setForeground(Color.WHITE);
        comp.setBorder(BorderFactory.createLineBorder(Color.black, 15));

        comp.setPreferredSize(new Dimension(350, 200));
        container.add(comp);
    
        StringBuffer msg = new StringBuffer();
        msg.append(courses.get(i).toString());
    
        comp.setText(msg.toString());
        }
    }

    public  void addActionEvent() {
        createCourse.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createCourse) {
            if(!user.GetType().equals("Teacher"))
            {
                new createCourseFrame();
            }
            else{
                JOptionPane.showMessageDialog(this, "Dear " + user.GetUsername() + ", you are not a teacher.");
            }
        }
        
    }
    
}
