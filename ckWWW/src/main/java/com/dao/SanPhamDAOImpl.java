package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.LoaiSanPham;
import com.entity.SanPham;



@Repository
public class SanPhamDAOImpl implements SanPhamDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<SanPham> getSanPhams() {
		List<SanPham> listsp= new ArrayList<SanPham>();
		Session session = sessionFactory.getCurrentSession();
		Query<SanPham> query = session.createQuery("from SanPham", SanPham.class);
		listsp = query.getResultList();
		return listsp;
	}

	@Override
	public SanPham getSanPham(int idSp) {
		Session session = sessionFactory.getCurrentSession();		
		SanPham sp = session.get(SanPham.class, idSp);		
        return sp;
	}


	@Override
	public void deleteSP(int idSp) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sp = session.get(SanPham.class, idSp);
        session.delete(sp);
	}

	@Override
	public void saveSanPham(SanPham sp, int lspID) {
		Session session = sessionFactory.getCurrentSession();	
		LoaiSanPham lsp =session.get(LoaiSanPham.class, lspID);
		lsp.addSanPham(sp);
		session.saveOrUpdate(sp);
	}

	@Override
	public void updateSanPham(SanPham sp, int lspID) {
		Session session = sessionFactory.getCurrentSession();	
		LoaiSanPham lsp =session.get(LoaiSanPham.class, lspID);
		SanPham spNew = session.get(SanPham.class, sp.getId());
		setValueSanPham(spNew, sp);
		session.saveOrUpdate(spNew);
		
	}
	
	private void setValueSanPham(SanPham theSP, SanPham tempSP) {
		theSP.setTenSP(tempSP.getTenSP());
		theSP.setDonGia(tempSP.getDonGia());
    }

}
