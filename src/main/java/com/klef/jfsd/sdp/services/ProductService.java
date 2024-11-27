package com.klef.jfsd.sdp.services;

import java.util.List;

import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.models.Product;

public interface ProductService 
{

	public String addproduct(Product product);
	public List<Product> getallproducts();
	public Product viewprobyid(int eid);
	List<Product> getProductsByMember(Member member);
	public Product getProductById(int productId);
	

}
