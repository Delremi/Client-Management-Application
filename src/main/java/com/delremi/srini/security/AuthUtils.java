package com.delremi.srini.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

    public static int getAuthenticatedUserId() {
        SriniUserDetails userDetails = (SriniUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUserId();
    }
}
