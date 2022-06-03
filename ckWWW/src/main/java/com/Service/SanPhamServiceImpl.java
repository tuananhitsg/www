package com.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SanPhamDAO;
import com.entity.SanPham;
@Service
public class SanPhamServiceImpl  implements SanPhamService{
	
	@Autowired
    private SanPhamDAO spDAO;

	@Override
	@Transactional
	public List<SanPham> getSanPhams() {
		return spDAO.getSanPhams();
	}

	@Override
	@Transactional
	public SanPham getSanPham(int idSp) {
		return spDAO.getSanPham(idSp);
	}

	@Override
	@Transactional
	public void saveSanPham(SanPham sp,int lspID) {
		spDAO.saveSanPham(sp,lspID);
		
	}

	@Override
	@Transactional
	public void updateSanPham(SanPham sp,int lspID) {
		spDAO.updateSanPham(sp,lspID);
		
	}



	@Override
	@Transactional
	public void deleteSP(int idSp) {
		spDAO.deleteSP(idSp);
		
	}

}
