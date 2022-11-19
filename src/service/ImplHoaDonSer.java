/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import donaimModel.HoaDon;
import donaimModel.KhachHang;
import donaimModel.NhanVien;
import donaimModel.SanPham;
import java.util.ArrayList;
import reponsitory.ImplHoaDonRep;

/**
 *
 * @author pqd15
 */
public class ImplHoaDonSer implements InterHoaDonSer{
    private ImplHoaDonRep hdRe;
    public ImplHoaDonSer(){
        this.hdRe = new ImplHoaDonRep();
    }
    @Override
    public ArrayList<HoaDon> getList() {
        return this.hdRe.getlist();
    }

    @Override
    public void Add(HoaDon hd) {
        this.hdRe.add(hd);
    }

    @Override
    public ArrayList<SanPham> getidsp() {
        return this.hdRe.getIdsp();
    }

    @Override
    public ArrayList<KhachHang> getidkh() {
        return this.hdRe.getIdkh();
    }

    @Override
    public ArrayList<NhanVien> getidnv() {
        return this.hdRe.getIdnv();
    }

    @Override
    public void delete(String idhd) {
        this.hdRe.delete(idhd);
    }

    @Override
    public void update(HoaDon hd) {
        this.hdRe.update(hd);
    }

    @Override
    public ArrayList<HoaDon> search(String id) {
        return this.hdRe.search(id);
    }
    
}
