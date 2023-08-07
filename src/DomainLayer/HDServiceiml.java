package DomainLayer;

import java.util.List;

import PersistenceLayer.HoaDonDAO;
import PersistenceLayer.HoaDonDAOiml;

import PersistenceLayer.KetNoiCSDL;

public class HDServiceiml implements HDService {
    private HoaDonDAO hoaDonDAO;
	public HDServiceiml () {
		hoaDonDAO = new HoaDonDAOiml(new KetNoiCSDL());
	}
	@Override
	public void addHD(HDTheoNgay hoadon) {
		// TODO Auto-generated method stub		
		hoaDonDAO.addHD(hoadon);
	}
	@Override
	public void updateHD(HDTheoNgay hoadon) {
		// TODO Auto-generated method stub
		hoaDonDAO.updateHD(hoadon);
		
	}

	@Override
	public void deleteHD(int MaHD) {
		// TODO Auto-generated method stub
		hoaDonDAO.deleteHD(MaHD);
	}

	@Override
	public HDTheoNgay getHDByMa(int MaHD) {
		// TODO Auto-generated method stub
		return hoaDonDAO.getHDByMa(MaHD);
	}

	@Override
	public List<HDTheoNgay> getAllHD() {
		// TODO Auto-generated method stub
		return hoaDonDAO.getAllHD();
	}
	@Override
	public void addHD1(HDTheoGio hoadon) {
		// TODO Auto-generated method stub
		hoaDonDAO.addHD1(hoadon);
	}
	@Override
	public void updateHD1(HDTheoGio hoadon) {
		// TODO Auto-generated method stub
		hoaDonDAO.updateHD1(hoadon);
	}
	@Override
	public void deletehd1(int MaHD) {
		// TODO Auto-generated method stub
		hoaDonDAO.deletehd1(MaHD);
	}
	@Override
	public HDTheoGio gethdByMa(int MaHD) {
		// TODO Auto-generated method stub
		return hoaDonDAO.gethdByMa(MaHD);
	}
	@Override
	public List<HDTheoGio> getAllhd() {
		// TODO Auto-generated method stub
		return hoaDonDAO.getAllhd();
	}
	@Override
	public Double TinhTong( ) {
		// TODO Auto-generated method stub
		return hoaDonDAO.TinhTong();
	}
	@Override
	public Double tinhTong() {
		
		return hoaDonDAO.tinhTong();
	}

}
