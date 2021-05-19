import Repository.courseRepository;
import Repository.dataRepository;

public class start {
    
    public static void main(String[] args) {
        new dataRepository();
        new courseRepository();
        new mainFrame().create_gui();
    }
}
