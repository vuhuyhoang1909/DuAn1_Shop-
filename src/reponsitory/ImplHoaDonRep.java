/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reponsitory;

import donaimModel.HoaDon;
import donaimModel.KhachHang;
import donaimModel.NhanVien;
import donaimModel.SanPham;
import java.util.ArrayList;
import Helper.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.xml.transform.Result;

/**
 *
 * @author pqd15
 */
public class ImplHoaDonRep implements interHoaDonRep{

    @Override
    public ArrayList<HoaDon> getlist() {
        ArrayList<HoaDon> listHd = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select * from HOADON";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.execute();
            ResultSet rs = pr.getResultSet();
            while (rs.next()) {        
                String idhd = rs.getString("IDHD");
                String idsp = rs.getString("IdSp");
                String tensp = rs.getString("TenSp");
                String idNV = rs.getString("IdNhanVien");
                String idnd = rs.getString("IdNguoiDung");
                String ngaytao = rs.getString("NgayTao");
                String dchi = rs.getString("DiaChi");
                String thanhtoan = rs.getString("ThanhToan");
                HoaDon hd = new HoaDon(idhd, idsp, idNV, idnd, tensp, dchi, ngaytao, thanhtoan);
                listHd.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHd;
    }

    @Override
    public void add(HoaDon hd) {
        Connection con = DBContext.getConnection();
        String sql = "insert into HOADON(IDHD,IdSp,TenSp,IdNhanVien,IdNguoiDung,NgayTao,DiaChi,ThanhToan) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, hd.getIdhd());
            pr.setString(2, hd.getIdsp());
            pr.setString(3, hd.getTensp());
            pr.setString(4, hd.getIdnv());
            pr.setString(5, hd.getIdkh());
            pr.setString(6, hd.getNgaytao());
            pr.setString(7, hd.getDiachi());
            pr.setString(8, hd.getThanhtoan());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<SanPham> getIdsp() {
        ArrayList<SanPham> lstSp = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select IdSp from SANPHAM";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.execute();
            ResultSet rs = pr.getResultSet();
            while (rs.next()) {                
                String idsp = rs.getString("IdSp");
                SanPham sp = new SanPham(idsp);
                lstSp.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstSp;
    }

    @Override
    public ArrayList<KhachHang> getIdkh() {
       ArrayList<KhachHang> lstkh = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select IdNguoiDung from NGUOIDUNG";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.execute();
            ResultSet rs = pr.getResultSet();
            while (rs.next()) {                
                String idnd = rs.getString("IdNguoiDung");
                KhachHang kh = new KhachHang(idnd);
                lstkh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstkh;
    }

    @Override
    public ArrayList<NhanVien> getIdnv() {
        ArrayList<NhanVien> lstnv = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select IdNhanVien from NHANVIEN";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.execute();
            ResultSet rs = pr.getResultSet();
            while (rs.next()) {                
                String idnv = rs.getString("IdNhanVien");
                NhanVien nv = new NhanVien(idnv);
                lstnv.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstnv;
    }

    @Override
    public void delete(String idhd) {
        Connection con = DBContext.getConnection();
        String sql = "delete from HOADON where IDHD = ?";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, idhd);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDon hd) {
        
        Connection con = DBContext.getConnection();
        String sql = "update HOADON set IDHD = ?,IdSp=?,TenSp=?,IdNhanVien=?,IdNguoiDung=?,NgayTao=?,DiaChi=?,ThanhToan=? where IDHD = ? ";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, hd.getIdhd());
            pr.setString(2, hd.getIdsp());
            pr.setString(3, hd.getTensp());
            pr.setString(4, hd.getIdnv());
            pr.setString(5, hd.getIdkh());
            pr.setString(6, hd.getNgaytao());
            pr.setString(7, hd.getDiachi());
            pr.setString(8, hd.getThanhtoan());
            pr.setString(9, hd.getIdhd());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<HoaDon> search(String id) {
        ArrayList<HoaDon> listHd = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "select * from HOADON where IDHD =?";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, id);
            pr.execute();
            ResultSet rs = pr.getResultSet();
            while (rs.next()) {                
                String idhd = rs.getString("IDHD");
                String idsp = rs.getString("IdSp");
                String tensp = rs.getString("TenSp");
                String idNV = rs.getString("IdNhanVien");
                String idnd = rs.getString("IdNguoiDung");
                String ngaytao = rs.getString("NgayTao");
                String dchi = rs.getString("DiaChi");
                String thanhtoan = rs.getString("ThanhToan");
                HoaDon hd = new HoaDon(idhd, idsp, idNV, idnd, tensp, dchi, ngaytao, thanhtoan);
                listHd.add(hd);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ImplHoaDonRep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHd;
    }
    
}
