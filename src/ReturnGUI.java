import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class ReturnGUI extends JFrame implements ActionListener {
        JFrame f;
        JButton ReturnStudent, ReturnTeacher, ReturnCommunity;
        JButton Home,Logout;
        JPanel p0,p1,p2;
        JLabel ReturnBooks;


        ReturnGUI() {
            createComponents();
            createPanel();
            addComponentsToPanel();
            actionEvent();
            createFrame();
            addComponentsToFrame();
        }
        public void createComponents(){
            ReturnBooks = new JLabel("RETURN BOOKS", JLabel.CENTER);
            ReturnStudent = new JButton("STUDENT RETURN");
            ReturnCommunity = new JButton("COMMUNITY RETURN");
            ReturnTeacher = new JButton("TEACHER RETURN");
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

            p1.add(ReturnBooks);
            p1.add(ReturnStudent);
            p1.add(ReturnTeacher);
            p1.add(ReturnCommunity);
            p2.add(Home);
            p2.add(Logout);
            ReturnBooks.setFont(new Font("Algerian",Font.BOLD,22));
            ReturnBooks.setForeground(new Color(0,0,49));
            ReturnBooks.setBackground(Color.GRAY);
            Home.setFont(new Font("Algerian",Font.BOLD,25));
            Home.setForeground(new Color(155,17,30));
            ReturnTeacher.setFont(new Font("Algerian",Font.BOLD,19));
            ReturnTeacher.setForeground(new Color(155,17,30));
            ReturnTeacher.setBackground(Color.GRAY);
            Logout.setFont(new Font("Algerian",Font.BOLD,25));
            Logout.setForeground(new Color(155,17,30));
            ReturnCommunity.setFont(new Font("Algerian",Font.BOLD,19));
            ReturnCommunity.setForeground(new Color(155,17,30));
            ReturnCommunity.setBackground(Color.GRAY);
            ReturnStudent.setFont(new Font("Algerian",Font.BOLD,19));
            ReturnStudent.setForeground(new Color(155,17,30));
            ReturnStudent.setBackground(Color.GRAY);
        }
        public void addComponentsToFrame(){
            f.add(p0);
        }
        public void actionEvent() {
            ReturnStudent.addActionListener( this);
            ReturnTeacher.addActionListener(this);
            ReturnCommunity.addActionListener(this);
            Home.addActionListener(this);
            Logout.addActionListener(this);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ReturnStudent) {
                f.dispose();
                new ReturnStudent();
            }
            if (e.getSource() == ReturnTeacher) {
                f.dispose();
                new ReturnTeacher();
            }
            if (e.getSource() == ReturnCommunity) {
                f.dispose();
                new ReturnCommunity();
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
//        new ReturnGUI();
//    }
    }
