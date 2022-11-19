/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import donaimModel.SanPham;
import ViewModel.SamPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface SanPhamService {

    public ArrayList<SamPhamViewModel> getList();

    public Boolean them(SanPham sp);

    public Boolean sua(String idSP, SanPham sp);

    public Boolean xoa(String idSP);

    public ArrayList<SamPhamViewModel> timkiem(String idSP);

}
