package Classes;

import java.util.ArrayList;
import java.util.List;

public class Form {
    private List<String> brands = new ArrayList<>();
    private List<String> manufacturers = new ArrayList<>();
    private List<String> technical_notifications = new ArrayList<>();
    private List<String> additions_devices = new ArrayList<>();
    private List<String> costumer_notifications = new ArrayList<>();
    private List<String> mutable_notifications = new ArrayList<>();

    public Form(){};

    public void addBrand(String brand) {
        if (!brands.contains(brand))
            brands.add(brand);
    }
    public void addManufacturers(String manufacturer) {
        if (!manufacturers.contains(manufacturer))
            manufacturers.add(manufacturer);
    }
    public void addTechnical_notifications(String technical_notification) {
        if (!technical_notifications.contains(technical_notification))
            technical_notifications.add(technical_notification);
    }
    public void addAdditions_devices(String addition_devices) {
        if (!additions_devices.contains(addition_devices))
            additions_devices.add(addition_devices);
    }
    public void addCostumer_notifications(String costumer_notification) {
        if (!costumer_notifications.contains(costumer_notification))
            costumer_notifications.add(costumer_notification);
    }
    public void addMutable_notifications(String mutable_notification) {
        if (!mutable_notifications.contains(mutable_notification))
            mutable_notifications.add(mutable_notification);
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<String> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<String> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public List<String> getTechnical_notifications() {
        return technical_notifications;
    }

    public void setTechnical_notifications(List<String> technical_notifications) {
        this.technical_notifications = technical_notifications;
    }

    public List<String> getAdditions_devices() {
        return additions_devices;
    }

    public void setAdditions_devices(List<String> addition_devices) {
        this.additions_devices = addition_devices;
    }

    public List<String> getCostumer_notifications() {
        return costumer_notifications;
    }

    public void setCostumer_notifications(List<String> costumer_notifications) {
        this.costumer_notifications = costumer_notifications;
    }

    public List<String> getMutable_notifications() {
        return mutable_notifications;
    }

    public void setMutable_notifications(List<String> mutable_notifications) {
        this.mutable_notifications = mutable_notifications;
    }
}
