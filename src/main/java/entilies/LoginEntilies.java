package entilies;

public class LoginEntilies {
    private String user;
    private String pwd;

    public static class Builder {
        private String user;
        private String pwd;

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder pwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public LoginEntilies build() {
            return new LoginEntilies(this);
        }
    }

    private LoginEntilies(Builder builder) {
        this.user = builder.user;
        this.pwd = builder.pwd;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "{getUse: " + user +
                "getPwd" + pwd +
                "}";
    }
}
