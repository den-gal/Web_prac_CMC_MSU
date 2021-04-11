package Classes;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int admin_id;
    private String login;
    private String password;

    public Admin() {};

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final Admin other = (Admin) obj;
        return  (this.admin_id == other.admin_id) &&
                (this.login.equals(other.login)) &&
                (this.password.equals(other.password));
    }
}
