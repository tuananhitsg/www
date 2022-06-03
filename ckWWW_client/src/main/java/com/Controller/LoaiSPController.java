package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Service.LoaiSpService;
import com.Service.SanPhamService;
import com.model.LoaiSanPham;
import com.model.SanPham;


@Controller
@RequestMapping("loaisanphams")
public class LoaiSPController {

	private LoaiSpService loaiSpService;

	private SanPhamService spService;
	
	@Autowired
	public LoaiSPController(LoaiSpService loaiSpService, SanPhamService spService) {
		super();
		this.loaiSpService = loaiSpService;
		this.spService = spService;
	}

	@GetMapping("/list")
	private String showListLoaiSanPham(Model model) {
		List<LoaiSanPham> list =loaiSpService.getLoaiSPs();
		System.out.print(list);
		model.addAttribute("listLoaiSP",list);
		System.out.print(model.toString());
		return "home";
	}
	
	@GetMapping("/showFormLoaiSPforAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		LoaiSanPham loaisp = new LoaiSanPham();
		theModel.addAttribute("loaisp", loaisp);
		return "loaisp-form";
	}
	
	@GetMapping("/showFormLoaiSPforUpdate")
	public String showFormForUpdate(@RequestParam("idlsp") int theId, Model theModel) {
		
		LoaiSanPham loaisp = loaiSpService.getLoaiSp(theId);
		theModel.addAttribute("loaisp", loaisp);
		return "loaisp-form";
	}
	
	@PostMapping("/saveLoaiSp")
	public String saveLoaiSp(@ModelAttribute("loaisp") LoaiSanPham lsp){
		loaiSpService.saveLoaiSp(lsp);
		return "redirect:/loaisanphams/list";
	}
	
	@GetMapping("/deleteLoaiSp")
	public String deleteLoaiSp(@RequestParam("idlsp") int id) {
		loaiSpService.deleteLoaiSp(id);
		return "redirect:/loaisanphams/list";
	}
}
