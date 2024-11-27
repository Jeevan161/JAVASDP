package com.klef.jfsd.sdp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdp.models.Category;
import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.models.Product;
import com.klef.jfsd.sdp.models.SubCategory;
import com.klef.jfsd.sdp.repositories.MemberRepo;
import com.klef.jfsd.sdp.res.PasswordSalting;
import com.klef.jfsd.sdp.services.CategoryService;
import com.klef.jfsd.sdp.services.ProductService;
import com.klef.jfsd.sdp.services.SubCategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class ClientController {
	PasswordSalting pass = new PasswordSalting();
	@Autowired
	private MemberRepo memberRepo;	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private ProductService productService;
	@Autowired 
	private JavaMailSender javaMailSender; 
	 
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService  subCategoryService;
	
	@RequestMapping("/403error")
	public ModelAndView errorpage() 
	{
		System.out.println("403 ERROR");
		return new ModelAndView("/Basic/Error.jsp");
	}
	@PostMapping("/user/save")
	public ResponseEntity<Object> saveUser(@RequestBody Member member)
	{
		System.out.println("hhh");
		member.setPassword(encoder.encode(member.getPassword()));
		Member res = memberRepo.save(member);
		if(res.getId()>0)
		{
			return ResponseEntity.ok("User Saved!!");
		}
		else
		{
			return ResponseEntity.status(404).body("Error,User Not Saved...");
		}
		
	}
	
	@GetMapping("/")
	public ModelAndView home()
	{
		System.out.println("HELLO!!!");
		return new ModelAndView("Basic/Home.jsp");
	}
	@GetMapping("login")
	public ModelAndView login()
	{
		return new ModelAndView("Templates/Login.jsp");
	}

	@GetMapping("subcategories")
	@ResponseBody
	public List<SubCategory> getAllSubcategories() {
	    // Retrieve all subcategories
	    List<SubCategory> subcategories = subCategoryService.getAllSubCategories();
	    return subcategories;
	}
	  @GetMapping("/getByCategory/{categoryId}")
	    public List<SubCategory> getSubcategories(@PathVariable("categoryId") int categoryId) {
	        // Fetch subcategories based on the selected category ID
	        List<SubCategory> subcategories = subCategoryService.getSubcategoriesById(categoryId);
	        for(SubCategory x:subcategories)
	        {
	        	System.err.println(x.getName());
	        }
	        return subcategories;
	    }
	    
	    @GetMapping("subcategories/{categoryId}")
	    public List<SubCategory> getSubcategoriesByCategory(@PathVariable("categoryId") int categoryId) {
	        // Retrieve subcategories based on the selected category
	        List<SubCategory> subcategories = subCategoryService.getSubcategoriesById(categoryId);
	        System.out.println(subcategories);
	        return subcategories;
	    }
	 
	@GetMapping("register")
	public ModelAndView register()
	{
		return new ModelAndView("Templates/Register.jsp");
	}
	@GetMapping("contactus")
	public ModelAndView contactus()
	{
		return new ModelAndView("Templates/Contact.jsp");
	}
	@GetMapping("product")
	public ModelAndView product()
	{
		ModelAndView mv = new ModelAndView("Templates/Products.jsp");
		List<Product> plist = productService.getallproducts();
		mv.addObject("plist", plist);
		System.out.println(plist);
		return mv;
	}
	@GetMapping("adminlogin")
	public ModelAndView adminlogin()
	{
		return new ModelAndView("Templates/AdminLogin.jsp");
	}
	@RequestMapping("about")
	public ModelAndView about()
	{
		return new ModelAndView("Templates/about.jsp");
	}
	@GetMapping("adminhome")
	public ModelAndView adminhome(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("adminObject"));
		
		System.out.println();
		return new ModelAndView("Admin/Home.jsp");
	}
	@RequestMapping("sellerhome")
	public ModelAndView sellerhome(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("producer"));
		
		System.out.println();
		return new ModelAndView("Seller/Home.jsp");
		
	}
	@GetMapping("sellerlogin")
	public ModelAndView sellerlogin()
	{
		return new ModelAndView("Templates/SellerLogin.jsp");
	}
	@GetMapping("cart")
	public ModelAndView cart()
	{
		return new ModelAndView("/Seller/Pay.jsp");
	}
	
	@GetMapping("productview/{id}")
	public ModelAndView productview(@PathVariable("id") int eid)
	{
		Product pro = productService.viewprobyid(eid);
	    ModelAndView mv = new ModelAndView("/Templates/ProductView.jsp");
	    mv.addObject("pro", pro);
	    System.out.println(pro.toString());
	    return mv;
	}
	
	@PostMapping("addproducer")
	public ModelAndView addpro(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String msg=null;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contactno");
		String userType = request.getParameter("userType"); 
		Member newmember = new Member();
		newmember.setName(name);
		newmember.setPassword(password);
		newmember.setPassword(encoder.encode(newmember.getPassword()));
		newmember.setEmail(email);
		newmember.setAddress(address);
		newmember.setContactno(contact);
		if (userType != null) {
		    if (userType.equals("seller")) {
		        newmember.setRole("USER");
		        memberRepo.save(newmember);
		    } else if (userType.equals("customer")) {
		        newmember.setRole("CUSTOMER");
		        memberRepo.save(newmember);
		    }
		}
		System.out.println(userType+ "enti aya edi");
		
		mv.setViewName("Templates/Login.jsp");
		mv.addObject("message", msg);
		return mv;
		
	}
	
	@Async 
	@GetMapping("/sendMail")
	public void sendEmail() 
	{ 
	 SimpleMailMessage mailMessage = new SimpleMailMessage(); 
	 mailMessage.setTo("jeevansp1432@gmail.com"); 
	 mailMessage.setText("Testing Success"); 
	 mailMessage.setSubject("TEST"); 
	 mailMessage.setFrom("webdynamos15@gmail.com"); //from mail id
	 javaMailSender.send(mailMessage); 
	}
	@PostMapping("checkadminlogin")
	  public String checkadminlogin(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView(); 
	    System.out.println("HOOO");
	    
	    String uname = request.getParameter("name");
	     String pwd = request.getParameter("password");
	     
	   
	    if(uname!=null)
	    {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("adminObject",null);
	    	System.out.println("Logged in");
	      return "redirect:/adminhome";
	    }
	    else
	    {
	      mv.setViewName("adminlogin");
	      mv.addObject("message", "Login Failed");
	    }
	    
	    return " ";
	  }
	@PostMapping("checkCustomerLogin")
	  public String checkCustomerLogin(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView(); 
	    
	    
	    String uname = request.getParameter("name");
	     String pwd = request.getParameter("password");
	     
	

	    if( null!=null)
	    {
	    	HttpSession session = request.getSession();
	      return "redirect:/product";
	    }
	    else
	    {
	      mv.setViewName("login");
	      mv.addObject("message", "Login Failed");
	    }
	    
	    return " ";
	  }
	@PostMapping("checkProducerLogin")
	  public String checkProducerLogin(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView(); 
	    
	    
	    String uname = request.getParameter("name");
	     String pwd = request.getParameter("password");
	     System.out.println(pass.hash(pwd));

	    if(null!=null)
	    {
	    	HttpSession session = request.getSession();
	    	
	      return "redirect:/seller/home";
	    }
	    else
	    {
	    	System.out.println("game out");
	      mv.setViewName("adminlogin");
	      mv.addObject("message", "Login Failed");
	    }
	    
	    return " ";
	  }
	@RequestMapping("viewallproduct")
	public ModelAndView viewallproducts()
	{
		ModelAndView mv = new ModelAndView("Admin/viewallproducts.jsp");
		List<Product> plist = productService.getallproducts();
		mv.addObject("plist", plist);
		return mv;
	}
	@PostMapping("checkselllerlogin")
	  public String checkselllerlogin(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView(); 
	    
	    
	    String uname = request.getParameter("name");
	     String pwd = request.getParameter("password");
	     
	 
	    if(null!=null)
	    {
	    	
	      return "redirect:/adminhome";
	    }
	    else
	    {
	      mv.setViewName("adminlogin");
	      mv.addObject("message", "Login Failed");
	    }
	    
	    return " ";
	  }
	
	
	@RequestMapping("addsubcategory")
	public ModelAndView addSubCategoryPage() {
	    ModelAndView mv = new ModelAndView("Templates/addsubcategory.jsp"); // Use the correct JSP filename
	    List<Category> categoryList = categoryService.getAllCategories();
	    System.out.println(categoryList);
	    mv.addObject("categoryList", categoryList); // Pass the list of categories to the JSP
	    return mv;
	}

	@PostMapping("addcategory")
	public ModelAndView addCategory(HttpServletRequest request) {
	    ModelAndView mv = new ModelAndView();
	    System.out.println("Ochanu");
	    String categoryName = request.getParameter("categoryName");
	    Category category = new Category();
	    category.setName(categoryName);
	    categoryService.saveCategory(category);
	    System.out.println("saved");
	    mv.setViewName("redirect:/adminhome"); // Redirect to the admin home page
	    return mv;
	}

	@PostMapping("addsubcategory")
	public ModelAndView addSubCategory(HttpServletRequest request) {
	    ModelAndView mv = new ModelAndView();
	    String subCategoryName = request.getParameter("subCategoryName");
	    int categoryId = Integer.parseInt(request.getParameter("categoryId"));

	    // Retrieve the category by ID to associate the subcategory
	    Category category = categoryService.getCategoryById(categoryId);

	    if (category != null) {
	        SubCategory subCategory = new SubCategory();
	        subCategory.setName(subCategoryName);
	        subCategory.setCategory(category); // Associate the subcategory with the category
	        subCategoryService.saveSubCategory(subCategory);
	    }

	    mv.setViewName("redirect:/adminhome"); // Redirect to the admin home page
	    return mv;
	}

}
