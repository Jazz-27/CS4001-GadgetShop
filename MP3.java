/**
 * Represents an MP3 player gadget.
 * This class extends the Gadget class and adds functionality
 * related to available memory for storing music.
 */
public class MP3 extends Gadget {

    // Available memory on the MP3 player
    private int memory;

    /**
     * Constructor to initialise an MP3 object.
     *
     * @param model  the model name of the MP3 player
     * @param price  the price of the MP3 player in pounds
     * @param weight the weight of the MP3 player in grams
     * @param size   the size of the MP3 player
     * @param memory the available memory
     */
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }

    /**
     * Returns the available memory.
     *
     * @return available memory
     */
    public int getMemory() {
        return memory;
    }

    /**
     * Downloads music to the MP3 player.
     * Reduces available memory if enough space exists.
     *
     * @param amount the size of the music download
     */
    public void downloadMusic(int amount) {
        if (amount <= memory) {
            memory -= amount;
            System.out.println("Music downloaded. Remaining memory: " + memory);
        } else {
            System.out.println("Not enough memory to download music.");
        }
    }

    /**
     * Deletes music from the MP3 player.
     * Increases available memory.
     *
     * @param amount the size of the music deleted
     */
    public void deleteMusic(int amount) {
        memory += amount;
        System.out.println("Music deleted. Available memory: " + memory);
    }

    /**
     * Displays the details of the MP3 player.
     * Calls the display method from the Gadget class
     * and then prints the available memory.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + memory);
    }
}
