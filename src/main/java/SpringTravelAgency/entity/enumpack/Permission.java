package SpringTravelAgency.entity.enumpack;

public enum Permission {
    DEVELOPERS_READ("developers:red"),
    DEVELOPERS_WRITE("developers:write");

    private final String permission;

    Permission(String permission){
        this.permission=permission;
    }

    public String getPermission(){
        return permission;
    }

}
