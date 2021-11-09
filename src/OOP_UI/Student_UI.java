package OOP_UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaiTapHuongDoiTuong.Student;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
//import java.lang.FdLibm.Cbrt;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JScrollPane;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class Student_UI<E> extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtBloodType;
	private JTextField txtIncome;
	private JTextField txtStartTime;
	private JTextField txtEndTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_UI frame = new Student_UI();
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
	public Student_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(Color.WHITE);
		setTitle("Quản lý sinh viên");
		setBounds(100, 100, 749, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbId = new JLabel("M\u00E3 sinh vi\u00EAn");
		lbId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbId.setBounds(10, 10, 90, 27);
		contentPane.add(lbId);
		
		txtId = new JTextField();
		txtId.setBounds(154, 16, 571, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lbName = new JLabel("Họ và tên");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbName.setBounds(10, 56, 90, 20);
		contentPane.add(lbName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(154, 55, 571, 21);
		contentPane.add(txtName);
		
		JLabel lbPhone = new JLabel("Số điện thoại");
		lbPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbPhone.setBounds(10, 90, 103, 21);
		contentPane.add(lbPhone);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(154, 92, 571, 21);
		contentPane.add(txtPhone);
		
		JLabel lbEmail = new JLabel("Thư điện tử");
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbEmail.setBounds(10, 126, 103, 21);
		contentPane.add(lbEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(154, 129, 571, 21);
		contentPane.add(txtEmail);
		
		JLabel lbDate = new JLabel("Ngày sinh");
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDate.setBounds(10, 157, 103, 21);
		contentPane.add(lbDate);
		
		JLabel lbGender = new JLabel("Giới tính");
		lbGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGender.setBounds(10, 188, 103, 21);
		contentPane.add(lbGender);
		
		JLabel lbBloodType = new JLabel("Nhóm máu");
		lbBloodType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbBloodType.setBounds(10, 219, 103, 21);
		contentPane.add(lbBloodType);
		
		txtBloodType = new JTextField();
		txtBloodType.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtBloodType.setColumns(10);
		txtBloodType.setBounds(154, 222, 571, 18);
		contentPane.add(txtBloodType);
		
		JLabel lbIncome = new JLabel("Thu nhập");
		lbIncome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbIncome.setBounds(10, 250, 103, 21);
		contentPane.add(lbIncome);
		
		txtIncome = new JTextField();
		txtIncome.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtIncome.setColumns(10);
		txtIncome.setBounds(154, 250, 138, 18);
		contentPane.add(txtIncome);
		
		JLabel lbStartTime = new JLabel("Thời gian bắt đầu");
		lbStartTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbStartTime.setBounds(10, 282, 134, 21);
		contentPane.add(lbStartTime);
		
		txtStartTime = new JTextField();
		txtStartTime.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtStartTime.setColumns(10);
		txtStartTime.setBounds(154, 282, 138, 18);
		contentPane.add(txtStartTime);
		
		JLabel lbEndTime = new JLabel("Thời gian kết thúc");
		lbEndTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbEndTime.setBounds(10, 313, 134, 21);
		contentPane.add(lbEndTime);
		
		txtEndTime = new JTextField();
		txtEndTime.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEndTime.setColumns(10);
		txtEndTime.setBounds(154, 313, 138, 18);
		contentPane.add(txtEndTime);
		
		String genderName[] = {"Nam", "Nữ"};
		DefaultComboBoxModel listGender = new DefaultComboBoxModel(genderName);
		JComboBox cbbGender = new JComboBox(listGender);
		cbbGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbGender.setBounds(154, 190, 138, 21);
		contentPane.add(cbbGender);
		cbbGender.setSelectedIndex(0);
		
		JTextArea txtResult = new JTextArea();
		txtResult.setEditable(false);
		txtResult.setBounds(10, 344, 715, 159);
		//contentPane.add(txtResult);
		JScrollPane scrollPane = new JScrollPane(txtResult,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 344, 715, 159);
		contentPane.add(scrollPane);
		
		JDateChooser dcDate = new JDateChooser();
		dcDate.setToolTipText("");
		dcDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dcDate.setDateFormatString("dd/MM/yyyy");
		dcDate.setBounds(154, 159, 138, 19);
		contentPane.add(dcDate);
		
		
		JButton btnCreate = new JButton("Tạo mới");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jOptionPane = new JOptionPane();
				jOptionPane.setMessage("Phải nhập tất cả các thông tin!");
//				if (txtId.getText().equals("") || txtName.getText().equals("") 
//					|| txtPhone.getText().equals("") || txtEmail.getText().equals("") 
//					|| txtBirthday.getText().equals("") || txtIncome.getText().equals("")
//					|| txtStartTime.getText().equals("") || txtEndTime.getText().equals("")) {
//					
//					jOptionPane.setMessage("Phải nhập tất cả các thông tin!");
//				} else {
					Student student = new Student();
					student.setStudentID(txtId.getText());
					student.setName(txtName.getText());
					student.setPhone(txtPhone.getText());
					student.setEmail(txtEmail.getText());
					//student.setBirthday(txtBirthday.getText());
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");				
					student.setBirthday(dateFormat.format(dcDate.getDate()));
					String data = "";
					if (cbbGender.getSelectedIndex() != -1) {
						data = "" + cbbGender.getItemAt(cbbGender.getSelectedIndex());//cbbGender.getSelectedIndex()
					}
					
					student.setBlood_type(txtBloodType.getText());
					double income =  Double.parseDouble(txtIncome.getText());
					int startTime = Integer.parseInt(txtStartTime.getText());
					int endTime = Integer.parseInt(txtEndTime.getText());
					long tax = (long) student.payTax(income, startTime, endTime);
					String output = "\n ******************" + student.getStudentID() + "********************* \n" + "Mã sinh viên: " + student.getStudentID() 
						+ "\n" + "Họ và tên: " + student.getName() 
						+ "\n" + "Số điện thoại: " + student.getPhone()
						+ "\n" + "Thư điện tử: " + student.getEmail()
						+ "\n" + "Ngày sinh: " + student.getBirthday()
						+ "\n" + "Giới tính: " + data
						+ "\n" + "Nhóm máu: " + student.getBlood_type()
						+ "\n" + "Tiền thuế phải đóng: " + tax + " VND " + "\n"; //+ "\n **************************************** \n";
					
					txtResult.append(output);
					txtId.setText("");
					txtName.setText("");
					txtPhone.setText("");
					txtEmail.setText("");
					txtBloodType.setText("");
					txtIncome.setText("");
					txtStartTime.setText("");
					txtEndTime.setText("");
				//}
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreate.setBounds(315, 250, 410, 84);
		contentPane.add(btnCreate);
		
		
	}

	
}
