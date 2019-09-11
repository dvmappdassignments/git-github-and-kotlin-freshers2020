/**
 * This class simulates a billing machine at a common restaurant.
 * The class asks the waiter about the category of the food they want to bill.
 * On selecting a category, the menu of that category is displayed, and the waiter chooses the dish he wants to add to the bill
 * He then enters the quantity of the item, and then the item is added to the bill
 * This process is repeated until the waiter has entered all the dishes, which will be communicated by entering a special symbol
 * */
import java.util.*;
var menuStarters = Array(5) { "" }
var menuMainCourse = Array(5) { "" }
var menuDesserts = Array(5) { "" }
var menuStartersPrice = Array(5) {0}
var menuMainCoursePrice = Array(5) {0}
var menuDessertsPrice = Array(5) {0}
var finalBill = Array(15) {""}
var finalPrice = 0
var finalBillQuantity = Array(15) {0}
var finalBillPrice = Array(15) {0}
var check = true
var flag1 = 0;

fun main(args: Array<String>) {
    menuStarters = arrayOf("1.Samosas","2.Fries","3.Cutlet","4.Pakoras","5.Fruit Salad")
    menuStartersPrice = arrayOf(20,35,40,30,25)
    menuMainCourse = arrayOf("1.Butter Chicken","2.Fried Rice","3.Butter Naan","4.Paneer","5.Dal")
    menuMainCoursePrice = arrayOf(180,120,25,90,60)
    menuDesserts = arrayOf("1.Ice Cream","2.Gulab jamun","3.Dahi","4.jalebi","5.Raita")
    menuDessertsPrice = arrayOf(20,10,20,10,20)
    while (true) {
        check = true
        println("input the category of food to be seen\nInput 1 for Starters\nInput 2 for Main Course\nInput 3 for Desserts\ninput * to end billing")
        val reader = Scanner(System.`in`)
        var inputDigit = reader.next()
        if ((inputDigit == "1")||(inputDigit == "2")||(inputDigit == "3")) {
            showMenuForCategory(inputDigit.toInt())
            addItemToBill()
        }
        if(inputDigit == "*")
        {
            displayBill()
            break
        }
        if((inputDigit != "*")&&(inputDigit != "1")&&(inputDigit != "2")&&(inputDigit != "3"))
        {
            println("Wrong input")
        }
    }
}

/**
 * This function will display the list of items available in the selected category
 * @param category is an integer number that decides the category selected
 * The list of categories is as follows: Starters, Main Course, and Desserts
 * */
fun showMenuForCategory(typeOfMenu: Int) {
    println("The selected menu is")
    for(i in 0..4 step 1)
    {
        if(typeOfMenu==1)
        {
            println(menuStarters[i]+"\tpriced at\t"+menuStartersPrice[i])
        }
        if(typeOfMenu==2)
        {
            println(menuMainCourse[i]+"\tpriced at\t"+menuMainCoursePrice[i])
        }
        if(typeOfMenu==3)
        {
            println(menuDesserts[i]+"\tpriced at\t"+menuDessertsPrice[i])
        }
    }
}

/**
 * The work of this function is to add a new item to the bill
 * You are free to decide the types of parameters and return type for this function
 * */
fun addItemToBill() {
    while(check)
    {
        println("Input code to add item to bill or input $ to return to main receiver")
        /**
         * Code to input item to bill is
         * For example to add Fried Rice to bill write to code 2.2.4
         * Wherein 2.2.4 First 2 gives the category of menu, Second 2 gives the particular food in given menu, and 4 gives number of plates
         */
        var flag2 = 0;
        val reader = Scanner(System.`in`)
        var addBillCode = reader.next()
        if(addBillCode =="$")
        {
            check = false
        }
        else
        {
            var menuCategory = addBillCode.substring(0,1).toInt()
            var menuFood = addBillCode.substring(2,3).toInt()-1
            var quantity = addBillCode.substring(4,5).toInt()
            //checking if the added food item is already in bill or not
            for(i in 0 until flag1 step 1)
            {
                if(menuCategory==1)
                {
                    if(menuStarters[menuFood]==finalBill[i])
                    {
                        flag2++
                        finalBillQuantity[i] += quantity
                        finalPrice += (quantity * menuStartersPrice[menuFood])
                        break
                    }
                }
                if(menuCategory==2)
                {
                    if(menuMainCourse[menuFood]==finalBill[i])
                    {
                        flag2++
                        finalBillQuantity[i] += quantity
                        finalPrice += (quantity * menuMainCoursePrice[menuFood])
                        break
                    }
                }
                if(menuCategory==3)
                {
                    if(menuDesserts[menuFood]==finalBill[i])
                    {
                        flag2++
                        finalBillQuantity[i] += quantity
                        finalPrice += (quantity * menuDessertsPrice[menuFood])
                        break
                    }
                }
            }
            if(flag2==0)
            {
                if(menuCategory==1)
                {
                    finalBill[flag1] = menuStarters[menuFood]
                    finalBillQuantity[flag1] = quantity
                    finalPrice += quantity*menuStartersPrice[menuFood]
                    finalBillPrice[flag1] = menuStartersPrice[menuFood]
                }
                if(menuCategory==2)
                {
                    finalBill[flag1] = menuMainCourse[menuFood]
                    finalBillQuantity[flag1] = quantity
                    finalPrice += quantity*menuMainCoursePrice[menuFood]
                    finalBillPrice[flag1] = menuMainCoursePrice[menuFood]
                }
                if(menuCategory==3)
                {
                    finalBill[flag1] = menuDesserts[menuFood]
                    finalBillQuantity[flag1] = quantity
                    finalPrice += quantity*menuDessertsPrice[menuFood]
                    finalBillPrice[flag1] = menuDessertsPrice[menuFood]
                }
                 flag1++
            }

        }
    }
}

/**
 * This function displays the final bill to the user
 * The bill should contain the name of the restaurant, the items selected, their price, quantity and cost
 * The bill should also display the final amount to be paid
 * */
fun displayBill() {
    println("The final bill is")
    println("Restaurant name: All night canteen")
    println("The items ordered are")
    for(i in 0 until flag1 step 1)
    {
        println(finalBill[i]+"\t"+finalBillPrice[i]+"\t quantity \t"+finalBillQuantity[i])
    }
    println("final price\t"+finalPrice)
}

