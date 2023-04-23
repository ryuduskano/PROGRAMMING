package javaacts;

	import javax.swing.*;
	import javax.swing.event.DocumentEvent;
	import javax.swing.event.DocumentListener;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

  public class PROGsystem {
	public class sign_up implements ActionListener {


	    JPanel panel = new JPanel();
	    JFrame frame = new JFrame();
	    JLabel started = new JLabel("Let's Get You Started...");
	    JLabel cinephil = new JLabel("CINEPHIL");
	    JTextField userInput = new JTextField(50);
	    JPasswordField passInput = new JPasswordField(50);
	    JPasswordField passConfirm = new JPasswordField(50);
	    JButton signup_button = new JButton("Sign up");
	    JLabel already = new JLabel("Already have an account?");
	    JButton login_button = new JButton("Log in here");
	    ImageIcon imageIcon = new ImageIcon("Sign_Up.png");
	    JLabel backgroundLabel = new JLabel(imageIcon);


	    public static String[] username = new String[500];
	    public static String[] password = new String[500];
	    int index = 0;

	    public void gui(){

	        frame.setSize(950, 520);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null);

	        cinephil.setBounds(100, 250, 400, 35);
	        cinephil.setFont(new Font("Rockwell", Font.BOLD, 35));
	        started.setBounds(490, 80, 410, 35);
	        started.setFont(new Font("Arial", Font.PLAIN, 35));

	        userInput.setBounds(560, 155, 250, 28);
	        passInput.setBounds(560, 200, 250, 28);
	        passConfirm.setBounds(560, 245, 250, 28);
	        signup_button.setBounds(620, 300, 100, 30);
	        login_button.setBounds(640, 368, 100, 15);

	        signup_button.addActionListener(this);
	        login_button.addActionListener(this);

	        already.setBounds(500, 370, 300, 10);
	        already.setFont(new Font("Arial", Font.PLAIN, 10));

	        panel.add(cinephil);
	        panel.add(started);
	        panel.add(userInput);
	        panel.add(passInput);
	        panel.add(passConfirm);
	        panel.add(signup_button);
	        panel.add(already);
	        panel.add(login_button);
	        panel.setLayout(new BorderLayout());
	        panel.add(backgroundLabel);
	        frame.add(panel);
	        frame.setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==signup_button){
	            Auth(username, password);
	        }
	        else{
	            log_in l = new log_in();
	            frame.setVisible(false);
	            frame.dispose();
	        }
	    }

	    public void Auth(String[] username, String[] password){
	        this.username = username;
	        this.password = password;
	        String userinput, userpass, userconfirm;
	        int i, valid = 0;

	        userinput = userInput.getText();
	        userpass = passInput.getText();
	        userconfirm = passConfirm.getText();

	        for(i = 0; i < username.length; i++){
	            if(userinput.equals(username[i])){
	                valid++;
	            }
	        }

	        if(valid!=0){
	            JOptionPane.showMessageDialog(null,"This username is already used");
	        }
	        else{
	            if(userconfirm.equals(userpass) && !userinput.isEmpty() && !userconfirm.isEmpty() && !userpass.isEmpty()){
	                JOptionPane.showMessageDialog(null, "Successfully signed up");
	                username[index] = userinput;
	                password[index] = userpass;
	                index++;
	            }
	            else if(userinput.isEmpty() || userconfirm.isEmpty() || userpass.isEmpty()){
	                JOptionPane.showMessageDialog(null, "Please fill up all fields");
	            }
	            else{
	                JOptionPane.showMessageDialog(null, "Password not matched");
	            }
	        }
	    }
	}

