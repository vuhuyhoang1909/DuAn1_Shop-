/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import donaimModel.SanPham;
import Repository.SanPhamRepository;
import service.SanPhamService;
import ViewModel.SamPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SanPhamServiceIMPL implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public ArrayList<SamPhamViewModel> getList() {
        return sanPhamRepository.getList();
    }

    @Override
    public Boolean them(SanPham sp) {
        return sanPhamRepository.them(sp);
    }

    @Override
    public Boolean sua(String idSP, SanPham sp) {
        return sanPhamRepository.sua(idSP, sp);
    }

    @Override
    public Boolean xoa(String idSP) {
        return sanPhamRepository.xoa(idSP);
    }

    @Override
    public ArrayList<SamPhamViewModel> timkiem(String idSP) {
        return sanPhamRepository.timkiem(idSP);
    }

   
}
