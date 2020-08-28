import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BooksInStore extends JFrame implements ActionListener {
    JFrame f;
    JPanel p0,p1,p2;
    JTextField Search;
    JButton Search1;
    JLabel label;
    static JTable table;

    final String url = "jdbc:h2:~/ngesumin";
    final String user = "brayo";
    final String password = "brayo";
    final String Driver = "org.h2.Driver";
    final String[] columnNames = {"BOOK TITLE", "BOOK TYPE", "AUTHOR", "SERIAL NUMBER", "YEAR"};

//    public static void main (String[] args){ new BooksInStore();}

    public BooksInStore() {
        createPanel();
        addComponentsToPanel();
        createTable();
        createFrame();
    }
    public void createFrame(){
        f = new JFrame("SEARCH DATABASE");
        f.setVisible(true);
        f.setLayout(new GridLayout());
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screensize.width, screensize.height);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.add(p0);
    }
        public void createPanel() {
            p0 = new JPanel(new GridLayout(0,2));
            p1 = new JPanel(new FlowLayout());
            p0.setVisible(true);
            p1.setVisible(true);
            p2 = new JPanel(new BorderLayout());
        }
        public void addComponentsToPanel() {
            Search = new JTextField();
            Search.setBounds(120, 30, 150, 20);
            label = new JLabel("ENTER BOOK TITLE: ");
            label.setBounds(10, 30, 100, 20);
            Search1 = new JButton("SEARCH");
            Search1.setBounds(120, 130, 150, 20);
            Search1.addActionListener(this);

            p1.add(label);
            p1.add(Search);
            p1.add(Search1);

            p2.setLocation(100,10);
            p2.setSize(1000,600);
            p2.setVisible(true);
            p2.setSize(400, 300);

            p0.add(p1);
            p0.add(p2);
        }
   public void createTable() {
        p2.setLayout(new BorderLayout());
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

        String BookTitle = Search.getText().toUpperCase();
        String BookType ;
        String Author ;
        String SerialNumber ;
        String Year ;
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from books where Book_title = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,BookTitle);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                BookType = rs.getString("book_type");
                Author = rs.getString("Author");
                SerialNumber = rs.getString("Serial_Number");
                Year = rs.getString("year");

                model.addRow(new Object[]{BookTitle, BookType, Author, SerialNumber, Year});
                ++i;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "SORRY, NO RECORD FOUND!");
            }
            if(i > 1){
                JOptionPane.showMessageDialog(null,i+" Records found");
            }
            if (i == 1){
               JOptionPane.showMessageDialog(null,i + " Record found");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        p2.add(scroll);
        }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()== Search1){
            createTable();
        }

    }
    }

