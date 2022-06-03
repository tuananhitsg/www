package com.dao;

import java.util.List;

import com.entity.LoaiSanPham;

public interface LoaiSPDAO {
	public List<LoaiSanPham> getLoaiSPs();
	
	public LoaiSanPham getLoaiSp(int id);
	
	public void saveLoaiSp(LoaiSanPham lsp);
	
	public void updateLoaiSp(LoaiSanPham lsp);
	
	public void deleteLoaiSp(int id);
}
