
import javax.swing.*; 

public class mainFrame {
    
    
    public void create_gui(){
    

        loginFrame loginF=new loginFrame();
        loginF.setTitle("Login Form");
        loginF.setVisible(true);
        loginF.setBounds(10,10,370,600);
        loginF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginF.setResizable(false);


    }
}
