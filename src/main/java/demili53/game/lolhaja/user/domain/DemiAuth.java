package demili53.game.lolhaja.user.domain;

public enum DemiAuth {
    ROLE_ADMIN("ROLE_AMDIN,ROLE_MEMBER"),
    ROLE_MEMBER("ROLE_MEMBER");
    private String authString;

    DemiAuth(String authString) {
        this.authString = authString;
    }

    public String getAuthString(){
        return authString;
    }

}
