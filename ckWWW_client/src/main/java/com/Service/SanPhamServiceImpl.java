package com.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.SanPham;
@Service
public class SanPhamServiceImpl implements SanPhamService {
	
	private RestTemplate restTemplate;
	private String crmUrl;
	
	
	@Autowired
	public SanPhamServiceImpl(RestTemplate restTemplate,@Value("${crm.rest.url}") String crmUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmUrl = crmUrl;
	}
	@Override
	public List<SanPham> getSanPhams() {
		ResponseEntity<List<SanPham>> response =
				restTemplate.exchange(crmUrl+"/sanphams",HttpMethod.GET,null,new ParameterizedTypeReference<List<SanPham>>() {
				});
		List<SanPham>list =response.getBody();
		return list;
	}
	@Override
	public SanPham getSanPham(int idSp) {
		SanPham sp = restTemplate.getForObject(crmUrl+"/sanpham/"+idSp, SanPham.class);
		return sp;
	}
	@Override
	public void saveSanPham(SanPham sp,int lspID) {
		restTemplate.postForEntity(crmUrl+"/"+lspID+"/sanphams", sp, String.class);
	}
	@Override
	public void updateSanPham(SanPham sp,int lspID) {
		restTemplate.put(crmUrl+"/"+lspID+"/sanphams", sp);
	}
	@Override
	public void deleteSP(int idSp) {
		restTemplate.delete(crmUrl+"/sanphams/"+idSp);
	}
}
