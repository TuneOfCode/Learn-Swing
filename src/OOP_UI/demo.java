package OOP_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class demo extends JFrame {

	private JPanel contentPane;
	private JTextField txtMessageOfMe;
	private JTextField txtMessageOfFaker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
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
	public demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbMe = new JLabel("Bạn");
		lbMe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbMe.setBounds(10, 30, 58, 25);
		contentPane.add(lbMe);
		
		txtMessageOfMe = new JTextField();
		txtMessageOfMe.setBounds(91, 30, 311, 25);
		contentPane.add(txtMessageOfMe);
		txtMessageOfMe.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 392, 92);
		contentPane.add(scrollPane);
		
		JTextArea txtContent = new JTextArea();
		scrollPane.setViewportView(txtContent);
		txtContent.setEditable(false);
		
		JButton btnSendOfMe = new JButton("Chat");
		btnSendOfMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contentMe = lbMe.getText() + ": " +  txtMessageOfMe.getText() + "\n";
				txtContent.append(contentMe);
				txtMessageOfMe.setText("");
			}
		});
		btnSendOfMe.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSendOfMe.setBounds(317, 65, 85, 21);
		contentPane.add(btnSendOfMe);
		
		JLabel lbFaker = new JLabel("Người lạ");
		lbFaker.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbFaker.setBounds(10, 96, 58, 25);
		contentPane.add(lbFaker);
		
		txtMessageOfFaker = new JTextField();
		txtMessageOfFaker.setColumns(10);
		txtMessageOfFaker.setBounds(91, 96, 311, 25);
		contentPane.add(txtMessageOfFaker);
		
		JButton btnChatOfFaker = new JButton("Chat");
		btnChatOfFaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contentFaker = lbFaker.getText() + ": " +  txtMessageOfFaker.getText() + "\n";
				txtContent.append(contentFaker);
				txtMessageOfFaker.setText("");
			}
		});
		btnChatOfFaker.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChatOfFaker.setBounds(317, 131, 85, 21);
		contentPane.add(btnChatOfFaker);
		
	}
}
