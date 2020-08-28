import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class RegisterStudentGUI extends JFrame implements ActionListener {
    final JFrame f = new JFrame("REGISTER STUDENT");
    JPanel p1;
    final JPanel p2;
    final JPanel p0;
    final JPanel p3 = new JPanel();
    final JTextField fname;
    final JTextField sname;
    final JTextField surname;
    final JTextField studentID;
    JComboBox <String> classlist;
    JComboBox <String> status;
    final JButton register;
    final JButton reset;
    final JButton home;
    final JButton Logout;
    final JButton delete;
    static JTable table;

    Connection conn = null;
    final String Driver = "org.h2.Driver";
    final String username = "brayo";
    final String password = "brayo";
    final String url = "jdbc:h2:~/ngesumin;IFEXISTS=TRUE";
    PreparedStatement addStudent = null;
    final String[] columnNames = {"STUDENT ID", "FIRST NAME", "SECOND NAME", "SURNAME", "CLASS", "STATUS"};
    final String [] classes = {"1 WEST","1 EAST","2 WEST","2 EAST","3 WEST","3 EAST","4 WEST","4 EAST"};
    final String [] Status = {"GOOD","DEFAULTER"};

    public RegisterStudentGUI() {
        p0 = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        p1 = new JPanel(new GridLayout(4, 0));
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
        p1.setLayout(new GridLayout(7, 0));
        p1.setBackground(Color.GRAY);
        p1.setVisible(true);
        p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        p2.setBackground(new Color(0, 0, 49));
        p2.setVisible(true);

        JLabel l4 = new JLabel("STUDENT ID: ");
        studentID = new JTextField();
        studentID.setEditable(true);
        p1.add(l4);
        p1.add(studentID);

        JLabel l1 = new JLabel("FIRST NAME: ");
        fname = new JTextField();
        fname.setEditable(true);
        p1.add(l1);
        p1.add(fname);

        JLabel l2 = new JLabel("SECOND NAME: ");
        sname = new JTextField();
        sname.setEditable(true);
        p1.add(l2);
        p1.add(sname);

        JLabel l3 = new JLabel("SURNAME: ");
        surname = new JTextField();
        surname.setEditable(true);
        p1.add(l3);
        p1.add(surname);

        JLabel l6 = new JLabel("STATUS: ");
        status = new JComboBox<>(Status);
        p1.add(l6);
        p1.add(status);

        JLabel l5 = new JLabel("CLASS: ");
        classlist = new JComboBox<>(classes);
        p1.add(l5);
        p1.add(classlist);

        register = new JButton("REGISTER");
        reset = new JButton("RESET");
        delete=new JButton("DELETE USER");
        home = new JButton("HOME");
        Logout = new JButton("LOGOUT");

        home.setFont(new Font("Algerian", Font.BOLD, 15));
        home.setForeground(new Color(155, 17, 30));
        register.setFont(new Font("Algerian", Font.BOLD, 15));
        register.setForeground(new Color(155, 17, 30));
        reset.setFont(new Font("Algerian", Font.BOLD, 15));
        reset.setForeground(new Color(155, 17, 30));
        Logout.setFont(new Font("Algerian", Font.BOLD, 15));
        Logout.setForeground(new Color(155, 17, 30));
        delete.setFont(new Font("Algerian", Font.BOLD, 15));
        delete.setForeground(new Color(155, 17, 30));

        register.addActionListener(this);
        reset.addActionListener(this);
        home.addActionListener(this);
        Logout.addActionListener(this);
        delete.addActionListener(this);
        classlist.getSelectedItem();
        status.getSelectedItem();


        GridBagConstraints d = new GridBagConstraints();
        d.weightx = 0;
        d.weighty = 10;
        d.anchor = GridBagConstraints.CENTER;
        d.fill = GridBagConstraints.CENTER;
        d.gridheight = 20;
        d.gridwidth = 20;
        d.ipady = 20;
        d.ipadx = 20;
        p2.add(register, d);
        p2.add(reset, d);
        p2.add(delete,d);
        p2.add(home, d);
        p2.add(Logout, d);

        Border border1 = BorderFactory.createEtchedBorder(new Color(155, 17, 30), new Color(0, 0, 49));
        p0.setBorder(border1);
        Border border2 = BorderFactory.createLineBorder(new Color(155, 17, 30), 2);
        p2.setBorder(border2);
        Border border3 = BorderFactory.createEtchedBorder(new Color(155, 17, 30), new Color(8));
        p1.setBorder(border3);

        p3.setLayout(new BorderLayout());
        Border border4 = BorderFactory.createLineBorder(new Color(0, 0, 49), 2);
        p3.setBorder(border4);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionAllowed(true);
        table.setBackground(Color.GRAY);
        table.getSelectedRow();
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String StudentID;
        String fname;
        String sname;
        String surname;
        String status;
        String form;
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while
            (rs.next()) {
                StudentID = rs.getString("ID");
                fname = rs.getString("First_Name");
                sname = rs.getString("Second_Name");
                surname = rs.getString("Surname");
                form = rs.getString("Class");
                status = rs.getString("Status");

                model.addRow(new Object[]{StudentID, fname, sname, surname, form, status});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        p3.add(scroll);

        p0.add(p1, c);
        p0.add(p2, c);
        f.setVisible(true);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screensize.width, screensize.height);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(1, 2));
        f.setResizable(false);
        f.add(p0);
        f.add(p3);

    }
    public void checkempty(){
        if ((surname.getText().trim().equals("")) || (fname.getText().trim().equals("")) || (sname.getText().trim().equals("")) || (studentID.getText().trim().equals(""))/*||(form.getText().trim().equals(""))||(status.getText().trim().equals(""))*/) {
            JOptionPane.showMessageDialog(null,"ALL FIELDS MUST BE ENTERED!");
        }else {
            register();
        }
    }
    public void register() {
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, username, password);
            addStudent = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
            addStudent.setString(1, studentID.getText().toUpperCase());
            addStudent.setString(2, fname.getText().toUpperCase());
            addStudent.setString(3, sname.getText().toUpperCase());
            addStudent.setString(4, surname.getText().toUpperCase());
            addStudent.setString(5, (String) classlist.getSelectedItem());
            addStudent.setString(6, (String) status.getSelectedItem());
            addStudent.setInt(7, 0);

            addStudent.executeUpdate();
            JOptionPane.showMessageDialog(null, "STUDENT SUCCESSFULLY REGISTERED!");
            f.dispose();
            new RegisterStudentGUI();

        } catch (SQLException | ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "SORRY,STUDENT IS ALREADY REGISTERED.");
            //ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            f.dispose();
            new community();
        }
        if (e.getSource()==delete){
        try {
            int row = table.getSelectedRow();
            String idd = (String) table.getModel().getValueAt(row,0);
            String delRow = "delete from student where id = '"+idd+"'";
                Class.forName(Driver);
                conn = DriverManager.getConnection(url, username, password);
               PreparedStatement del = conn.prepareStatement(delRow);
                del.executeUpdate();
                JOptionPane.showMessageDialog(null, "STUDENT SUCCESSFULLY DELETED!");
                f.dispose();
                new RegisterStudentGUI();

            } catch (SQLException | ClassNotFoundException | IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "ROW TO BE DELETED HAS NOT BEEN SELECTED.");
                //ex.printStackTrace();
            }
        }
        if (e.getSource() == Logout) {
            f.dispose();
            new LoginGUI();
        }
        if (e.getSource() == reset) {
            fname.setText("");
            sname.setText("");
            surname.setText("");
            studentID.setText("");
        }
        if (e.getSource() == register) {
            checkempty();
        }
        }
//        public static void main (String[]args){
//            new RegisterStudentGUI();
//        }
    }


