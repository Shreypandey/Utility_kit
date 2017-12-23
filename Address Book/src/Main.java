
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shrey Pandey
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        jScrollPane1.setVisible(false);
        jButton1.grabFocus();
        jLabel2.setVisible(false);
        jScrollPane2.setVisible(false);
        jTextField1.setVisible(false);
        saveb.setVisible(false);
        addb.setVisible(false);}
public void refresh(){
    jScrollPane1.setVisible(true) ; 
DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
       model.removeRow(i);
    }
try 
{ Class.forName("java.sql.DriverManager"); 
Connection con = (Connection)  DriverManager.getConnection ("jdbc:mysql://localhost:3306/address_book","root", "123");
 Statement stmt = (Statement) con.createStatement();
 String query="SELECT * FROM personal order by first_name,middle_name,last_name ;"; 
 ResultSet rs = stmt.executeQuery(query); 
 while(rs.next())  
 {     String Name   = rs.getString("First_Name")+ " "+rs.getString("Middle_Name")+" "+rs.getString("last_Name");
 String Mobile = rs.getString("Phone");
  model.addRow (new Object[] {Name, Mobile});   }    
 jTextField1.setVisible(true);jLabel2.setVisible(true);}   
catch (Exception e)  {    JOptionPane.showMessageDialog (this, e.getMessage());  }
/*int n=jTable1.getRowCount();
if(n<12)
{jScrollPane1.setSize(20, 50);jTable1.setSize(50, 50);}*/}
public void search(){
    String s=jTextField1.getText();
    jScrollPane1.setVisible(true) ; 
DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
       model.removeRow(i);
    }
try 
{ Class.forName("java.sql.DriverManager"); 
Connection con = (Connection)  DriverManager.getConnection ("jdbc:mysql://localhost:3306/address_book","root", "123");
 Statement stmt = (Statement) con.createStatement();
 String query="SELECT * FROM personal where first_name like '%"+s+"%' || middle_name like '%"+s+"%'|| last_name like '%"+s+"%' order by first_name,middle_name,last_name ;"; 
 ResultSet rs = stmt.executeQuery(query); 
 while(rs.next())  
 {     String Name   = rs.getString("First_Name")+ " "+rs.getString("Middle_Name")+" "+rs.getString("last_Name");
 String Mobile = rs.getString("Phone");
  model.addRow (new Object[] {Name, Mobile});   }    
  viewb.setVisible(true); }   
