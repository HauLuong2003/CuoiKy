package PresentationLayer;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import java.util.List;

	import javax.swing.JOptionPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.table.DefaultTableModel;

	import DomainLayer.HDService;
import DomainLayer.HDTheoGio;


	public class DeletGio  implements ActionListener {
		private GUI Gui;
	    public DeletGio( GUI Gui) {
	    	this.Gui =Gui;
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			Delet();		
		}
	    public void Delet() {    	
	    	 JTable table1 = Gui.getTable();
			// HDService hd = Gui.getHoaDonService();
			 HDTheoGio hdgio = Gui.getHdgio();
			 JTextField mahoadonJTextField1 = Gui.getMahoadonJTextField();
		     JTextField tenkhachhangJTextField1 = Gui.getTenkhachhangJTextField();
		     JTextField maphongJTextField1 = Gui.getMaphongJTextField();
		     JTextField ngaylaphoadonJTextField1 = Gui.getNgaylaphoadonJTextField();
		     JTextField dongiaJTextField1 = Gui.getDongiaJTextField();
		     JTextField songaythueJTextField1 =Gui.getSogiothueJTextField();
		     		
				int row = table1.getSelectedRow();
				if(row == -1) {
					 JOptionPane.showMessageDialog(null, "Please select a student to delete.");
			            return;
				}
				 int mahd = Integer.parseInt(mahoadonJTextField1.getText());
		         mahd =(int) table1.getValueAt(row, 0);
		  		//hd.deletehd1(mahd);	
		        // HDTheoGio hdgio = new HDTheoGio();
		        hdgio.xoa(mahd);
		  		LoadTableGio();	  		
		  		mahoadonJTextField1.setText("");	  	  
				tenkhachhangJTextField1.setText("");		
				maphongJTextField1.setText("");
				ngaylaphoadonJTextField1.setText("");
				dongiaJTextField1.setText("");
				songaythueJTextField1.setText("");
	    }
	         public void LoadTableGio() {
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


