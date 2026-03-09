package bt05;

public class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {

        UserActions.super.logActivity(activity);
        AdminActions.super.logActivity(activity);
        System.out.println("SuperAdmin log: " + activity);
    }
}