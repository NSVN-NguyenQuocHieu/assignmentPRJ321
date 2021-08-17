/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public class LoaiXe {
    private int id;
    private String ten;
    private int tong_so_xe;
    private float gia_thue_1_ngay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTong_so_xe() {
        return tong_so_xe;
    }

    public void setTong_so_xe(int tong__so_xe) {
        this.tong_so_xe = tong__so_xe;
    }

    public float getGia_thue_1_ngay() {
        return gia_thue_1_ngay;
    }

    public void setGia_thue_1_ngay(float gia_thue_1_ngay) {
        this.gia_thue_1_ngay = gia_thue_1_ngay;
    }
    
}
