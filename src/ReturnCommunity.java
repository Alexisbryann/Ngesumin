import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.*;
import javax.swing.border.Border;

public class ReturnCommunity extends JFrame implements ActionListener {
    JFrame f = new JFrame("NGESUMIN GIRLS SECONDARY SCHOOL");
    JPanel p0,p1, p2;
    JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11,l12;
    JTextField ID,fname,sname,surname,Phone,BookTittle,BookType,Serial_Number;
    JFormattedTextField Status,DaysElapsed,DateOfReturn,DateOfIssue,ExpectedReturnDate;
    JButton Return,Logout, Home, Reset;

    String url = "jdbc:h2:~/ngesumin;IFEXISTS=TRUE";
    String Driver = "org.h2.Driver";
    Connection conn = null;
    String user = "brayo";
    String password = "brayo";

//    public static void main(String[] args) {
//        new ReturnCommunity();
//    }

    public ReturnCommunity() {

        createJPanels();
        createComponents();
        addComponentsToJPanels();
        addJPanelsToFrame();
        actionEvent();
        createFrame();
    }

    public void createFrame() {

        f.setLayout(new GridLayout(0, 1));
        f.setSize(500, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void createJPanels() {
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
        p1 = new JPanel();
        p1.setVisible(true);
        p1.setLayout(new GridLayout(13, 1));
        p1.setBackground(Color.GRAY);
        p1.setSize(500, 400);
        p2 = new JPanel();
        p2.setVisible(true);
        p2.setBackground(new Color(0,0,49));
        p2.setLayout(new GridBagLayout());
        Border border1 = BorderFactory.createLineBorder(new Color(155,17,30),2);
        p0.setBorder(border1);
        Border border2=BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(8));
        p2.setBorder(border2);
        p0.add(p1,c);
        p0.add(p2,c);
    }

    public void createComponents() {
        l0 = new JLabel("NATIONAL ID: ");
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
        Status = new JFormattedTextField();
        Status.setEditable(false);
        l12 = new JLabel("SERIAL NUMBER");
        Serial_Number = new JTextField();
        Serial_Number.setEditable(true);
        l4 = new JLabel("BOOK TITTLE: ");
        BookTittle = new JTextField();
        BookTittle.setEditable(false);
        l5 = new JLabel("BOOK TYPE: ");
        BookType = new JTextField();
        BookType.setEditable(false);
        l6 = new JLabel("DATE OF ISSUE: ");
        DateOfIssue = new JFormattedTextField();
        DateOfIssue.setEditable(false);
        l7 = new JLabel("EXPECTED DATE OF RETURN: ");
        ExpectedReturnDate = new JFormattedTextField();
        ExpectedReturnDate.setEditable(false);
        l10 = new JLabel("RETURN DATE: ");
        LocalDate date5 = LocalDate.now();
        DateOfReturn = new JFormattedTextField(date5);
        DateOfReturn.setEditable(false);
        l11 = new JLabel("DAYS ELAPSED: ");
        DaysElapsed = new JFormattedTextField();
        DaysElapsed.setEditable(false);

        Return = new JButton("RETURN");
        Reset = new JButton("RESET");
        Logout = new JButton("LOGOUT");
        Home = new JButton("HOME");
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
        p1.add(l12);
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
        p1.add(DateOfReturn);
        p1.add(l11);
        p1.add(DaysElapsed);
        p2.add(Reset,d);
        p2.add(Return,d);
        p2.add(Logout,d);
        p2.add(Home,d);


        Home.setFont(new Font("Algerian",Font.BOLD,18));
        Home.setForeground(new Color(155,17,30));
        Reset.setFont(new Font("Algerian",Font.BOLD,18));
        Reset.setForeground(new Color(155,17,30));
        Return.setFont(new Font("Algerian",Font.BOLD,18));
        Return.setForeground(new Color(155,17,30));
        Logout.setFont(new Font("Algerian",Font.BOLD,18));
        Logout.setForeground(new Color(155,17,30));
    }

    public void actionEvent() {
        Return.addActionListener(this);
        Logout.addActionListener(this);
        Home.addActionListener(this);
        Reset.addActionListener(this);
        fname.addActionListener(this);
        BookType.addActionListener(this);
        BookTittle.addActionListener(this);
        DaysElapsed.addActionListener(this);
    }

    public void addJPanelsToFrame() {
        f.add(p0);
    }

    public void counter() {
        String sql = "select * from community where ID ='"+ID.getText()+"'";
        String sql3 = "update community set Books_Issued = ? where ID ='"+ID.getText()+"'";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            int noIssued = Integer.parseInt(rs.getString(7));

            if(noIssued > 0){
                PreparedStatement prepstm = conn.prepareStatement(sql3);
                --noIssued ;
                prepstm.setInt(1,(noIssued));
                prepstm.executeUpdate();
                pst.close();
                rs.close();
            }
            else{
                JOptionPane.showMessageDialog(null,"ALL THE ISSUED BOOKS HAVE BEEN RETURNED." );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Return() {
        if ((ID.getText().trim().equals("")) || (fname.getText().trim().equals("")) || (sname.getText().trim().equals("")) || (surname.getText().trim().equals("")) || (Phone.getText().trim().equals("")) || (Status.getText().trim().equals("")) || (Serial_Number.getText().trim().equals("")) || (BookTittle.getText().trim().equals("")) || (BookType.getText().trim().equals("")) || (DateOfIssue.getText().trim().equals("")) || (ExpectedReturnDate.getText().trim().equals("")) || (DaysElapsed.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null, "ALL FIELDS MUST BE ENTERED!");
        } else {
            if (Status.getText().equalsIgnoreCase("defaulter")) {
                JOptionPane.showMessageDialog(null, "CAN NOT ISSUE BOOK TO A DEFAULTER.");
            } else {
                try {
                    Class.forName(Driver);
                    conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement ReturnBook0 = conn.prepareStatement("DELETE FROM Issue_To_Community WHERE ID ='" + (ID.getText()) + "' AND  SERIAL_NUMBER = '" + (Serial_Number.getText().toUpperCase()) + "'");
                    PreparedStatement ReturnBook1 = conn.prepareStatement("INSERT INTO Community_Return values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    PreparedStatement ReturnBook2 = conn.prepareStatement("UPDATE community SET STATUS = '" + Status.getText() + "' WHERE ID = '" + ID.getText() + "'");

                    ReturnBook1.setString(1, ID.getText().toUpperCase());
                    ReturnBook1.setString(2, fname.getText().toUpperCase());
                    ReturnBook1.setString(3, sname.getText().toUpperCase());
                    ReturnBook1.setString(4, surname.getText().toUpperCase());
                    ReturnBook1.setString(5, Phone.getText().toUpperCase());
                    ReturnBook1.setString(6, Status.getText().toUpperCase());
                    ReturnBook1.setString(7, Serial_Number.getText().toUpperCase());
                    ReturnBook1.setString(8, BookTittle.getText().toUpperCase());
                    ReturnBook1.setString(9, BookType.getText().toUpperCase());
                    ReturnBook1.setString(10, DateOfIssue.getText());
                    ReturnBook1.setString(11, ExpectedReturnDate.getText());
                    ReturnBook1.setString(12, DaysElapsed.getText());

                    ReturnBook1.executeUpdate();

                    JOptionPane.showMessageDialog(null, "BOOK RETURNED!");
                    ReturnBook2.executeUpdate();
                    ReturnBook0.executeUpdate();
                    counter();
                    f.dispose();
                    new ReturnCommunity();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fname) {
            {
                try {
                    Class.forName(Driver);
                    conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement retrieve = conn.prepareStatement("SELECT * FROM Issue_To_Community where ID=?");
                    retrieve.setString(1, ID.getText());
                    ResultSet rs = retrieve.executeQuery();
                    {
                        rs.next();
                        fname.setText(rs.getString(2));
                        sname.setText(rs.getString(3));
                        surname.setText(rs.getString(4));
                        Phone.setText(rs.getString(5));
                    }
                } catch (SQLException|ClassNotFoundException eq) {
                   // eq.printStackTrace();
                    JOptionPane.showMessageDialog(null,"NO RECORD FOUND FOR ID NUMBER: "+ID.getText());
                }
            }
        }
        if (e.getSource() == BookTittle) {

            try {
                Class.forName(Driver);
                conn = DriverManager.getConnection(url, user, password);
                PreparedStatement retrieve = conn.prepareStatement("SELECT * FROM Issue_To_Community where SERIAL_NUMBER=?");
                retrieve.setString(1, Serial_Number.getText().toUpperCase());
                ResultSet rs = retrieve.executeQuery();
                rs.next();
                BookTittle.setText(rs.getString(8));
                BookType.setText(rs.getString(9));
                DateOfIssue.setText(rs.getString(10));
                ExpectedReturnDate.setText(rs.getString(11));
                String d1 = (DateOfReturn.getText());
                String d2 = (ExpectedReturnDate.getText());
                LocalDate d3 = LocalDate.parse(d1);
                LocalDate d4 = LocalDate.parse(d2);
                long DaysElapsed1 = ChronoUnit.DAYS.between(d4, d3);
                DaysElapsed.setValue(String.valueOf(DaysElapsed1));
                if (DaysElapsed1 > 6) {
                    Status.setText("DEFAULTER!");
                }
                if (DaysElapsed1 <= 6) {
                    Status.setText("GOOD");
                }

            } catch (SQLException|ClassNotFoundException eq) {
                JOptionPane.showMessageDialog(null,"SORRY, NO BOOK FOUND.");
            }
        }
        if (e.getSource() == Return) {
            Return();
        }
        if (e.getSource()==Reset){
            ID.setText("");
            fname.setText("");
            sname.setText("");
            surname.setText("");
            Phone.setText("");
            Status.setText("");
            BookTittle.setText("");
            BookType.setText("");
            ExpectedReturnDate.setText("");
            DateOfReturn.setText("");
            DaysElapsed.setText("");
        }
        if (e.getSource() == Home) {
            f.dispose();
            new ReturnGUI();
        }
    }
}