package OOP_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class InputTextarea extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputTextarea frame = new InputTextarea();
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
	public InputTextarea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 236, 56);
		contentPane.add(scrollPane);
		
		JTextArea txtInput = new JTextArea();
		scrollPane.setViewportView(txtInput);
		txtInput.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 89, 416, 164);
		contentPane.add(scrollPane_1);
		
		JTextArea txtResult = new JTextArea();
		scrollPane_1.setViewportView(txtResult);
		
		JButton btnUp = new JButton("Đăng");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = txtInput.getText();
				txtResult.append(output);
			}
		});
		btnUp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUp.setBounds(309, 10, 85, 56);
		contentPane.add(btnUp);
	}

}