catch (Exception e)  {    JOptionPane.showMessageDialog (this, e.getMessage());  }

}    
 public void stat(){
     try 
    {String m ;
Class.forName("java.sql.DriverManager");
Connection con = (Connection)   DriverManager.getConnection ("jdbc:mysql://localhost:3306/address_book", "root", "123");
Statement stmt = (Statement) con.createStatement();  
String query="SELECT * FROM personal WHERE phone='"+pyx.b+"';";  
ResultSet rs=stmt.executeQuery(query);    
while(rs.next()) {
String first_name = rs.getString("First_Name"); firstname.setText(first_name);
String middle_name  = rs.getString("Middle_Name");middleName.setText(middle_name);
String last_name = rs.getString("Last_Name");      lastName.setText(last_name);
String Company_name = rs.getString("Company_Name");     companyName.setText(Company_name);
String Designation1 = rs.getString("Designation");     Designation.setText(Designation1);
String Website = rs.getString("Website");      website.setText(Website);Phone1.setText(pyx.b);
String bday= rs.getString("Birthday"),a,b,c; bday=bday.trim();a=bday.substring(0,2);b=bday.substring(3,5);c=bday.substring(6,10);
date.setValue(Integer.parseInt(a));month.setValue(Integer.parseInt(b));year.setValue(Integer.parseInt(c));
String Image = rs.getString("image");      
if("/images.jpg".equals(Image))
{image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpg"))); }
else {
    image.setIcon(new javax.swing.ImageIcon(Image));
}
}
String query4="SELECT * FROM phone WHERE Phone1='"+pyx.b+"';";  
ResultSet rs4=stmt.executeQuery(query4);
while(rs4.next()) {
String phone2 = rs4.getString("Phone2"),pty2 = rs4.getString("pty2");Phone7.setText(phone2);phtype6.setSelectedItem(pty2);
String phone3 = rs4.getString("Phone3"),pty3 = rs4.getString("pty3");Phone8.setText(phone3);phtype7.setSelectedItem(pty3);
String phone4 = rs4.getString("Phone4"),pty4 = rs4.getString("pty4");Phone2.setText(phone4);phtype1.setSelectedItem(pty4);
String phone5 = rs4.getString("Phone5"),pty5 = rs4.getString("pty5");Phone3.setText(phone5);phtype2.setSelectedItem(pty5);
String phone6 = rs4.getString("Phone6"),pty6 = rs4.getString("pty6");Phone4.setText(phone6);phtype3.setSelectedItem(pty6);
String phone7 = rs4.getString("Phone7"),pty7 = rs4.getString("pty7");Phone5.setText(phone7);phtype4.setSelectedItem(pty7);
String phone8 = rs4.getString("Phone8"),pty8 = rs4.getString("pty8");Phone6.setText(phone8);phtype5.setSelectedItem(pty8);
String phone9 = rs4.getString("Phone9"),pty9 = rs4.getString("pty9");Phone9.setText(phone9);phtype8.setSelectedItem(pty9);
}
String query1="SELECT * FROM email WHERE phone='"+pyx.b+"';";  
ResultSet rs1=stmt.executeQuery(query1);
while(rs1.next()) {
String email = rs1.getString("email1"),emailt = rs1.getString("ety1");email1.setText(email);phtype8.setSelectedItem(emailt);
String email2 = rs1.getString("email2"),email2t = rs1.getString("ety2");Email5.setText(email2);phtype8.setSelectedItem(email2t);
String email3= rs1.getString("email3"),email3t = rs1.getString("ety3");Email1.setText(email3);phtype8.setSelectedItem(email3t);
String email4 = rs1.getString("email4"),email4t = rs1.getString("ety4");Email2.setText(email4);phtype8.setSelectedItem(email4t);
String email5 = rs1.getString("email5"),email5t = rs1.getString("ety5");Email3.setText(email5);phtype8.setSelectedItem(email5t);
}
String query2="SELECT * FROM address WHERE phone='"+pyx.b+"';";  
ResultSet rs2=stmt.executeQuery(query2);
while(rs2.next()) {
String line1 = rs2.getString("line1");addline1.setText(line1);
String line2 = rs2.getString("line2");addline2.setText(line2);
String line3 = rs2.getString("line3");addline3.setText(line3);
String Country = rs2.getString("country");country.setText(Country);
String zipc1 = rs2.getString("zip_code");zipc.setText(zipc1);
String type = rs2.getString("type");addtype.setSelectedItem(type);

 }}
catch(Exception e) 
{ 
    JOptionPane.showMessageDialog(this, e.getMessage()); }
        String m;
  }
 String s,x="";
 /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        viewb = new javax.swing.JButton();
        removeB = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        middleName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        companyName = new javax.swing.JTextField();
        Designation = new javax.swing.JTextField();
        Phone1 = new javax.swing.JFormattedTextField();
        phtype = new javax.swing.JComboBox();
        Phone7 = new javax.swing.JFormattedTextField();
        phtype6 = new javax.swing.JComboBox();
        Phone8 = new javax.swing.JFormattedTextField();
        phtype7 = new javax.swing.JComboBox();
        Phone2 = new javax.swing.JFormattedTextField();
        Phone3 = new javax.swing.JFormattedTextField();
        Phone4 = new javax.swing.JFormattedTextField();
        Phone5 = new javax.swing.JFormattedTextField();
        Phone6 = new javax.swing.JFormattedTextField();
        Phone9 = new javax.swing.JFormattedTextField();
        phtype1 = new javax.swing.JComboBox();
        phtype2 = new javax.swing.JComboBox();
        phtype3 = new javax.swing.JComboBox();
        phtype4 = new javax.swing.JComboBox();
        phtype8 = new javax.swing.JComboBox();
        phtype5 = new javax.swing.JComboBox();
        email1 = new javax.swing.JTextField();
        mailtype = new javax.swing.JComboBox();
        Email5 = new javax.swing.JTextField();
        mailtype4 = new javax.swing.JComboBox();
        Email1 = new javax.swing.JTextField();
        mailtype1 = new javax.swing.JComboBox();
        Email2 = new javax.swing.JTextField();
        mailtype2 = new javax.swing.JComboBox();
        Email3 = new javax.swing.JTextField();
        mailtype3 = new javax.swing.JComboBox();
        addline1 = new javax.swing.JTextField();
        addline2 = new javax.swing.JTextField();
        addline3 = new javax.swing.JTextField();
        country = new javax.swing.JTextField();
        zipc = new javax.swing.JFormattedTextField();
        addtype = new javax.swing.JComboBox();
        website = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        date = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        month = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        year = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saveb = new javax.swing.JButton();
        addb = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(Main.MAXIMIZED_BOTH);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });
        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusGained(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone"
            }
        ));
        jTable1.setCellSelectionEnabled(true);
        jTable1.setRowHeight(50);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 580, 610));

        jTextField1.setToolTipText("Search Any Contact");
        jTextField1.setOpaque(false);
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 580, 40));

        jLabel2.setBackground(new java.awt.Color(20, 67, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shrey Pandey\\Downloads\\search.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 55, 40));

        add.setBackground(new java.awt.Color(153, 153, 255));
        add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add Contact");
        add.setToolTipText("Click to refresh");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 155, 200, 40));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Refresh");
        jButton1.setToolTipText("Click to refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 200, 40));

        viewb.setBackground(new java.awt.Color(153, 153, 255));
        viewb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewb.setForeground(new java.awt.Color(255, 255, 255));
        viewb.setText("Edit Contact");
        viewb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbActionPerformed(evt);
            }
        });
        getContentPane().add(viewb, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 245, 200, 40));

        removeB.setBackground(new java.awt.Color(153, 153, 255));
        removeB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeB.setForeground(new java.awt.Color(255, 255, 255));
        removeB.setText("Remove Contact");
        removeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBActionPerformed(evt);
            }
        });
        getContentPane().add(removeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 290, 200, 40));

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 720, 200, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("CONTACTS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 350, 70));

        jScrollPane2.setOpaque(false);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpg"))); // NOI18N
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 290));

        firstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstname.setForeground(new java.awt.Color(153, 153, 153));
        firstname.setText("First Name");
        firstname.setEnabled(false);
        firstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstnameFocusLost(evt);
            }
        });
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 190, 40));

        middleName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        middleName.setForeground(new java.awt.Color(153, 153, 153));
        middleName.setText("Middle Name");
        middleName.setEnabled(false);
        middleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                middleNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                middleNameFocusLost(evt);
            }
        });
        jPanel1.add(middleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 190, 40));

        lastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastName.setForeground(new java.awt.Color(153, 153, 153));
        lastName.setText("Last Name");
        lastName.setEnabled(false);
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameFocusLost(evt);
            }
        });
        jPanel1.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 170, 40));

        companyName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        companyName.setForeground(new java.awt.Color(153, 153, 153));
        companyName.setText("Company Name");
        companyName.setEnabled(false);
        companyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                companyNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                companyNameFocusLost(evt);
            }
        });
        jPanel1.add(companyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 550, 40));

        Designation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Designation.setForeground(new java.awt.Color(153, 153, 153));
        Designation.setText("Designation");
        Designation.setEnabled(false);
        Designation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DesignationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DesignationFocusLost(evt);
            }
        });
        jPanel1.add(Designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, 40));

        Phone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone1.setEnabled(false);
        Phone1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone1CaretUpdate(evt);
            }
        });
        Phone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone1KeyPressed(evt);
            }
        });
        jPanel1.add(Phone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 220, 40));

        phtype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype.setEnabled(false);
        jPanel1.add(phtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 140, 40));

        Phone7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone7.setEnabled(false);
        Phone7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone7.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone7CaretUpdate(evt);
            }
        });
        Phone7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone7KeyPressed(evt);
            }
        });
        jPanel1.add(Phone7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 220, 40));

        phtype6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype6.setEnabled(false);
        jPanel1.add(phtype6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 140, 40));

        Phone8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone8.setEnabled(false);
        Phone8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone8.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone8CaretUpdate(evt);
            }
        });
        Phone8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone8KeyPressed(evt);
            }
        });
        jPanel1.add(Phone8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 220, 40));

        phtype7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype7.setEnabled(false);
        jPanel1.add(phtype7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 610, 140, 40));

        Phone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone2.setEnabled(false);
        Phone2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone2CaretUpdate(evt);
            }
        });
        Phone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone2KeyPressed(evt);
            }
        });
        jPanel1.add(Phone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 220, 40));

        Phone3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone3.setEnabled(false);
        Phone3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone3CaretUpdate(evt);
            }
        });
        Phone3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone3KeyPressed(evt);
            }
        });
        jPanel1.add(Phone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 220, 40));

        Phone4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone4.setEnabled(false);
        Phone4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone4.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone4CaretUpdate(evt);
            }
        });
        Phone4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone4KeyPressed(evt);
            }
        });
        jPanel1.add(Phone4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 220, 40));

        Phone5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone5.setEnabled(false);
        Phone5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone5.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone5CaretUpdate(evt);
            }
        });
        Phone5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone5KeyPressed(evt);
            }
        });
        jPanel1.add(Phone5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 810, 220, 40));

        Phone6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone6.setEnabled(false);
        Phone6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone6.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone6CaretUpdate(evt);
            }
        });
        Phone6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone6KeyPressed(evt);
            }
        });
        jPanel1.add(Phone6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 860, 220, 40));

        Phone9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Phone9.setEnabled(false);
        Phone9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone9.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Phone9CaretUpdate(evt);
            }
        });
        Phone9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone9KeyPressed(evt);
            }
        });
        jPanel1.add(Phone9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 910, 220, 40));

        phtype1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype1.setEnabled(false);
        jPanel1.add(phtype1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 140, 40));

        phtype2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype2.setEnabled(false);
        jPanel1.add(phtype2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 710, 140, 40));

        phtype3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype3.setEnabled(false);
        jPanel1.add(phtype3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 760, 140, 40));

        phtype4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype4.setEnabled(false);
        jPanel1.add(phtype4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 810, 140, 40));

        phtype8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype8.setEnabled(false);
        jPanel1.add(phtype8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 910, 140, 40));

        phtype5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phtype5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mobile", "Work", "Home", "Main", "Pager", "Other" }));
        phtype5.setEnabled(false);
        jPanel1.add(phtype5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 860, 140, 40));

        email1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        email1.setForeground(new java.awt.Color(153, 153, 153));
        email1.setText("someone@example.com");
        email1.setEnabled(false);
        email1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                email1CaretUpdate(evt);
            }
        });
        email1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                email1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                email1FocusLost(evt);
            }
        });
        jPanel1.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 990, 350, 40));

        mailtype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mailtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Work", "Home", "Other" }));
        mailtype.setEnabled(false);
        jPanel1.add(mailtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 990, 140, 40));

        Email5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Email5.setForeground(new java.awt.Color(153, 153, 153));
        Email5.setText("someone@example.com");
        Email5.setEnabled(false);
        Email5.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Email5CaretUpdate(evt);
            }
        });
        Email5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Email5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Email5FocusLost(evt);
            }
        });
        jPanel1.add(Email5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1040, 350, 40));

        mailtype4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mailtype4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Work", "Home", "Other" }));
        mailtype4.setEnabled(false);
        jPanel1.add(mailtype4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 1040, 140, 40));

        Email1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Email1.setForeground(new java.awt.Color(153, 153, 153));
        Email1.setText("someone@example.com");
        Email1.setEnabled(false);
        Email1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Email1CaretUpdate(evt);
            }
        });
        Email1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Email1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Email1FocusLost(evt);
            }
        });
        jPanel1.add(Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1090, 350, 40));

        mailtype1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mailtype1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Work", "Home", "Other" }));
        mailtype1.setEnabled(false);
        jPanel1.add(mailtype1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 1090, 140, 40));

        Email2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Email2.setForeground(new java.awt.Color(153, 153, 153));
        Email2.setText("someone@example.com");
        Email2.setEnabled(false);
        Email2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Email2CaretUpdate(evt);
            }
        });
        Email2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Email2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Email2FocusLost(evt);
            }
        });
        jPanel1.add(Email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1140, 350, 40));

        mailtype2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mailtype2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Work", "Home", "Other" }));
        mailtype2.setEnabled(false);
        jPanel1.add(mailtype2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 1140, 140, 40));

        Email3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Email3.setForeground(new java.awt.Color(153, 153, 153));
        Email3.setText("someone@example.com");
        Email3.setEnabled(false);
        Email3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Email3CaretUpdate(evt);
            }
        });
        Email3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Email3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Email3FocusLost(evt);
            }
        });
        jPanel1.add(Email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1190, 350, 40));

        mailtype3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mailtype3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Work", "Home", "Other" }));
        mailtype3.setEnabled(false);
        jPanel1.add(mailtype3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 1190, 140, 40));

        addline1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addline1.setForeground(new java.awt.Color(153, 153, 153));
        addline1.setText("Address Line 1");
        addline1.setEnabled(false);
        addline1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addline1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addline1FocusLost(evt);
            }
        });
        jPanel1.add(addline1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1270, 550, 40));

        addline2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addline2.setForeground(new java.awt.Color(153, 153, 153));
        addline2.setText("Address Line 2");
        addline2.setEnabled(false);
        addline2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addline2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addline2FocusLost(evt);
            }
        });
        jPanel1.add(addline2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1320, 550, 40));

        addline3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addline3.setForeground(new java.awt.Color(153, 153, 153));
        addline3.setText("Address Line 3");
        addline3.setEnabled(false);
        addline3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addline3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addline3FocusLost(evt);
            }
        });
        jPanel1.add(addline3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1370, 550, 40));

        country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        country.setForeground(new java.awt.Color(153, 153, 153));
        country.setText("Country");
        country.setEnabled(false);
        country.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                countryCaretUpdate(evt);
            }
        });
        country.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                countryFocusLost(evt);
            }
        });
        jPanel1.add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1420, 250, 40));

        zipc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        zipc.setEnabled(false);
        zipc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(zipc, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1420, 160, 40));

        addtype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Home", "Work" }));
        addtype.setEnabled(false);
        jPanel1.add(addtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1420, 120, 40));

        website.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        website.setEnabled(false);
        jPanel1.add(website, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1500, 470, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("Date");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1580, 50, 40));

        date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        date.setEnabled(false);
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1580, 70, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("Month");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 1580, 50, 40));

        month.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        month.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        month.setEnabled(false);
        month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                monthMousePressed(evt);
            }
        });
        month.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monthStateChanged(evt);
            }
        });
        month.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                monthFocusGained(evt);
            }
        });
        month.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                monthKeyPressed(evt);
            }
        });
        jPanel1.add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 1580, 70, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Year");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1580, 50, 40));

        year.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        year.setModel(new javax.swing.SpinnerNumberModel(2000, 1900, 2017, 1));
        year.setEnabled(false);
        year.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearMouseClicked(evt);
            }
        });
        year.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                yearStateChanged(evt);
            }
        });
        jPanel1.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1580, 70, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Birthday");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1540, 220, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Address");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1230, 220, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Website");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1460, 220, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 950, 220, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Phone");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 220, 40));

        saveb.setBackground(new java.awt.Color(153, 153, 255));
        saveb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        saveb.setForeground(new java.awt.Color(255, 255, 255));
        saveb.setText("Save");
        saveb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebActionPerformed(evt);
            }
        });
        jPanel1.add(saveb, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 290, 270, 40));

        addb.setBackground(new java.awt.Color(153, 153, 255));
        addb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addb.setForeground(new java.awt.Color(255, 255, 255));
        addb.setText("Add/Replace Image");
        addb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbActionPerformed(evt);
            }
        });
        jPanel1.add(addb, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 280, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shrey Pandey\\Downloads\\wallpaper-spectrum-blue-desktop-media.jpg")); // NOI18N
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 1440));

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 580, 610));

        jLabel1.setBackground(new java.awt.Color(102, 146, 221));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shrey Pandey\\Downloads\\backround-03.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
