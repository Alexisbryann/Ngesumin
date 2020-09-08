import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class LoginGUI extends JFrame implements ActionListener {
    // variables declaration
    JFrame f;
    JTextField Username,Password;
    JButton Login,Reset,Quit;
    JPanel cp,cp1,cp2,cp3;
    JCheckBox showPassword;
    JLabel welcome;
    JLabel username = new JLabel("USERNAME:");
    JLabel password =new JLabel("PASSWORD: ");
    //ImageIcon icon = new ImageIcon("D:NGESUMIN.png");

    public LoginGUI() {
        // creating JPanel containers cp and cp1
        cp = new JPanel();
        cp.setLayout(new FlowLayout());
        cp.setBackground(Color.GRAY);
        cp2 = new JPanel();
        cp2.setLayout(new FlowLayout());
        cp2.setBackground(new Color(0,0,49));
        cp2.setVisible(true);
        cp1 = new JPanel();
        cp1.setLayout(new FlowLayout());
        cp1.setBackground(new Color(0,0,49));
        cp3= new JPanel();
        cp3.setLayout(new FlowLayout());
        cp3.setBackground(Color.GRAY);
        cp3.setVisible(true);

        //Declaring & adding JLabels,JTextFields and JPasswords to JPanel cp
        welcome = new JLabel("NGESUMIN GIRLS SECONDARY SCHOOL");
        welcome.setFont(new Font("algerian",Font.BOLD,25));
        welcome.setForeground(new Color(0,0,49));
        cp3.add(welcome);

        cp.add(username);//Adding label to the Username field
        username.setVerticalTextPosition(3);
        username.setFont(new Font("algerian",Font.BOLD,15));
        Username = new JTextField(15);//creating a new JTextField for Username
        Username.setEditable(true);//declaring JTextField field as editable
        cp.add(Username);//adding Username to the panel cp

        //Adding label to the password field
        cp.add(password);
        password.setFont(new Font("algerian",Font.BOLD,15));
        Password = new JPasswordField(15);//creating a new JPassword field
        Password.setEditable(true);//declaring JPassword field as editable
        cp.add(Password);//adding password to the panel cp

        // Button components
        cp2.add(showPassword = new JCheckBox ("show password"));//adding & declaring show password
        showPassword.setBackground(new Color(0,0,49));
        showPassword.setForeground(new Color(155,17,30));
        showPassword.setFont(new Font("algerian",Font.BOLD,15));
        showPassword.addActionListener(this);//Action listener for JCheckBox show password

        cp1.add(Login = new JButton ("LOGIN"));//adding & declaring Login Button in JPanel cp1
        Login.setFont(new Font("algerian",Font.BOLD,20));
        Login.setForeground(new Color(155,17,30));
        Login.addActionListener(this);//action listener to for the Login Button

        cp1.add(Reset = new JButton ("RESET"));//adding & declaring Reset Button in JPanel cp1
        Reset.setFont(new Font("algerian", Font.BOLD,20));
        Reset.setForeground(new Color(155,17,30));
        Reset.addActionListener(this);//action listener for the Reset Button

        cp1.add(Quit = new JButton("QUIT"));
        Quit.setFont(new Font("algerian",Font.BOLD,20));
        Quit.setForeground(new Color(155,17,30));
        Quit.addActionListener(this);

        f= new JFrame ("NGSS LIBRARY MANAGEMENT SYSTEM"); //Overall window
//        f.setForeground(new Color(212,175,55));
        f.setSize(500,300);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setBackground(Color.DARK_GRAY);
        f.setLayout(new GridLayout(4,0));
        f.add(cp3);
        f.add(cp);
        f.add(cp2);
        f.add(cp1);
        f.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) { //action events for the 3 buttons

        if (e.getSource() == Login) { // conditions for Login button
            String Uname = Username.getText();//captures and stores JTextFields Username input
            String paswd = Password.getText();//captures and stores JPassword input
            if (Uname.equalsIgnoreCase("Ngesumin") && paswd.equalsIgnoreCase("Ngesumin123")) {//condition equating password and Username fields
                f.dispose();
                new Home();//opens a new frame called Entry

            }else {
                JOptionPane.showMessageDialog(null, "Wrong Password/Username");//Message dialog pops up
            }
            f.dispose();
        }
        if (e.getSource() == Reset) { //conditions for reset button
            Username.setText("");//resets username JTextField
            Password.setText("");//resets password JPassword field
        }
        if (e.getSource() == showPassword) { // conditions for showpassword
            if (showPassword.isSelected()) {
                ((JPasswordField) Password).setEchoChar((char) 0);// displays JPassword as char
            }else {
                ((JPasswordField) Password).setEchoChar('*');//displays JPassword as *
            }
        }
        if (e.getSource()==Quit){
            f.dispose();
        }
    }
    public static void main(String[] args) { //main method where the program runs from
        //thread
        // Let the constructor do the job
        SwingUtilities.invokeLater(LoginGUI::new);

    }

}
