package app;

public class User {
    private String username;
    private String password;

    // Constructors, getters, and setters
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