search();  
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
  jTextField1.setOpaque(true);
  jTextField1.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
    jTextField1.setOpaque(false);   
    jTextField1.setBackground(new java.awt.Color(20, 67, 255));
    }//GEN-LAST:event_jTextField1FocusLost

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
new new_cont().setVisible(true);  

    }//GEN-LAST:event_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
refresh();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbActionPerformed

       // int row_index;row_index=jTable1.getSelectedRow();
//pyx.a=(String) jTable1.getModel().getValueAt(row_index, 0);  
//pyx.b=(String) jTable1.getModel().getValueAt(row_index, 1);
 addb.setVisible(true);
     Designation.setEnabled(true);
     Phone1.setEnabled(true);
     addline1.setEnabled(true);
     addline2.setEnabled(true);
     addline3.setEnabled(true);
     addtype.setEnabled(true);
     companyName.setEnabled(true);
     country.setEnabled(true);
     date.setEnabled(true);
     email1.setEnabled(true);
     firstname.setEnabled(true);
     lastName.setEnabled(true);
     mailtype.setEnabled(true);
     middleName.setEnabled(true);
     month.setEnabled(true);
     website.setEnabled(true);
     year.setEnabled(true);
     zipc.setEnabled(true);
     //editb.setVisible(false);
     saveb.setVisible(true);
     phtype.setEnabled(true);
     Phone7.setEnabled(true);phtype6.setEnabled(true);
     Phone8.setEnabled(true);phtype7.setEnabled(true);
     Phone2.setEnabled(true);phtype1.setEnabled(true);
     Phone3.setEnabled(true);phtype2.setEnabled(true);
     Phone4.setEnabled(true);phtype3.setEnabled(true);
     Phone5.setEnabled(true);phtype4.setEnabled(true);
     Phone6.setEnabled(true);phtype5.setEnabled(true);
     Phone9.setEnabled(true);phtype8.setEnabled(true);
     Email5.setEnabled(true);mailtype4.setEnabled(true);
     Email1.setEnabled(true);mailtype1.setEnabled(true);
     Email2.setEnabled(true);mailtype2.setEnabled(true);
     Email3.setEnabled(true);mailtype3.setEnabled(true);
 
    }//GEN-LAST:event_viewbActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
