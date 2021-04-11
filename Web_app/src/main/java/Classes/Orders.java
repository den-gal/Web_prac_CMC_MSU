package Classes;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, updatable = false)
    private int order_id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private Cars car_id;

    private boolean test_drive;
    private java.sql.Date date_of_order;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    private Clients client;

    public Orders(){}

    public Orders(Cars car_id, Clients client, boolean test_drive, java.sql.Date date_of_order, String status) {
        this.car_id = car_id;
        this.client = client;
        this.test_drive = test_drive;
        this.date_of_order = date_of_order;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Cars getCar_id() {
        return car_id;
    }

    public void setCar_id(Cars car_id) {
        this.car_id = car_id;
    }

    public boolean isTest_drive() {
        return test_drive;
    }

    public void setTest_drive(boolean test_drive) {
        this.test_drive = test_drive;
    }

    public java.sql.Date getDate_of_order() {
        return date_of_order;
    }

    public void setDate_of_order(java.sql.Date date_of_order) {
        this.date_of_order = date_of_order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Clients getClients() {
        return client;
    }

    public void setClients(Clients client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            System.out.println("class");
            return false;
        }
        final Orders other = (Orders) obj;
        return  (this.order_id == other.order_id) &&
                (this.car_id.getReg_id() == other.car_id.getReg_id()) &&
                (this.client.getClient_id() == other.client.getClient_id()) &&
                (this.test_drive == other.test_drive) &&
                (this.date_of_order.equals(other.date_of_order)) &&
                (this.status.equals(other.status));
    }
}
