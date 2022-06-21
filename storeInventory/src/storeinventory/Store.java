/* ****************************************************************************
 * Store.java
 * Kevin Bell
 *
 * This class of objects stores information for a store inventory
 **************************************************************************** */
package storeinventory;

import java.util.Scanner;

public class Store {

    Scanner computerKeyboardInput = new Scanner(System.in);
    private int size = 2;
    private Inventory[] items;

    public Store() {
        items = new Inventory[size];
        String name = "";
        double price = 0.0;
        int quantity = 0;
        System.out.println("Stock this inventory");
        for (int i = 0; i < size; i++) {
            System.out.print("Name of inventory item: ");
            name = computerKeyboardInput.nextLine();
            System.out.print("Price of that item: ");
            price = computerKeyboardInput.nextDouble();
            computerKeyboardInput.nextLine(); //flush newline
            System.out.print("Quantity of that item: ");
            quantity = computerKeyboardInput.nextInt();
            computerKeyboardInput.nextLine(); //flush newline
            items[i] = new Inventory(name, price, quantity);
        } //end for
    } //end Store constructor

    public void display() {
        System.out.println("Inventory Listing");
        for (Inventory i : items) {
            System.out.println(i.display());
        }
    } //end display

    public int findItem(String name) {
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(name)) {
                return i;
            } //end if
        } //end for
        return -1;
    } //end findItem

    public double sell(String name, int quantity) {
        int i = findItem(name);
        if (i == -1) {
            System.out.println("Can't find this item, sorry");
            return 0;
        } //end if
        return items[i].sell(quantity);
    } //end sell
} //end class Store