int row_index;row_index=jTable1.getSelectedRow();
pyx.a=(String) jTable1.getModel().getValueAt(row_index, 0);  
pyx.b=(String) jTable1.getModel().getValueAt(row_index, 1);
stat();jScrollPane2.setVisible(true);
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 int row_index;row_index=jTable1.getSelectedRow();
pyx.a=(String) jTable1.getModel().getValueAt(row_index, 0);  
pyx.b=(String) jTable1.getModel().getValueAt(row_index, 1);
stat();
    }//GEN-LAST:event_jTable1MouseClicked

    private void removeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBActionPerformed
       int row_index;row_index=jTable1.getSelectedRow();String a,b;
      a=(String) jTable1.getModel().getValueAt(row_index, 0); b=(String) jTable1.getModel().getValueAt(row_index, 1);
  try 
{ Class.forName("java.sql.DriverManager"); 
Connection con = (Connection)  DriverManager.getConnection ("jdbc:mysql://localhost:3306/address_book","root", "123");
 Statement stmt = (Statement) con.createStatement();
 String query1="Delete from personal where phone='"+b+"' ;";
stmt.execute(query1);
String query2="Delete from phone where phone1='"+b+"' ;";
stmt.execute(query2);
String query3="Delete from address where phone='"+b+"' ;";
stmt.execute(query3);
String query4="Delete from email where phone='"+b+"' ;";
stmt.execute(query4);
}   
  catch(Exception e)  {    JOptionPane.showMessageDialog (this, e.getMessage());  }
  refresh();
    }//GEN-LAST:event_removeBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int i;
      i=  JOptionPane.showConfirmDialog(this, "Sure to Exit","Confirm",JOptionPane.YES_NO_OPTION);
