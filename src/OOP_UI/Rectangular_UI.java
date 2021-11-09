package OOP_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaiTapHuongDoiTuong.Rectangular;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Rectangular_UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHeigth_x;
	private JTextField txtHeigth_y;
	private JTextField txtWidth_x;
	private JTextField txtWidth_y;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rectangular_UI frame = new Rectangular_UI();
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
	public Rectangular_UI() {
		setTitle("Tính chu vi và diện tích Hình chữ nhật");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbHeigth = new JLabel("Tọa độ chiều dài");
		lbHeigth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbHeigth.setBounds(10, 21, 180, 32);
		contentPane.add(lbHeigth);
		
		JLabel lbWidth = new JLabel("Tọa độ chiều rộng");
		lbWidth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbWidth.setBounds(10, 71, 180, 32);
		contentPane.add(lbWidth);
		
		txtHeigth_x = new JTextField();
		txtHeigth_x.setBounds(169, 30, 96, 19);
		contentPane.add(txtHeigth_x);
		txtHeigth_x.setColumns(10);
		
		txtHeigth_y = new JTextField();
		txtHeigth_y.setColumns(10);
		txtHeigth_y.setBounds(307, 30, 96, 19);
		contentPane.add(txtHeigth_y);
		
		txtWidth_x = new JTextField();
		txtWidth_x.setColumns(10);
		txtWidth_x.setBounds(169, 80, 96, 19);
		contentPane.add(txtWidth_x);
		
		txtWidth_y = new JTextField();
		txtWidth_y.setColumns(10);
		txtWidth_y.setBounds(307, 80, 96, 19);
		contentPane.add(txtWidth_y);
		
		Rectangular r = new Rectangular();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 393, 101);
		contentPane.add(scrollPane);
		
		
		JTextArea txtResult = new JTextArea();
		txtResult.setEditable(false);
		scrollPane.setViewportView(txtResult);
		txtResult.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		
		
		JButton btnArea = new JButton("Tính diện tích");
		btnArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String width_x = (txtWidth_x.getText());
				String width_y = (txtWidth_y.getText());
				String height_x = (txtHeigth_x.getText());
				String height_y = (txtHeigth_y.getText());
				
				r.setWidth_x(Double.parseDouble(width_x));
				r.setWidth_y(Double.parseDouble(width_y));
				r.setHeight_x(Double.parseDouble(height_x));
				r.setHeigth_y(Double.parseDouble(height_y));
				String area = "Diện tích= " + r.calcArea() + "\n";
				txtResult.append(area);
			}
		});
		btnArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnArea.setBounds(257, 121, 146, 21);
		contentPane.add(btnArea);
		
		
		JButton btnPerimeter = new JButton("Tính chu vi");
		btnPerimeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String width_x = (txtWidth_x.getText());
				String width_y = (txtWidth_y.getText());
				String height_x = (txtHeigth_x.getText());
				String height_y = (txtHeigth_y.getText());
				
				r.setWidth_x(Double.parseDouble(width_x));
				r.setWidth_y(Double.parseDouble(width_y));
				r.setHeight_x(Double.parseDouble(height_x));
				r.setHeigth_y(Double.parseDouble(height_y));
				String perimeter = "Chu vi= " + r.calcPerimeter() + "\n";
				txtResult.append(perimeter);
			}
		});
		
		btnPerimeter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPerimeter.setBounds(10, 121, 146, 21);
		contentPane.add(btnPerimeter);
		
		txtWidth_x.setText("");
		txtWidth_y.setText("");
		txtHeigth_x.setText("");
		txtHeigth_y.setText("");
	}
}
