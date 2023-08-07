package PresentationLayer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import Observer.Subscriber;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import DomainLayer.HDService;
import DomainLayer.HDServiceiml;
import DomainLayer.HDTheoGio;
import DomainLayer.HDTheoNgay;



public class GUI extends JFrame implements Subscriber  {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        
        private HDService hoaDonService;
        private ADDTheoNgay add;
        private ADDTheoGio addgio;        
        private UpdateNgay updateNgay;
        private UpdateGio updateGio;
        private DeletNgay deletNgay;
        private DeletGio deletGio;
        private TimKiemNgay timkiem;
        private TimKiemGio timkiemGio;
        private TongTien tong;
        private ThanhTien tong1;

        
		private JLabel mahoadonJLabel;
		private JLabel ngaylaphoadonJLabel;
		private JLabel dongiaJLabel;
		private JLabel maphongJLabel;
		private JLabel sogiothueJLabel;
		
		private JTextField mahoadonJTextField;
		private JTextField ngaylaphoadonJTextField;
		private JTextField tenkhachhangJTextField;
		private JTextField dongiaJTextField;
		private JTextField maphongJTextField;
		private JTextField sogiothueJTextField;
		private JTextField tongthanhtienJTextField;
		
		private JTextField mahoadonJTextField1;
		private JTextField ngaylaphoadonJTextField1;
		private JTextField tenkhachhangJTextField1;
		private JTextField dongiaJTextField1;
		private JTextField maphongJTextField1;
		private JTextField songaythueJTextField1;
		private JTextField tongthanhtienJTextField1;
		
		private JButton themButton;
		private JButton suaButton;
		private JButton xoaButton;
		private JButton lammoiButton;
		private JButton tongthanhtienJButton;
		private JButton timkiemJButton;
		
		private JButton themButton1;
		private JButton suaButton1;
		private JButton xoaButton1;
		private JButton lammoiButton1;
		private JButton tongthanhtienJButton1;
		private JButton timkiemJButton1;
		private JPanel contentPane;
		private JTable table;
		private JPanel panelButton;

		private JTable table1;

		public GUI(){
             hoaDonService = new HDServiceiml();             
             UI();
             
             add = new ADDTheoNgay(this);
             addgio = new ADDTheoGio(this);
             updateNgay = new UpdateNgay(this);  
             updateGio = new UpdateGio(this);
             deletNgay = new DeletNgay(this);
             deletGio = new DeletGio(this);
             timkiem = new TimKiemNgay(this);
             timkiemGio = new TimKiemGio(this);
             tong = new TongTien(this);
             tong1 = new ThanhTien(this);
//             hdNgay = new HDTheoNgay();
             // controller thêm ngày
            // add.LoadTableNgay();
             themButton1.addActionListener(add);
             //controller sửa   ngày
             updateNgay.LoadTableNgay();
             suaButton1.addActionListener(updateNgay);
             // controller thêm giờ
             addgio.loadTableGio();
             themButton.addActionListener(addgio);
             //controller sửa giờ
             updateGio.loadTableGio();
             suaButton.addActionListener(updateGio);
             //controller xóa ngày
             deletNgay.LoadTableNgay();
             xoaButton1.addActionListener(deletNgay);
             //controller xóa giờ
             deletGio.LoadTableGio();
             xoaButton.addActionListener(deletGio);
             
             timkiemJButton1.addActionListener(timkiem);
             timkiemJButton.addActionListener(timkiemGio);
             tongthanhtienJButton.addActionListener(tong1);
             tongthanhtienJButton1.addActionListener(tong);
		}
		public void UI() {
			setTitle("ManagementCustomerInvoicesApp");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setBounds(100, 100, 890, 786);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 841, 680);
			contentPane.add(tabbedPane);
			
			JPanel panelTab = new JPanel();
			tabbedPane.addTab("HÓA ĐƠN THEO GIỜ", null, panelTab, null);
			panelTab.setLayout(null);
			
			JPanel hoadontheogioPanel = new JPanel();		
			hoadontheogioPanel.setBounds(0, 0, 805, 51);
			panelTab.add(hoadontheogioPanel);
			hoadontheogioPanel.setLayout(null);
			