if(i==0){System.exit(0);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
refresh();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void firstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusGained
        if ("First Name".equals(firstname.getText()))
        {   firstname.setForeground(new java.awt.Color(0,0,0));
            firstname.setText(""); }
    }//GEN-LAST:event_firstnameFocusGained

    private void firstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusLost
        if ("".equals(firstname.getText())){firstname.setForeground(new java.awt.Color(153,153,153));
            firstname.setText("First Name");}
    }//GEN-LAST:event_firstnameFocusLost

    private void middleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middleNameFocusGained
        if ("Middle Name".equals(middleName.getText()))
        {   middleName.setForeground(new java.awt.Color(0,0,0));
            middleName.setText(""); }        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameFocusGained

    private void middleNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middleNameFocusLost
        if ("".equals(middleName.getText())){middleName.setForeground(new java.awt.Color(153,153,153));
            middleName.setText("Middle Name");}        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameFocusLost

    private void lastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusGained
        if ("Last Name".equals(lastName.getText()))
        {   lastName.setForeground(new java.awt.Color(0,0,0));
            lastName.setText(""); }             // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFocusGained

    private void lastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusLost
        if ("".equals(lastName.getText())){lastName.setForeground(new java.awt.Color(153,153,153));
            lastName.setText("First Name");}        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFocusLost

    private void companyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companyNameFocusGained
        if ("Company Name".equals(companyName.getText()))
        {   companyName.setForeground(new java.awt.Color(0,0,0));
            companyName.setText(""); }              // TODO add your handling code here:
    }//GEN-LAST:event_companyNameFocusGained

    private void companyNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companyNameFocusLost
        if ("".equals(companyName.getText())){companyName.setForeground(new java.awt.Color(153,153,153));
            companyName.setText("Company Name");}
    }//GEN-LAST:event_companyNameFocusLost

    private void DesignationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DesignationFocusGained
        if ("Designation".equals(Designation.getText()))
        {   Designation.setForeground(new java.awt.Color(0,0,0));
            Designation.setText(""); }        // TODO add your handling code here:
    }//GEN-LAST:event_DesignationFocusGained

    private void DesignationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DesignationFocusLost
        if ("".equals(Designation.getText())){Designation.setForeground(new java.awt.Color(153,153,153));
            Designation.setText("Designation");}
    }//GEN-LAST:event_DesignationFocusLost

    private void Phone1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone1CaretUpdate
    //    int a=phoney.getY(),i=1;
    //    if("".equals(Phone1.getText())){phoney.setLocation(0, 540);}
    //    else{  phoney.setLocation(0, 600);
    //    }
    }//GEN-LAST:event_Phone1CaretUpdate

    private void Phone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone1KeyPressed

    }//GEN-LAST:event_Phone1KeyPressed

    private void Phone7CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone7CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone7CaretUpdate

    private void Phone7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone7KeyPressed

    private void Phone8CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone8CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone8CaretUpdate

    private void Phone8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone8KeyPressed

    private void Phone2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone2CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone2CaretUpdate

    private void Phone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone2KeyPressed

    private void Phone3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone3CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone3CaretUpdate

    private void Phone3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone3KeyPressed

    private void Phone4CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone4CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone4CaretUpdate

    private void Phone4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone4KeyPressed

    private void Phone5CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone5CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone5CaretUpdate

    private void Phone5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone5KeyPressed

    private void Phone6CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone6CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone6CaretUpdate

    private void Phone6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone6KeyPressed

    private void Phone9CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Phone9CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone9CaretUpdate

    private void Phone9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Phone9KeyPressed

    private void email1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_email1CaretUpdate
   //     int a=emaily.getY();
   //     if("someone@example.com".equals(email1.getText())||"".equals(email1.getText())){emaily.setLocation(0, 60);}
   //     else{  emaily.setLocation(0, 60+60);}
    }//GEN-LAST:event_email1CaretUpdate

    private void email1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusGained
        if ("someone@example.com".equals(email1.getText()))
        {   email1.setForeground(new java.awt.Color(0,0,0));
            email1.setText(""); }       // TODO add your handling code here:
    }//GEN-LAST:event_email1FocusGained

    private void email1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusLost
        if ("".equals(email1.getText())){email1.setForeground(new java.awt.Color(153,153,153));
            email1.setText("someone@example.com");}      // TODO add your handling code here:
    }//GEN-LAST:event_email1FocusLost

    private void Email5CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Email5CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Email5CaretUpdate

    private void Email5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email5FocusGained
        if ("someone@example.com".equals(Email5.getText()))
        {   Email5.setForeground(new java.awt.Color(0,0,0));
            Email5.setText(""); }        // TODO add your handling code here:
    }//GEN-LAST:event_Email5FocusGained

    private void Email5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Email5FocusLost

    private void Email1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Email1CaretUpdate
        //int a=emaily.getY();
        //      if("someone@example.com".equals(Email1.getText())||"".equals(Email1.getText())){emaily.setLocation(0, 60);}
        //else{  emaily.setLocation(0, 60+60);}
    }//GEN-LAST:event_Email1CaretUpdate

    private void Email1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email1FocusGained
        if ("someone@example.com".equals(Email1.getText()))
        {   addline3.setForeground(new java.awt.Color(0,0,0));
            addline3.setText(""); }    // TODO add your handling code here:
    }//GEN-LAST:event_Email1FocusGained

    private void Email1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email1FocusLost
        if ("".equals(Email1.getText())){Email1.setForeground(new java.awt.Color(153,153,153));
            Email1.setText("someone@example.com");}      // TODO add your handling code here:
    }//GEN-LAST:event_Email1FocusLost

    private void Email2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Email2CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Email2CaretUpdate

    private void Email2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email2FocusGained
        if ("someone@example.com".equals(Email2.getText()))
        {   Email2.setForeground(new java.awt.Color(0,0,0));
            Email2.setText(""); }      // TODO add your handling code here:
    }//GEN-LAST:event_Email2FocusGained

    private void Email2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Email2FocusLost

    private void Email3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Email3CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Email3CaretUpdate

    private void Email3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email3FocusGained
        if ("someone@example.com".equals(Email3.getText()))
        {   Email3.setForeground(new java.awt.Color(0,0,0));
            Email3.setText(""); }     // TODO add your handling code here:
    }//GEN-LAST:event_Email3FocusGained

    private void Email3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Email3FocusLost

    private void addline1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addline1FocusGained
        if ("Address Line 1".equals(addline1.getText()))
        {   addline1.setForeground(new java.awt.Color(0,0,0));
            addline1.setText(""); }
    }//GEN-LAST:event_addline1FocusGained

    private void addline1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addline1FocusLost
        if ("".equals(addline1.getText())){addline1.setForeground(new java.awt.Color(153,153,153));
            addline1.setText("Address Line 1");}
    }//GEN-LAST:event_addline1FocusLost

    private void addline2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addline2FocusGained
        if ("Address Line 2".equals(addline2.getText()))
        {   addline2.setForeground(new java.awt.Color(0,0,0));
            addline2.setText(""); }
    }//GEN-LAST:event_addline2FocusGained

    private void addline2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addline2FocusLost
        if ("".equals(addline2.getText())){addline2.setForeground(new java.awt.Color(153,153,153));
            addline2.setText("Address Line 2");}
    }//GEN-LAST:event_addline2FocusLost

    private void addline3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addline3FocusGained
        if ("Address Line 3".equals(addline3.getText()))
        {   addline3.setForeground(new java.awt.Color(0,0,0));
            addline3.setText(""); }
    }//GEN-LAST:event_addline3FocusGained

    private void addline3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addline3FocusLost
        if ("".equals(addline3.getText())){addline3.setForeground(new java.awt.Color(153,153,153));
            addline3.setText("Address Line 3");}
    }//GEN-LAST:event_addline3FocusLost

    private void countryCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_countryCaretUpdate

    }//GEN-LAST:event_countryCaretUpdate

    private void countryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryFocusGained
        if ("Country".equals(country.getText()))
        {   country.setForeground(new java.awt.Color(0,0,0));
            country.setText(""); }
    }//GEN-LAST:event_countryFocusGained

    private void countryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryFocusLost
        if ("".equals(country.getText())){country.setForeground(new java.awt.Color(153,153,153));
            country.setText("Country");}
    }//GEN-LAST:event_countryFocusLost

    private void monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMouseClicked

    }//GEN-LAST:event_monthMouseClicked

    private void monthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMousePressed

    }//GEN-LAST:event_monthMousePressed

    private void monthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monthStateChanged
    //    dateChooserSetter();        // TODO add your handling code here:
    }//GEN-LAST:event_monthStateChanged

    private void monthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_monthFocusGained

    }//GEN-LAST:event_monthFocusGained

    private void monthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthKeyPressed

    }//GEN-LAST:event_monthKeyPressed

    private void yearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearMouseClicked

    }//GEN-LAST:event_yearMouseClicked

    private void yearStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_yearStateChanged
   //     dateChooserSetter();        // TODO add your handling code here:
    }//GEN-LAST:event_yearStateChanged

    private void jScrollPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusGained
