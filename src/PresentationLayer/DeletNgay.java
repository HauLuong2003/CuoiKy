package PresentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DomainLayer.HDService;
import DomainLayer.HDTheoNgay;

public class DeletNgay implements ActionListener {
	private GUI Gui;
    public DeletNgay( GUI Gui) {
    	this.Gui =Gui;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Delet();		
	}
    public void Delet() {    	
    	 JTable table1 = Gui.getTable1();
		// HDService hd = Gui.getHoaDonService();
		 HDTheoNgay hdngay = Gui.getHdngay();
		 JTextField mahoadonJTextField1 = Gui.getMahoadonJTextField1();
	     JTextField tenkhachhangJTextField1 = Gui.getTenkhachhangJTextField1();
	     JTextField maphongJTextField1 = Gui.getMaphongJTextField1();
	     JTextField ngaylaphoadonJTextField1 = Gui.getNgaylaphoadonJTextField1();
	     JTextField dongiaJTextField1 = Gui.getDongiaJTextField1();
	     JTextField songaythueJTextField1 =Gui.getSongaythueJTextField1();
	     		
			int row = table1.getSelectedRow();
			if(row == -1) {
				 JOptionPane.showMessageDialog(null, "Please select a student to delete.");
		            return;
			}
			 int mahd = Integer.parseInt(mahoadonJTextField1.getText());
	         mahd =(int) table1.getValueAt(row, 0);
	         hdngay.Xoa(mahd);		
	  		LoadTableNgay();	  		
	  		mahoadonJTextField1.setText("");	  	  
			tenkhachhangJTextField1.setText("");		
			maphongJTextField1.setText("");
			ngaylaphoadonJTextField1.setText("");
			dongiaJTextField1.setText("");
			songaythueJTextField1.setText("");
    }
         public void LoadTableNgay() {
            HDService hd = Gui.getHoaDonService();
     	    List<HDTheoNgay> hoadons = hd.getAllHD();
     	
     	      JTable table = Gui.getTable1();
     	      DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
     		  tableModel.setRowCount(0);
     		 for (HDTheoNgay hoadon : hoadons) {
     	            Object[] rowData = { hoadon.getmaHD(), hoadon.gettenKH(), hoadon.getmaPhong(), hoadon.getngayHD(),
     	            		 hoadon.getdonGia(),    hoadon.getsoNgayO(), hoadon.ThanhTien() };
     	            tableModel.addRow(rowData);
     	        }
    }
}
