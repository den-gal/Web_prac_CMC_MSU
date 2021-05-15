package Classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id", nullable = false, updatable = false)
    private int reg_id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cars_clients",
            joinColumns = @JoinColumn(name = "reg_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Clients> clients_id = new ArrayList<>();

    private String brand;
    private String manufacturer;
    private String technical_not;
    private String addition_devices;
    private String costumer_not;
    private String mutable_not;
    private double price;

    public Cars(){}

    public Cars(String brand, String manufacturer, String technical_not, String addition_devices, String costumer_not, String mutable_not, double price) {
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.technical_not = technical_not;
        this.addition_devices = addition_devices;
        this.costumer_not = costumer_not;
        this.mutable_not = mutable_not;
        this.price = price;
    }

    public int getReg_id() {
        return reg_id;
    }

    public List<Clients> getClients_id() {
        return clients_id;
    }

    public void setClients_id(List<Clients> clients_id) {
        this.clients_id = clients_id;
    }

    public void addClient_id(Clients client_id) {
        clients_id.add(client_id);
    }

    public void removeClient_id(Clients client_id) {
        clients_id.remove(client_id);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTechnical_not() {
        return technical_not;
    }

    public void setTechnical_not(String technical_not) {
        this.technical_not = technical_not;
    }

    public String getAddition_devices() {
        return addition_devices;
    }

    public void setAddition_devices(String addition_devices) {
        this.addition_devices = addition_devices;
    }

    public String getCostumer_not() {
        return costumer_not;
    }

    public void setCostumer_not(String costumer_not) {
        this.costumer_not = costumer_not;
    }

    public String getMutable_not() {
        return mutable_not;
    }

    public void setMutable_not(String mutable_not) {
        this.mutable_not = mutable_not;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static boolean compareTwoListsClients(List<Clients> list, List<Clients> list2){
        boolean controll = true;
        int j = 0;
        if(list.size() != list2.size()) {
            controll = false;
            System.out.println("compareTwoListsOrders:: wrong list size");
        }
        else {
            while ((controll) && (j < list.size())){
                if(!list.get(j).equals(list2.get(j)))
                    controll = false;
                j++;
            }
        }
        return controll;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final Cars other = (Cars) obj;
        return  (this.reg_id == other.reg_id) &&
                (Cars.compareTwoListsClients(this.clients_id,other.clients_id)) &&
                (this.brand.equals(other.brand)) &&
                (this.manufacturer.equals(other.manufacturer)) &&
                (this.technical_not.equals(other.technical_not)) &&
                (this.addition_devices.equals(other.addition_devices)) &&
                (this.costumer_not.equals(other.costumer_not)) &&
                (this.mutable_not.equals(other.mutable_not)) &&
                (Double.compare(this.price, other.price) == 0);
    }
}