stat();  jScrollPane2.setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1FocusGained

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
stat(); jScrollPane2.setVisible(true);             // TODO add your handling code here:
    }//GEN-LAST:event_jTable1FocusGained

    private void addbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbActionPerformed
int returnVal = jFileChooser1.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = jFileChooser1.getSelectedFile();
        try {s= file.getAbsolutePath();
        int a,n=1;String temp,temp1=s;
        a=s.length();
        while(a>0){
            temp=temp1.toString().substring(0,1);
            temp1=temp1.toString().substring( 1);
            if("\\".equals(temp))
            {temp="/";}
            x=x+temp;a--;
        }
        System.out.print(x);
         image.setIcon(new javax.swing.ImageIcon(s)); 
        } catch (Exception ex) {
          System.out.println("problem accessing file"+file.getAbsolutePath());
        }
    } else {
        System.out.println("File access cancelled by user.");
    }
    
    }//GEN-LAST:event_addbActionPerformed

    private void savebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebActionPerformed
 String a=month.getValue().toString(),b=date.getValue().toString();
String firstn,middlen,lastn,company,designation,phone1,addressl1,addressl2,addressl3,coun,zic,addtyp,websit,dob,email2,email3,email4,email5,email,phone2,phone3,phone4,phone5,phone6,phone7,phone8,phone9;
String ptype1,ptype2,ptype3,ptype4,ptype5,ptype6,ptype7,ptype8,ptype9,etype1,etype2,etype3,etype4,etype5;
firstn=firstname.getText();middlen=middleName.getText();lastn=lastName.getText();
phone3=Phone8.getText();ptype3=phtype7.getSelectedItem().toString();
phone5=Phone3.getText();ptype5=phtype2.getSelectedItem().toString();
phone6=Phone4.getText();ptype6=phtype3.getSelectedItem().toString();
phone7=Phone5.getText();ptype7=phtype4.getSelectedItem().toString();
phone1=Phone1.getText();ptype1=phtype.getSelectedItem().toString();
phone4=Phone2.getText();ptype4=phtype1.getSelectedItem().toString();
phone8=Phone6.getText();ptype8=phtype5.getSelectedItem().toString();
phone9=Phone9.getText();ptype9=phtype8.getSelectedItem().toString();
phone2=Phone7.getText();ptype2=phtype6.getSelectedItem().toString();
email2=Email5.getText();etype2=mailtype3.getSelectedItem().toString();
email3=Email1.getText();etype3=mailtype4.getSelectedItem().toString();
email4=Email2.getText();etype4=mailtype.getSelectedItem().toString();
email5=Email3.getText();etype5=mailtype1.getSelectedItem().toString();
email=email1.getText();etype1=mailtype2.getSelectedItem().toString();
company=companyName.getText();designation=Designation.getText();
addressl1=addline1.getText();addressl2=addline2.getText();addressl3=addline3.getText();coun=country.getText();addtyp=(addtype.getSelectedItem()).toString();zic=zipc.getText();
if ("First Name".equals(firstn)){firstn="";}
if ("Middle Name".equals(middlen)){middlen="";}
if ("Last Name".equals(lastn)){lastn="";}
if ("Company Name".equals(company)){company="";}
if ("Designation".equals(designation)){designation="";}
if ("someone@example.com".equals(email2)){email2="";}
if ("someone@example.com".equals(email3)){email3="";}
if ("someone@example.com".equals(email4)){email4="";}
if ("someone@example.com".equals(email5)){email5="";}
if ("someone@example.com".equals(email)){email="";}
if ("Address Line 1".equals(addressl1)){addressl1="";}
if ("Address Line 2".equals(addressl2)){addressl2="";}
if ("Address Line 3".equals(addressl3)){addressl3="";}
if ("Country".equals(coun)){coun="";}
if(a.length()==1){a="0"+a;}
if(b.length()==1){b="0"+b;}
dob=(b+"/"+a+"/"+year.getValue());websit=website.getText();
try{    Class.forName("java.sql.DriverManager");   
Connection con = (Connection)   DriverManager.getConnection ("jdbc:mysql://localhost:3306/address_book","root","123");
Statement stmt = (Statement) con.createStatement(); 
if("".equals(x)){x="/images.jpg";}
String query1="Update personal set First_name='"+firstn+"',Middle_Name='"+middlen+"',Last_Name='"+lastn+"',Company_Name='"+company+"',Designation='"+designation+"',Website='"+websit+"',Birthday='"+dob+"',image='"+x+"',phone='"+phone1+"' where phone='"+pyx.b+"';";
String query2="Update phone set First_name='"+firstn+"',Middle_Name='"+middlen+"',Last_Name='"+lastn+"',Phone1='"+phone1+"',Phone2='"+phone2+"',Phone3='"+phone3+"',Phone4='"+phone4+"',Phone5='"+phone5+"',Phone6='"+phone6+"',Phone7='"+phone7+"',Phone8='"+phone8+"',Phone9='"+phone9+"',pty1='"+ptype3+"',pty2='"+ptype5+"',pty3='"+ptype6+"',pty4='"+ptype7+"',pty5='"+ptype1+"',pty6='"+ptype4+"',pty7='"+ptype8+"',pty8='"+ptype9+"',pty9='"+ptype2+"' where Phone1='"+pyx.b+"';";
String query3="Update email set First_name='"+firstn+"',Middle_Name='"+middlen+"',Last_Name='"+lastn+"',email1='"+email+"',email2='"+email2+"',email3='"+email3+"',email4='"+email4+"',email5='"+email5+"',phone='"+phone1+"',ety1='"+etype2+"',ety2='"+etype3+"',ety3='"+etype4+"',ety4='"+etype5+"',ety5='"+etype1+"' where phone='"+pyx.b+"';";
String query4="Update address set First_name='"+firstn+"',Middle_Name='"+middlen+"',Last_Name='"+lastn+"',line1='"+addressl1+"',line2='"+addressl2+"',line3='"+addressl3+"',country='"+coun+"',zip_code='"+zic+"',type='"+addtyp+"',phone='"+phone1+"' where phone='"+pyx.b+"';";
stmt.executeUpdate(query1);stmt.executeUpdate(query2);stmt.executeUpdate(query3); stmt.executeUpdate(query4);
}
catch(Exception e)  {   JOptionPane.showMessageDialog (this, e.getMessage());  }
refresh();
    }//GEN-LAST:event_savebActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Designation;
    private javax.swing.JTextField Email1;
    private javax.swing.JTextField Email2;
    private javax.swing.JTextField Email3;
    private javax.swing.JTextField Email5;
    private javax.swing.JFormattedTextField Phone1;
    private javax.swing.JFormattedTextField Phone2;
    private javax.swing.JFormattedTextField Phone3;
    private javax.swing.JFormattedTextField Phone4;
    private javax.swing.JFormattedTextField Phone5;
    private javax.swing.JFormattedTextField Phone6;
    private javax.swing.JFormattedTextField Phone7;
    private javax.swing.JFormattedTextField Phone8;
    private javax.swing.JFormattedTextField Phone9;
    private javax.swing.JButton add;
    private javax.swing.JButton addb;
    private javax.swing.JTextField addline1;
    private javax.swing.JTextField addline2;
    private javax.swing.JTextField addline3;
    private javax.swing.JComboBox addtype;
    private javax.swing.JTextField companyName;
    private javax.swing.JTextField country;
    private javax.swing.JSpinner date;
    private javax.swing.JTextField email1;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lastName;
    private javax.swing.JComboBox mailtype;
    private javax.swing.JComboBox mailtype1;
    private javax.swing.JComboBox mailtype2;
    private javax.swing.JComboBox mailtype3;
    private javax.swing.JComboBox mailtype4;
    private javax.swing.JTextField middleName;
    private javax.swing.JSpinner month;
    private javax.swing.JComboBox phtype;
    private javax.swing.JComboBox phtype1;
    private javax.swing.JComboBox phtype2;
    private javax.swing.JComboBox phtype3;
    private javax.swing.JComboBox phtype4;
    private javax.swing.JComboBox phtype5;
    private javax.swing.JComboBox phtype6;
    private javax.swing.JComboBox phtype7;
    private javax.swing.JComboBox phtype8;
    private javax.swing.JButton removeB;
    private javax.swing.JButton saveb;
    private javax.swing.JButton viewb;
    private javax.swing.JTextField website;
    private javax.swing.JSpinner year;
    private javax.swing.JFormattedTextField zipc;
    // End of variables declaration//GEN-END:variables
}
