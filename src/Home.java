import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JFrame f = new JFrame("NGSS LIBRARY");
    JLabel Welcome;
    JButton Register,IssueBook,Reports,Logout ,Quit;
    JPanel p0,p1,p2;
    private GridBagConstraints c;

    public Home(){
        createComponents();
        createPanel();
        addComponentsToPanel();
        actionEvent();
        createFrame();
        addComponentsToFrame();}

    private void addComponentsToFrame() {
        f.add(p0);
    }
    private void createFrame() {
        f.setLayout(new GridLayout(1,0));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        f.setSize(width/2,height/2);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void actionEvent() {
        Register.addActionListener(this);
        IssueBook.addActionListener(this);
        Reports.addActionListener(this);
        Logout.addActionListener(this);
        Quit.addActionListener(this);
    }

    private void addComponentsToPanel() {
        GridBagConstraints d = new GridBagConstraints();
        d.weightx = 0;
        d.weighty = 10;
        d.anchor = GridBagConstraints.CENTER;
        d.fill=GridBagConstraints.CENTER;
        d.gridheight = 10;
        d.gridwidth = 10;
        d.ipady=30;
        d.ipadx=30;

        p1.add(Welcome,d);
        p1.add(IssueBook,d);
        p1.add(Register,d);
        p1.add(Reports,d);

        p2.add(Logout);
        p2.add(Quit);

        p0.add(p1,c);
        p0.add(p2,c);
    }
    private void createPanel() {
        p0 = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
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

        p1.setLayout(new GridLayout(2,2));
        p1.setVisible(true);
        p1.setBackground(Color.GRAY);
        p2.setLayout(new FlowLayout());
        p2.setVisible(true);
        p2.setBackground(new Color(0,0,49));
    }

    private void createComponents() {
        Welcome = new JLabel ("WELCOME", JLabel.CENTER);
        Register = new JButton("REGISTER");
        IssueBook = new JButton("ISSUE BOOK");
        Reports = new JButton("REPORTS");
        Logout = new JButton("LOGOUT");
        Quit = new JButton("QUIT");
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        Welcome.setFont(new Font("Algerian",Font.BOLD,25));
        Welcome.setForeground(new Color(155,17,30));
        Welcome.setBackground(Color.GRAY);
        IssueBook.setFont(new Font("Algerian",Font.BOLD,25));
        IssueBook.setForeground(new Color(155,17,30));
        IssueBook.setBackground(Color.GRAY);
        Register.setFont(new Font("Algerian",Font.BOLD,25));
        Register.setForeground(new Color(155,17,30));
        Register.setBackground(Color.GRAY);
        Reports.setFont(new Font("Algerian",Font.BOLD,25));
        Reports.setForeground(new Color(155,17,30));
        Reports.setBackground(Color.GRAY);
        Logout.setFont(new Font("Algerian",Font.BOLD,25));
        Logout.setForeground(new Color(155,17,30));
        Logout.setBackground(Color.GRAY);
        Quit.setFont(new Font("Algerian",Font.BOLD,25));
        Quit.setForeground(new Color(155,17,30));
        Quit.setBackground(Color.GRAY);
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource()== Register){
            f.dispose();
            new community();
        }if (e.getSource() == IssueBook){
            f.dispose();
            new IssueBookHome();
        }if (e.getSource()==Logout){
            f.dispose();
            new LoginGUI();
        }if(e.getSource()==Quit){
            f.dispose();
        }if (e.getSource()==Reports){

        }
    }
//    public static void main(String[] args){
//        new Home();
//    }
}
