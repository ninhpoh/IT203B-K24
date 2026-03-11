package btvn;

public class Bt05 {

    public enum Role {
        ADMIN, MODERATOR, USER
    }

    public enum Action {
        DELETE_USER, LOCK_USER, VIEW_PROFILE
    }

    public static class User {
        private final Role role;

        public User(Role role) {
            this.role = role;
        }

        public Role getRole() {
            return role;
        }
    }

    public boolean canPerformAction(User user, Action action) {
        if (user == null || action == null) {
            return false;
        }

        switch (user.getRole()) {
            case ADMIN:
                return true; // ADMIN có quyền tất cả
            case MODERATOR:
                return action == Action.LOCK_USER || action == Action.VIEW_PROFILE;
            case USER:
                return action == Action.VIEW_PROFILE;
            default:
                return false;
        }
    }
}