package com.model;

import java.util.ArrayList;
import java.util.List;

import com.model.*;



public class LoaiSanPham {
	private int id;
	private String tenLoaiSP;
	private List<SanPham> sanPhams;
	
	
	public LoaiSanPham() {
		super();
	}

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	public SanPham getSanPham(int spID) {
        if (sanPhams != null) {
            for (SanPham theSP : sanPhams)
                if (theSP.getId() == spID)
                    return theSP;
        }
        return null;
    }
	public void addSanPham(SanPham theSP) {
        if (sanPhams == null) {
        	sanPhams = new ArrayList<SanPham>();
        }
        sanPhams.add(theSP);
    }

	public LoaiSanPham(int id, String tenLoaiSP, List<SanPham> sanPhams) {
	super();
	this.id = id;
	this.tenLoaiSP = tenLoaiSP;
	this.sanPhams = sanPhams;
}

	public LoaiSanPham(int id) {
		super();
		this.id = id;
	}

	public LoaiSanPham(String tenLoaiSP) {
		super();
		this.tenLoaiSP = tenLoaiSP;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [id=" + id + ", tenLoaiSP=" + tenLoaiSP + "]";
	}
}
