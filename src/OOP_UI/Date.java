package OOP_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Date extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date frame = new Date();
					frame.setLocationRelativeTo(null);
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
	public Date() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser txtDate = new JDateChooser();
		txtDate.setDateFormatString("dd-MM-yyyy");
		txtDate.setBounds(20, 34, 240, 19);
		contentPane.add(txtDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 63, 384, 177);
		contentPane.add(scrollPane);
		
		JTextArea txtResult = new JTextArea();
		txtResult.setEditable(false);
		scrollPane.setViewportView(txtResult);
		
		JButton btnNewButton = new JButton("Nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date ngayDate = txtDate.getDate();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				String output = "Ngày sinh= " + df.format(ngayDate) + "\n";
				txtResult.append(output);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(319, 34, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}
}
