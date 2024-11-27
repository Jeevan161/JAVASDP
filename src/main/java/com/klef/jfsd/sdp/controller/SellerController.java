package com.klef.jfsd.sdp.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.models.Product;
import com.klef.jfsd.sdp.models.SubCategory;
import com.klef.jfsd.sdp.repositories.MemberRepo;
import com.klef.jfsd.sdp.services.ProductService;
import com.klef.jfsd.sdp.services.SubCategoryService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@Controller
@RequestMapping("seller")
public class SellerController {
	private final Environment env;
    @Autowired
    public SellerController(Environment env) {
        this.env = env;
    }
	@Autowired
	private ProductService productService;
	@Autowired
	private SubCategoryService  subCategoryService;
	@Autowired
	private MemberRepo  memberRepository;
	@Autowired 
	private JavaMailSender javaMailSender; 
	
	@RequestMapping(value = {"pay"}, method = RequestMethod.GET)
	public ModelAndView payment(){
		ModelAndView mv = new ModelAndView("/Seller/Pay.jsp");
	    mv.addObject("rzp_key_id", env.getProperty("rzp_key_id"));
	    mv.addObject("rzp_currency", env.getProperty("rzp_currency"));
	    mv.addObject("rzp_company_name", env.getProperty("rzp_company_name"));
	    return mv;
	}
	
	@GetMapping("/payment/createOrderId/{amount}")
	@ResponseBody
	public String createPaymentOrderId(@PathVariable String amount) {
	    String orderId = null;
	    try {
	        RazorpayClient razorpay = new RazorpayClient(env.getProperty("rzp_key_id"), env.getProperty("rzp_key_secret"));

	        JSONObject orderRequest = new JSONObject();
	        orderRequest.put("amount", amount); // amount in the smallest currency unit
	        orderRequest.put("currency", env.getProperty("rzp_currency"));
	        orderRequest.put("receipt", "order_rcptid_11");

	        Order order = razorpay.orders.create(orderRequest);
	        orderId = order.get("id");
	    } catch (RazorpayException e) {
	        // Handle Exception
	        System.out.println(e.getMessage());
	    }
	    return orderId;
	}
	@RequestMapping("/otpverify")
	public ModelAndView otpverify() {
	    // Generate a random 6-digit OTP
	    int otp = generateRandomOTP();

	    // Get the logged-in user's email address
	    String email = SecurityContextHolder.getContext().getAuthentication().getName();

	    // Send the OTP to the user's email
	    System.out.println(otp);
	    Optional<Member> userOptional = memberRepository.findByEmail(email);
	    Member user1 = null;
	    if (userOptional.isPresent()) {
	        user1 = userOptional.get();
	        user1.setOtp(otp);
	        memberRepository.save(user1);
	    }
	    String message = null;
	    if(user1!=null)
	    {
	    	 message = "Dear "+user1.getName()+",\r\n"
	    			+ "\r\n"
	    			+ "Thank you for choosing AgriMarketHub to showcase and sell your products. To complete the registration process and activate your seller account, we require you to verify your email through a One-Time Password (OTP) verification.\r\n"
	    			+ "\r\n"
	    			+ "Please use the following OTP code: "+otp+"\r\n"
	    			+ "\r\n"
	    			+ "Kindly enter this code in the registration form to validate your email and activate your seller account.\r\n"
	    			+ "\r\n"
	    			+ "Should you encounter any issues or require assistance during the registration process, please don't hesitate to contact our support team. We're here to help you get started smoothly on AgriMarketHub.\r\n"
	    			+ "\r\n"
	    			+ "We appreciate your interest in partnering with us and look forward to seeing your offerings on our platform.\r\n"
	    			+ "\r\n"
	    			+ "Best regards,\r\n"
	    			+ "AgriMarketHub";
	    }
	    sendOTPEmail(email, message); // Replace with your actual method to retrieve the user by email

	    // Redirect to the OTP verification page
	    return new ModelAndView("/Seller/OTPVerify.jsp");
	}
	@RequestMapping("adminVerficationPending")
	public ModelAndView adminverpen(){
		 String email = SecurityContextHolder.getContext().getAuthentication().getName();
		 Optional<Member> userOptional = memberRepository.findByEmail(email);
		    if (userOptional.isPresent()) {
		        Member user = userOptional.get();
		        if(user.isAdminVerified())
		        {
		        	return new ModelAndView("redirect:/Seller/Home.jsp");
		        }
		    }
		return new ModelAndView("/Seller/adminVerficationPending.jsp");
	}
	@PostMapping("verifyOTP")
	public ModelAndView verifyOTP(HttpServletRequest request) {
	    // Get the logged-in user's email address
	    String email = SecurityContextHolder.getContext().getAuthentication().getName();
	    int otp = Integer.parseInt(request.getParameter("otp"));
	    // Retrieve the user by email from the repository
	    Optional<Member> userOptional = memberRepository.findByEmail(email);
	    ModelAndView mv = new ModelAndView();
	    if (userOptional.isPresent()) {
	        Member user = userOptional.get();

	        if (user.getOtp() == otp) {
	            // OTP is correct, mark isOtpVerified as true
	            user.setOtpVerified(true);
	            memberRepository.save(user);
	            // Redirect to seller/home
	            if(user.isAdminVerified())
	            {
	            	return new ModelAndView("redirect:/seller/home");
	            }
	            else
	            {
	            	return new ModelAndView("redirect:/seller/adminVerficationPending");
	            }
	            
	        } else {
	            mv.setViewName("/Seller/OTPVerify.jsp");
	            mv.addObject("message","Incorrect OTP");
	        }
	    } 

	    return mv;
	}

