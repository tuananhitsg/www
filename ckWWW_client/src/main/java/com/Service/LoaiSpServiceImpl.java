package com.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.LoaiSanPham;

@Service
public class LoaiSpServiceImpl implements LoaiSpService {
	private RestTemplate restTemplate;
	private String crmUrl;
	 
	@Autowired
	public LoaiSpServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String crmUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmUrl = crmUrl;
	}
	@Override
	public List<LoaiSanPham> getLoaiSPs() {
		ResponseEntity<List<LoaiSanPham>> response = restTemplate.exchange(crmUrl+"/loaisanphams", HttpMethod.GET,null,new ParameterizedTypeReference<List<LoaiSanPham>>() {
		});
		List<LoaiSanPham> list = response.getBody();
		return list;
	}
	@Override
	public LoaiSanPham getLoaiSp(int id) {
		LoaiSanPham lsp = restTemplate.getForObject(crmUrl+"/loaisanphams/"+id, LoaiSanPham.class);
		return lsp;
	}
	@Override
	public void saveLoaiSp(LoaiSanPham lsp) {
		restTemplate.postForEntity(crmUrl+"/loaisanphams", lsp, String.class);
	}
	@Override
	public void updateLoaiSp(LoaiSanPham lsp) {
		restTemplate.put(crmUrl+"/loaisanphams", lsp);
	}
	@Override
	public void deleteLoaiSp(int id) {
		restTemplate.delete(crmUrl+"/loaisanphams/"+id);
	}
}
