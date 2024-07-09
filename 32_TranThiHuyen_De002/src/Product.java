public abstract class Product {
    private String name;
    protected float price;
    private String description;
    protected int quantity;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public abstract void showInfo();

    public Product(String name, float price,String description, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

}
