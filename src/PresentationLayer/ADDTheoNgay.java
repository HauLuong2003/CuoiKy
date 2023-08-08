package PresentationLayer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DomainLayer.HDService;

import DomainLayer.HDTheoNgay;

public class ADDTheoNgay implements ActionListener {
	private GUI Gui;
    public ADDTheoNgay(GUI Gui) {
    	this.Gui=Gui;   	    	
    } 
	@Override
	public void actionPerformed(ActionEvent e) {
     	ThemNgay();		 
	}	
      public void ThemNgay() {   		
//  	  HDService hd = Gui.getHoaDonService();		
  		  HDTheoNgay hdngay = Gui.getHdngay();
  	      JTextField mahoadonJTextField1 = Gui.getMahoadonJTextField1();
          JTextField tenkhachhangJTextField1 = Gui.getTenkhachhangJTextField1();
          JTextField maphongJTextField1 = Gui.getMaphongJTextField1();
          JTextField ngaylaphoadonJTextField1 = Gui.getNgaylaphoadonJTextField1();
          JTextField dongiaJTextField1 = Gui.getDongiaJTextField1();
          JTextField songaythueJTextField1 =Gui.getSongaythueJTextField1();
          
          int mahd = Integer.parseInt(mahoadonJTextField1.getText());
  		  String tenkh = tenkhachhangJTextField1.getText();
  		  int maphong =Integer.parseInt(maphongJTextField1.getText());
  		// chuyen dạng ngày
  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          Date ngaylap = new Date();
  		try {
  		ngaylap =  dateFormat.parse(ngaylaphoadonJTextField1.getText());
  		} catch (ParseException e1) {			
  			e1.printStackTrace();
  		}			
  		Double dongia = Double.parseDouble(dongiaJTextField1.getText()) ;
  		int songaythue = Integer.parseInt(songaythueJTextField1.getText());
//  	  Double ThanhTien = songaythue*dongia;	     				       
//  	    HDTheoNgay hoadon = new HDTheoNgay(mahd, tenkh, maphong,ngaylap,dongia,songaythue,ThanhTien); 		
//  	    hd.addHD(hoadon);	  		
  		hdngay.setmaHD(mahd);    	
  		hdngay.settenKH(tenkh);
  		hdngay.setmaPhong(maphong);
    	hdngay.setdonGia(dongia);    	
    	hdngay.setngayHD(ngaylap);
    	hdngay.setsoNgayO(songaythue);
    	hdngay.Them();
    	
    	//hoadon.Them();
  		//hdngay.ThanhTien();
     	LoadTableNgay();
      }
      
     //  tai du lieu len bang      
	  public void LoadTableNgay() {
    	HDService hd = Gui.getHoaDonService();	
    	List<HDTheoNgay> hoadons = hd.getAllHD();
         JTable table1 = Gui.getTable1();
	     DefaultTableModel tableModel1 = (DefaultTableModel) table1.getModel();
		 tableModel1.setRowCount(0);
		 for (HDTheoNgay hoadon : hoadons) {
	            Object[] rowData = { hoadon.getmaHD(), hoadon.gettenKH(), hoadon.getmaPhong(), hoadon.getngayHD(),
	            		 hoadon.getdonGia(),  hoadon.getsoNgayO(), hoadon.ThanhTien() };
	            tableModel1.addRow(rowData);
	        }
    }
    
}
