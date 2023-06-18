package handlersys;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class frame1 extends JFrame implements ActionListener {

  private ImageIcon icon;
  private Container C;
  private JPanel pane1;
  //private JLabel userlabel1, userlabel2, userlabel3;
  private JLabel titleLabel, NameLabel, productlabel, pricelabel, idlabel;
  private JTextField nametf, pricetf, idtf, producttf;
  private JButton addButton, deleteButton, clearButton, updateButton,SaveButton;
  private Font h1f, h2f;
  private JTable table;
  private JScrollPane scroll;
  private DefaultTableModel model;
  private String[] columns = { "Name", "Product", "Price", "Id" };
  private String[] rows = new String[4];

  frame1() { // constructor
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(780, 690);
    this.setTitle("Money Handler System (BETA)");
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    initComponents2();
  }

  public void initComponents2() {
    C = getContentPane(); // Asigning content frame to C which is a object.
    C.setLayout(null); // setting to null because of manually setting the object in the frame
    C.setBackground(Color.DARK_GRAY); // set content frame background color

    h2f = new Font("Arial", Font.BOLD, 18); // creating font name,type,size
    h1f = new Font("Arial", Font.BOLD, 24);

    // creating img,icon object
    icon = new ImageIcon(getClass().getResource("app_icon.png")); // import icon , IMAGE

    this.setIconImage(icon.getImage()); // set icon to the app

    titleLabel = new JLabel("Money handler System");
    titleLabel.setFont(h1f);
    titleLabel.setBounds(140, 10, 400, 50); //done
    titleLabel.setForeground(Color.WHITE);
    C.add(titleLabel);

    NameLabel = new JLabel("  Name");
    NameLabel.setBounds(10 + 40, 80, 140, 30);
    NameLabel.setFont(h2f);
    NameLabel.setForeground(Color.WHITE);
    C.add(NameLabel);

    nametf = new JTextField();
    nametf.setBounds(110 + 25, 80, 200, 30);
    nametf.setFont(h2f);
    C.add(nametf);

    productlabel = new JLabel("Product");
    productlabel.setBounds(10 + 40, 130, 140, 30);
    productlabel.setFont(h2f);
    productlabel.setForeground(Color.WHITE);
    C.add(productlabel);

    producttf = new JTextField();
    producttf.setBounds(110 + 25, 130, 200, 30);
    producttf.setFont(h2f);
    C.add(producttf);

    pricelabel = new JLabel("   Price");
    pricelabel.setBounds(10 + 40, 180, 140, 30);
    pricelabel.setFont(h2f);
    pricelabel.setForeground(Color.WHITE);
    C.add(pricelabel);

    pricetf = new JTextField();
    pricetf.setBounds(110 + 25, 180, 200, 30);
    pricetf.setFont(h2f);
    C.add(pricetf);

    idlabel = new JLabel("      ID");
    idlabel.setBounds(10 + 40, 230, 140, 30);
    idlabel.setFont(h2f);
    idlabel.setForeground(Color.WHITE);
    C.add(idlabel);

    idtf = new JTextField();
    idtf.setBounds(110 + 25, 230, 200, 30);
    idtf.setFont(h2f);
    C.add(idtf);

    addButton = new JButton("Add");
    addButton.setBounds(400, 80, 100, 30);
    addButton.setFont(h2f);
    C.add(addButton);

    deleteButton = new JButton("Delete");
    deleteButton.setBounds(400, 130, 100, 30);
    deleteButton.setFont(h2f);
    C.add(deleteButton);

    clearButton = new JButton("Clear");
    clearButton.setBounds(400, 180, 100, 30);
    clearButton.setFont(h2f);
    C.add(clearButton);

    updateButton = new JButton("Update");
    updateButton.setBounds(400, 230, 100, 30);
    updateButton.setFont(h2f);
    C.add(updateButton);
    
    
    SaveButton = new JButton("SAVE");
    SaveButton.setBounds(320, 300, 100, 30);
    SaveButton.setFont(h2f);
    C.add(SaveButton);

    table = new JTable();

    model = new DefaultTableModel();
    model.setColumnIdentifiers(columns);
    table.setModel(model);
    table.setFont(h2f);
    table.setSelectionBackground(Color.GRAY);
    table.setBackground(Color.WHITE);
    table.setRowHeight(30);
    scroll = new JScrollPane(table);
    scroll.setBounds(10, 360, 740, 265);
    C.add(scroll);

    
    
    
      
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            String dbUrl = "jdbc:mysql://localhost/moneydb";    
            String dbUser = "root";
            String dbPass = "";
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            System.out.println("Connected to database successfully!");

            // Execute a query
            String sql = "SELECT * FROM `moneytable`";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            // Extract data from result set
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String product = resultSet.getString("Product");
                int price = resultSet.getInt("Price");
                String id = resultSet.getString("ID");
                
                rows[0] = name;
                rows[1] = product;
                rows[2] = Integer.toString(price);
                rows[3] = id;
                model.addRow(rows);
                
               //System.out.println("Name: " + name + ", Product: " + product+" Price: "+price+" ID: " +id);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    
    
    
    
    
    
    
    
    
    
    addButton.addActionListener(this);
    deleteButton.addActionListener(this);
    updateButton.addActionListener(this);
    clearButton.addActionListener(this);
    SaveButton.addActionListener(this);
    table.addMouseListener(
      new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          int numberofrow = table.getSelectedRow();
          String nameString = model.getValueAt(numberofrow, 0).toString();
          String producString = model.getValueAt(numberofrow, 1).toString();
          String priceString = model.getValueAt(numberofrow, 2).toString();
          String idString = model.getValueAt(numberofrow, 3).toString();

          nametf.setText(nameString);
          producttf.setText(producString);
          pricetf.setText(priceString);
          idtf.setText(idString);
        }
      }
    );
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addButton) {
      rows[0] = nametf.getText();
      rows[1] = producttf.getText();
      rows[2] = pricetf.getText();
      rows[3] = idtf.getText();
      model.addRow(rows);
    } 
    
    else if (e.getSource() == SaveButton) {

            System.out.println("Save Button Clicked");
            
            try {
                JTableSync.replaceTable(table);
                JOptionPane.showMessageDialog(null, "Saved Successful!!");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Save Unsuccessful!");

            }
        }
    
    
    else if (e.getSource() == clearButton) {
      nametf.setText("");
      producttf.setText("");
      pricetf.setText("");
      idtf.setText("");
    } else if (e.getSource() == deleteButton) {
      int numberofrow = table.getSelectedRow();
      if (numberofrow >= 0) {
        model.removeRow(numberofrow);
      } else {
        JOptionPane.showMessageDialog(null, "You didn't selected anything!");
      }
    } else if (e.getSource() == updateButton) {
      int numberOfrow = table.getSelectedRow();

      String namString = nametf.getText();
      String prodString = producttf.getText();
      String pricString = pricetf.getText();
      String idString = idtf.getText();

      model.setValueAt(namString, numberOfrow, 0);
      model.setValueAt(prodString, numberOfrow, 1);
      model.setValueAt(pricString, numberOfrow, 2);
      model.setValueAt(idString, numberOfrow, 3);
    }
  }
  
  public class JTableSync {
    private static final String DB_URL = "jdbc:mysql://localhost/moneydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String TABLE_NAME = "moneytable";
    private static final String[] COLUMN_NAMES = {"Name", "Product", "Price", "ID"};

    public static void replaceTable(JTable table) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Truncate the table to remove all existing data
            String truncateQuery = "TRUNCATE TABLE " + TABLE_NAME;
            try (PreparedStatement truncateStatement = conn.prepareStatement(truncateQuery)) {
                truncateStatement.executeUpdate();
            }

            // Insert the new data from the JTable into the table
            String insertQuery = "INSERT INTO " + TABLE_NAME + " (Name, Product, Price, ID) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    String name = model.getValueAt(i, 0).toString();
                    String product = model.getValueAt(i, 1).toString();
                    double price = Double.parseDouble(model.getValueAt(i, 2).toString());
                    String id = model.getValueAt(i, 3).toString();

                    insertStatement.setString(1, name);
                    insertStatement.setString(2, product);
                    insertStatement.setDouble(3, price);
                    insertStatement.setString(4, id);

                    insertStatement.executeUpdate();
                }
            }
        }
    }
}
    
    
    
  
  

  public static void main(String[] args) {
    frame1 frame = new frame1();
    frame.setVisible(true);
  }
}
