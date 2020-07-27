import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterTeacherGUI extends Frame implements ActionListener{
    JFrame f = new JFrame("REGISTER TEACHER");
    JPanel j0 ;
    JPanel j1 = new JPanel();
    JPanel j2 = new JPanel();
    JPanel j3 = new JPanel();
    static JTable table;
    JTextField Fname,Sname,Surname,TSCno,PhoneNo,Status;
    JButton Register = new JButton ("REGISTER");
    JButton Reset = new JButton("RESET");
    JButton Logout = new JButton ("LOGOUT");
    JButton Home = new JButton ("HOME");
    JButton delete = new JButton("DELETE TEACHER");

    Connection conn = null;
    String url = "jdbc:h2:~/ngesumin";
    String user = "brayo";
    String password = "brayo";
    String Driver = "org.h2.Driver";
    PreparedStatement insertNewTeacher = null;
    String [] columnNames ={"TSC NUMBER","FIRST NAME","SECOND NAME","SURNAME","PHONE NO","STATUS",};

    public RegisterTeacherGUI() {

        j0 = new JPanel(new GridBagLayout());
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

        j1.setLayout(new GridLayout(7, 0));
        j1.setBackground(Color.GRAY);
        j1.setVisible(true);


        JLabel l4 = new JLabel("TSC NUMBER:");
        TSCno = new JTextField();
        TSCno.setEditable(true);
        j1.add(l4);
        j1.add(TSCno);

        JLabel l1 = new JLabel("FIRST NAME: ");
        Fname = new JTextField();
        Fname.setEditable(true);
        j1.add(l1);
        j1.add(Fname);

        JLabel l2 = new JLabel("SECOND NAME: ");
        Sname = new JTextField();
        Sname.setEditable(true);
        j1.add(l2);
        j1.add(Sname);

        JLabel l3 = new JLabel("SURNAME: ");
        Surname = new JTextField();
        Surname.setEditable(true);
        j1.add(l3);
        j1.add(Surname);

        JLabel l5 = new JLabel("PHONE NUMBER: ");
        PhoneNo = new JTextField();
        PhoneNo.setEditable(true);
        j1.add(l5);
        j1.add(PhoneNo);

        JLabel l6 = new JLabel("STATUS: ");
        Status = new JTextField("GOOD");
        Status.setEditable(false);
        j1.add(l6);
        j1.add(Status);

        j2.setLayout(new GridBagLayout());
        j2.setBackground(new Color(0,0,49));
        GridBagConstraints d = new GridBagConstraints();
        d.weightx = 0;
        d.weighty = 10;
        d.anchor = GridBagConstraints.CENTER;
        d.fill=GridBagConstraints.CENTER;
        d.gridheight = 20;
        d.gridwidth = 20;
        d.ipady=20;
        d.ipadx=20;
        j2.add(Register,d);
        j2.add(Reset,d);
        j2.add(delete,d);
        j2.add(Home,d);
        j2.add(Logout,d);

        Register.addActionListener(this);
        Reset.addActionListener(this);
        Logout.addActionListener(this);
        delete.addActionListener(this);
        Home.addActionListener(this);

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

        Border border1 = BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(0,0,49));
        j0.setBorder(border1);
        Border border2 = BorderFactory.createLineBorder(new Color(155,17,30),2);
        j2.setBorder(border2);
        Border border3=BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(8));
        j1.setBorder(border3);
        j0.add(j1,c);
        j0.add(j2,c);

        j3.setLayout(new BorderLayout());
        Border border4 = BorderFactory.createLineBorder(new Color(0,0,49),2);
        j3.setBorder(border4);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionAllowed(true);
        table.getSelectedRow();
        table.setBackground(Color.GRAY);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String TscNo ;
        String fname ;
        String sname;
        String surname ;
        String PhoneNo;
        String Status ;
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from teacher";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while
            (rs.next()) {
                TscNo = rs.getString("ID");
                fname = rs.getString("First_Name");
                sname = rs.getString("Second_Name");
                surname = rs.getString("Surname");
                PhoneNo = rs.getString("Phone_Number");
                Status = rs.getString("Status");

                model.addRow(new Object[]{TscNo,fname,sname,surname,PhoneNo,Status});
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        j3.add(scroll);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screensize.width,screensize.height);
        f.setLayout (new GridLayout(0,2));
        f.setResizable(false);
        f.add(j0);
        f.add(j3);
        f.setVisible(true);

    }
    public void Register(){
            {
                try {
                    Class.forName(Driver);
                    conn = DriverManager.getConnection(url, user, password);
                    insertNewTeacher = conn.prepareStatement("INSERT INTO teacher VALUES (?,?,?,?,?,?,?)");

                    insertNewTeacher.setString(1,TSCno.getText().toUpperCase());
                    insertNewTeacher.setString(2,Fname.getText().toUpperCase());
                    insertNewTeacher.setString(3,Sname.getText().toUpperCase());
                    insertNewTeacher.setString(4,Surname.getText().toUpperCase());
                    insertNewTeacher.setString(5,PhoneNo.getText().toUpperCase());
                    insertNewTeacher.setString(6,Status.getText().toUpperCase());
                    insertNewTeacher.setInt(7,0);

                    insertNewTeacher.executeUpdate();
                    JOptionPane.showMessageDialog(null,"TEACHER REGISTERED!");
                    f.dispose();
                    new RegisterTeacherGUI();
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"SORRY, TSC NO: '" + TSCno.getText()+"' \n IS ALREADY REGISTERED.");
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
    }
    public void checkempty(){
        if ((Surname.getText().trim().equals("")) || (Fname.getText().trim().equals("")) || (Sname.getText().trim().equals("")) || (TSCno.getText().trim().equals(""))||(PhoneNo.getText().trim().equals(""))||(Status.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null,"ALL FIELDS MUST BE ENTERED!");
        }else {
            Register();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==Logout){
            f.dispose();
            new LoginGUI();
        }
        if (e.getSource()==delete){
            try {
            int row = table.getSelectedRow();
            String idd = (String) table.getModel().getValueAt(row,0);
            String delRow = "delete from teacher where id = '"+idd+"'";

                Class.forName(Driver);
                conn = DriverManager.getConnection(url, user, password);
                PreparedStatement DeleteTeacher = conn.prepareStatement(delRow);

                DeleteTeacher.executeUpdate();
                JOptionPane.showMessageDialog(null, "TEACHER SUCCESSFULLY DELETED!");
                f.dispose();
                new RegisterTeacherGUI();
            }
            catch (SQLException | ClassNotFoundException | ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "ROW TO BE DELETED HAS NOT BEEN SELECTED.");
               //ex.printStackTrace();
            }
        }
        if (e.getSource()==Register){
            checkempty();
        }
        if (e.getSource()==Reset){
            Fname.setText("");
            Sname.setText("");
            Surname.setText("");
            TSCno.setText("");
            PhoneNo.setText("");
        }
        if (e.getSource()==Home){
            f.dispose();
            new community();
        }
    }
    public static void main(String[] args){
        new RegisterTeacherGUI();
    }

}
