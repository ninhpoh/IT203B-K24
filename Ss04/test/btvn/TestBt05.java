package btvn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Bt05Test {

    private Bt05.User testUser;
    private final Bt05 service = new Bt05();

    @AfterEach
    void tearDown() {
        testUser = null;
    }

    // --- ADMIN ---
    @Test
    void testAdminCanDeleteUser() {
        testUser = new Bt05.User(Bt05.Role.ADMIN);
        assertTrue(service.canPerformAction(testUser, Bt05.Action.DELETE_USER));
    }

    @Test
    void testAdminCanLockUser() {
        testUser = new Bt05.User(Bt05.Role.ADMIN);
        assertTrue(service.canPerformAction(testUser, Bt05.Action.LOCK_USER));
    }

    @Test
    void testAdminCanViewProfile() {
        testUser = new Bt05.User(Bt05.Role.ADMIN);
        assertTrue(service.canPerformAction(testUser, Bt05.Action.VIEW_PROFILE));
    }

    // --- MODERATOR ---
    @Test
    void testModeratorCannotDeleteUser() {
        testUser = new Bt05.User(Bt05.Role.MODERATOR);
        assertFalse(service.canPerformAction(testUser, Bt05.Action.DELETE_USER));
    }

    @Test
    void testModeratorCanLockUser() {
        testUser = new Bt05.User(Bt05.Role.MODERATOR);
        assertTrue(service.canPerformAction(testUser, Bt05.Action.LOCK_USER));
    }

    @Test
    void testModeratorCanViewProfile() {
        testUser = new Bt05.User(Bt05.Role.MODERATOR);
        assertTrue(service.canPerformAction(testUser, Bt05.Action.VIEW_PROFILE));
    }

    // --- USER ---
    @Test
    void testUserCannotDeleteUser() {
        testUser = new Bt05.User(Bt05.Role.USER);
        assertFalse(service.canPerformAction(testUser, Bt05.Action.DELETE_USER));
    }

    @Test
    void testUserCannotLockUser() {
        testUser = new Bt05.User(Bt05.Role.USER);
        assertFalse(service.canPerformAction(testUser, Bt05.Action.LOCK_USER));
    }

    @Test
    void testUserCanViewProfile() {
        testUser = new Bt05.User(Bt05.Role.USER);
        assertTrue(service.canPerformAction(testUser, Bt05.Action.VIEW_PROFILE));
    }
}