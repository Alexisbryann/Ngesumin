import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueBookHome extends JFrame implements ActionListener {
    JFrame f = new JFrame("BOOK ISSUING");
    JPanel p1,p2;
    JButton student,teacher,community,home,logout,quit;

    IssueBookHome(){
        createComponents();
        createJPanel();
        addComponentsToJPanel();
        addJPanelToFrame();
        actionEvent();
        createFrame();
    }
    public void createFrame(){
        f.setLayout(new GridLayout(2,0));
        f.setSize(500, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void createJPanel(){
        p1 = new JPanel();
        p2 = new JPanel();
        p1.setLayout(new GridLayout(3,0));
        p2.setLayout(new FlowLayout());
    }
    public void createComponents(){
        student = new JButton("STUDENT");
        teacher = new JButton("TEACHER");
        community = new JButton("COMMUNITY");
        home = new JButton("HOME");
        logout = new JButton("LOGOUT");
        quit = new JButton("QUIT");
    }
    public void addComponentsToJPanel(){
        p1.add(student);
        p1.add(teacher);
        p1.add(community);
        p2.add(home);
        p2.add(logout);
        p2.add(quit);
    }
    public void addJPanelToFrame(){
        f.add(p1);
        f.add(p2);
    }
    public void actionEvent(){
        student.addActionListener(this);
        teacher.addActionListener(this);
        community.addActionListener(this);
        home.addActionListener(this);
        logout.addActionListener(this);
        quit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==student) {
            new IssueToStudentGUI();
            f.dispose();
        }
        if (e.getSource()==teacher) {
            new IssueToTeacher();
            f.dispose();
        }
        if (e.getSource()==community) {
            new IssueToCommunity();
            f.dispose();
        }
        if (e.getSource()==student) {
            new IssueToStudentGUI();
            f.dispose();
        }
        if (e.getSource()==home) {
            new Home();
            f.dispose();
        }
        if (e.getSource()==logout) {
            new LoginGUI();
            f.dispose();
        }
        if (e.getSource()==quit) {
            f.dispose();
        }



    }
    public static void main(String[] args){
        new IssueBookHome();
    }
}
