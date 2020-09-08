import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterHome extends JFrame  implements ActionListener{
    JFrame f;
    JButton RegisterBook ,RegisterTeacher ,RegisterStudent ,RegisterCommunity ;
    JButton Home,Logout;
    JPanel p0,p1,p2;
    JLabel RegisterMembers;


    RegisterHome() {
        createComponents();
        createPanel();
        addComponentsToPanel();
        actionEvent();
        createFrame();
        addComponentsToFrame();
    }
    public void createComponents(){
        RegisterMembers = new JLabel("REGISTER USERS & BOOKS", JLabel.CENTER);
        RegisterStudent = new JButton("REGISTER STUDENT");
        RegisterBook = new JButton("REGISTER BOOK");
        RegisterCommunity = new JButton("REGISTER COMMUNITY");
        RegisterTeacher = new JButton("REGISTER  TEACHER");
        Home = new JButton("HOME");
        Logout = new JButton("LOGOUT");

    }
    public void createFrame(){
        f = new JFrame("NGESUMIN GIRLS SECONDARY SCHOOL");
        f.setLayout(new GridLayout(1, 0));
        f.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        f.setSize(width/4,height/2);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void createPanel() {
        p0 = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 40;
        c.gridwidth = 20;
        c.weightx = GridBagConstraints.VERTICAL;
        c.weighty = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 30;
        c.ipady = 30;
        p1  = new JPanel();
        p1.setLayout(new GridLayout(5,0));
        p1.setBackground(Color.GRAY);
        p2 = new JPanel();
        p2.setBackground(new Color(0,0,49));
        p2.setLayout(new FlowLayout());
        Border border2 = BorderFactory.createEtchedBorder(new Color(155, 17, 30), new Color(8));
        p2.setBorder(border2);
        Border border1 = BorderFactory.createLineBorder(new Color(155, 17, 30), 2);
        p0.setBorder(border1);
        p0.add(p1,c);
        p0.add(p2,c);
    }
    public void addComponentsToPanel(){

        p1.add(RegisterMembers);
        p1.add(RegisterBook);
        p1.add(RegisterStudent);
        p1.add(RegisterTeacher);
        p1.add(RegisterCommunity);
        p2.add(Home);
        p2.add(Logout);
        RegisterMembers.setFont(new Font("Algerian",Font.BOLD,22));
        RegisterMembers.setForeground(new Color(0,0,49));
        RegisterMembers.setBackground(Color.GRAY);
        Home.setFont(new Font("Algerian",Font.BOLD,25));
        Home.setForeground(new Color(155,17,30));
        RegisterStudent.setFont(new Font("Algerian",Font.BOLD,19));
        RegisterStudent.setForeground(new Color(155,17,30));
        RegisterStudent.setBackground(Color.GRAY);
        RegisterTeacher.setFont(new Font("Algerian",Font.BOLD,19));
        RegisterTeacher.setForeground(new Color(155,17,30));
        RegisterTeacher.setBackground(Color.GRAY);
        Logout.setFont(new Font("Algerian",Font.BOLD,25));
        Logout.setForeground(new Color(155,17,30));
        RegisterCommunity.setFont(new Font("Algerian",Font.BOLD,19));
        RegisterCommunity.setForeground(new Color(155,17,30));
        RegisterCommunity.setBackground(Color.GRAY);
        RegisterBook.setFont(new Font("Algerian",Font.BOLD,19));
        RegisterBook.setForeground(new Color(155,17,30));
        RegisterBook.setBackground(Color.GRAY);
    }
    public void addComponentsToFrame(){
        f.add(p0);
    }
    public void actionEvent() {
        RegisterBook.addActionListener( this);
        RegisterTeacher.addActionListener(this);
        RegisterStudent.addActionListener(this);
        RegisterCommunity.addActionListener(this);
        Home.addActionListener(this);
        Logout.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RegisterBook) {
            f.dispose();
            new RegisterBookGUI();
        }
        if (e.getSource() == RegisterTeacher) {
            f.dispose();
            new RegisterTeacherGUI();
        }
        if (e.getSource() == RegisterStudent) {
            f.dispose();
            new RegisterStudentGUI();
        }
        if (e.getSource() == RegisterCommunity) {
            f.dispose();
            new RegisterCommunity();
        }
        if(e.getSource()== Home){
            f.dispose();
            new Home();
        }
        if (e.getSource()==Logout){
            f.dispose();
            new LoginGUI();
        }
    }
//    public static void main (String[] args){
//        new community();
//    }
}

