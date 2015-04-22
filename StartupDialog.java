package ChatClient;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    StartupDialog

    A custom dialog box to allow users to setup a new connection configuration.

*/
public class StartupDialog extends JDialog {

    private JButton jButton1;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,15}$";
    private Matcher matcher;
    private Pattern pattern;
    public boolean canceled;

    public StartupDialog(JFrame parent) {
        super(parent, true);
        initComponents(parent);
    }

    private void initComponents(JFrame parent) {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jButton1 = new JButton();
        jButton3 = new JButton();
        canceled = false;
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setTitle("New Connection");
        setResizable(false);

        jLabel1.setText("Host:");
        jLabel2.setText("Port:");
        jLabel3.setText("Username:");
        jTextField1.setText("0.0.0.0");
        jTextField2.setText("8000");
        jButton1.setText("Connect");
        jButton3.setText("Cancel");

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt){
                canceled = true;
            }   
        });
        
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(jTextField3.getText());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                matcher = pattern.matcher(jTextField3.getText());

                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Username must be 3-15 characters long and may consist of letters, numbers, underscores, and hyphens.",
                            "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
                    jTextField3.setText("");
                }
                else {
                    dispose();
                }
            }
        });
        
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceled = true;
                dispose();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
        getRootPane().setDefaultButton(jButton1);
        jButton1.requestFocus();
        setVisible(true);
    }


    public String getHost() { return this.jTextField1.getText(); }
    public String getUsername() { return this.jTextField3.getText(); }
    public int getPort() { return Integer.parseInt(this.jTextField2.getText()); }

}


