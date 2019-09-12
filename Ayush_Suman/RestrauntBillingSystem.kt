/**
 * This class simulates a billing machine at a common restaurant.
 * The class asks the waiter about the category of the food they want to bill.
 * On selecting a category, the menu of that category is displayed, and the waiter chooses the dish he wants to add to the bill
 * He then enters the quantity of the item, and then the item is added to the bill
 * This process is repeated until the waiter has entered all the dishes, which will be communicated by entering a special symbol
 * */
import java.util.*
var scanner=Scanner(System.`in`)
var selectedCategory=mutableListOf<Array<String>>()
val starters=mutableListOf(arrayOf("2-Bananas", "10000"), arrayOf("Soluchan", "10"), arrayOf("Vimal", "500"), arrayOf("Rinkia ke Papad", "400"))
val mainCourse=mutableListOf(arrayOf("Chick 'n Biryani", "300"), arrayOf("Butt 'r Paneer", "50"), arrayOf("Katle-t", "500"))
val desserts=mutableListOf(arrayOf("Babu Shona", "1"), arrayOf("Sweet Cyanide", "100000"), arrayOf("Fructose+Fehling Soluchan", "2000"))
var order =mutableListOf<Array<String>>()
var selection:Int = 0
var ordered:Int =0
var quant:Int=0
fun main() {
showMenuForCategory()   
}

/**
 * This function will display the list of items available in the selected category
 * @param category is an integer number that decides the category selected
 * The list of categories is as follows: Starters, Main Course, and Desserts
 * */
//item is an array of two elements:Item Name and Item Price 
fun showMenuForCategory() {
  println("1-Starters  2-Main Course  3-Desserts 4-Display Bill 5-Select items")
  selection=scanner.nextInt()
  
  if(selection==1){
    println("********Menu********")
    for ((index, items) in starters.withIndex()){
        println("${index+1} - ${items.first()} for ${items.last()}")}
        selectedCategory=starters
        showMenuForCategory()
   }else if(selection==2){
      println("********Menu********")
      for ((index, items) in mainCourse.withIndex()){
      println("${index+1} - ${items.first()} for ${items.last()}")}
      selectedCategory=mainCourse
      showMenuForCategory()
  }else if(selection==3){
      println("********Menu********")
      for ((index, items) in desserts.withIndex()){
          println("${index+1} - ${items.first()} for ${items.last()}")}
          selectedCategory=desserts
          showMenuForCategory()
  }else if(selection==4){
    if(ordered==1){
        displayBill()}
    else{
        println("Lite le... bas ek Bite le")
        showMenuForCategory()}
  }else if (selection==5){
    if(!selectedCategory.isEmpty()){
    println("Select items...  Enter 0 to go back to Menu Categories")
    selection=scanner.nextInt()
      if(selection<=selectedCategory.size){
          if(selection!=0){
              println("Enter Quantity")
              quant=scanner.nextInt()
              addItemToBill(selectedCategory.get(selection-1), quant)}
          else{
              showMenuForCategory()
    }
  }else{
    println("Are Bhai Bhai")
    addItemToBill(selectedCategory.get(0),0)
      }
    }else{println("Select Menu Category First")
    showMenuForCategory()
    }
  }else{
    println("Are Bhai Bhai Bhai")
    showMenuForCategory()
        }   
}
  

/**
 * The work of this function is to add a new item to the bill
 * You are free to decide the types of parameters and return type for this function
 * */
fun addItemToBill(item:Array<String>, quantity:Int){
if(quantity==0){println("Select items...  Enter 0 to go back to Menu Categories")
  selection=scanner.nextInt()
  if(selection<=selectedCategory.size){
    if(selection!=0){
      println("Enter Quantity")
      quant=scanner.nextInt()
      addItemToBill(selectedCategory.get(selection-1), quant)}else{
      showMenuForCategory()
  }}else{
    println("Are Bhai Bhai")
    addItemToBill(selectedCategory.get(0),0)
  }
}else{item.set(1,(item.last().toInt()*quantity).toString())
    order.add(item)
    ordered=1
    println("Enter next item to be added... Enter 0 to go back to Menu Categories")
    selection=scanner.nextInt()
if(selection<=selectedCategory.size){
  if(selection!=0){
    println("Enter Quantity")
    quant=scanner.nextInt()
    addItemToBill(selectedCategory.get(selection-1),quant)}else{
    showMenuForCategory()
}}else{
  println("Are Bhai Bhai Bhai")}
  addItemToBill(selectedCategory.get(0),0)
}
}

/**
 * This function displays the final bill to the user
 * The bill should contain the name of the restaurant, the items selected, their price, quantity and cost
 * The bill should also display the final amount to be paid
 * */
fun displayBill() {
var total:Int=0
for(items in order){
    if(items.last().toInt()>=0){
        println("${items.first()}- ${items.last()}")
        total+=items.last().toInt()
    }
}
println("Total bill is $total")
println("")
println("")
println("Lets Start Over")
order=mutableListOf()
selection=0
quant=0
showMenuForCategory()
}
