import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryGUI extends JFrame implements ActionListener {
    JFrame f = new JFrame("NGSS LIBRARY");
    JLabel Welcome = new JLabel ("WELCOME", JLabel.CENTER);
    JButton Register = new JButton("REGISTER");
    JButton IssueBook = new JButton("ISSUE BOOK");
    JButton Reports = new JButton("REPORTS");
    JButton Logout = new JButton("LOGOUT");
    JButton Quit = new JButton("QUIT");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    public EntryGUI(){

        p1.setLayout(new GridLayout(7,0));
        p1.setVisible(true);
        p1.setSize(500,300);
        p1.add(Welcome);
        p1.add(IssueBook);
        p1.add(Register);
        p1.add(Reports);


        p2.setLayout(new FlowLayout());
        p2.setVisible(true);
        p2.setBackground(Color.blue);
        p2.add(Logout);
        p2.add(Quit);

        Register.addActionListener(this);
        IssueBook.addActionListener(this);
        Reports.addActionListener(this);
        Logout.addActionListener(this);
        Quit.addActionListener(this);


        f.setLayout(new GridLayout(2,0));
        f.setSize(500,500);
        f.setLocation(500,200);
        f.add(p1);
        f.add(p2);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){

        /*if (e.getSource()== IssueBookHome){
            f.dispose();
            new RegisterTeacherGUI();
        }*/
        //if (e.getSource() == Reports){
          //  f.dispose();
           // new Reports();
       // }
        if (e.getSource() == IssueBook){
            f.dispose();
            new IssueBookHome();
        }
        if (e.getSource()==Logout){
            f.dispose();
            new LoginGUI();
        }
        if(e.getSource()==Quit){
            f.dispose();
        }
    }

    public static void main(String[] args){
        new EntryGUI();
    }
}
