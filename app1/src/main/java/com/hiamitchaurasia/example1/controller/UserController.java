package com.hiamitchaurasia.example1.controller;

import com.hiamitchaurasia.example1.model.User;
import com.hiamitchaurasia.example1.security.IsViewer;
import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @GetMapping("/users")
    public User getUsers(){
        return new User("Amit", "Chaurasia","hiamitchaurasia","801");
    }

    @GetMapping("/userName")
    @RolesAllowed("ROLE_VIEWER")
    public String getUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }

    @GetMapping("/userName5")
    public String getUsername5() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }

    @GetMapping("/userAuthority")
    @PreAuthorize("hasAuthority('SYS_ADMIN')")
    public String getUsernameLC(){
        return getUsername().toLowerCase();
    }

    @GetMapping("/isAdmin/{userName}")
    @RolesAllowed({ "ROLE_VIEWER", "ROLE_EDITOR" })
    public boolean isValidUsername(@PathVariable(value = "userName") String userName) {
        return userName.contains("admin");
    }

    @GetMapping("/isValidUserName1/{userName}")
    @PreAuthorize("hasRole('ROLE_VIEWER') or hasRole('ROLE_EDITOR')")
    public boolean isValidUsername3(@PathVariable(value = "userName") String userName) {
        return userName.contains("admin");
    }

    @GetMapping("/isValidUserName4/{userName}")
    @PreAuthorize("hasRole('ROLE_EDITOR')")
    public boolean isValidUsername4(@PathVariable(value = "userName") String userName) {
        return userName.contains("admin");
    }

    @GetMapping("/getRole1")
    @PreAuthorize("#username == authentication.principal.username")
    public String getMyRoles(String username) {
        return "ADMIN";
    }

    @GetMapping("/getUser1")
    @PostAuthorize
            ("returnObject.userName == authentication.principal.username")
    public User loadUserDetail(String username) {
        return new User("Amit", "Chaurasia","hiamitchaurasia","801");
    }

    @GetMapping("/getUser2")
    @PreFilter
            (value = "filterObject != authentication.principal.username",
                    filterTarget = "usernames")
    public String joinUsernamesAndRoles(
            List<String> usernames, List<String> roles) {

        return usernames.stream().collect(Collectors.joining(";"))
                + ":" + roles.stream().collect(Collectors.joining(";"));
    }

    @GetMapping("/getUser4")
    @IsViewer
    public String getUsername4() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }

    @GetMapping("/getUser5")
    @PreAuthorize("#username == authentication.principal.username")
    @PostAuthorize("returnObject.username == authentication.principal.username")
    public User securedLoadUserDetail(String username) {
        return new User("Amit", "Chaurasia","hiamitchaurasia","801");
    }
}
