package OOP_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class Admin_UI extends JFrame {
	ManageBook frManageBook;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_UI frame = new Admin_UI();
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
	public Admin_UI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Trang quản trị viên");
		
		setBounds(100, 100, 829, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 10, 795, 439);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 785, 22);
		desktopPane.add(menuBar);
		
		JMenu mnHome = new JMenu("Trang chủ");
		mnHome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnHome);
		
		JMenuItem mntmExit = new JMenuItem("Thoát");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.addMouseListener(new MouseAdapter() {
			
		});
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmExit.setHorizontalAlignment(SwingConstants.CENTER);
		mnHome.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Phần mềm");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quản lý sách");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frManageBook == null || frManageBook.isClosed()) {
					try {
						frManageBook = new ManageBook();
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					desktopPane.add(frManageBook);
					frManageBook.setLocation((desktopPane.getWidth()) - frManageBook.getWidth()
							, (desktopPane.getHeight()) - frManageBook.getHeight());
				}
				frManageBook.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
	}
}
//DESKTOP-3CTVBGT\SQLEXPRESS