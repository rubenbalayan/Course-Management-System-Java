
import java.awt.GridLayout;
import javax.swing.*;

import Repository.courseRepository;

public class createCourseFrame {

    private courseRepository crp = new courseRepository();

    createCourseFrame()
    {
        display();
    }
    
    private void display() {
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Course Name"));
        panel.add(field1);
        panel.add(new JLabel("Course Content"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Course",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            crp.WriteToFile(field1.getText(), field2.getText());
        } else {
            System.out.println("Cancelled");
        }
    }

}
