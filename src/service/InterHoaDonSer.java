/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import donaimModel.HoaDon;
import donaimModel.KhachHang;
import donaimModel.NhanVien;
import donaimModel.SanPham;
import java.util.ArrayList;

/**
 *
 * @author pqd15
 */
public interface InterHoaDonSer {
    public ArrayList<HoaDon> getList();
    public void Add(HoaDon hd);
    public ArrayList<SanPham> getidsp();
    public ArrayList<KhachHang> getidkh();
    public ArrayList<NhanVien> getidnv();
    public void delete(String idhd);
    public void update(HoaDon hd);
    public ArrayList<HoaDon> search(String id);
}
