/**
 * This class simulates a billing machine at a common restaurant.
 * The class asks the waiter about the category of the food they want to bill.
 * On selecting a category, the menu of that category is displayed, and the waiter chooses the dish he wants to add to the bill
 * He then enters the quantity of the item, and then the item is added to the bill
 * This process is repeated until the waiter has entered all the dishes, which will be communicated by entering a special symbol
 * */
import java.util.*;
class RestrauntBillingSystem {

    fun main(args: Array<String>) {
        val input=Scanner(System.`in`)
        var category:Int

        println("1-Starters  2-Main Course  3-Desserts  #-Display Bill")
        category=input.nextInt()
        showMenuForCategory(category)

    }

    /**
     * This function will display the list of items available in the selected category
     * @param category is an integer number that decides the category selected
     * The list of categories is as follows: Starters, Main Course, and Desserts
     * */
    
    fun showMenuForCategory(category: Int) {


    }

    /**
     * The work of this function is to add a new item to the bill
     * You are free to decide the types of parameters and return type for this function
     * */
    fun addItemToBill() {

    }

    /**
     * This function displays the final bill to the user
     * The bill should contain the name of the restaurant, the items selected, their price, quantity and cost
     * The bill should also display the final amount to be paid
     * */
    fun displayBill() {

    }
}