			JLabel hoadontheogioJLabel = new JLabel("HÓA ĐƠN THEO GIỜ");
			hoadontheogioJLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	
			hoadontheogioJLabel.setBounds(300, 10, 300, 40);
			hoadontheogioPanel.add(hoadontheogioJLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 61, 785, 240);
			panelTab.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã Hóa Đơn ", "Tên Khách Hàng", "Mã Phòng", "Ngày Lập Hóa Đơn  ","Đơn giá","Số giờ thuê", "Thành Tiền"
				}
			));			

			panelButton = new JPanel();
			panelButton.setBounds(10, 314, 785, 80);
			panelTab.add(panelButton);
			panelButton.setLayout(null);
			
			themButton = new JButton("Thêm");
			themButton .setFont(new Font("Tahoma", Font.BOLD, 15));
			themButton .setBounds(10, 10, 109, 60);
			panelButton.add(themButton );
			
			suaButton = new JButton("Sửa");
			suaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			suaButton.setBounds(151, 10, 109, 60);
			panelButton.add(suaButton);
			
			xoaButton = new JButton("Xóa");
			xoaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			xoaButton.setBounds(298, 10, 109, 60);
			panelButton.add(xoaButton);
			
			lammoiButton = new JButton("Làm Mới");
			lammoiButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			lammoiButton.setBounds(443, 10, 109, 60);
			panelButton.add(lammoiButton);
			
			timkiemJButton = new JButton("Tìm Kiếm");
			timkiemJButton .setFont(new Font("Tahoma", Font.BOLD, 15));
			timkiemJButton .setBounds(589, 10, 109, 60);
			panelButton.add(timkiemJButton );
			
			JPanel panel1 = new JPanel();
			panel1.setForeground(Color.BLACK);
			panel1.setBounds(10, 402, 641, 226);
			panelTab.add(panel1);
			panel1.setLayout(null);
			
			mahoadonJLabel = new JLabel("Mã Hóa Đơn");
			mahoadonJLabel .setBounds(0, 24, 77, 24);
			panel1.add(mahoadonJLabel );
			mahoadonJLabel .setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			mahoadonJTextField = new JTextField();
			//mahoadonJTextField.setEditable(false);
			mahoadonJTextField.setColumns(10);
			mahoadonJTextField.setBounds(85, 28, 88, 24);
			panel1.add(mahoadonJTextField);
			
			ngaylaphoadonJLabel = new JLabel("Ngày Lập Hóa Đơn");
			ngaylaphoadonJLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			ngaylaphoadonJLabel.setBounds(0, 64, 114, 24);
			panel1.add(ngaylaphoadonJLabel);
			
			ngaylaphoadonJTextField = new JTextField();
			ngaylaphoadonJTextField.setColumns(10);
			ngaylaphoadonJTextField.setBounds(124, 66, 192, 24);
			panel1.add(ngaylaphoadonJTextField);
			
			JLabel tenkhachhangJLabel = new JLabel("Tên Khách Hàng");
			tenkhachhangJLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			tenkhachhangJLabel.setBounds(0, 117, 114, 24);
			panel1.add(tenkhachhangJLabel);
			
			tenkhachhangJTextField = new JTextField();
			tenkhachhangJTextField.setColumns(10);
			tenkhachhangJTextField.setBounds(124, 121, 192, 24);
			panel1.add(tenkhachhangJTextField);
			
			dongiaJLabel = new JLabel("Đơn Giá");
			dongiaJLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			dongiaJLabel.setBounds(0, 174, 58, 24);
			panel1.add(dongiaJLabel);
			
			dongiaJTextField = new JTextField();
			dongiaJTextField.setColumns(10);
			dongiaJTextField.setBounds(71, 176, 181, 23);
			panel1.add(dongiaJTextField);
			
			sogiothueJLabel = new JLabel("Số Giờ Thuê");
			sogiothueJLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			sogiothueJLabel.setBounds(365, 104, 77, 24);
			panel1.add(sogiothueJLabel);
			
			sogiothueJTextField = new JTextField();
			sogiothueJTextField.setColumns(10);
			sogiothueJTextField.setBounds(477, 106, 130, 24);
			panel1.add(sogiothueJTextField);
			
			maphongJLabel = new JLabel("Mã Phòng");
			maphongJLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			maphongJLabel.setBounds(376, 31, 77, 24);
			panel1.add(maphongJLabel);
			
			maphongJTextField = new JTextField();
			maphongJTextField.setColumns(10);
			maphongJTextField.setBounds(477, 33, 88, 24);
			panel1.add(maphongJTextField);
			
			tongthanhtienJButton = new JButton("Tổng thành tiền");
			
			tongthanhtienJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			tongthanhtienJButton.setBackground(Color.WHITE);
			tongthanhtienJButton.setBounds(283, 168, 144, 36);
			panel1.add(tongthanhtienJButton);
			
			tongthanhtienJTextField = new JTextField();
			tongthanhtienJTextField.setColumns(10);
			tongthanhtienJTextField.setBounds(437, 178, 170, 24);
			panel1.add(tongthanhtienJTextField);
			table.getColumnModel().getColumn(1).setPreferredWidth(107);
			table.getColumnModel().getColumn(2).setPreferredWidth(107);
			
			
			
			//hoa don theo ngay
			JPanel panelTAB = new JPanel();
			tabbedPane.addTab("HÓA ĐƠN THEO NGÀY", null, panelTAB, null);
			panelTAB.setLayout(null);
			
			JPanel hoadontheogioJPanel = new JPanel();
			hoadontheogioJPanel.setLayout(null);			
			hoadontheogioJPanel.setBounds(0, 0, 861, 51);
			panelTAB.add(hoadontheogioJPanel);
			
			JLabel hoadontheongayJLabel = new JLabel("HÓA ĐƠN THEO NGÀY");		
			hoadontheongayJLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			hoadontheongayJLabel.setBounds(269, 10, 291, 36);
			hoadontheogioJPanel.add(hoadontheongayJLabel);
			
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(0, 61, 861, 207);
			panelTAB.add(scrollPane1);
			
			 table1 = new JTable();
			 //table1.setEditingRow(state);
			scrollPane1.setViewportView(table1);
			table1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"Mã Hóa Đơn", "Tên Khách Hàng ", "Mã Phòng ", "Ngày Lập Hóa Đơn","Đơn giá","Số ngày thuê" ,"Thành Tiền "
				}
			));
			
			JPanel panelButton1 = new JPanel();
			panelButton1.setLayout(null);

			panelButton1.setBounds(10, 293, 750, 80);
			panelTAB.add(panelButton1);
			
			 themButton1 = new JButton("Thêm");
			themButton1.setFont(new Font("Tahoma", Font.BOLD, 15));

			themButton1.setBounds(10, 10, 109, 60);
			panelButton1.add(themButton1);
			
			 suaButton1 = new JButton("Sửa");
			suaButton1.setFont(new Font("Tahoma", Font.BOLD, 15));

			suaButton1.setBounds(151, 10, 109, 60);
			panelButton1.add(suaButton1);
			
			 xoaButton1 = new JButton("Xóa");
			xoaButton1.setFont(new Font("Tahoma", Font.BOLD, 15));

			xoaButton1.setBounds(298, 10, 109, 60);
			panelButton1.add(xoaButton1);
			
			 lammoiButton1 = new JButton("Làm Mới");
			lammoiButton1.setFont(new Font("Tahoma", Font.BOLD, 15));

			lammoiButton1.setBounds(443, 10, 109, 60);
			panelButton1.add(lammoiButton1);
			
			 timkiemJButton1 = new JButton("Tìm Kiếm");
			timkiemJButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			timkiemJButton1.setBounds(589, 10, 109, 60);
			panelButton1.add(timkiemJButton1);
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
	
			panel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel2.setBounds(28, 400, 641, 226);
			panelTAB.add(panel2);
			
			JLabel MaHoaDonJLabel1 = new JLabel("Mã Hóa Đơn");
			MaHoaDonJLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			MaHoaDonJLabel1.setBounds(0, 24, 77, 24);
			panel2.add(MaHoaDonJLabel1);
			
			 mahoadonJTextField1 = new JTextField();
	
			mahoadonJTextField1.setColumns(10);
			mahoadonJTextField1.setBounds(85, 28, 88, 24);
			panel2.add(mahoadonJTextField1);
			
			JLabel ngaylaphoadonJLabel1 = new JLabel("Ngày Lập Hóa Đơn");
			ngaylaphoadonJLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			ngaylaphoadonJLabel1.setBounds(0, 64, 114, 24);
			panel2.add(ngaylaphoadonJLabel1);
			
			 ngaylaphoadonJTextField1 = new JTextField();
			ngaylaphoadonJTextField1.setColumns(10);
			ngaylaphoadonJTextField1.setBounds(124, 66, 192, 24);
			panel2.add(ngaylaphoadonJTextField1);
			
			JLabel tenkhachhangJLabel1 = new JLabel("Tên Khách Hàng");
			tenkhachhangJLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			tenkhachhangJLabel1.setBounds(0, 117, 114, 24);
			panel2.add(tenkhachhangJLabel1);
			
			 tenkhachhangJTextField1 = new JTextField();
			tenkhachhangJTextField1.setColumns(10);
			tenkhachhangJTextField1.setBounds(124, 121, 192, 24);
			panel2.add(tenkhachhangJTextField1);
			
			JLabel dongiaJLabel1 = new JLabel("Đơn Giá");
			dongiaJLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			dongiaJLabel1.setBounds(0, 174, 58, 24);
			panel2.add(dongiaJLabel1);
			
			 dongiaJTextField1 = new JTextField();
			dongiaJTextField1.setColumns(10);
			dongiaJTextField1.setBounds(71, 176, 181, 23);
			panel2.add(dongiaJTextField1);
			
			JLabel songaythueJLabel1 = new JLabel("Số Ngày Thuê");
			songaythueJLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			songaythueJLabel1.setBounds(365, 104, 88, 24);
			panel2.add(songaythueJLabel1);
			
			songaythueJTextField1 = new JTextField();
			songaythueJTextField1.setColumns(10);
			songaythueJTextField1.setBounds(477, 106, 130, 24);
			panel2.add(songaythueJTextField1);
			
			JLabel maphongJLabel1 = new JLabel("Mã Phòng");
			maphongJLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			maphongJLabel1.setBounds(376, 31, 77, 24);
			panel2.add(maphongJLabel1);
			
			 maphongJTextField1 = new JTextField();
			maphongJTextField1.setColumns(10);
			maphongJTextField1.setBounds(477, 33, 88, 24);
			panel2.add(maphongJTextField1);
			
			 tongthanhtienJButton1 = new JButton("Tổng thành tiền");

			tongthanhtienJButton1.setFont(new Font("Tahoma", Font.BOLD, 13));
			tongthanhtienJButton1.setBounds(283, 168, 144, 36);
			panel2.add(tongthanhtienJButton1);			
			 tongthanhtienJTextField1 = new JTextField();
			tongthanhtienJTextField1.setColumns(10);
			tongthanhtienJTextField1.setBounds(437, 178, 170, 24);
			panel2.add(tongthanhtienJTextField1);
			table1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
					
					String mahoadon = tableModel.getValueAt(table1.getSelectedRow(), 0).toString();
					
				   String tenkhachhang = tableModel.getValueAt(table1.getSelectedRow(), 1).toString();
					String maphong = tableModel.getValueAt(table1.getSelectedRow(), 2).toString();
				   String ngaylaphoadon = tableModel.getValueAt(table1.getSelectedRow(), 3).toString();
					String dongia =tableModel.getValueAt(table1.getSelectedRow(), 4).toString();
					String songaythue =tableModel.getValueAt(table1.getSelectedRow(), 5).toString();
									 
					mahoadonJTextField1.setText(mahoadon);
					tenkhachhangJTextField1.setText(tenkhachhang);
					maphongJTextField1.setText(maphong);
					ngaylaphoadonJTextField1.setText(ngaylaphoadon);
					dongiaJTextField1.setText(dongia);
					songaythueJTextField1.setText(songaythue);									
				}		
			});
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					
					String mahoadon = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
					
				   String tenkhachhang = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
					String maphong = tableModel.getValueAt(table.getSelectedRow(), 2).toString();
				   String ngaylaphoadon = tableModel.getValueAt(table.getSelectedRow(), 3).toString();
					String dongia =tableModel.getValueAt(table.getSelectedRow(), 4).toString();
					String sogiothue =tableModel.getValueAt(table.getSelectedRow(), 5).toString();					 
					mahoadonJTextField.setText(mahoadon);
					tenkhachhangJTextField.setText(tenkhachhang);
					maphongJTextField.setText(maphong);
					ngaylaphoadonJTextField.setText(ngaylaphoadon);
					dongiaJTextField.setText(dongia);
					sogiothueJTextField.setText(sogiothue);					
				}		
			});
			lammoiButton1.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {					
					clear1();
				}
			});
	        lammoiButton.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {				
					clear();
				}
			});
		}	
		public void clear1() {
			mahoadonJTextField1.setText("");
			tenkhachhangJTextField1.setText("");		
			maphongJTextField1.setText("");
			ngaylaphoadonJTextField1.setText("");
			dongiaJTextField1.setText("");
			songaythueJTextField1.setText("");
			tongthanhtienJTextField1.setText("");
		}

		public void clear() {
			mahoadonJTextField.setText("");
			tenkhachhangJTextField.setText("");
			maphongJTextField.setText("");
			ngaylaphoadonJTextField.setText("");
			dongiaJTextField.setText("");
			sogiothueJTextField.setText("");
			tongthanhtienJTextField.setText("");
		}
       public HDService getHoaDonService() {
			return hoaDonService;
		}
		
		public JTextField getMahoadonJTextField() {
			return mahoadonJTextField;
		}
		public JTextField getMahoadonJTextField1() {
			return mahoadonJTextField1;
		}
		public JTextField getNgaylaphoadonJTextField() {
			return ngaylaphoadonJTextField;
		}
		public JTextField getTenkhachhangJTextField() {
			return tenkhachhangJTextField;
		}
		public JTextField getDongiaJTextField() {
			return dongiaJTextField;
		}
		public JTextField getMaphongJTextField() {
			return maphongJTextField;
		}
		public JTextField getTongthanhtienJTextField() {
			return tongthanhtienJTextField;
		}
		
		public JTextField getNgaylaphoadonJTextField1() {
			return ngaylaphoadonJTextField1;
		}
		public JTextField getTenkhachhangJTextField1() {
			return tenkhachhangJTextField1;
		}
		public JTextField getDongiaJTextField1() {
			return dongiaJTextField1;
		}
		public JTextField getMaphongJTextField1() {
			return maphongJTextField1;
		}
		public JTextField getTongthanhtienJTextField1() {
			return tongthanhtienJTextField1;
		}
		public JTable getTable() {
			return table;
		}
		public JTable getTable1() {
			return table1;
		}
		public JTextField getSogiothueJTextField() {
			return sogiothueJTextField;
		}
		
		public JTextField getSongaythueJTextField1() {			
			return songaythueJTextField1;
		}

		@Override
		public void update() {			
			LoadTableNgay();
			loadTableGio();
		}
		 public void LoadTableNgay() {
		    	//HDService hd = Gui.getHoaDonService();	
		    	List<HDTheoNgay> hoadons = hoaDonService.getAllHD();		         
			     DefaultTableModel tableModel1 = (DefaultTableModel) table1.getModel();
				 tableModel1.setRowCount(0);
				 for (HDTheoNgay hoadon : hoadons) {
			            Object[] rowData = { hoadon.getmaHD(), hoadon.gettenKH(), hoadon.getmaPhong(), hoadon.getngayHD(),
			            		 hoadon.getdonGia(),  hoadon.getsoNgayO(), hoadon.ThanhTien() };
			            tableModel1.addRow(rowData);
			        }
		    }
		 public void loadTableGio() {
				
				List<HDTheoGio> hoadons = hoaDonService.getAllhd();

			      DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				  tableModel.setRowCount(0);
				 for (HDTheoGio hoadon : hoadons) {
			            Object[] rowData = { hoadon.getmaHD(), hoadon.gettenKH(), hoadon.getmaPhong(), hoadon.getngayHD(),
			            		 hoadon.getdonGia(),    hoadon.getsoGioThue(), hoadon.ThanhTien() };
			            tableModel.addRow(rowData);
			        }
			}
}