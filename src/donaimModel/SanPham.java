/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donaimModel;

/**
 *
 * @author DELL
 */
public class SanPham {
    private String idSP;
    private String tenSP;
    private String ngayNhap;
    private String tenTrangThai;
    private String nhanHieu;
    private String giaNhap;
    private String giaBan;
    private String ngaySanXuat;

    public SanPham() {
    }

    public SanPham(String idSP, String tenSP, String ngayNhap, String tenTrangThai, String nhanHieu, String giaNhap, String giaBan, String ngaySanXuat) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.ngayNhap = ngayNhap;
        this.tenTrangThai = tenTrangThai;
        this.nhanHieu = nhanHieu;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSP=" + idSP + ", tenSP=" + tenSP + ", ngayNhap=" + ngayNhap + ", tenTrangThai=" + tenTrangThai + ", nhanHieu=" + nhanHieu + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", ngaySanXuat=" + ngaySanXuat + '}';
    }
}
