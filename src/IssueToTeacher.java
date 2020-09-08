import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.Border;

public class IssueToTeacher extends JFrame implements ActionListener {
    JFrame f = new JFrame("NGSS LIBRARY MANAGEMENT SYSTEM");
    JPanel p0,p1, p2;
    JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9,l10,l11;
    JTextField ID;
    JTextField fname;
    JTextField sname;
    JTextField surname;
    JTextField Phone;
    JTextField BookTittle;
    JTextField BookType;
    JTextField Status;
    JTextField Books_Issued;
    JTextField Serial_Number;
    JFormattedTextField DateOfIssue;
    JFormattedTextField ExpectedReturnDate = new JFormattedTextField();
    JButton Reset, Issue, Logout, Home;

    String url = "jdbc:h2:~/ngesumin;IFEXISTS=TRUE";
    Connection conn = null;
    Connection conn2 = null;
    String user = "brayo";
    String password = "brayo";
    String Driver ="org.h2.Driver";
    PreparedStatement issuebook = null;
    int noIssued;

//    public static void main(String[] args) {
//        new IssueToTeacher();
//    }

    public IssueToTeacher() {


        createComponents();
        createJPanels();
        addComponentsToJPanels();
        addJPanelsToFrame();
        actionEvent();
        createFrame();
    }

