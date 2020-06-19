public class User {

        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String address;
        private String number;
        private String role;



        public User(String username) {
            this.username = username;

        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
        public String getfirstName() {
            return firstName;
        }

        public void setfirstName(String firstName) {
            this.firstName= firstName;
        }

        public String getlastName() {
            return lastName;
        }

        public void setlastName(String lastName) {
            this.lastName = lastName;
        }

        public String getemail() {
            return email;
        }

        public void setemail(String email) {
            this.email = email;
        }

        public String getaddress() {
            return address;
        }

        public void setaddress(String address) {
            this.address = address;
        }

        public String getnumber() {
            return number;
        }

        public void setnumber(String number) {
            this.number= number;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (!username.equals(user.username)) return false;
            if (!password.equals(user.password)) return false;
            if(!email.equals(user.email)) return false;
            return role.equals(user.role);
        }

        @Override
        public int hashCode() {
            int result = username.hashCode();
            result = 31 * result + password.hashCode();
            result = 31 * result + role.hashCode();
            result = 31 * result + email.hashCode();
            result = 31 * result + firstName.hashCode();
            result = 31 * result + lastName.hashCode();
            result = 31 * result + address.hashCode();
            result = 31 * result + number.hashCode();
            return result;
        }


        @Override
        public String toString() {
            return "UserDTO{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", firstname='" + firstName + '\'' +
                    ", lastname='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    ", number='" + number + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

