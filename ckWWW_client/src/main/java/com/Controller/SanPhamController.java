package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Service.LoaiSpService;
import com.Service.SanPhamService;
import com.model.LoaiSanPham;
import com.model.SanPham;

@Controller
@RequestMapping("/sanphams")
public class SanPhamController {


	private SanPhamService spService;
	private LoaiSpService loaiSpService;
	
	
	
	@Autowired
	public SanPhamController(SanPhamService spService, LoaiSpService loaiSpService) {
		super();
		this.spService = spService;
		this.loaiSpService = loaiSpService;
	}
	@GetMapping("/sanphams")
	private String showListLoaiSanPham(Model model) {
		List<SanPham> list =spService.getSanPhams();
		System.out.print(list);
		model.addAttribute("listLoaiSP",list);
		model.addAttribute("text","tesstt");
		System.out.print(model.toString());
		return "home";
		
	}
	
	@GetMapping("/list")
	private String showSanPhamByLoaiSP(@RequestParam("IDloaiSP")  int id,Model model) {
		LoaiSanPham lsp = loaiSpService.getLoaiSp(id);
		List<SanPham> list = lsp.getSanPhams();
		System.out.println(list);
		model.addAttribute("lisSP",list);
		model.addAttribute("lsp", lsp);
		return "sanpham";
	}
	
	@GetMapping("/showFormAdd")
	private String showFormAdd(Model model,@RequestParam("IDloaiSP") int id) {
		SanPham sp = new SanPham();
		model.addAttribute("sanpham",sp);
		model.addAttribute("IDloaiSP",id);
		model.addAttribute("isUpdate", false);
		return "sanpham-form";
	}
	
	@PostMapping("/saveSP")
	private String saveSanPham(@ModelAttribute("sanpham") SanPham sp,@RequestParam("IDloaiSP")int id) {
		spService.saveSanPham(sp,id);
		return"redirect:/sanphams/list?IDloaiSP="+id;
	}
	
	@PostMapping("/updateSP")
	private String updateSanPham(@ModelAttribute("sanpham") SanPham sp,@RequestParam("IDloaiSP")int id) {
		spService.updateSanPham(sp,id);
		return"redirect:/sanphams/list?IDloaiSP="+id;
	}
	
	@GetMapping("/showFormUpdate")
	private String showFormUpdate(@RequestParam("IDloaiSP") int lspid,@RequestParam("id") int id, Model model) {
		SanPham sp = spService.getSanPham(id);
		model.addAttribute("sanpham",sp);
		model.addAttribute("IDloaiSP",lspid);
		model.addAttribute("isUpdate", true);
		return "sanpham-form";
	}
	
	@GetMapping("/delete")
	private String deleteSanPham(@RequestParam("id")int id,int IDloaiSP) {
		spService.deleteSP(id);
		return "redirect:/sanphams/list?IDloaiSP="+IDloaiSP;
	}
	
	
	
	
	
}