    public void createFrame() {
        f.setLayout(new GridLayout(1, 0));
        f.setSize(500, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void createJPanels() {
        p0 = new JPanel();
        p0.setLayout(new GridBagLayout());
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
        p1 = new JPanel();
        p1.setVisible(true);
        p1.setLayout(new GridLayout(12, 0));
        p1.setBackground(Color.GRAY);
        p1.setSize(500, 500);
        p2 = new JPanel();
        p2.setVisible(true);
        p2.setSize(500,100);
        p2.setBackground(new Color(0,0,49));
        p2.setLayout(new GridBagLayout());

        p0.add(p1,c);
        p0.add(p2,c);
    }

    public void createComponents() {
        l0 = new JLabel("TSC NUMBER: ");
        ID = new JTextField();
        ID.setEditable(true);
        l1 = new JLabel("FIRST NAME: ");
        fname = new JTextField();
        fname.setEditable(false);
        l2 = new JLabel("SECOND NAME: ");
        sname = new JTextField();
        sname.setEditable(false);
        l3 = new JLabel("SURNAME: ");
        surname = new JTextField();
        surname.setEditable(false);
        l9 = new JLabel("PHONE NUMBER: ");
        Phone = new JTextField();
        Phone.setEditable(false);
        l8 = new JLabel("STATUS: ");
        Status = new JTextField();
        Status.setEditable(false);
        l11 =new JLabel("SERIAL NUMBER: ");
        Serial_Number = new JTextField();
        Serial_Number.setEditable(true);
        l4 = new JLabel("BOOK TITTLE: ");
        BookTittle = new JTextField();
        BookTittle.setEditable(false);
        l5 = new JLabel("BOOK TYPE: ");
        BookType = new JTextField();
        BookType.setEditable(false);
        l6 = new JLabel("DATE OF ISSUE: ");
        LocalDate date2 = LocalDate.now();
        DateOfIssue = new JFormattedTextField(date2);
        DateOfIssue.setEditable(false);
        l7 = new JLabel("EXPECTED DATE OF RETURN: ");
        ExpectedReturnDate.setEditable(false);
        l10 = new JLabel("NUMBER OF BOOKS ISSUED: ");
        Books_Issued = new JTextField();
        Books_Issued.setEditable(false);

        Reset = new JButton("RESET");
        Issue = new JButton("ISSUE BOOK");
        Logout = new JButton("LOGOUT");
        Home = new JButton("HOME");

        BookTittle.addActionListener(e -> {
            String text = BookType.getText();
            switch (text) {
                case "COURSE BOOK":
                    ExpectedReturnDate.setText(String.valueOf(LocalDate.now().plusDays(90)));
                case "REVISION BOOK":
                case "REFERENCE BOOK":
                case "SET BOOK":
                    ExpectedReturnDate.setText(String.valueOf(LocalDate.now().plusDays(7)));
                    break;
            }
        });

        Home.setFont(new Font("Algerian",Font.BOLD,15));
        Home.setForeground(new Color(155,17,30));
        Issue.setFont(new Font("Algerian",Font.BOLD,15));
        Issue.setForeground(new Color(155,17,30));
        Reset.setFont(new Font("Algerian",Font.BOLD,15));
        Reset.setForeground(new Color(155,17,30));
        Logout.setFont(new Font("Algerian",Font.BOLD,15));
        Logout.setForeground(new Color(155,17,30));
    }

    public void addComponentsToJPanels() {

        GridBagConstraints d = new GridBagConstraints();
        d.weightx = 0;
        d.weighty = 10;
        d.anchor = GridBagConstraints.CENTER;
        d.fill=GridBagConstraints.CENTER;
        d.gridheight = 20;
        d.gridwidth = 20;
        d.ipady=20;
        d.ipadx=20;

        p1.add(l0);
        p1.add(ID);
        p1.add(l1);
        p1.add(fname);
        p1.add(l2);
        p1.add(sname);
        p1.add(l3);
        p1.add(surname);
        p1.add(l9);
        p1.add(Phone);
        p1.add(l8);
        p1.add(Status);
        p1.add(l11);
        p1.add(Serial_Number);
        p1.add(l4);
        p1.add(BookTittle);
        p1.add(l5);
        p1.add(BookType);
        p1.add(l6);
        p1.add(DateOfIssue);
        p1.add(l7);
        p1.add(ExpectedReturnDate);
        p1.add(l10);
        p1.add(Books_Issued);
        p2.add(Reset,d);
        p2.add(Issue,d);
        p2.add(Logout,d);
        p2.add(Home,d);
    }

    public void actionEvent() {
        Reset.addActionListener(this);
        Issue.addActionListener(this);
        Logout.addActionListener(this);
        Home.addActionListener(this);
        fname.addActionListener(this);
        BookType.addActionListener(this);
        BookTittle.addActionListener(this);
    }

    public void addJPanelsToFrame() {
        Border border1 = BorderFactory.createLineBorder(new Color(155, 17, 30), 2);
        p0.setBorder(border1);
        Border border2 = BorderFactory.createEtchedBorder(new Color(155, 17, 30), new Color(8));
        p2.setBorder(border2);
        f.add(p0);
    }
    public void counter() {
        String sql = "select * from teacher where ID ='"+ID.getText()+"'";
        String sql3 = "update teacher set Books_Issued = ? where ID ='"+ID.getText()+"' ";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            int noIssued = Integer.parseInt(rs.getString(7));
            {
                PreparedStatement prepstm = conn.prepareStatement(sql3);
                int count;
                count = ++noIssued;
                prepstm.setInt(1,count);
                prepstm.executeUpdate();
                Books_Issued.setText(String.valueOf(count));
                pst.close();
                rs.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void issue(){
        {
            checkempty();
            if (Status.getText().equalsIgnoreCase("defaulter")) {
                JOptionPane.showMessageDialog(null, "CAN NOT ISSUE BOOK TO A DEFAULTER.");
            } else {
                try {
                    Class.forName(Driver);
                    conn = DriverManager.getConnection(url, user, password);
                    issuebook = conn.prepareStatement("insert into issue_to_teacher values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    issuebook.setString(1, ID.getText().toUpperCase());
                    issuebook.setString(2, fname.getText().toUpperCase());
                    issuebook.setString(3, sname.getText().toUpperCase());
                    issuebook.setString(4, surname.getText().toUpperCase());
                    issuebook.setString(5, Phone.getText().toUpperCase());
                    issuebook.setString(6, Status.getText().toUpperCase());
                    issuebook.setString(7, Serial_Number.getText().toUpperCase());
                    issuebook.setString(8, BookTittle.getText().toUpperCase());
                    issuebook.setString(9, BookType.getText().toUpperCase());
                    issuebook.setString(10, DateOfIssue.getText().toUpperCase());
                    issuebook.setString(11, ExpectedReturnDate.getText().toUpperCase());
                    issuebook.setString(12, Books_Issued.getText());

                    noIssued = Integer.parseInt(Books_Issued.getText());
                    if (noIssued < 3) {
                        issuebook.executeUpdate();
                        JOptionPane.showMessageDialog(null, " BOOK ISSUED!");
                        counter();
                        f.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "SORRY, " + fname.getText() + ' ' + sname.getText() + " HAS CHECKED OUT A MAXIMUM OF 3 BOOKS.");
                    }
                    new IssueToTeacher();
                } catch (SQLException | ClassNotFoundException ex) {
                    //ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "SORRY, BOOK WITH SERIAL NUMBER '" + Serial_Number.getText() + "' HAS ALREADY BEEN ISSUED. ");
                }
            }
        }
    }
    public void checkempty(){
        if ((ID.getText().trim().equals("")) || (fname.getText().trim().equals("")) || (sname.getText().trim().equals("")) || (surname.getText().trim().equals(""))||(Phone.getText().trim().equals(""))||(Status.getText().trim().equals(""))||(Serial_Number.getText().trim().equals(""))||(BookTittle.getText().trim().equals(""))||(BookType.getText().trim().equals(""))||(DateOfIssue.getText().trim().equals(""))||(ExpectedReturnDate.getText().trim().equals(""))||(Books_Issued.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null,"ALL FIELDS MUST BE ENTERED!");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fname) {

            {
                try {
                    Class.forName(Driver);
                    conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement retrieve = conn.prepareStatement("SELECT * FROM teacher where ID=?");
                    retrieve.setString(1, ID.getText());
                    ResultSet rs = retrieve.executeQuery();

                    if (rs.next()) {
                        fname.setText(rs.getString(2));
                        sname.setText(rs.getString(3));
                        surname.setText(rs.getString(4));
                        Phone.setText(rs.getString(5));
                        Status.setText(rs.getString(6));
                        Books_Issued.setText(String.valueOf(rs.getInt(7)));
                    } else {
                        JOptionPane.showMessageDialog(null, "SORRY,NO RECORD FOUND!");
                    }
                } catch (SQLException|ClassNotFoundException  eq) {
                    eq.printStackTrace();
                }
            }
        }
        if (e.getSource() == Home) {
            f.dispose();
            new IssueBookHome();
        }
        if(e.getSource()==Reset){
            ID.setText("");
            fname.setText("");
            sname.setText("");
            surname.setText("");
            Phone.setText("");
            Status.setText("");
            Serial_Number.setText("");
            BookTittle.setText("");
            BookType.setText("");
            ExpectedReturnDate.setText("");
            Books_Issued.setText("");
        }
        if (e.getSource() == Issue) {
            issue();
        }
        if (e.getSource() == Logout) {
            f.dispose();
            new LoginGUI();
        }
        if (e.getSource() == BookTittle) {
            {
                try {
                    Class.forName(Driver);
                    conn2 = DriverManager.getConnection(url, user, password);
                    PreparedStatement ret = conn2.prepareStatement("SELECT * FROM books WHERE SERIAL_NUMBER = ?");
                    ret.setString(1, Serial_Number.getText().toUpperCase());
                    ResultSet rs = ret.executeQuery();

                    if (rs.next()) {
                        BookTittle.setText(rs.getString(1));
                        BookType.setText(rs.getString(5));
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "SORRY, NO BOOK FOUND!");
                    }
                } catch (SQLException|ClassNotFoundException eq) {
                    eq.printStackTrace();
                }
            }
        }
    }

}


