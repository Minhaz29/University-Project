package handlersys;

//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginframe extends JFrame {

  private ImageIcon icon, cover;
  private Container C;
  private JLabel userlabel1, userlabel2, userlabel3;
  private JLabel imgLabel;
  private JTextField tf1;
  // private JTextField tf2;
  private JPasswordField passf;
  private JButton btn1, btn2;
  private Cursor cursorhand;

  private Font h1f, h2f, h3f, h4f;

  loginframe() { // constructor
    initComponents();
  }

  public void initComponents() {
    C = getContentPane(); // Asigning content frame to C which is a object.
    C.setLayout(null); // setting to null because of manually setting the object in the frame

    h2f = new Font("Arial", Font.BOLD, 18); // creating font name,type,size
    h1f = new Font("Arial", Font.BOLD, 24);
    h3f = new Font("Georgia", Font.BOLD, 20);
    h4f = new Font("Georgia", Font.BOLD, 13);

    C.setBackground(Color.DARK_GRAY); // set content frame background color

    // creating img,icon object
    icon = new ImageIcon(getClass().getResource("app_icon.png")); // import icon , IMAGE
    cover = new ImageIcon(getClass().getResource("Money Handler (2).png")); // setting background Cover of the
    // content frame
    this.setIconImage(icon.getImage()); // set icon to the app
    imgLabel = new JLabel(cover);

    // Creating JLabel
    userlabel1 = new JLabel(); // created JLabel object
    userlabel2 = new JLabel(" To Begin Enter your Username: "); // set text Jlabel
    userlabel3 = new JLabel("                   Enter your Password: ");
    userlabel1.setText(
      " Welcome to The World's Best Personal Fiancial App. :,)"
    );

    userlabel1.setFont(h1f); // set font to object
    userlabel2.setFont(h2f);
    userlabel3.setFont(h2f);

    userlabel1.setForeground(Color.black); // set font color

    userlabel1.setOpaque(true); // Enabling font background
    userlabel2.setOpaque(true);
    userlabel3.setOpaque(true);

    userlabel1.setBackground(Color.white); // setting font background color
    userlabel2.setBackground(Color.white);
    userlabel3.setBackground(Color.white);
    // userlabel3.setBackground(Color.CYAN);
    // userlabel3.setBackground(Color.CYAN);

    // creating JtextField, JPassField, JButton, cursor
    cursorhand = new Cursor(Cursor.HAND_CURSOR);

    tf1 = new JTextField();
    tf1.setFont(h2f);
    // tf1.setCursor(cursor2);
    // tf2 = new JTextField();
    passf = new JPasswordField();
    passf.setEchoChar('*');
    passf.setFont(h3f);

    // Reset Password
    btn1 = new JButton("Reset Password");
    btn1.setFont(h4f);
    btn1.setForeground(Color.BLACK);
    btn1.setBackground(Color.WHITE);
    btn1.setCursor(cursorhand);

    // Set Account
    btn2 = new JButton("Create new Account");
    btn2.setFont(h4f);
    btn2.setForeground(Color.BLACK);
    btn2.setBackground(Color.WHITE);
    btn2.setCursor(cursorhand);

    // setting Location
    userlabel1.setBounds(20, 40, 637, 30); // setting location of the Jlabel textfield
    userlabel2.setBounds(50 + 85, 310 + 60, 290, 30);
    userlabel3.setBounds(50 + 85, 350 + 60, 290, 30);
    imgLabel.setBounds(0, 0, cover.getIconWidth(), cover.getIconHeight());
    // imgLabel.setBounds(10, 10, cover.getIconWidth(),cover.getIconHeight());
    // imgLabel.setBounds(0, 0, 690,280);
    tf1.setBounds(355 + 85, 310 + 60, 290, 30);
    tf1.setHorizontalAlignment(JTextField.CENTER);
    passf.setBounds(355 + 85, 350 + 60, 290, 30);
    passf.setHorizontalAlignment(JPasswordField.CENTER);
    // tf2.setBounds(355 + 85, 350 + 60, 290, 30);
    // tf2.setHorizontalAlignment(JTextField.CENTER);
    btn1.setBounds(20, 100, 160, 25);
    btn2.setBounds(190, 100, 190, 25);

    // action listener
    tf1.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String S = tf1.getText();
          if (S.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter name");
          } else {
            passf.requestFocusInWindow();
          }
        }
      }
    );

    passf.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          char[] passwordChars = passf.getPassword();
          String S1 = new String(passwordChars);
          String S = tf1.getText();

          if (S1.isEmpty() || S.isEmpty()) {
            JOptionPane.showMessageDialog(
              null,
              "Please Enter Password or Username"
            );
          } else if (S.equals("Sabbir") && S1.equals("abc")) {
            dispose();
            frame1 frame = new frame1();
            frame.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Incorrect password or Username"
            );
          }
        }
      }
    );

    btn1.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(null, "You resetted your password");
        }
      }
    );

    btn2.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(null, "Created Account");
        }
      }
    );

    C.add(userlabel1); // show the text in the content frame
    C.add(userlabel2);
    C.add(userlabel3);
    C.add(btn1);
    C.add(btn2);

    C.add(imgLabel);
    C.add(tf1);
    C.add(passf);
    // C.add(tf2);

  }

  public static void main(String[] args) {
    loginframe frame = new loginframe();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setSize(704, 440);
    frame.setSize(920, 518);
    frame.setTitle("Money Handler System (BETA)");
    frame.setResizable(false);
  }
}
