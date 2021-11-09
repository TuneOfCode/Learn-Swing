package OOP_UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.List;
import java.beans.PropertyVetoException;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ManageBook extends JInternalFrame {
	private JTable tableListBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBook frame = new ManageBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public ManageBook() throws PropertyVetoException {
		setClosable(true);
		setIcon(true);
		setMaximum(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosed(true);
		setTitle("Quản lý sách");
		setBounds(100, 100, 738, 481);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 706, 436);
		getContentPane().add(scrollPane);
		
		Book[] book = new Book[] {new Book("LT1", "Programming language C", "Dennis Ritchie", 20, 100000),
				new Book("LT2", "Programming language C++", "Dennis", 20, 100000),
				new Book("LT3", "Programming language C#", "Ritchie", 20, 100000),
				new Book("LT4", "Programming language Python", "Dennis Ritchie", 20, 100000)};
		tableListBook = new JTable();
		tableListBook.setCellSelectionEnabled(true);
		tableListBook.setColumnSelectionAllowed(true);
		tableListBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		DefaultTableModel dt = new DefaultTableModel(new Object[][] {
		},
		new String[] {
			"Mã sách", "Tên sách", "Tác giả", "Số lượng", "Giá bán", "Thành tiền"
		});
		tableListBook.setModel(dt);
		scrollPane.setViewportView(tableListBook);
		
		DefaultTableModel model = (DefaultTableModel) tableListBook.getModel();
		model.setRowCount(0);
		for (int i=0; i<book.length; i++) {
			model.insertRow(model.getRowCount(), new Object[]{
					book[i].getId(),
					book[i].getName(),
					book[i].getAuthor(),
					book[i].getQuantity(),
					book[i].getPrice(),
					book[i].getQuantity() * book[i].getPrice() + " VND"
			});
		}

	}
}
