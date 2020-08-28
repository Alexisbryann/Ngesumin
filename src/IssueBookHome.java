import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueBookHome extends JFrame implements ActionListener {
    JFrame f = new JFrame("BOOK ISSUING");
    JPanel p0,p1,p2;
    JButton student,teacher,community,home,logout,quit;
    private GridBagConstraints mConstraints;


//    public static void main(String[] args){
//        new IssueBookHome();
//    }

    IssueBookHome(){
        createComponents();
        createJPanel();
        addComponentsToJPanel();
        addJPanelToFrame();
        createFrame();
        actionEvent();

    }
    public void createFrame(){
        f.setLayout(new GridLayout(1,0));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        f.setSize(width/2,height/2);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void createJPanel(){
        p0 = new JPanel(new GridBagLayout());
        mConstraints = new GridBagConstraints();
        mConstraints.gridx = 0;
        mConstraints.gridy = GridBagConstraints.RELATIVE;
        mConstraints.fill = GridBagConstraints.BOTH;
        mConstraints.gridheight = 40;
        mConstraints.gridwidth = 20;
        mConstraints.weightx = GridBagConstraints.VERTICAL;
        mConstraints.weighty = GridBagConstraints.HORIZONTAL;
        mConstraints.anchor = GridBagConstraints.CENTER;
        mConstraints.ipadx = 30;
        mConstraints.ipady = 30;

        p1.setLayout(new GridLayout(2,2));
        p1.setVisible(true);
        p1.setBackground(Color.GRAY);
        p2.setLayout(new FlowLayout());
        p2.setVisible(true);
        p2.setBackground(new Color(0,0,49));
    }
    public void createComponents(){
        student = new JButton("STUDENT");
        teacher = new JButton("TEACHER");
        community = new JButton("COMMUNITY");
        home = new JButton("HOME");
        logout = new JButton("LOGOUT");
        quit = new JButton("QUIT");
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        student.setFont(new Font("Algerian",Font.BOLD,25));
        student.setForeground(new Color(155,17,30));
        student.setBackground(Color.GRAY);
        teacher.setFont(new Font("Algerian",Font.BOLD,25));
        teacher.setForeground(new Color(155,17,30));
        teacher.setBackground(Color.GRAY);
        community.setFont(new Font("Algerian",Font.BOLD,25));
        community.setForeground(new Color(155,17,30));
        community.setBackground(Color.GRAY);
        home.setFont(new Font("Algerian",Font.BOLD,25));
        home.setForeground(new Color(155,17,30));
        home.setBackground(Color.GRAY);
        logout.setFont(new Font("Algerian",Font.BOLD,25));
        logout.setForeground(new Color(155,17,30));
        logout.setBackground(Color.GRAY);
        quit.setFont(new Font("Algerian",Font.BOLD,25));
        quit.setForeground(new Color(155,17,30));
        quit.setBackground(Color.GRAY);
    }
    public void addComponentsToJPanel(){
        GridBagConstraints d = new GridBagConstraints();
        d.weightx = 0;
        d.weighty = 10;
        d.anchor = GridBagConstraints.CENTER;
        d.fill=GridBagConstraints.CENTER;
        d.gridheight = 10;
        d.gridwidth = 10;
        d.ipady=30;
        d.ipadx=30;

        p1.add(student,d);
        p1.add(teacher,d);
        p1.add(community,d);
        p2.add(home,d);

        p2.add(logout);
        p2.add(quit);

        p0.add(p1,mConstraints);
        p0.add(p2,mConstraints);
    }
    public void addJPanelToFrame(){
        f.add(p0);
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
            f.dispose();
            new IssueToStudentGUI();
        }
        if (e.getSource()==teacher) {
            f.dispose();
            new IssueToTeacher();
        }
        if (e.getSource()==community) {
            f.dispose();
            new IssueToCommunity();
        }
        if (e.getSource()==home) {
            f.dispose();
            new Home();
        }
        if (e.getSource()==logout) {
            f.dispose();
            new LoginGUI();
        }
        if (e.getSource()==quit) {
            f.dispose();
        }
    }

}
