package com.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.LoaiSpService;
import com.Service.SanPhamService;
import com.entity.LoaiSanPham;
import com.entity.SanPham;


@RestController
@RequestMapping("/api")
public class SanPhamRestController {

	private SanPhamService spService;
	private LoaiSpService lspService;
	
	
	@Autowired
	public SanPhamRestController(SanPhamService spService, LoaiSpService lspService) {
		super();
		this.spService = spService;
		this.lspService = lspService;
	}

	@GetMapping("/sanphams")
	public List<SanPham>getSanPhams(){
		List<SanPham>sanPhams = spService.getSanPhams();
		return sanPhams;
	}
	
	@GetMapping("/sanpham/{idSp}")
	public SanPham getSanPham(@PathVariable int idSp)throws Exception{
		SanPham sp = spService.getSanPham(idSp);
		return sp;
	}
	
	@PostMapping("{lspID}/sanphams")
	public SanPham addSanPham(@RequestBody SanPham sp,@PathVariable int lspID) {
		spService.saveSanPham(sp,lspID);
		return sp;
	}
	
	@PutMapping("{lspID}/sanphams")
	public SanPham updateSanPham(@RequestBody SanPham sp,@PathVariable int lspID) {
		spService.updateSanPham(sp,lspID);
		return sp;
	}
	
	@DeleteMapping("/sanphams/{idSp}")
	public String deleteSanPham(@PathVariable int idSp) {
		SanPham sp = spService.getSanPham(idSp);
		if ((idSp < 0)|| sp==null) {
			throw new RuntimeException("customer id not found - " + idSp);
		}
		spService.deleteSP(idSp);
		return "Deleted customer id - " + idSp;
	}
	
	
	
	@GetMapping("loaisanpham/{idSp}/sanphams")
	public List<SanPham> getSanPhamByLoaiSP(@PathVariable int idSp){
		LoaiSanPham lsp = lspService.getLoaiSp(idSp);
		List<SanPham>sanPhams = lsp.getSanPhams();
		return sanPhams;
	}

}
