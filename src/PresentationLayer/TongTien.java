package PresentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DomainLayer.HDService;

import DomainLayer.HDTheoNgay;

public class TongTien implements ActionListener {
     private GUI Gui;
     public TongTien (GUI Gui) {
    	 this.Gui=Gui;
     }
	@Override
	public void actionPerformed(ActionEvent e) {
          HDService hd = Gui.getHoaDonService();
          JTextField thanhtien = Gui.getTongthanhtienJTextField1();
      // hd.TinhTong();
          thanhtien.setText(String.valueOf( hd.TinhTong()));
                    
	}

}
