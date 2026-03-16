
/**
 * Represents a generic gadget sold in the gadget shop.
 * This class stores basic information about a gadget including
 * its model, price, weight and size.
 */
public class Gadget {

    // Model name of the gadget
    private String model;

    // Price of the gadget in pounds
    private double price;

    // Weight of the gadget in grams
    private int weight;

    // Physical size of the gadget
    private String size;

    /**
     * Constructor to initialise a Gadget object.
     *
     * @param model  the model name of the gadget
     * @param price  the price of the gadget in pounds
     * @param weight the weight of the gadget in grams
     * @param size   the size of the gadget
     */
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    /**
     * Returns the model of the gadget.
     *
     * @return the model name
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the price of the gadget.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the weight of the gadget.
     *
     * @return the weight in grams
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the size of the gadget.
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Displays the details of the gadget.
     */
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }
}
