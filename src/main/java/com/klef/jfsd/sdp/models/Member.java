package com.klef.jfsd.sdp.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_table") // Renamed the table to "user_table" to represent all user types
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name", length = 50)
    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Product> products;
    @Column(name = "user_email", unique = true, length = 30)
    private String email;

    @Column(name = "user_password", length = 200)
    private String password;

    @Column(name = "user_address")
    private String address;
    
    @Column(name = "admin_verified")
    private boolean adminVerified;
    
    @Column(name = "otp_verified")
    private boolean otpVerified;

    private String gender;
    @Column(name = "user_contactno", unique = true)
    private String contactno;

    @Column(name = "user_role", length = 20) // Role field
    private String role;
    
    private int otp;
    public Member()
    {
    	
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + email + ", password=" +
                password + ", address=" + address + ", contactno=" + contactno + ", role=" + role + "]";
    }

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public boolean isAdminVerified() {
		return adminVerified;
	}

	public void setAdminVerified(boolean adminVerified) {
		this.adminVerified = adminVerified;
	}

	public boolean isOtpVerified() {
		return otpVerified;
	}

	public void setOtpVerified(boolean otpVerified) {
		this.otpVerified = otpVerified;
	}


	public int getOtp() {
		return otp;
	}


	public void setOtp(int otp) {
		this.otp = otp;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
}
