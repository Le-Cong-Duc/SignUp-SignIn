package SignUp;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;
import JDBC.ConnectionJDBC;
import Model.Users;
import SignIn.SignIn;

public class SignUp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Le Cong Duc");
		setSize(609, 417);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		java.net.URL logo = SignIn.class.getResource("1.png");
		Image image = Toolkit.getDefaultToolkit().createImage(logo);
		setIconImage(image);

		JPanel background = new JPanel();
		background.setLocation(0, 0);
		background.setBackground(new Color(255, 255, 255));
		background.setSize(600, 380);
		background.setLayout(null);
		getContentPane().add(background);

		JPanel Left = new JPanel();
		Left.setBounds(0, 0, 250, 380);
		Left.setBackground(new Color(0, 0, 0));
		background.add(Left);
		Left.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Le Cong Duc");
		lblNewLabel_1.setForeground(new Color(255, 128, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(55, 228, 137, 37);
		Left.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 68, 206, 200);
		Left.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignIn.class.getResource("1.png"))));

		JPanel Right = new JPanel();
		Right.setBackground(new Color(255, 255, 255));
		Right.setBounds(250, 0, 350, 380);
		Right.setLayout(null);
		background.add(Right);

		JLabel Title = new JLabel("Sign Up");
		Title.setForeground(new Color(255, 0, 0));
		Title.setFont(new Font("VNI-Cooper", Font.BOLD, 24));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(90, 22, 165, 43);
		Right.add(Title);

		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(43, 76, 132, 14);
		Right.add(lblName);

		JTextField txtname = new JTextField();
		txtname.setBounds(43, 101, 247, 30);
		Right.add(txtname);
		txtname.setColumns(10);
		JTextField txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(43, 168, 247, 30);
		Right.add(txtUser);

		JLabel lblUser = new JLabel(" User : ");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUser.setBounds(43, 142, 132, 14);
		Right.add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(43, 209, 132, 14);
		Right.add(lblPassword);

		JPasswordField txtpassword = new JPasswordField();
		txtpassword.setBounds(43, 234, 247, 30);
		Right.add(txtpassword);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectionJDBC jdbc = new ConnectionJDBC();
				Connection conn = null;

				try {
					String username = txtUser.getText();
					String pass = txtpassword.getText();
					String name = txtname.getText();

					Users user = new Users(username, pass, name);
					UserDAO.getInstance().insert(user);

					if (username.equals("") || pass.equals("") || name.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui long nhap day du thong tin");
					} else {
						JOptionPane.showMessageDialog(null, "Đăng kí thành công");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Connection");
				}
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnSignUp.setForeground(new Color(255, 0, 0));
		btnSignUp.setBackground(new Color(0, 0, 0));
		btnSignUp.setBounds(43, 283, 104, 30);
		Right.add(btnSignUp);

		JLabel lbl3 = new JLabel("I 've an account");
		lbl3.setForeground(new Color(0, 64, 128));
		lbl3.setBounds(43, 324, 132, 14);
		Right.add(lbl3);

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignIn signIn = new SignIn();
				signIn.setVisible(true);
				signIn.setLocationRelativeTo(null);
				setVisible(false);

			}
		});

		btnSignIn.setForeground(new Color(255, 128, 64));
		btnSignIn.setBackground(new Color(255, 255, 255));
		btnSignIn.setBounds(186, 316, 104, 30);
		Right.add(btnSignIn);

		setVisible(true);
	}
}
