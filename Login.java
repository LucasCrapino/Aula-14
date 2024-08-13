import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JLabel screenName;
    private JLabel usernameLabel, passwordLabel;
    private JButton login;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            loginCheck();
        }
    }

    public Login() {
        super("Tela de login");

        screenName = new JLabel("Tela de Login");
        screenName.setOpaque(true);
        screenName.setBackground(Color.CYAN);
        screenName.setHorizontalAlignment(JLabel.CENTER);
        screenName.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        usernameLabel = new JLabel("Digite o usuário:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 20));

        passwordLabel = new JLabel("Digite a senha:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 20));

        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 20));
        login.addActionListener(this);

        
        Container box = getContentPane();
        box.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        box.add(screenName, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.anchor = GridBagConstraints.LINE_END;
        box.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0; 
        gbc.insets = new Insets(5, 0, 5, 20);
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        box.add(usernameTextField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0; 
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.anchor = GridBagConstraints.LINE_END;
        box.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0; 
        gbc.insets = new Insets(5, 0, 5, 20);
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        box.add(passwordTextField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        box.add(login, gbc);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void loginCheck(){
        String enteredUsername = usernameTextField.getText();
        String enteredPassword = new String(passwordTextField.getPassword());
        UsersCrudBD usersCrudBD = new UsersCrudBD();
        usersCrudBD.searchNamesAndPasswords(enteredUsername, enteredPassword);
    }

}