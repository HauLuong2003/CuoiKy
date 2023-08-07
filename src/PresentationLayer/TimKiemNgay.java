package PresentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DomainLayer.HDService;
import DomainLayer.HDTheoNgay;

public class TimKiemNgay implements ActionListener{
	private GUI Gui;
   public TimKiemNgay(GUI Gui) {
	   this.Gui =Gui;
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		 HDService hd = Gui.getHoaDonService();
		
		 String input = JOptionPane.showInputDialog("nhâp vào mã hóa đơn.");  
		 JTextField mahoadonJTextField = Gui.getMahoadonJTextField1();
         JTextField tenkhachhangJTextField1 = Gui.getTenkhachhangJTextField1();
	     JTextField maphongJTextField1 = Gui.getMaphongJTextField1();
	     JTextField ngaylaphoadonJTextField1 = Gui.getNgaylaphoadonJTextField1();
	     JTextField dongiaJTextField1 = Gui.getDongiaJTextField1();
	     JTextField songaythueJTextField1 =Gui.getSongaythueJTextField1();
	     
	     int mahd = Integer.parseInt(input);
	     HDTheoNgay mahoadon = hd.getHDByMa(mahd);
		 if(mahoadon != null) {
			mahoadonJTextField.setText(String.valueOf (mahoadon.getmaHD()));
			tenkhachhangJTextField1.setText(mahoadon.gettenKH());
			maphongJTextField1.setText(String.valueOf (mahoadon.getmaPhong()));
			ngaylaphoadonJTextField1.setText(String.valueOf(mahoadon.getngayHD()));
			dongiaJTextField1.setText(String.valueOf(mahoadon.getdonGia()));
			songaythueJTextField1.setText(String.valueOf(mahoadon.getsoNgayO()));
			
		}
		else {
	        JOptionPane.showMessageDialog(null, "không tin thấy.");	     
	    }
	}
}
