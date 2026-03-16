
/**
 * Represents a Mobile phone gadget.
 * This class extends the Gadget class and adds functionality
 * related to calling credit and making phone calls.
 */
public class Mobile extends Gadget {

    // Number of minutes of calling credit remaining
    private int credit;

    /**
     * Constructor to initialise a Mobile object.
     *
     * @param model  the model name of the mobile phone
     * @param price  the price of the mobile phone in pounds
     * @param weight the weight of the mobile phone in grams
     * @param size   the size of the mobile phone
     * @param credit the initial calling credit in minutes
     */
    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }

    /**
     * Returns the remaining calling credit.
     *
     * @return the credit in minutes
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Adds calling credit to the mobile phone.
     *
     * @param amount the amount of credit to add
     */
    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
            System.out.println("Credit added successfully. New credit: " + credit + " minutes.");
        } else {
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    /**
     * Simulates making a phone call.
     *
     * @param phoneNumber the number being called
     * @param duration    the duration of the call in minutes
     */
    public void makeCall(String phoneNumber, int duration) {
        if (duration <= credit) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            credit -= duration;
            System.out.println("Remaining credit: " + credit + " minutes.");
        } else {
            System.out.println("Insufficient credit to make this call.");
        }
    }

    /**
     * Displays the details of the mobile phone.
     * Calls the display method of the parent Gadget class
     * and then prints the remaining calling credit.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Calling Credit: " + credit + " minutes");
    }
}
