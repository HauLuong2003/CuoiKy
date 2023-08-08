package DomainLayer;
import Observer.Publisher;
import Observer.Subscriber;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HDTheoNgay extends HoaDon implements Publisher{
	  private HDService hoadonService;
	  private List<Subscriber> subscribers = new LinkedList<Subscriber>();
      int SoNgayO;
      public HDTheoNgay() {    	 
    	  hoadonService = new HDServiceiml();
      }           
      public HDTheoNgay(int MaHD, String TenKH
    		  ,int MaPhong,Date NgayHD,Double DonGia,int SoNgayO, Double thanhTien ) {
    	  this.MaHD = MaHD;
    	  this.TenKH =TenKH;  	
    	  this.MaPhong = MaPhong;
    	  this.NgayHD = NgayHD;
    	  this.DonGia =DonGia;
//    	  super();
    	  this.SoNgayO = SoNgayO;
    	  //hoadonService = new HDServiceiml();
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
		notifySubscribers();	
		 
	}
	public void Xoa(int ma) {
		//HDTheoNgay hoadon = new HDTheoNgay();
		hoadonService.deleteHD(ma);		
		notifySubscribers();
	}
	public void Sua() {
		HDTheoNgay hoadon = new HDTheoNgay(this.MaHD, TenKH, SoNgayO, NgayHD, DonGia, SoNgayO,ThanhTien());
		hoadonService.updateHD(hoadon);
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
	public void setsoNgayO(int SoNgayO) {
        this.SoNgayO = SoNgayO;		
	}
	public int getsoNgayO() {
		return SoNgayO;		
	}
	@Override
	public String toString() {
		
		return "Ma hoa don :"+MaHD +", Ten khach hang:"+TenKH
				+", Ma phong"+MaPhong+", Ngay hoa don :"+NgayHD+", Don gia:"+DonGia+", So ngay o:"+SoNgayO + ThanhTien();
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
