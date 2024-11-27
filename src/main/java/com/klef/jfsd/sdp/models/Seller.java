package com.klef.jfsd.sdp.models;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Seller")
public class Seller extends Member {
    @Column(name = "admin_verified")
    private boolean adminVerified;

    @Column(name = "otp_verified")
    private boolean otpVerified;

    // Other fields specific to admins

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
}
