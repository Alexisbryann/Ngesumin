import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterCommunity extends JFrame implements ActionListener {
    JFrame f = new JFrame("NGESUMIN GIRLS SECONDARY SCHOOL");
    JPanel p0,p1, p2;
    JPanel p3 = new JPanel();
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField Fname, Sname, Surname, IDno, PhoneNo, Status;
    static  JTable table;
    JButton Register = new JButton("REGISTER");
    JButton Reset = new JButton("RESET");
    JButton Home = new JButton("HOME");
    JButton Logout = new JButton("LOGOUT");
    JButton delete = new JButton("DELETE USER");

    Connection conn = null;
    String url = "jdbc:h2:~/ngesumin;IFEXISTS=TRUE";
    String user = "brayo";
    String password = "brayo";
    String Driver = "org.h2.Driver";
    PreparedStatement insertNewCommunity = null;
    String []columnNames = {"NATIONAL ID","FIRST NAME","SECOND NAME","SURNAME","PHONE NO","STATUS"};

    RegisterCommunity() {
        createJPanels();
        createComponents();
        addComponentsToJPanels();
        addJPanelsToFrame();
        actionEvent();
        createTable();
        createFrame();
    }

    public void createFrame() {
        f.setLayout(new GridLayout(0, 2));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screensize.width,screensize.height);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
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
        p1.setLayout(new GridLayout(6, 0));
        p1.setSize(500,400);
        p1.setBackground(Color.GRAY);
        p2 = new JPanel();
        p2.setBackground(new Color(0,0,49));
        p2.setLayout(new GridBagLayout());
        Border border1 = BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(0,0,49));
        p0.setBorder(border1);
        Border border2 = BorderFactory.createLineBorder(new Color(155,17,30),2);
        p2.setBorder(border2);
        Border border3=BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(8));
        p1.setBorder(border3);
        p0.add(p1,c);
        p0.add(p2,c);
    }

    public void createComponents() {
        l1 = new JLabel("FIRST NAME: ");
        Fname = new JTextField();
        Fname.setEditable(true);
        l2 = new JLabel("SECOND NAME: ");
        Sname = new JTextField();
        Sname.setEditable(true);
        l3 = new JLabel("SURNAME: ");
        Surname = new JTextField();
        Surname.setEditable(true);
        l4 = new JLabel("ID NUMBER: ");
        IDno = new JTextField();
        IDno.setEditable(true);
        l5 = new JLabel("PHONE NUMBER: ");
        PhoneNo = new JTextField(10);
        PhoneNo.setEditable(true);
        l6 = new JLabel("STATUS: ");
        Status = new JTextField("GOOD");
        Status.setEditable(false);
        Home.setFont(new Font("Algerian",Font.BOLD,15));
        Home.setForeground(new Color(155,17,30));
        Register.setFont(new Font("Algerian",Font.BOLD,15));
        Register.setForeground(new Color(155,17,30));
        Reset.setFont(new Font("Algerian",Font.BOLD,15));
        Reset.setForeground(new Color(155,17,30));
        Logout.setFont(new Font("Algerian",Font.BOLD,15));
        Logout.setForeground(new Color(155,17,30));
        delete.setFont(new Font("Algerian",Font.BOLD,15));
        delete.setForeground(new Color(155,17,30));
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
        p1.add(l4);
        p1.add(IDno);
        p1.add(l1);
        p1.add(Fname);
        p1.add(l2);
        p1.add(Sname);
        p1.add(l3);
        p1.add(Surname);
        p1.add(l5);
        p1.add(PhoneNo);
        p1.add(l6);
        p1.add(Status,d);
        p2.add(Register,d);
        p2.add(Reset,d);
        p2.add(delete,d);
        p2.add(Home,d);
        p2.add(Logout,d);
    }
    public void createTable(){
        p3.setLayout(new BorderLayout());
        Border border3=BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(8));
        p3.setBorder(border3);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setBackground(Color.GRAY);
        table.setRowSelectionAllowed(true);
        table.getSelectedRow();
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String NationalID ;
        String fname ;
        String sname;
        String surname ;
        String PhoneNo;
        String Status ;
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from community";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while
            (rs.next()) {
                NationalID = rs.getString("ID");
                fname = rs.getString("First_Name");
                sname = rs.getString("Second_Name");
                surname = rs.getString("Surname");
                PhoneNo = rs.getString("Phone_number");
                Status = rs.getString("Status");

                model.addRow(new Object[]{NationalID,fname,sname,surname,PhoneNo,Status});
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        p3.add(scroll);
    }
    public void addJPanelsToFrame() {
        f.add(p0);
        f.add(p3);
    }
    public void actionEvent() {
        Home.addActionListener(this);
        Register.addActionListener(this);
        Reset.addActionListener(this);
        delete.addActionListener(this);
        Logout.addActionListener(this);
    }
    public void Register(){
        {
            try {
                Class.forName(Driver);
                conn = DriverManager.getConnection(url, user, password);

                insertNewCommunity = conn.prepareStatement
                        ("INSERT INTO community VALUES (?,?,?,?,?,?,?)");
                insertNewCommunity.setString(1, IDno.getText().toUpperCase());
                insertNewCommunity.setString(2, Fname.getText().toUpperCase());
                insertNewCommunity.setString(3, Sname.getText().toUpperCase());
                insertNewCommunity.setString(4, Surname.getText().toUpperCase());
                insertNewCommunity.setString(5, PhoneNo.getText().toUpperCase());
                insertNewCommunity.setString(6, Status.getText().toUpperCase());
                insertNewCommunity.setInt(7, 0);

                insertNewCommunity.executeUpdate();
                JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULLY!");
                f.dispose();
                new RegisterCommunity();
            } catch (SQLDataException eq){
                JOptionPane.showMessageDialog(null,"SORRY, PHONE NUMBER MUST HAVE \n A MAXIMUM OF 10 DIGITS.");
            } catch (ClassNotFoundException | SQLException ex) {
               // ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "SORRY, ID NUMBER '" +IDno.getText()+ "' \n IS ALREADY REGISTERED.");
            }
        }
    }
    public void checkempty(){
        if ((Surname.getText().trim().equals("")) || (Fname.getText().trim().equals("")) || (Sname.getText().trim().equals("")) || (IDno.getText().trim().equals(""))||(PhoneNo.getText().trim().equals(""))||(Status.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null,"ALL FIELDS MUST BE ENTERED!");
        }else {
            Register();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Home) {
            f.dispose();
            new RegisterHome();
        }
        if (e.getSource()==delete){
            try {
                int row = table.getSelectedRow();
                String idd = (String) table.getModel().getValueAt(row,0);
                String delRow = "delete from community where id = '"+idd+"'";

                Class.forName(Driver);
                conn = DriverManager.getConnection(url, user, password);
                PreparedStatement DeleteUser = conn.prepareStatement(delRow);

                DeleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "USER SUCCESSFULLY DELETED!");
                f.dispose();
                new RegisterCommunity();
            }
            catch (SQLException | ClassNotFoundException | ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "ROW TO BE DELETED HAS NOT BEEN SELECTED.");
                //ex.printStackTrace();
            }
        }
        if (e.getSource() == Logout) {
            f.dispose();
            new LoginGUI();
        }
        if (e.getSource() == Reset) {
            Fname.setText("");
            Sname.setText("");
            Surname.setText("");
            IDno.setText("");
            PhoneNo.setText("");
            Status.setText("");
        }
        if (e.getSource() == Register){
            checkempty();
        }
    }

//    public static void main(String[] args) {
//        new RegisterCommunity();
//    }
}
