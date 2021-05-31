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
    private int function;
    private int function_1;
    private int number;

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

    public int getFunction() {
        return function;
    }

    public void setFunction(int function) {
        this.function = function;
    }

    public int getFunction_1() {
        return function_1;
    }

    public void setFunction_1(int function_1) {
        this.function_1 = function_1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
