package DomainLayer;

import java.util.Date;

public abstract class HoaDon {
       int MaHD;
       String TenKH;
       Date NgayHD;
       int MaPhong;
       Double DonGia; 
       abstract Double ThanhTien();
}
