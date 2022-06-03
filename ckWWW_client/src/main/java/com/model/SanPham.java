package com.model;

import java.util.List;



public class SanPham {
	private int id;
	private String tenSP;
	private float donGia;
	private LoaiSanPham loaiSanPhams;

	public SanPham() {
		super();
	}
	public SanPham(int id, String tenSP, float donGia, LoaiSanPham loaiSanPhams) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.loaiSanPhams = loaiSanPhams;
	}
	public SanPham(int id) {
		super();
		this.id = id;
	}
	public SanPham(String tenSP, float donGia, LoaiSanPham loaiSP) {
		super();
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.loaiSanPhams = loaiSP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public LoaiSanPham getLoaiSanPhams() {
		return loaiSanPhams;
	}
	public void setLoaiSanPhams(LoaiSanPham loaiSanPhams) {
		this.loaiSanPhams = loaiSanPhams;
	}
	@Override
	public String toString() {
		return "SanPham [id=" + id + ", tenSP=" + tenSP + ", donGia=" + donGia + "]";
	}
}
