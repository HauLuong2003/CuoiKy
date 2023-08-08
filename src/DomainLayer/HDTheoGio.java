package DomainLayer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Observer.Publisher;
import Observer.Subscriber;


public class HDTheoGio extends HoaDon implements Publisher{
	 int SoGioThue;
	 private List<Subscriber> subscribers = new LinkedList<Subscriber>();
	 private HDService hoadonService;
	 public HDTheoGio() {
			  hoadonService = new HDServiceiml();
	 }
     public HDTheoGio(int MaHD, String TenKH,int MaPhong,Date NgayHD
   		  ,Double DonGia,int SoGioThue,double ThanhTien ) {
   	  this.MaHD = MaHD;
   	  this.TenKH =TenKH;
   	  this.NgayHD = NgayHD;
   	  this.MaPhong = MaPhong;
   	  this.DonGia =DonGia;
   	  this.SoGioThue = SoGioThue;
   	 // hoadonService = new HDServiceiml();
     }
	@Override	
	public Double ThanhTien() {		
		double ThanhTien = 0;
		if(SoGioThue <= 30 && SoGioThue >0 ) {
			 ThanhTien = SoGioThue*DonGia;
		}		
		else {
			return ThanhTien;
		}
		return ThanhTien;		
	}
	public void Them() {
		HDTheoGio hoadon = new HDTheoGio(this.MaHD, TenKH, MaPhong, NgayHD, DonGia, SoGioThue,ThanhTien());
		hoadonService.addHD1(hoadon);				
		notifySubscribers();
		
	}
	public void xoa(int ma) {
		hoadonService.deletehd1(ma);				
		notifySubscribers();
	}
	public void Sua() {
		HDTheoGio hoadon = new HDTheoGio(this.MaHD, TenKH, MaPhong, NgayHD, DonGia, SoGioThue,ThanhTien());
		hoadonService.updateHD1(hoadon);
		notifySubscribers();
	}
	public void setmaHD(int MaHD) {
          this.MaHD = MaHD;		
	}
	public int getmaHD() {
		return MaHD;
		
	}
	public void settenKH(String TenKH) {
       this.TenKH = TenKH;		
	}
	public String gettenKH() {
		return TenKH;
	}
	public void setngayHD(Date NgayHD) {
       this.NgayHD = NgayHD;		
	}
	public Date getngayHD() {
		return NgayHD;
	}
	public void setmaPhong(int MaPhong) {
       this.MaPhong = MaPhong;		
	}
	public int getmaPhong() {
		return MaPhong;		
	}
	public void setdonGia(Double DonGia) {
       this.DonGia = DonGia;		
	}
	public Double getdonGia() {
		return DonGia;		
	}
	public void setsoGioThue(int SoGioThue) {
       this.SoGioThue = SoGioThue;		
	}
	public int getsoGioThue() {
		return SoGioThue;		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ma hoa don :"+MaHD +", Ten khach hang:"+TenKH
				+", Ngay hoa don :"+NgayHD+", Ma phong"+MaPhong+", Don gia:"+DonGia+", So gio thue:"+SoGioThue + ThanhTien();
	}
	@Override
	public void subscribe(Subscriber s) {
		subscribers.add(s);	
		
	}
	@Override
	public void unsubscribe(Subscriber s) {
		subscribers.remove(s);
		
	}
	@Override
	public void notifySubscribers() {
		for(Subscriber s: subscribers)
		s.update();
		
	}
}

