package db;

public class Items {
    Long id;
    String name;
    double price;
    int ramSize;
    String memory;
    String description;

    public Items() {
    }

    public Items(Long id, String name, double price, int ramSize, String memory, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ramSize = ramSize;
        this.memory = memory;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
