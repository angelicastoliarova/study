package by.tc.st.bean;

import by.tc.st.bean.entity.User;

public class AuthenticationResponse extends Response {

    private User user;

    public AuthenticationResponse() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}