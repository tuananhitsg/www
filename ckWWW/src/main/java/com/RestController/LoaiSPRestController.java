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
import com.entity.LoaiSanPham;
import com.entity.SanPham;

@RestController
@RequestMapping("/api")
public class LoaiSPRestController {
	@Autowired
	private LoaiSpService lspService;
//	
	@GetMapping("/loaisanphams")
	public List<LoaiSanPham>getLoaiSanPhams(){
		List<LoaiSanPham>lsps = lspService.getLoaiSPs();
		return lsps;
	}
	
	@GetMapping("/loaisanphams/{id}")
	public LoaiSanPham getLoaiSanPham(@PathVariable int id)throws Exception{
		LoaiSanPham lsp = lspService.getLoaiSp(id);
		return lsp;
	}
	
	@PostMapping("/loaisanphams")
	public LoaiSanPham addLoaiSP(@RequestBody LoaiSanPham lsp) {
		lspService.saveLoaiSp(lsp);
		return lsp;
	}
	
	@PutMapping("/loaisanphams")
	public LoaiSanPham updateLoaiSP(@RequestBody LoaiSanPham lsp) {
		lspService.updateLoaiSp(lsp);
		return lsp;
	}
	
	@DeleteMapping("/loaisanphams/{id}")
	public String deleteLoaiSP (@PathVariable int id) {
		LoaiSanPham lsp = lspService.getLoaiSp(id);
		if ((id < 0)|| lsp==null) {
			throw new RuntimeException("customer id not found - " + id);
		}
		lspService.deleteLoaiSp(id);
		return "Deleted customer id - " + id;
	}
}
