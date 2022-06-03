package com.Service;

import java.util.List;

import com.model.LoaiSanPham;



public interface LoaiSpService {
	public List<LoaiSanPham> getLoaiSPs();
	
	public LoaiSanPham getLoaiSp(int id);
	
	public void saveLoaiSp(LoaiSanPham lsp);
	
	public void updateLoaiSp(LoaiSanPham lsp);
	
	public void deleteLoaiSp(int id);
}
