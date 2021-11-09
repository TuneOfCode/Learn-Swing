package ConnectToMySql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import BaiTapHuongDoiTuong.Student;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import java.sql.*;
public class ManageStudent extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtBlood;
	private JTextField txtIncome;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JTextField txtFind;
	private JTable tbList;
	private DefaultTableModel model;
	private JComboBox cbbGender;
	private JDateChooser dcDate;
	
	private static String URL = "jdbc:mysql://localhost:3306/testdb";
	private static String USER = "root";
	private static String PASSWORD = "";
	private Connection connection = null;
	private Statement statement;
	private PreparedStatement ps = null;
	@SuppressWarnings("deprecation")

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudent frame = new ManageStudent();
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public ManageStudent() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1413, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(730, 22, 180, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lbId = new JLabel("Mã sinh viên");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbId.setBounds(10, 53, 139, 27);
		contentPane.add(lbId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(145, 59, 132, 21);
		contentPane.add(txtId);
		
		JLabel lbName = new JLabel("Tên sinh viên");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbName.setBounds(10, 90, 139, 27);
		contentPane.add(lbName);
		
		JLabel lbPhone = new JLabel("Số điện thoại");
		lbPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPhone.setBounds(10, 127, 139, 27);
		contentPane.add(lbPhone);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbEmail.setBounds(10, 164, 139, 27);
		contentPane.add(lbEmail);
		
		JLabel lbDate = new JLabel("Ngày sinh");
		lbDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDate.setBounds(10, 201, 139, 27);
		contentPane.add(lbDate);
		
		JLabel lbGender = new JLabel("Giới tính");
		lbGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbGender.setBounds(10, 238, 139, 27);
		contentPane.add(lbGender);
		
		JLabel lbBlood = new JLabel("Nhóm máu");
		lbBlood.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbBlood.setBounds(10, 275, 139, 27);
		contentPane.add(lbBlood);
		
		JLabel lbIncome = new JLabel("Thu nhập");
		lbIncome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbIncome.setBounds(10, 312, 139, 27);
		contentPane.add(lbIncome);
		
		JLabel lbStart = new JLabel("Thời gian bắt đầu");
		lbStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbStart.setBounds(10, 349, 139, 27);
		contentPane.add(lbStart);
		
		JLabel lbEnd = new JLabel("Thời gian kết thúc");
		lbEnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbEnd.setBounds(10, 386, 139, 27);
		contentPane.add(lbEnd);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(145, 96, 180, 21);
		contentPane.add(txtName);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(145, 133, 132, 21);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(145, 170, 180, 21);
		contentPane.add(txtEmail);
		
		txtBlood = new JTextField();
		txtBlood.setColumns(10);
		txtBlood.setBounds(145, 281, 58, 21);
		contentPane.add(txtBlood);
		
		txtIncome = new JTextField();
		txtIncome.setColumns(10);
		txtIncome.setBounds(145, 318, 180, 21);
		contentPane.add(txtIncome);
		
		txtStart = new JTextField();
		txtStart.setColumns(10);
		txtStart.setBounds(155, 354, 58, 21);
		contentPane.add(txtStart);
		
		txtEnd = new JTextField();
		txtEnd.setColumns(10);
		txtEnd.setBounds(155, 391, 58, 21);
		contentPane.add(txtEnd);
		
		cbbGender = new JComboBox();
		cbbGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbbGender.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbbGender.setBounds(145, 243, 58, 21);
		contentPane.add(cbbGender);
		
		dcDate = new JDateChooser();
		dcDate.setDateFormatString("yyyy-MM-dd");
		dcDate.setBounds(145, 201, 180, 19);
		contentPane.add(dcDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 61, 1051, 434);
		contentPane.add(scrollPane);
		
		tbList = new JTable();
		String cols[] = {"Mã sinh viên", "Tên sinh viên", "SĐT", "Email", "Ngày sinh", "Giới tính", "Nhóm máu", "Thu nhập", "Bắt đầu", "Kết thúc", "Thuế"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(cols);
		
		tbList.setModel(model);
		scrollPane.setViewportView(tbList);
		ConnectMySql();
		render(View(true));
		
		tbList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tbList.getSelectedRow();
				txtId.setText(model.getValueAt(i, 0).toString());
				txtName.setText(model.getValueAt(i, 1).toString());
				txtPhone.setText(model.getValueAt(i, 2).toString());
				txtEmail.setText(model.getValueAt(i, 3).toString());
				DateFormat	dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					dcDate.setDate( dateFormat.parse((String) model.getValueAt(i, 4)));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cbbGender.setSelectedItem(model.getValueAt(i, 5));
				txtBlood.setText(model.getValueAt(i, 6).toString());
				txtIncome.setText(model.getValueAt(i, 7).toString());
				txtStart.setText(model.getValueAt(i, 8).toString());
				txtEnd.setText(model.getValueAt(i, 9).toString());
				
			}
		});
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int startTime = Integer.parseInt(txtStart.getText());
				int endTime = Integer.parseInt(txtEnd.getText());
				if (txtId.getText().equals("") || txtName.getText().equals("") 
					|| txtPhone.getText().equals("") || txtEmail.getText().equals("") 
					|| txtIncome.getText().equals("")
					|| txtStart.getText().equals("") || txtEnd.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Phải nhập tất cả các thông tin!", "", JOptionPane.ERROR_MESSAGE);;
				} else if (startTime > endTime) {
					JOptionPane.showMessageDialog(null, "Thời gian bắt đầu không được lớn hơn Thời gian kết thúc", "", JOptionPane.ERROR_MESSAGE);
				} else {
					add();
					
				}
			}
			

		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setForeground(SystemColor.textHighlight);
		btnAdd.setBounds(10, 423, 100, 32);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int startTime = Integer.parseInt(txtStart.getText());
				int endTime = Integer.parseInt(txtEnd.getText());
				if (startTime > endTime) {
					JOptionPane.showMessageDialog(null, "Thời gian bắt đầu không được lớn hơn Thời gian kết thúc", "", JOptionPane.ERROR_MESSAGE);
				} else {
					edit();
				}
			}
		});
		btnEdit.setForeground(Color.MAGENTA);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(118, 423, 100, 32);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setForeground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(228, 423, 100, 32);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("Tìm kiếm");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rows = model.getRowCount(); 
				for(int i = rows - 1; i >=0; i--)
				{
				   model.removeRow(i); 
				}
				render(find());
			}
		});
		btnFind.setForeground(new Color(0, 128, 0));
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(225, 465, 100, 32);
		contentPane.add(btnFind);
		
		txtFind = new JTextField();
		txtFind.setBounds(10, 465, 203, 27);
		contentPane.add(txtFind);
		txtFind.setColumns(10);
		
		JButton btnClear = new JButton("Làm mới");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtName.setText("");
				txtPhone.setText("");
				txtEmail.setText("");
				dcDate.setDate(null);
				txtBlood.setText("");
				txtIncome.setText("");
				txtStart.setText("");
				txtEnd.setText("");
			}
		});
		btnClear.setForeground(Color.BLUE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(232, 383, 93, 32);
		contentPane.add(btnClear);
		
		
	}
	public void ConnectMySql() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connect successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("connect failure!");
			connection.close();
			e.printStackTrace();
		}
	}
	public ResultSet View(boolean action) {
		if (action) {
			ResultSet resultSet = null;
			String query = "select * from student";
			try {
				statement =  connection.createStatement();
				return statement.executeQuery(query);
			} catch (SQLException e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			return resultSet;
		} else {
			ResultSet resultSet = null;
			String find = "SELECT * FROM student ";
			String search = txtFind.getText();
			if (search.length()>0) {
				find = find + " WHERE id like '%" + search + "%'";	
			}
			try {
				statement =  connection.createStatement();
				return statement.executeQuery(find);
			} catch (SQLException e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			return resultSet;
		} 
	}
	public void render(ResultSet resultSet) {
		String cols[] = {"Mã sinh viên", "Tên sinh viên", "SĐT", "Email", "Ngày sinh", "Giới tính", "Nhóm máu", "Thu nhập", "Bắt đầu", "Kết thúc", "Thuế"};
		model.setColumnIdentifiers(cols);
		try {
			while(resultSet.next()) {
				String rows[] = new String[11];
				rows[0] = resultSet.getString(1);
				rows[1] = resultSet.getString(2);
				rows[2] = resultSet.getString(3);
				rows[3] = resultSet.getString(4);
				rows[4] = resultSet.getDate(5).toString();
				rows[5] = resultSet.getString(6);
				rows[6] = resultSet.getString(7);
				rows[7] = (long)resultSet.getDouble(8) + "";
				rows[8] = resultSet.getInt(9) + "";
				rows[9] = resultSet.getInt(10) + "";
				
				
				double income = resultSet.getDouble(8);
				int start_time = resultSet.getInt(9);
				int end_time = resultSet.getInt(10);
				double TaxPercent = ((income > (11 * Math.pow(10, 6))) ? (0.5 / 100) : 0);
				double TaxStudent = income * TaxPercent * Math.abs(end_time - start_time); 
				
				String update = "UPDATE student " + "SET tax = ? " + "WHERE id = ? ";
				String id = resultSet.getString(1);
				try {
					ps = connection.prepareStatement(update);
					ps.setDouble(1, TaxStudent);
					ps.setString(2, id);
					ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO: handle exception
					resultSet = null;
					e.printStackTrace();
				}
				rows[10] = resultSet.getDouble(11) + "";
				model.addRow(rows);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ResultSet add() {
		ResultSet resultSet = null;
		String insert = "INSERT INTO student (id, name, phone, email, birthday, gender, type_blood, income, start_time, end_time, tax) "
        		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			ps = connection.prepareStatement(insert);
			String data = "";
			if (cbbGender.getSelectedIndex() != -1) {
				data = "" + cbbGender.getItemAt(cbbGender.getSelectedIndex());//cbbGender.getSelectedIndex()
			}

			double income =  Double.parseDouble(txtIncome.getText());
			int startTime = Integer.parseInt(txtStart.getText());
			int endTime = Integer.parseInt(txtEnd.getText());
			ps.setString(1, txtId.getText());
            ps.setString(2, txtName.getText());
            ps.setString(3, txtPhone.getText());
            ps.setString(4, txtEmail.getText());
            DateFormat	dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            ps.setString(5, dateFormat.format(dcDate.getDate()));
            ps.setString(6, data);
            ps.setString(7, txtBlood.getText());
            ps.setDouble(8, income);
            ps.setInt(9, startTime);
            ps.setInt(10, endTime);
            double TaxPercent = ((income > (11 * Math.pow(10, 6))) ? (0.5 / 100) : 0);
            double TaxStudent = income * TaxPercent * Math.abs(startTime - endTime); 
            
            ps.setDouble(11, TaxStudent);
            ps.executeUpdate();
            //ps.setDouble(11, s.payTax(s.getIncome(), s.getStartTime(), s.getEndTime()));
            
            int rows = model.getRowCount(); 
			for(int j = rows - 1; j >=0; j--)
			{
			   model.removeRow(j); 
			}
			render(View(true));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet edit() {
		ResultSet resultSet = null;
		String update = "UPDATE student SET id= ?, name= ?, phone= ?, email= ?, birthday= ?, gender= ?, type_blood= ?,income= ?, start_time= ?, end_time= ?, tax= ? "
				+ "WHERE id = ?";
		try {
			int i = tbList.getSelectedRow();
			model.setValueAt(txtId.getText(), i, 0);
			model.setValueAt(txtName.getText(), i, 1);
			model.setValueAt(txtPhone.getText(), i, 2);
			model.setValueAt(txtEmail.getText(), i, 3);
			DateFormat	dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = dateFormat.format(dcDate.getDate());
			model.setValueAt(date, i, 4);
			String data = "";
			if (cbbGender.getSelectedIndex() != -1) {
				data = "" + cbbGender.getItemAt(cbbGender.getSelectedIndex());//cbbGender.getSelectedIndex()
				model.setValueAt(data, i, 5);
			}
			double income =  Double.parseDouble(txtIncome.getText());
			int startTime = Integer.parseInt(txtStart.getText());
			int endTime = Integer.parseInt(txtEnd.getText());
			
			model.setValueAt(txtBlood.getText(), i, 6);
			model.setValueAt(txtIncome.getText(), i, 7);
			model.setValueAt(txtStart.getText(), i, 8);
			model.setValueAt(txtEnd.getText(), i, 9);
			double TaxPercent = ((income > (11 * Math.pow(10, 6))) ? (0.5 / 100) : 0);
            double TaxStudent = income * TaxPercent * Math.abs(startTime - endTime); 
			model.setValueAt(TaxStudent, i, 10);
			JOptionPane.showMessageDialog(null, "Sửa thành công ! ");
			
			ps = connection.prepareStatement(update);
			ps.setString(1, txtId.getText());
            ps.setString(2, txtName.getText());
            ps.setString(3, txtPhone.getText());
            ps.setString(4, txtEmail.getText());
            
            ps.setString(5, dateFormat.format(dcDate.getDate()));
            ps.setString(6, data);
            ps.setString(7, txtBlood.getText());
            ps.setDouble(8, income);
            ps.setInt(9, startTime);
            ps.setInt(10, endTime);
            ps.setDouble(11, TaxStudent);
            ps.setString(12, txtId.getText());
            ps.executeUpdate();
            
            
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet delete() {
		ResultSet resultSet = null;
		String delete = "DELETE FROM student WHERE id= ? ";
		try {
			int i = tbList.getSelectedRow();
			if (i>=0) {
				JOptionPane.showMessageDialog(null, "Đã xóa sinh viên " + tbList.getValueAt(i, 0));
				ps = connection.prepareStatement(delete);
				ps.setString(1, (String) tbList.getValueAt(i, 0));
				ps.executeUpdate();
				model.removeRow(i);
				
				txtId.setText("");
				txtName.setText("");
				txtPhone.setText("");
				txtEmail.setText("");
				dcDate.setDate(null);
				txtBlood.setText("");
				txtIncome.setText("");
				txtStart.setText("");
				txtEnd.setText("");
			} else {
				txtId.setText("");
				txtName.setText("");
				txtPhone.setText("");
				txtEmail.setText("");
				dcDate.setDate(null);
				txtBlood.setText("");
				txtIncome.setText("");
				txtStart.setText("");
				txtEnd.setText("");
				
				int rows = model.getRowCount(); 
				for(int j = rows - 1; j >=0; j--)
				{
				   model.removeRow(j); 
				}
				render(View(true));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet find() {
		ResultSet resultSet = null;
		for(int i = 0; i < tbList.getRowCount(); i++) {
			model.removeRow(i);
		}
		String find = "SELECT * FROM student ";
		String search = txtFind.getText();
		if (search.length()>0) {
			find = find + " WHERE id like '%" + search + "%' "
						+ "	OR name like '%" + search + "%' "
						+ "	OR phone like '%" + search + "%' "
						+ "	OR email like '%" + search + "%' "
						+ "	OR birthday like '%" + search + "%' "
						+ "	OR gender like '%" + search + "%' "
						+ "	OR type_blood like '%" + search + "%' "
						+ "	OR income like '%" + search + "%' "
						+ "	OR start_time like '%" + search + "%' "
						+ "	OR end_time like '%" + search + "%' "
						+ "	OR tax like '%" + search + "%' ";
		}
		try {
			statement =  connection.createStatement();
			return statement.executeQuery(find);
		} catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return resultSet;
	}
}
