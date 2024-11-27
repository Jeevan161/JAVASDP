package com.klef.jfsd.sdp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.models.Product;
import com.klef.jfsd.sdp.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductRepository productRepository;
	
	
	public String addproduct(Product product) 
	{
	  productRepository.save(product);	
	  return "Registered Successfully";
	}
	 @Override
	    public List<Product> getProductsByMember(Member member) {
	        // Use the custom query method to fetch products associated with the member
	        return productRepository.findProductsByMember(member);
	    }
	
	@Override
	public List<Product> getallproducts() 
	{
		return productRepository.findAll();
	}

	@Override
	public Product viewprobyid(int eid) {
		Optional<Product> obj = productRepository.findById(eid);    
	    
	    if(obj.isPresent())
	    {
	      Product pro = obj.get();
	      return pro;
	    }
	      return null;
	}
	@Override
	public Product getProductById(int productId) {
		  Optional<Product> productOptional = productRepository.findById(productId);
	        return productOptional.orElse(null);

	}
}
