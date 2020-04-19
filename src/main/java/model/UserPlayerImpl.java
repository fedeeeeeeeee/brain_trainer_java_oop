package model;

public class UserPlayerImpl implements UserPlayer {
    private String username;
    private String password;

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public void setPassword(final String password) {
        this.password = password;
    }

}
