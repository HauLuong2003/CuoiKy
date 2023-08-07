package PersistenceLayer;

import java.util.List;

import DomainLayer.HDTheoGio;
import DomainLayer.HDTheoNgay;


public interface HoaDonDAO {
	  void addHD(HDTheoNgay hoadon);
	  void updateHD(HDTheoNgay hoadon);
	  void deleteHD(int MaHD);
	  HDTheoNgay getHDByMa(int MaHD);
	  List<HDTheoNgay> getAllHD();    
	  Double TinhTong();
	  
	  void addHD1(HDTheoGio hoadon);
	  void updateHD1(HDTheoGio hoadon);
	  void deletehd1(int MaHD);
	  HDTheoGio gethdByMa(int MaHD);
	  List<HDTheoGio> getAllhd();   
	  Double tinhTong();
}
