package PersistenceLayer;

import java.util.List;

import DomainLayer.HDTheoGio;
import DomainLayer.HDTheoNgay;


public class HoaDonDAOiml implements HoaDonDAO {
    private HoaDonGateway hoaDonGateway;
	public HoaDonDAOiml(HoaDonGateway hoaDonGateway) {
		this.hoaDonGateway = hoaDonGateway;
	}

	@Override
	public void addHD(HDTheoNgay hoadon) {
	
		hoaDonGateway.addHD(hoadon);
	}

	@Override
	public void updateHD(HDTheoNgay hoadon) {
		
		hoaDonGateway.updateHD(hoadon);
	}

	@Override
	public void deleteHD(int MaHD) {
		// TODO Auto-generated method stub
		hoaDonGateway.deleteHD(MaHD);
	}

	@Override
	public HDTheoNgay getHDByMa(int MaHD) {
		// TODO Auto-generated method stub
		return hoaDonGateway.getHDByMa(MaHD);
	}

	@Override
	public List<HDTheoNgay> getAllHD() {
		
		return hoaDonGateway.getAllHD();
	}

	@Override
	public void addHD1(HDTheoGio hoadon) {
		// TODO Auto-generated method stub
		hoaDonGateway.addHD1(hoadon);
	}

	@Override
	public void updateHD1(HDTheoGio hoadon) {
		// TODO Auto-generated method stub
		hoaDonGateway.updateHD1(hoadon);
	}

	@Override
	public void deletehd1(int MaHD) {
		// TODO Auto-generated method stub
		hoaDonGateway.deletehd1(MaHD);
	}

	@Override
	public HDTheoGio gethdByMa(int MaHD) {
		// TODO Auto-generated method stub		
		return hoaDonGateway.gethdByMa(MaHD);
	}
	@Override
	public List<HDTheoGio> getAllhd() {
		// TODO Auto-generated method stub
		return hoaDonGateway.getAllhd();
	}

	@Override
	public Double TinhTong( ) {
		// TODO Auto-generated method stub
		return hoaDonGateway.TinhTong( );
	}

	@Override
	public Double tinhTong() {
		// TODO Auto-generated method stub
		return hoaDonGateway.tinhTong();
	}

}
