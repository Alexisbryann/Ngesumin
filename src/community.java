import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class community extends JFrame  implements ActionListener{
    JFrame f;
    JButton RegisterBook ,RegisterTeacher ,RegisterStudent ,RegisterCommunity ;
    JButton Home,Logout;
    JPanel p0,p1,p2;


    community() {
        createComponents();
        createPanel();
        addComponentsToPanel();
        actionEvent();
        createFrame();
        addComponentsToFrame();
    }
    public void createComponents(){
        RegisterStudent = new JButton("REGISTER STUDENT");
        RegisterBook = new JButton("REGISTER BOOK");
        RegisterCommunity = new JButton("REGISTER COMMUNITY");
        RegisterTeacher = new JButton("REGISTER TEACHER");
        Home = new JButton("HOME");
        Logout = new JButton("LOGOUT");

    }
    public void createFrame(){
        f = new JFrame("REGISTER");
        f.setLayout(new GridLayout(1, 0));
        f.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        f.setSize(width/2,height/2);
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
        p1.setLayout(new GridLayout(2,2));
        p2 = new JPanel();
        p2.setBackground(new Color(0,0,49));
        p2.setLayout(new FlowLayout());
        p0.add(p1,c);
        p0.add(p2,c);
    }
    public void addComponentsToPanel(){
        GridBagConstraints d = new GridBagConstraints();
        d.weightx = 0;
        d.weighty = 10;
        d.anchor = GridBagConstraints.CENTER;
        d.fill=GridBagConstraints.CENTER;
        d.gridheight = 10;
        d.gridwidth = 10;
        d.ipady=30;
        d.ipadx=30;
        p1.add(RegisterBook,d);
        p1.add(RegisterTeacher,d);
        p1.add(RegisterStudent,d);
        p1.add(RegisterCommunity,d);
        p2.add(Home);
        p2.add(Logout);
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

