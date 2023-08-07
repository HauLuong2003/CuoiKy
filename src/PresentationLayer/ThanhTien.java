package PresentationLayer;


	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JTextField;
	import DomainLayer.HDService;
	public class ThanhTien  implements ActionListener {
	     private GUI Gui;
	     public ThanhTien (GUI Gui) {
	    	 this.Gui=Gui;
	     }
		@Override
		public void actionPerformed(ActionEvent e) {
	          HDService hd = Gui.getHoaDonService();
	          JTextField thanhtien = Gui.getTongthanhtienJTextField();
	          thanhtien.setText(String.valueOf( hd.tinhTong()));
	                    
		}

	}
