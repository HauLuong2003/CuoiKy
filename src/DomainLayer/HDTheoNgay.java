package DomainLayer;
import Observer.Publisher;
import java.util.Date;

public class HDTheoNgay extends HoaDon{
	  private HDService hoadonService;
      int SoNgayO;
      public HDTheoNgay() {}
      
      
      public HDTheoNgay(int MaHD, String TenKH
    		  ,int MaPhong,Date NgayHD,Double DonGia,int SoNgayO, Double thanhTien ) {
    	  this.MaHD = MaHD;
    	  this.TenKH =TenKH;  	
    	  this.MaPhong = MaPhong;
    	  this.NgayHD = NgayHD;
    	  this.DonGia =DonGia;
//    	  super();
    	  this.SoNgayO = SoNgayO;
    	  hoadonService = new HDServiceiml();
      }
	@Override
	
	public Double ThanhTien() {
		
		Double thanhtien =(double) 0;
		if(SoNgayO > 7) {
		thanhtien = (SoNgayO*DonGia)-(SoNgayO*DonGia)*0.2;
		}
		else {
		 thanhtien =SoNgayO*DonGia;
		}
		return thanhtien;		
	}
	public void Them() {
		HDTheoNgay hoadon = new HDTheoNgay(this.MaHD, TenKH, SoNgayO, NgayHD, DonGia, SoNgayO,ThanhTien());
		hoadonService.addHD(hoadon);
		
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
	public void setsoNgayO(int SoNgayO) {
        this.SoNgayO = SoNgayO;		
	}
	public int getsoNgayO() {
		return SoNgayO;		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ma hoa don :"+MaHD +", Ten khach hang:"+TenKH
				+", Ma phong"+MaPhong+", Ngay hoa don :"+NgayHD+", Don gia:"+DonGia+", So ngay o:"+SoNgayO + ThanhTien();
	}
}