	private void sendOTPEmail(String userEmail, String message) {
	    // Create an email message with the OTP
	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(userEmail);
	    mailMessage.setSubject("Account Activation OTP for AgriMarketHub Seller Registration");
	    mailMessage.setText( message);
	    javaMailSender.send(mailMessage);
	}
	private int generateRandomOTP() {
	    // Generate a random 6-digit OTP
	    Random random = new Random();
	    return 100000 + random.nextInt(900000);
	}

	@RequestMapping("contactus")
	public ModelAndView sellercontact()
	{
		return new ModelAndView("/Seller/Contact.jsp");
	}
	@GetMapping("home")
	public ModelAndView sellerhome(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("/Seller/Home.jsp");
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<Member> memberOptional = memberRepository.findByEmail(email);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            mv.addObject("user",member);
            System.out.println(member.toString());
        }
		System.out.println();
		return mv ;
		
	}
	@GetMapping("products")
	public ModelAndView sellerProducts(HttpSession session) {
	    ModelAndView mv = new ModelAndView("/Seller/sellerproducts.jsp");

	    // Check if there's a logged-in user (seller)
	    if (SecurityContextHolder.getContext().getAuthentication() != null) {
	        // Retrieve the email of the logged-in user
	        String email = SecurityContextHolder.getContext().getAuthentication().getName();

	        // Find the Member (seller) using your repository
	        Optional<Member> memberOptional = memberRepository.findByEmail(email);

	        if (memberOptional.isPresent()) {
	            Member seller = memberOptional.get();

	            // Retrieve the list of products associated with the seller
	            List<Product> sellerProducts = productService.getProductsByMember(seller);

	            // Add the list of products to the model
	            mv.addObject("sellerProducts", sellerProducts);
	        }
	    }

	    return mv;
	}
	@GetMapping("/{productId}")
    public ModelAndView editProduct(@PathVariable int productId) {
        // Retrieve the product details
        Product product = productService.getProductById(productId);
        ModelAndView mv = new ModelAndView("/Seller/editProduct.jsp");

       mv.addObject("product",product);
       List<SubCategory> subcategoryList = subCategoryService.getAllSubCategories();
       mv.addObject("subcategoryList", subcategoryList);
        return mv; 
    }
	@RequestMapping("addproduct")
    public ModelAndView addproduct() {
        ModelAndView modelAndView = new ModelAndView("/Seller/addproduct.jsp");

        // Retrieve and populate your category data (you should modify this part)
        List<SubCategory> subcategoryList = subCategoryService.getAllSubCategories();
        modelAndView.addObject("subcategoryList", subcategoryList);

        return modelAndView;
    }
	@PostMapping("addproductaction")
	public ModelAndView addproductaction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("/Seller/sellerproducts.jsp");
    
    
    String msg=null;
    try {
        
        // Handle the uploaded image
        Part file = request.getPart("productImage");

        System.out.println(file);
        if (file != null) {
        	String productName = request.getParameter("name");
        	String randomDigits = String.format("%03d", new Random().nextInt(1000));
            String imageFileName = productName + "_" + randomDigits;
            System.out.println("Selected Image: " + imageFileName);
            
//            String uploadPath = "B:/3-1 sem/JFSD/SpringBootDemoWORKSPACE/SpringBootImageTutorial/src/main/webapp/images/" + imageFileName;
            String uploadPath =  "D:/3_1/JFSD/SDPWORKSPACE/SDPPROJECT/src/main/webapp/images/"+imageFileName;
            try (FileOutputStream fos = new FileOutputStream(uploadPath);
                 InputStream is = file.getInputStream()) {
                
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                
                // File saved successfully
                
                // Create a Product object with the form field values
                Product product = new Product();
                product.setName(request.getParameter("name")); // Use imageFileName as the product name
                product.setCost(Integer.parseInt(request.getParameter("cost")));
                product.setType(request.getParameter("type"));
                String subcategoryId = request.getParameter("subcategoryId");
	            // Retrieve the SubCategory object based on the subcategoryId
	            SubCategory subCategory = subCategoryService.getSubCategoryById(Integer.parseInt(subcategoryId));
	            product.setSubCategory(subCategory);
	            String email = SecurityContextHolder.getContext().getAuthentication().getName();
	            
	         // Find the Member using your repository
	            Optional<Member> memberOptional = memberRepository.findByEmail(email);
	            if (memberOptional.isPresent()) {
	                Member member = memberOptional.get();
	                product.setMember(member);
	                System.out.println(member.toString());
	            }
	            else
	            {
	            	product.setMember(null);
	            }
                product.setDescription(request.getParameter("description"));
                product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                product.setDiscount(Integer.parseInt(request.getParameter("dis_cost")));
                product.setImg_url(imageFileName);
                product.setUnit(request.getParameter("unit"));
                product.setArea(request.getParameter("area"));
                productService.addproduct(product);
                
                msg="Product Successfully Added";
            }
        } else {
            // Handle the case where no file was uploaded
            // Provide an error message or redirect the user
          msg="Failed to Add Product";
        }
    } catch (Exception e) {
        // Handle exceptions appropriately, e.g., show an error message to the user
        e.printStackTrace();
    }
   
    mv.addObject("message", msg);
    return mv;
	}
	
}
