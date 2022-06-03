package com.Service;

import java.util.List;

import com.entity.SanPham;

public interface SanPhamService {

	public List<SanPham> getSanPhams();
	public SanPham getSanPham(int idSp);
	public void saveSanPham(SanPham sp,int lspID);
	public void updateSanPham(SanPham sp,int lspID);
	public void deleteSP(int idSp);
}
