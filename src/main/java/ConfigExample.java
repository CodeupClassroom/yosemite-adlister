public class ConfigExample {

        private String url = "jdbc:mysql://localhost/example_db";
        private String username = "a_mysql_user_for_this_db";
        private String password = "a_password_for_this_user";

        public String getUrl() {
            return url;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
}
