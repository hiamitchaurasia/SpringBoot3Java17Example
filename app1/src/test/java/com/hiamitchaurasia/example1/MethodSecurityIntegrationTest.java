package com.hiamitchaurasia.example1;

import com.hiamitchaurasia.example1.controller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration
//@WithMockUser(username = "john", roles = { "VIEWER" })
public class MethodSecurityIntegrationTest {
    private final UserController userController;
    public MethodSecurityIntegrationTest(UserController userController){
        this.userController = userController;
    }
    @Test
    @WithMockUser(username = "john", roles = { "VIEWER" })
    public void givenRoleViewer_whenCallGetUsername_thenReturnUsername() {
        String userName = userController.getUsername();

        assertEquals("john", userName);
    }

    @Test
    @WithMockUser(username = "JOHN", authorities = { "SYS_ADMIN" })
    public void givenAuthoritySysAdmin_whenCallGetUsernameLC_thenReturnUsername() {
        String username = userController.getUsernameLC();

        assertEquals("john", username);
    }

    @Test
    @WithAnonymousUser
    public void givenAnomynousUser_whenCallGetUsername_thenAccessDenied() {
        Assertions.assertThrows(AccessDeniedException.class, () -> {userController.getUsername();});
    }
}
