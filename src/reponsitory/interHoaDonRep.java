/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reponsitory;

import donaimModel.HoaDon;
import donaimModel.KhachHang;
import donaimModel.NhanVien;
import donaimModel.SanPham;
import java.util.ArrayList;

/**
 *
 * @author pqd15
 */
public interface interHoaDonRep {
    public ArrayList<HoaDon> getlist();
    public void add(HoaDon hd);
    public ArrayList<SanPham> getIdsp();
    public ArrayList<KhachHang> getIdkh();
    public ArrayList<NhanVien> getIdnv();
    public void delete(String idhd);
    public void update(HoaDon hd);
    public ArrayList<HoaDon> search(String id);
}
