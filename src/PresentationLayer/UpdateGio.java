package PresentationLayer;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;

	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.table.DefaultTableModel;

	import DomainLayer.HDService;
import DomainLayer.HDTheoGio;
import DomainLayer.HDTheoNgay;

	public class UpdateGio  implements ActionListener {
		private GUI Gui;
	    public UpdateGio(GUI Gui) {
	    	this.Gui=Gui;   	    	
	    }
	  
		@Override
		public void actionPerformed(ActionEvent e) {
	     	update();		 
		}
		
		   public void update() {   		
			   HDService hd = Gui.getHoaDonService();	
				JTextField mahoadonJTextField = Gui.getMahoadonJTextField();
				JTextField tenkhachhangJTextField = Gui.getTenkhachhangJTextField();
			    JTextField maphongJTextField = Gui.getMaphongJTextField();
				JTextField ngaylaphoadonJTextField = Gui.getNgaylaphoadonJTextField();
				JTextField dongiaJTextField = Gui.getDongiaJTextField();
				JTextField sogiothueJTextField =Gui.getSogiothueJTextField();
				
				int mahd = Integer.parseInt(mahoadonJTextField.getText());
				String tenkh = tenkhachhangJTextField.getText();
				int maphong =Integer.parseInt(maphongJTextField.getText());
						// chuyen dạng ngày
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date ngaylap = new Date();
				try {
						ngaylap =  dateFormat.parse(ngaylaphoadonJTextField.getText());
			   } catch (ParseException e1) {
							
							e1.printStackTrace();
				}			
				Double dongia = Double.parseDouble(dongiaJTextField.getText()) ;
				int sogiothue = Integer.parseInt(sogiothueJTextField.getText());
				Double ThanhTien = sogiothue*dongia;
					
				HDTheoGio hoadon = new HDTheoGio(mahd, tenkh, maphong,ngaylap,dongia,sogiothue,ThanhTien);
				hd.updateHD1(hoadon);	
				loadTableGio();
				mahoadonJTextField.setText("");
				tenkhachhangJTextField.setText("");
				maphongJTextField.setText("");
				ngaylaphoadonJTextField.setText("");
				dongiaJTextField.setText("");
				sogiothueJTextField.setText("");
		}
			
			public void loadTableGio() {
				HDService hd = Gui.getHoaDonService();
				List<HDTheoGio> hoadons = hd.getAllhd();
			
			      JTable table = Gui.getTable();
			      DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				  tableModel.setRowCount(0);
				 for (HDTheoGio hoadon : hoadons) {
			            Object[] rowData = { hoadon.getmaHD(), hoadon.gettenKH(), hoadon.getmaPhong(), hoadon.getngayHD(),
			            		 hoadon.getdonGia(),    hoadon.getsoGioThue(), hoadon.ThanhTien() };
			            tableModel.addRow(rowData);
			        }
			}
	}


