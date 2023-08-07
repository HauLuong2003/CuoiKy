package PersistenceLayer;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DomainLayer.HDTheoGio;
import DomainLayer.HDTheoNgay;
public class KetNoiCSDL implements HoaDonGateway  {
	
     private  Connection connection;
     public KetNoiCSDL() {
    	 String url ="jdbc:sqlserver://localhost:1433;databaseName=HoaDon;encrypt=true;trustServerCertificate=true";
		  String username = "sa";
		  String pass ="09012003";			
			try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection  =DriverManager.getConnection(url,username,pass);
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			    
			}		
     }
	@Override
	public void addHD(HDTheoNgay hoadon) {
		
		Date sqldate = new Date(hoadon.getngayHD().getTime());		
		String sql = "INSERT INTO HDTheoNgay (MaHD, TenKH, MaPhong, NgayHD, DonGia, SoNgayThue,ThanhTien) VALUES (?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoadon.getmaHD());
            statement.setString(2, hoadon.gettenKH());
            statement.setInt(3, hoadon.getmaPhong());
            statement.setDate(4,  sqldate);
            statement.setDouble(5, hoadon.getdonGia());
            statement.setInt(6, hoadon.getsoNgayO());
            statement.setDouble(7, hoadon.ThanhTien());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	@Override
	public void updateHD(HDTheoNgay hoadon) {
		Date sqldate = new Date(hoadon.getngayHD().getTime());
		String sql = "UPDATE HDTheoNgay SET TenKH = ?, MaPhong = ?, NgayHD = ?, DonGia = ?, SoNgayThue = ?,ThanhTien =?  WHERE MaHD = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			    statement.setInt(7, hoadon.getmaHD());
	            statement.setString(1, hoadon.gettenKH());
	            statement.setInt(2, hoadon.getmaPhong());
	            statement.setDate(3,  sqldate);
	            statement.setDouble(4, hoadon.getdonGia());
	            statement.setInt(5, hoadon.getsoNgayO());	           	           
	            statement.setDouble(6, hoadon.ThanhTien());
	            statement.executeUpdate();
		}
			catch(Exception e2) {
				e2.printStackTrace();
			}
	}
	@Override
	public void deleteHD(int MaHD) {
		String sql ="DELETE FROM HDTheoNgay WHERE MaHD =?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,MaHD);
			statement.executeUpdate();
		}
		catch(Exception e3) {
			e3.printStackTrace();
		}		
	}
	@Override
	public HDTheoNgay getHDByMa(int MaHD) {
		String sql = "SELECT * FROM HDTheoNgay WHERE MaHD = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaHD);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {        	 
            	  int mahd = resultSet.getInt("MaHD");            	
                  String tenkh = resultSet.getString("TenKH");                 
                  int maphong = resultSet.getInt("MaPhong");                 
                  Date ngayhd = resultSet.getDate("NgayHD");                 
                  double dongia = resultSet.getDouble("DonGia");
                  int songaythue = resultSet.getInt("SoNgayThue");
                   //Calculate the average mark using the formula provided
                  double thanhtien = songaythue*dongia ;
                  return new HDTheoNgay(mahd,tenkh, maphong,ngayhd,dongia,songaythue,thanhtien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;		
	}
	@Override
	public List<HDTheoNgay> getAllHD() {
		List<HDTheoNgay> hoadon = new ArrayList<>();
		String sql = "SELECT * FROM HDTheoNgay";
		try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {    	 
                int mahd = resultSet.getInt("MaHD");
                String tenkh = resultSet.getString("TenKH");
                int maphong = resultSet.getInt("MaPhong");
                Date ngayhd = resultSet.getDate("NgayHD");
                double dongia = resultSet.getDouble("DonGia");
                int songaythue = resultSet.getInt("SoNgayThue");
                // Calculate the average mark using the formula provided
                double thanhtien = resultSet.getDouble("ThanhTien") ;
                hoadon.add(new HDTheoNgay(mahd,tenkh, maphong,ngayhd,dongia,songaythue,thanhtien));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return hoadon;
	}
	@Override
	public void addHD1(HDTheoGio hoadon) {
		
       Date sqldate = new Date(hoadon.getngayHD().getTime());
		
		String sql = "INSERT INTO HDTheoGio (MaHD, TenKH, MaPhong, NgayHD, DonGia, SoGioThue,ThanhTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoadon.getmaHD());
            statement.setString(2, hoadon.gettenKH());
            statement.setInt(3, hoadon.getmaPhong());
            statement.setDate(4,  sqldate);
            statement.setDouble(5, hoadon.getdonGia());
            statement.setInt(6, hoadon.getsoGioThue());
            statement.setDouble(7, hoadon.ThanhTien());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	@Override
	public void updateHD1(HDTheoGio hoadon) {
		Date sqldate = new Date(hoadon.getngayHD().getTime());
		String sql = "UPDATE HDTheoGio set TenKH = ?, MaPhong = ?, NgayHD = ?"
				+ ", DonGia = ?, SoGioThue = ?,ThanhTien =? WHERE MaHD = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
		        statement.setInt(7, hoadon.getmaHD());
	            statement.setString(1, hoadon.gettenKH());
	            statement.setInt(2, hoadon.getmaPhong());
	            statement.setDate(3,  sqldate);
	            statement.setDouble(4, hoadon.getdonGia());
	            statement.setInt(5, hoadon.getsoGioThue());
	            statement.setDouble(6, hoadon.ThanhTien());
	            statement.executeUpdate();
		}
			catch(Exception e2) {
				e2.printStackTrace();
			}		
	}
	@Override
	public void deletehd1(int MaHD) {
		String sql ="DELETE FROM HDTheoGio WHERE MaHD =?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,MaHD);
			statement.executeUpdate();
		}
		catch(Exception e3) {
			e3.printStackTrace();
		}
		
		
	}
	@Override
	public HDTheoGio gethdByMa(int MaHD) {
		String sql = "SELECT * FROM HDTheoGio WHERE MaHD = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaHD);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {        	 
            	  int mahd = resultSet.getInt("MaHD");            	
                  String tenkh = resultSet.getString("TenKH");                 
                  int maphong = resultSet.getInt("MaPhong");                 
                  Date ngayhd = resultSet.getDate("NgayHD");                 
                  double dongia = resultSet.getDouble("DonGia");
                  int songaythue = resultSet.getInt("SoGioThue");
                   //Calculate the average mark using the formula provided
                  double thanhtien = songaythue*dongia ;
                  return new HDTheoGio(mahd,tenkh, maphong,ngayhd,dongia,songaythue,thanhtien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	
	}
	@Override
	public List<HDTheoGio> getAllhd() {
		List<HDTheoGio> hoadon = new ArrayList<>();
		String sql = "SELECT * FROM HDTheoGio";
		try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {    	 
                int mahd = resultSet.getInt("MaHD");
                String tenkh = resultSet.getString("TenKH");
                int maphong = resultSet.getInt("MaPhong");
                Date ngayhd = resultSet.getDate("NgayHD");
                double dongia = resultSet.getDouble("DonGia");
                int sogiothue = resultSet.getInt("SoGioThue");
          
                double thanhtien = resultSet.getDouble("ThanhTien") ;
              hoadon.add(new HDTheoGio(mahd,tenkh, maphong,ngayhd,dongia,sogiothue,thanhtien));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return hoadon;
		
	}
	@Override
	public Double TinhTong() {
		String sql ="SELECT SUM (ThanhTien) AS TONG FROM HDTheoNgay";
		try(PreparedStatement statement = connection.prepareStatement(sql)){	
			
			 ResultSet resultSet = statement.executeQuery();
			 if (resultSet.next()) {
				  double thanhtien = resultSet.getDouble("TONG"); 
			      return thanhtien;
			    }
	}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return null;	
	}
	@Override
	public Double tinhTong() {
		String sql ="SELECT SUM (ThanhTien) AS TONG FROM HDTheoGio";
		try(PreparedStatement statement = connection.prepareStatement(sql)){	
			
			 ResultSet resultSet = statement.executeQuery();
			 if (resultSet.next()) {
				  double thanhtien = resultSet.getDouble("TONG"); 
			      return thanhtien;
			 }
	}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		
		return null;
		
		
	}	
}
  