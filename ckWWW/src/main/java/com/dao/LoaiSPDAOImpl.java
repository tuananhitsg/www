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
public class LoaiSPDAOImpl implements LoaiSPDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<LoaiSanPham> getLoaiSPs() {
		List<LoaiSanPham> lsps = new ArrayList<LoaiSanPham>();
		Session session = sessionFactory.getCurrentSession();
		
		Query<LoaiSanPham> query = session.createQuery("from LoaiSanPham", LoaiSanPham.class);
		lsps = query.getResultList();
		return lsps;
	}

	@Override
	public LoaiSanPham getLoaiSp(int id) {
		LoaiSanPham lsp = new LoaiSanPham();
		String sql = "from LoaiSanPham where id =:id";
		Session session = sessionFactory.getCurrentSession();
		Query<LoaiSanPham> query = session.createQuery(sql, LoaiSanPham.class);
        query.setParameter("id", id);
        lsp= query.getSingleResult();
        return lsp;
	}


	@Override
	public void saveLoaiSp(LoaiSanPham lsp) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(lsp);
		
	}

	@Override
	public void updateLoaiSp(LoaiSanPham lsp) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(lsp);
		
		
	}

	@Override
	public void deleteLoaiSp(int id) {
		Session session = sessionFactory.getCurrentSession();
		LoaiSanPham lsp = session.get(LoaiSanPham.class, id);
		session.delete(lsp);
	}

}
