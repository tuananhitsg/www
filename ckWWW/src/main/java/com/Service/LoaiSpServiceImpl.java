package com.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoaiSPDAO;
import com.entity.LoaiSanPham;
@Service
public class LoaiSpServiceImpl implements LoaiSpService {

	
	@Autowired
    private LoaiSPDAO lspDAO;
	
	@Override
	@Transactional
	public List<LoaiSanPham> getLoaiSPs() {
		return lspDAO.getLoaiSPs();
	}

	@Override
	@Transactional
	public void saveLoaiSp(LoaiSanPham lsp) {
		lspDAO.saveLoaiSp(lsp);
		
	}

	@Override
	@Transactional
	public void updateLoaiSp(LoaiSanPham lsp) {
		lspDAO.updateLoaiSp(lsp);
		
	}

	@Override
	@Transactional
	public void deleteLoaiSp(int id) {
		lspDAO.deleteLoaiSp(id);
		
	}

	@Override
	@Transactional
	public LoaiSanPham getLoaiSp(int id) {
		return lspDAO.getLoaiSp(id);
	}

}
