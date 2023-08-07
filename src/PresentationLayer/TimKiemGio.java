package PresentationLayer;


	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	import DomainLayer.HDService;
import DomainLayer.HDTheoGio;


	public class TimKiemGio  implements ActionListener{
		private GUI Gui;
	   public TimKiemGio(GUI Gui) {
		   this.Gui =Gui;
	   }
		@Override
		public void actionPerformed(ActionEvent e) {
			HDService hd = Gui.getHoaDonService();
			
			 String input = JOptionPane.showInputDialog("nhâp vào mã hóa đơn.");  
			 JTextField mahoadonJTextField = Gui.getMahoadonJTextField();
	         JTextField tenkhachhangJTextField1 = Gui.getTenkhachhangJTextField();
		     JTextField maphongJTextField1 = Gui.getMaphongJTextField();
		     JTextField ngaylaphoadonJTextField1 = Gui.getNgaylaphoadonJTextField();
		     JTextField dongiaJTextField1 = Gui.getDongiaJTextField();
		     JTextField songaythueJTextField1 =Gui.getSogiothueJTextField();
		     
		     int mahd = Integer.parseInt(input);
		     HDTheoGio mahoadon = hd.gethdByMa(mahd);
			 if(mahoadon != null) {
				mahoadonJTextField.setText(String.valueOf (mahoadon.getmaHD()));
				tenkhachhangJTextField1.setText(mahoadon.gettenKH());
				maphongJTextField1.setText(String.valueOf (mahoadon.getmaPhong()));
				ngaylaphoadonJTextField1.setText(String.valueOf(mahoadon.getngayHD()));
				dongiaJTextField1.setText(String.valueOf(mahoadon.getdonGia()));
				songaythueJTextField1.setText(String.valueOf(mahoadon.getsoGioThue()));
				
			}
			else {
		        JOptionPane.showMessageDialog(null, "không tim thấy.");	     
		    }
		}
		

	}

