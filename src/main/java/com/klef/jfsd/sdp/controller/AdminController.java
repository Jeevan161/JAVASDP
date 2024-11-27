package com.klef.jfsd.sdp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.repositories.MemberRepo;
import com.klef.jfsd.sdp.services.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MemberRepo memberRepository;
	@Autowired
	private MemberService memberService;
	@RequestMapping("home")
	public ModelAndView adminhome()
	{
		ModelAndView mv = new ModelAndView("/Admin/Home.jsp");
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
	@RequestMapping("sellers")
	public ModelAndView viewallsellers()
	{
		List<Member> m = memberService.findAllUsers();
		ModelAndView mv = new ModelAndView("/Admin/Sellers.jsp");
		mv.addObject("sellers",m);
		return mv;
	}@RequestMapping("{sellerId}")
	public ModelAndView updateseller(@PathVariable("sellerId") int sellerid)
	{
		System.out.println(sellerid+"dld");
		Optional<Member> omu = memberService.findbyID(sellerid);
		Member mu = omu.get();
		ModelAndView mv = new ModelAndView("/Admin/UpdateSeller.jsp");
		mv.addObject("seller",mu);
		
		return mv;
	}
	@PostMapping("updateuser")
	public ModelAndView updateuser(HttpServletRequest request)
	{
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String address = request.getParameter("address");
	        String contactno = request.getParameter("contactno");
	        String otp = request.getParameter("otp");
	        String admin = request.getParameter("admin");
	        
	        Optional<Member> memberOptional = memberRepository.findByEmail(email);
	        Member existingMember = memberOptional.get();
	        
	        // Update the fields with the values from the request
	        existingMember.setName(request.getParameter("name"));
	        existingMember.setEmail(request.getParameter("email"));
	        existingMember.setAddress(request.getParameter("address"));
	        existingMember.setContactno(request.getParameter("contactno"));
	        
	        existingMember.setOtpVerified("True".equalsIgnoreCase(otp));
	        existingMember.setAdminVerified("True".equalsIgnoreCase(admin));
	        
	        // Save the updated Member to the database
	        Member updatedMember = memberRepository.save(existingMember);
	        
	        ModelAndView mv = new ModelAndView("redirect:/admin/sellers"); // Replace with your success page.
	        
	        return mv;
		
	}
	@RequestMapping("verify/{userId}")
	public ModelAndView activateUser(@PathVariable int userId) {
	    // Retrieve the user from the database by ID
	    Optional<Member> userOptional = memberRepository.findById(userId);

	    if (userOptional.isPresent()) {
	        Member user = userOptional.get();

	        // Update the adminVerified status to true
	        user.setAdminVerified(true);

	        // Save the updated user to the database
	        memberRepository.save(user);

	        ModelAndView mv = new ModelAndView("redirect:/admin/verifyseller"); // Replace with your success page.
	        mv.addObject("message", "User activated successfully.");
	        return mv;
	    } else {
	        ModelAndView mv = new ModelAndView("errorPage"); // Replace with your error page.
	        mv.addObject("errorMessage", "User not found or invalid user ID.");
	        return mv;
	    }
	}

	@RequestMapping("verifyseller")
	public ModelAndView verifyseller()
	{
		List<Member> m = memberService.getUsersWithUnverifiedAdmin();
		ModelAndView mv = new ModelAndView("/Admin/VerifySeller.jsp");
		mv.addObject("sellers",m);
		return mv;
	}
}
