/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reponsitory;

import donaimModel.SanPham;
import Helper.DBContext;
import ViewModel.SamPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SanPhamRepository {

    private DBContext connection;

    public ArrayList<SamPhamViewModel> getList() {
        ArrayList<SamPhamViewModel> lstSamPhamViewModel = new ArrayList<>();
        String sql = "select SanPham.idSP, tenSP,ngayNhap,TenTrangThai,idNhanHieu,giaNhap,giaBan,ngaySanXuat from SanPham";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SamPhamViewModel sp = new SamPhamViewModel();
                sp.setIdSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setNgayNhap(rs.getString(3));
                sp.setTenTrangThai(rs.getString(4));
                sp.setNhanHieu(rs.getString(5));
                sp.setGiaNhap(rs.getString(6));
                sp.setGiaBan(rs.getString(7));
                sp.setNgaySanXuat(rs.getString(8));

                lstSamPhamViewModel.add(sp);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return lstSamPhamViewModel;
    }

    public Boolean them(SanPham sp) {
        String sql = "insert into SanPham(idSP,tenSP,ngayNhap,TenTrangThai,idNhanHieu,giaNhap,giaBan,ngaySanXuat) values\n"
                + "(?,?,?,?,?,?,?,?)";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getIdSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getNgayNhap());
            ps.setObject(4, sp.getTenTrangThai());
            ps.setObject(5, sp.getNhanHieu());
            ps.setObject(6, sp.getGiaNhap());
            ps.setObject(7, sp.getGiaBan());
            ps.setObject(8, sp.getNgaySanXuat());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public Boolean xoa(String idSP) {
        String sql = "delete SanPham where idSP = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, idSP);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public Boolean sua(String idSP, SanPham sp) {
        String sql = "update SanPham tenSP = ?,ngayNhap =?,TenTrangThai = ?,idNhanHieu = ?,giaNhap = ?,giaBan = ?,ngaySanXuat= ? where idSP = '" + idSP + "'";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, sp.getTenSP());
            ps.setObject(2, sp.getNgayNhap());
            ps.setObject(3, sp.getTenTrangThai());
            ps.setObject(4, sp.getNhanHieu());
            ps.setObject(5, sp.getGiaNhap());
            ps.setObject(6, sp.getGiaBan());
            ps.setObject(7, sp.getNgaySanXuat());
//            ps.setObject(8, sp.getIdSP());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public ArrayList<SamPhamViewModel> timkiem(String idSP) {
        ArrayList<SamPhamViewModel> getList = new ArrayList<>();
        String sql = "select SanPham.tenSP,ngayNhap,TenTrangThai,idNhanHieu,giaNhap,giaBan,ngaySanXuat from SanPham where SANPHAM.IdSp like '%"+idSP+"%'";
        try (Connection con = connection.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SamPhamViewModel sp = new SamPhamViewModel();             
                sp.setTenSP(rs.getString(1));
                sp.setNgayNhap(rs.getString(2));
                sp.setTenTrangThai(rs.getString(3));
                sp.setNhanHieu(rs.getString(4));
                sp.setGiaNhap(rs.getString(5));
                sp.setGiaBan(rs.getString(6));
                sp.setNgaySanXuat(rs.getString(7));                
                getList.add(sp);
            }
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return getList;
    }

    public static void main(String[] args) {
        ArrayList<SamPhamViewModel> lst = new SanPhamRepository().getList();
        System.out.println(lst.toString());
    }
}
