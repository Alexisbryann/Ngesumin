import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.DriverManager;

public class RegisterBookGUI extends JFrame implements ActionListener {
    JFrame f = new JFrame("REGISTER BOOK");
    JPanel p1,p0;
    JPanel p2 = new JPanel(new FlowLayout());
    JPanel p3 = new JPanel(new GridLayout(4,0));
    JPanel p4 = new JPanel();
    JTextField BookTitle,Author,SerialNumber,Year;
    ButtonGroup BookType;
    static JTable table;
    JButton Register = new JButton("REGISTER");
    JButton Home = new JButton("HOME");
    JButton Logout = new JButton("LOGOUT");
    JButton Reset = new JButton("RESET");
    JButton delete = new JButton("DELETE BOOK");


    Connection conn = null;
    String Driver = "org.h2.Driver";
    String url = "jdbc:h2:~/ngesumin;IFEXISTS=TRUE";
    String user = "brayo";
    String password = "brayo";
    PreparedStatement addNewBook = null;
    String[] columnNames = {"BOOK TITLE", "BOOK TYPE", "AUTHOR", "SERIAL NUMBER", "YEAR"};

    public RegisterBookGUI() {

        p1 = new JPanel(new GridLayout(4, 0));
        p1.setBackground(Color.GRAY);
        p2.setBackground(new Color(0, 0, 49));
        p3.setBackground(Color.GRAY);
        p4.setForeground(Color.GRAY);
        p0 = new JPanel(new GridBagLayout());
        p0.setBackground(Color.GRAY);
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


        JLabel l1 = new JLabel("BOOK TITLE: ");
        BookTitle = new JTextField();
        BookTitle.setEditable(true);
        p1.add(l1);
        p1.add(BookTitle);

        JLabel l2 = new JLabel("AUTHOR: ");
        Author = new JTextField();
        Author.setEditable(true);
        p1.add(l2);
        p1.add(Author);

        p1.add(new JLabel("SERIAL NO: "));
        SerialNumber = new JTextField();
        SerialNumber.setEditable(true);
        p1.add(SerialNumber);

        p1.add(new JLabel("YEAR: "));
        Year = new JTextField(4);
        Year.setEditable(true);
        p1.add(Year);

        Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(155, 17, 30)), "BOOK TYPE");
        p3.setBorder(border);
        BookType = new ButtonGroup();
        JRadioButton j1 = new JRadioButton("COURSE BOOK");
        j1.setActionCommand("COURSE BOOK");
        j1.setOpaque(false);
        p3.add(j1);
        BookType.add(j1);
        JRadioButton j2 = new JRadioButton("REFERENCE BOOK");
        j2.setActionCommand("REFERENCE BOOK");
        j2.setOpaque(false);
        p3.add(j2);
        BookType.add(j2);
        JRadioButton j3 = new JRadioButton("SET BOOK");
        j3.setActionCommand("SET BOOK");
        j3.setOpaque(false);
        p3.add(j3);
        BookType.add(j3);
        JRadioButton j4 = new JRadioButton("REVISION BOOK");
        j4.setActionCommand("REVISION BOOK");
        j4.setOpaque(false);
        p3.add(j4);
        BookType.add(j4);

        Home.setFont(new Font("Algerian", Font.BOLD, 18));
        Home.setForeground(new Color(155, 17, 30));
        Register.setFont(new Font("Algerian", Font.BOLD, 18));
        Register.setForeground(new Color(155, 17, 30));
        Reset.setFont(new Font("Algerian", Font.BOLD, 18));
        Reset.setForeground(new Color(155, 17, 30));
        Logout.setFont(new Font("Algerian", Font.BOLD, 18));
        Logout.setForeground(new Color(155, 17, 30));
        delete.setFont(new Font("Algerian", Font.BOLD, 18));
        delete.setForeground(new Color(155, 17, 30));

        Border border1 = BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(0,0,49));
        p0.setBorder(border1);
        Border border2 = BorderFactory.createLineBorder(new Color(155,17,30),2);
        p2.setBorder(border2);
        Border border3=BorderFactory.createEtchedBorder(new Color(155,17,30),new Color(8));
        p1.setBorder(border3);
        p4.setLayout(new BorderLayout());
        Border border4 = BorderFactory.createLineBorder(new Color(0,0,49),2);
        p4.setBorder(border4);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String BookTitle;
        String BookType;
        String Author;
        String SerialNumber;
        String Year;
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from books";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while
            (rs.next()) {
                BookTitle = rs.getString("book_title").toUpperCase();
                BookType = rs.getString("Book_type").toUpperCase();
                Author = rs.getString("Author").toUpperCase();
                SerialNumber = rs.getString("Serial_Number").toUpperCase();
                Year = rs.getString("Year").toUpperCase();

                model.addRow(new Object[]{BookTitle, BookType, Author, SerialNumber, Year});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        p4.add(scroll);

        p2.add(Register);
        Register.addActionListener(this);
        p2.add(Reset);
        Reset.addActionListener(this);
        p2.add(delete);
        delete.addActionListener(this);
        p2.add(Home);
        Home.addActionListener(this);
        p2.add(Logout);
        Logout.addActionListener(this);


        Border border5 = BorderFactory.createEtchedBorder(new Color(155, 17, 30), new Color(0, 0, 49));
        p0.setBorder(border5);
        p0.setSize(200, 200);

        p0.add(p1, c);
        p0.add(p3, c);
        p0.add(p2, c);

        f.setLayout(new GridLayout(0, 2));
        f.setResizable(false);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screensize.width, screensize.height);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(p0);
        f.add(p4);

        f.setVisible(true);
    }
        public void Register(){
            try {
                Class.forName(Driver);
                conn = DriverManager.getConnection(url, user, password);
                addNewBook = conn.prepareStatement("INSERT into books values(?,?,?,?,?)");

                addNewBook.setString(1, BookTitle.getText().toUpperCase());
                addNewBook.setString(2, Author.getText().toUpperCase());
                addNewBook.setString(3, SerialNumber.getText().toUpperCase());
                addNewBook.setString(4, Year.getText().toUpperCase());
                addNewBook.setString(5, BookType.getSelection().getActionCommand().toUpperCase());

                addNewBook.executeUpdate();
                JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULLY!");
                f.dispose();
                new RegisterBookGUI();
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "SORRY, '" + BookTitle.getText() + "' OF SERIAL NUMBER \n '" + SerialNumber.getText() + "' HAS ALREADY BEEN ENTERED.");
            } catch (NullPointerException ed) {
                JOptionPane.showMessageDialog(null, "YOU MUST MAKE A BOOK TYPE SELECTION!");
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
        public void checkempty(){
            if ((BookTitle.getText().trim().equals("")) || (Author.getText().trim().equals("")) || (SerialNumber.getText().trim().equals("")) || (Year.getText().trim().equals(""))) {
                JOptionPane.showMessageDialog(null,"ALL FIELDS MUST BE ENTERED!");
            }else {
                Register();
            }
        }
        public void actionPerformed (ActionEvent e) {

            if (e.getSource()==delete){
                try {
                    int row = table.getSelectedRow();
                    String idd = (String) table.getModel().getValueAt(row,0);
                    String delRow = "delete from book where id = '"+idd+"'";

                    Class.forName(Driver);
                    conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement DeleteTeacher = conn.prepareStatement(delRow);

                    DeleteTeacher.executeUpdate();
                    JOptionPane.showMessageDialog(null, "BOOK SUCCESSFULLY DELETED!");
                    f.dispose();
                    new RegisterTeacherGUI();
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
            if (e.getSource() == Home) {
                f.dispose();
                new community();
            }
            if (e.getSource() == Reset) {
                BookTitle.setText("");
                Author.setText("");
                SerialNumber.setText("");
                Year.setText("");
                BookType.clearSelection();
            }
            if (e.getSource() == Register) {
                {
                    checkempty();
                }
            }
        }
//    public static void main(String[] args){
//        new RegisterBookGUI();
//    }
}
