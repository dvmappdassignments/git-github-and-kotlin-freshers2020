/**
 * This class simulates a billing machine at a common restaurant.
 * The class asks the waiter about the category of the food they want to bill.
 * On selecting a category, the menu of that category is displayed, and the waiter chooses the dish he wants to add to the bill
 * He then enters the quantity of the item, and then the item is added to the bill
 * This process is repeated until the waiter has entered all the dishes, which will be communicated by entering a special symbol
 * */
import java.util.*

val input=Scanner(System.`in`)
var totalBill:Int = 0
fun main() {

    var category:Int
    category=1
    while(category!=4) {
        println("1-Starters  2-Main Course  3-Desserts  4-Display Bill")
        category = input.nextInt()
        showMenuForCategory(category)
    }
    displayBill()
}

/**
 * This function will display the list of items available in the selected category
 * @param category is an integer number that decides the category selected
 * The list of categories is as follows: Starters, Main Course, and Desserts
 * */

fun showMenuForCategory(category: Int) {
    var item:String
    val price:Int
    val starters= arrayOf<String>("Spring Roll","Potatoes in Honey & Chilly","Chilly Mushroom Dry","Veg. Manchurian Dry")
    val mainCourse= arrayOf<String>("Veg Chopsouey","Sweet & Sour Veg","Mix. Veg. in Garlic Sauce","Paneer Butter Masala")
    val desserts= arrayOf<String>("Warm Apple Crostata","Gulaab Jaamun","Grill Cheesecake","Choco Lava Cake")
    val startersPrice= arrayOf<Int>(145,175,155,135)
    val mainCoursePrice= arrayOf<Int>(195,175,185,210)
    val dessertsPrice= arrayOf<Int>(295,175,385,210)
    if (category==1) {
        println("1 -"+starters[0]+"             "+startersPrice[0]+"-/")
        println("2 -"+starters[1]+"             "+startersPrice[1]+"-/")
        println("3 -"+starters[2]+"             "+startersPrice[2]+"-/")
        println("4 -"+starters[3]+"             "+startersPrice[3]+"-/")
    }
    else if(category==2){
        println("1 -"+mainCourse[0]+"          "+mainCoursePrice[0]+"-/")
        println("2 -"+mainCourse[1]+"          "+mainCoursePrice[1]+"-/")
        println("3 -"+mainCourse[2]+"          "+mainCoursePrice[2]+"-/")
        println("4 -"+mainCourse[3]+"          "+mainCoursePrice[3]+"-/")
    }
    else if(category==3){
        println("1 -"+desserts[0]+"          "+dessertsPrice[0]+"-/")
        println("2 -"+desserts[1]+"          "+dessertsPrice[1]+"-/")
        println("3 -"+desserts[2]+"          "+dessertsPrice[2]+"-/")
        println("4 -"+desserts[3]+"          "+dessertsPrice[3]+"-/")
    }
    else{
        displayBill()
        return
    }
    val menuChoice: Int = input.nextInt()
    when (category) {
        1 -> addItemToBill(starters[menuChoice-1],startersPrice[menuChoice-1])
        2 -> addItemToBill(mainCourse[menuChoice-1],mainCoursePrice[menuChoice-1])
        3 -> addItemToBill(desserts[menuChoice-1],dessertsPrice[menuChoice-1])
    }
}

/**
 * The work of this function is to add a new item to the bill
 * You are free to decide the types of parameters and return type for this function
 * */
fun addItemToBill(foodItem: String,itemPrice: Int) {



    totalBill += itemPrice
}

/**
 * This function displays the final bill to the user
 * The bill should contain the name of the restaurant, the items selected, their price, quantity and cost
 * The bill should also display the final amount to be paid
 * */
fun displayBill() {


}