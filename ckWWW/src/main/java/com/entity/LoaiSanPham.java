package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loai_sp")
public class LoaiSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ten_loai_sp", columnDefinition = "nvarchar(50)")
	private String tenLoaiSP;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ma_loai")
	private List<SanPham> sanPhams;
	
	
	public List<SanPham> getSanPhams() {
		return sanPhams;
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

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public LoaiSanPham(int id, String tenLoaiSP, List<SanPham> sanPhams) {
		super();
		this.id = id;
		this.tenLoaiSP = tenLoaiSP;
		this.sanPhams = sanPhams;
	}

	public LoaiSanPham() {
		super();
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
}
