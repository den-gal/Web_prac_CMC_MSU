package Classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false, updatable = false)
    private int client_id;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

    private String full_name;
    private String client_inf;
    private String login;
    private String password;
    private String costumer_status;

    @ManyToMany(mappedBy = "clients_id")
    private List<Cars> cars = new ArrayList<>();

    public Clients(){}

    public Clients( String full_name, String client_inf, String login, String password, String costumer_status) {
        this.full_name = full_name;
        this.client_inf = client_inf;
        this.login = login;
        this.password = password;
        this.costumer_status = costumer_status;
    }

    public int getClient_id() {
        return client_id;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void addOrder(Orders order) {
        orders.add(order);
    }

    public void removeOrder(Orders order) {
        orders.remove(order);
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getClient_inf() {
        return client_inf;
    }

    public void setClient_inf(String client_inf) {
        this.client_inf = client_inf;
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

    public String getCostumer_status() {
        return costumer_status;
    }

    public void setCostumer_status(String costumer_status) {
        this.costumer_status = costumer_status;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public void setCars(List<Cars> cars) {
        this.cars = cars;
    }
    public static boolean compareTwoListsOrders(List<Orders> list, List<Orders> list2){
        boolean controll = true;
        int i = 0;
        if(list.size() != list2.size()) {
            controll = false;
            System.out.println("compareTwoListsOrders:: wrong list size");
        }
        else {
            while ((controll) && (i < list.size())){
                if(!list.get(i).equals(list2.get(i)))
                    controll = false;
                i++;
            }
        }
        return controll;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final Clients other = (Clients) obj;
        return  (this.client_id == other.client_id) &&
                (Clients.compareTwoListsOrders(this.orders, other.orders)) &&
                (this.full_name.equals(other.full_name)) &&
                (this.client_inf.equals(other.client_inf)) &&
                (this.costumer_status.equals(other.costumer_status)) &&
                (this.login.equals(other.login)) &&
                (this.password.equals(other.password));
    }
}
