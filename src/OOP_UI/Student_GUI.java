package OOP_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;

import BaiTapHuongDoiTuong.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtBloodType;
	private JTextField txtIncome;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	DefaultTableModel model;
	private JTable tbResult;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_GUI frame = new Student_GUI();
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
	public Student_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(Color.WHITE);
		setTitle("Quản lý sinh viên");
		setBounds(100, 100, 1414, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbId = new JLabel("M\u00E3 sinh vi\u00EAn");
		lbId.setBounds(53, 8, 213, 27);
		lbId.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbId);
		
		txtId = new JTextField();
		txtId.setBounds(399, 15, 991, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lbName = new JLabel("Họ và tên");
		lbName.setBounds(53, 45, 134, 38);
		lbName.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbName);
		
		txtName = new JTextField();
		txtName.setBounds(399, 58, 991, 21);
		txtName.setColumns(10);
		contentPane.add(txtName);
		
		JLabel lbPhone = new JLabel("Số điện thoại");
		lbPhone.setBounds(53, 87, 134, 26);
		lbPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(399, 92, 991, 21);
		txtPhone.setColumns(10);
		contentPane.add(txtPhone);
		
		JLabel lbEmail = new JLabel("Thư điện tử");
		lbEmail.setBounds(53, 124, 134, 25);
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(399, 128, 991, 21);
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);
		
		JLabel lbDate = new JLabel("Ngày sinh");
		lbDate.setBounds(53, 155, 134, 27);
		lbDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbDate);
		
		JLabel lbGender = new JLabel("Giới tính");
		lbGender.setBounds(53, 188, 103, 21);
		lbGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbGender);
		
		JLabel lbBloodType = new JLabel("Nhóm máu");
		lbBloodType.setBounds(53, 217, 134, 21);
		lbBloodType.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbBloodType);
		
		txtBloodType = new JTextField();
		txtBloodType.setBounds(399, 222, 991, 18);
		txtBloodType.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtBloodType.setColumns(10);
		contentPane.add(txtBloodType);
		
		JLabel lbIncome = new JLabel("Thu nhập");
		lbIncome.setBounds(53, 245, 134, 21);
		lbIncome.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbIncome);
		
		txtIncome = new JTextField();
		txtIncome.setBounds(399, 250, 452, 18);
		txtIncome.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtIncome.setColumns(10);
		contentPane.add(txtIncome);
		
		JLabel lbStartTime = new JLabel("Thời gian bắt đầu");
		lbStartTime.setBounds(53, 280, 180, 21);
		lbStartTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbStartTime);
		
		txtStartTime = new JTextField();
		txtStartTime.setBounds(399, 285, 452, 18);
		txtStartTime.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtStartTime.setColumns(10);
		contentPane.add(txtStartTime);
		
		JLabel lbEndTime = new JLabel("Thời gian kết thúc");
		lbEndTime.setBounds(53, 311, 180, 21);
		lbEndTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbEndTime);
		
		txtEndTime = new JTextField();
		txtEndTime.setBounds(399, 316, 452, 18);
		txtEndTime.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEndTime.setColumns(10);
		contentPane.add(txtEndTime);
		
		String genderName[] = {"Nam", "Nữ"};
		DefaultComboBoxModel listGender = new DefaultComboBoxModel(genderName);
		JComboBox cbbGender = new JComboBox(listGender);
		cbbGender.setBounds(399, 188, 452, 21);
		cbbGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(cbbGender);
		cbbGender.setSelectedIndex(0);
		
		JDateChooser dcDate = new JDateChooser();
		dcDate.setBounds(399, 159, 452, 19);
		dcDate.setToolTipText("");
		dcDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dcDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dcDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 344, 1380, 159);
		contentPane.add(scrollPane);
		
		tbResult = new JTable();
		tbResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tbResult.getSelectedRow();
				txtId.setText(model.getValueAt(i, 0).toString());
				txtName.setText(model.getValueAt(i, 1).toString());
				txtPhone.setText(model.getValueAt(i, 2).toString());
				txtEmail.setText(model.getValueAt(i, 3).toString());
				
				DateFormat	dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				try {
					dcDate.setDate( dateFormat.parse((String) model.getValueAt(i, 4)));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cbbGender.setSelectedItem(model.getValueAt(i, 5));
				
				txtBloodType.setText(model.getValueAt(i, 6).toString());
				txtIncome.setText(model.getValueAt(i, 7).toString());
				txtStartTime.setText(model.getValueAt(i, 8).toString());
				txtEndTime.setText(model.getValueAt(i, 9).toString());
			}
		});
		tbResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		model = new DefaultTableModel();
		Object[] col = {lbId.getText(), lbName.getText(), 
				lbPhone.getText(), lbEmail.getText(), lbDate.getText(),
				lbGender.getText(), lbBloodType.getText(), lbIncome.getText() + "(VND)", 
				lbStartTime.getText(), lbEndTime.getText(), "Tiền thuế(VND)"};
		final Object[] row = new Object[11];
		model.setColumnIdentifiers(col);
		tbResult.setModel(model);
		scrollPane.setViewportView(tbResult);
		
		JButton btnCreate = new JButton("Thêm");
		btnCreate.setBounds(868, 250, 156, 38);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane jOptionPane = new JOptionPane();
				int startTime = Integer.parseInt(txtStartTime.getText());
				int endTime = Integer.parseInt(txtEndTime.getText());
				if (txtId.getText().equals("") || txtName.getText().equals("") 
					|| txtPhone.getText().equals("") || txtEmail.getText().equals("") 
					|| txtIncome.getText().equals("")
					|| txtStartTime.getText().equals("") || txtEndTime.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Phải nhập tất cả các thông tin!", "", JOptionPane.ERROR_MESSAGE);;
				} else if (startTime > endTime) {
					JOptionPane.showMessageDialog(null, "Thời gian bắt đầu không được lớn hơn Thời gian kết thúc", "", JOptionPane.ERROR_MESSAGE);
				}  
				else {
					Student student = new Student();
					row[0] = txtId.getText();
					row[1] = txtName.getText();
					row[2] = txtPhone.getText();
					row[3] = txtEmail.getText();
					
					
					student.setStudentID(row[0].toString());
					student.setName(row[1].toString());
					student.setPhone(row[2].toString());
					student.setEmail(row[3].toString());
		
					DateFormat	dateFormat = new SimpleDateFormat("dd/MM/yyyy");				
					student.setBirthday(dateFormat.format(dcDate.getDate()));
					row[4] = dateFormat.format(dcDate.getDate());
					String data = "";
					if (cbbGender.getSelectedIndex() != -1) {
						int index = cbbGender.getSelectedIndex();
						data = (String) cbbGender.getItemAt(index);//cbbGender.getSelectedIndex()
					}
					
					row[5] = data;
					row[6] = txtBloodType.getText();
					
					student.setBlood_type(row[6].toString());
					double income =  Double.parseDouble(txtIncome.getText());
					long tax = (long) student.payTax(income, startTime, endTime);
					row[7] = txtIncome.getText();
					row[8] = txtStartTime.getText();
					row[9] = txtEndTime.getText();
					row[10] = tax;
					
					TableColumn column = null;
					for (int i=0; i<row.length; i++) {
						column = tbResult.getColumnModel().getColumn(i);
						
						if (i>=7 && i<=10) {
							column.setPreferredWidth(120);
						} else if (i==1 && i==3) {
							column.setPreferredWidth(400);
						}
						else {
							column.setPreferredWidth(40);
						}
					}
					model.addRow(row);
					
					
					txtId.setText("");
					txtName.setText("");
					txtPhone.setText("");
					txtEmail.setText("");
					//dcDate.setDate(null);
					txtBloodType.setText("");
					txtIncome.setText("");
					txtStartTime.setText("");
					txtEndTime.setText("");
					
					JOptionPane.showMessageDialog(null, "Thông tin được thêm thành công!");
				}
			}
		});
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch.setBounds(868, 310, 156, 27);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnCreate);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int startTime = Integer.parseInt(txtStartTime.getText());
				int endTime = Integer.parseInt(txtEndTime.getText());
				if (startTime > endTime) {
					JOptionPane.showMessageDialog(null, "Thời gian bắt đầu không được lớn hơn Thời gian kết thúc", "", JOptionPane.ERROR_MESSAGE);
				} else {
					int i = tbResult.getSelectedRow();
					model.setValueAt(txtId.getText(), i, 0);
					model.setValueAt(txtName.getText(), i, 1);
					model.setValueAt(txtPhone.getText(), i, 2);
					model.setValueAt(txtEmail.getText(), i, 3);
					DateFormat	dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String date = dateFormat.format(dcDate.getDate());
					model.setValueAt(date, i, 4);
					String data = "";
					if (cbbGender.getSelectedIndex() != -1) {
						data = "" + cbbGender.getItemAt(cbbGender.getSelectedIndex());//cbbGender.getSelectedIndex()
						model.setValueAt(data, i, 5);
					}
					Student student = new Student();
					double income =  Double.parseDouble(txtIncome.getText());
					
					
					model.setValueAt(txtBloodType.getText(), i, 6);
					model.setValueAt(txtIncome.getText(), i, 7);
					model.setValueAt(txtStartTime.getText(), i, 8);
					model.setValueAt(txtEndTime.getText(), i, 9);
					long tax = (long) student.payTax(income, startTime, endTime);
//					row[10] = tax + " VND";
					model.setValueAt(tax, i, 10);
					JOptionPane.showMessageDialog(null, "Sửa thành công ! ");
				}
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBounds(1047, 250, 156, 38);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tbResult.getSelectedRow();
				if (i>=0) {
					JOptionPane.showMessageDialog(null, "Đã xóa sinh viên " + tbResult.getValueAt(i, 0));
					model.removeRow(i);
				} else {
					JOptionPane.showMessageDialog(null, "Hãy chọn một dòng để xóa!");
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(1234, 250, 156, 38);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = txtSearch.getText();
				for(int i = 0; i < tbResult.getRowCount(); i++){//For each row
			        for(int j = 0; j < tbResult.getColumnCount(); j++){//For each column in that row
			            if(tbResult.getModel().getValueAt(i, j).equals(search)){//Search the model
			            	//JOptionPane.showMessageDialog(null, tbResult.getModel().getValueAt(i, j));
			                //System.out.println(tbResult.getModel().getValueAt(i, j));//Print if found string
			            	JOptionPane.showMessageDialog(null, "Dữ liệu được tìm thấy tại dòng thứ " + i);
			            } else {
			            	JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu nào trùng khớp!");
			            	break;
			            }
			        }//For loop inner
			    }//For loop outer
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBounds(1047, 302, 156, 38);
		contentPane.add(btnSearch);
		
		JButton btnReset = new JButton("Làm mới");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtName.setText("");
				txtPhone.setText("");
				txtEmail.setText("");
				//dcDate.setDate(null);
				txtBloodType.setText("");
				txtIncome.setText("");
				txtStartTime.setText("");
				txtEndTime.setText("");
				txtSearch.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(1234, 302, 156, 38);
		contentPane.add(btnReset);
		
		
		
		
		
		
	}
}
