package com.entity;

import java.util.List;

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
@Table(name="san_pham")
public class SanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ten_sp", columnDefinition = "nvarchar(50)")
	private String tenSP;
	
	@Column(name = "don_gia")
	private float donGia;
	

	public SanPham() {
		super();
	}

	

	public SanPham(int id) {
		super();
		this.id = id;
	}

	

	public SanPham(String tenSP, float donGia) {
		super();
		this.tenSP = tenSP;
		this.donGia = donGia;
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



	@Override
	public String toString() {
		return "SanPham [id=" + id + ", tenSP=" + tenSP + ", donGia=" + donGia + "]";
	}

	
	

	

	

	
	
	

}
