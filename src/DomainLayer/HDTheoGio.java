package DomainLayer;

import java.util.Date;

import Observer.Publisher;


public class HDTheoGio extends HoaDon{
	 int SoGioThue;
	 private HDService hoadonService;
     public HDTheoGio(int MaHD, String TenKH,int MaPhong,Date NgayHD
   		  ,Double DonGia,int SoGioThue,double ThanhTien ) {
   	  this.MaHD = MaHD;
   	  this.TenKH =TenKH;
   	  this.NgayHD = NgayHD;
   	  this.MaPhong = MaPhong;
   	  this.DonGia =DonGia;
   	  this.SoGioThue = SoGioThue;
   	  hoadonService = new HDServiceiml();
     }
	@Override	
	public Double ThanhTien() {		
		double ThanhTien = 0;
		if(SoGioThue <= 30 && SoGioThue >0 ) {
			 ThanhTien = SoGioThue*DonGia;
		}

		return ThanhTien;		
	}
	public void Them() {
		HDTheoGio hoadon = new HDTheoGio(this.MaHD, TenKH, MaPhong, NgayHD, DonGia, SoGioThue,ThanhTien());
		hoadonService.addHD1(hoadon);		
		
		Publisher publisher = new Publisher();
		publisher.notifySubscribers();
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
}

