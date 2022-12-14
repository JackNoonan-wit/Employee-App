package ie.setu.ie.setu

import ie.setu.controllers.EmployeeAPI
import ie.setu.models.Employee
import mu.KotlinLogging
import kotlin.math.round

/*
Ansi color escape codes sourced through here:
https://www.codegrepper.com/code-examples/java/how+to+print+in+color+kotlin
*/



//backgrounds
//val blackb = "\\033[0;100m"
val blackb = "\u001b[40m"


// colours
val white = "\u001b[97m"
val yellow = "\u001b[93m"
val blue = "\u001b[94m"
val green = "\u001b[92m"
val red = "\u001b[91m"
val reset = "\u001b[0m"

//colors underlined
val whiteu = "\u001b[4;97m"
val yellowu = "\u001b[4;93m"
val blueu = "\u001b[1;4;94m"
val resetu = "\u001b[4;0m"

//var  =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)
var employees = EmployeeAPI()


val logger = KotlinLogging.logger {}

fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()

    print("Enter surname: ")
    val surname = readLine().toString()

    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]

    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()

    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()

    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()

    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()

    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}
/*fun update(){
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        return employees.update(update)

    print("Enter first name: ")
    val firstName = readLine().toString()

    print("Enter surname: ")
    val surname = readLine().toString()

    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]

    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()

    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()

    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()

    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()

    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.update(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}*/


fun main(args: Array<String>){
    start()
}


fun menu () : Int {
    logger.info { blue +"Launching Employee App"+ reset }
    print(yellow+"""
|   Employee Menu
     |"""+blue+"""   1. """+whiteu+"""Add Employee"""+reset+yellow+"""
     |"""+blue+"""   2. """+whiteu+"""List All Employees"""+reset+yellow+"""
     |"""+blue+"""   3. """+whiteu+"""Search Employees"""+reset+yellow+"""
     |"""+blue+"""   4. """+whiteu+"""Print Payslip for Employee"""+reset+yellow+"""
     |"""+blue+"""   5. """+whiteu+"""Delete All Employee"""+reset+yellow+"""
     |"""+blue+"""   6. """+whiteu+"""Delete Most Recent Employee"""+reset+yellow+"""
     |"""+blue+"""   7. """+whiteu+"""Load in Dummy Employee Data"""+reset+yellow+"""
     |"""+blue+"""  -1. """+whiteu+"""Exit"""+reset+yellow+"""
     |
|   Enter Option : """.trimMargin())
    return readLine()!!.toInt()
}

fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> chooseList()
            3 -> chooseSearch()
            4 -> paySlip()
            5 -> delete()
            6 -> confirmPop()
            7 -> dummyData()
            //9 -> update()
           //9 -> pop()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}



// Functions used by the Menu



//deletes entire employee array
fun delete() {
employees.delete()
}

//Displays a confirmation screen for the Pop command
internal fun confirmPop() {
    print("Are you sure you want to delete the current Database? "+green+"1  "+reset+"/"+red+"  2"+reset)
    val answer = readLine()!!.toInt()
    if (answer == 1) {
        println("Database deleted")
        return employees.pop()
    }
}

//Displays a Selection screen to choose a normal display or for it to be displayed in alphabetical order
internal fun chooseList() {
    print("Display database chronologically or sort alphabetically? "+green+"Normal  "+reset+"/"+red+"  Alphabetically"+reset)

    val answer = readLine()!!.toString()

    if (answer == "Alphabetically") {
        println("Database displayed")
        return employees.findAllAlpha()
    }
    else {
       return employees.findAll()
           .forEach{ println(it) }
    }
}


//Displays a Selection screen to choose to find by ID or by Name
internal fun chooseSearch() {
    print("Search by ID or Name?? "+green+"ID  "+reset+"/"+red+"  Name"+reset)

    val answer = readLine()!!.toString()

    if (answer == "Name") {
        return searchName()
    }
    else {
        return search()
    }
}

//Searches array by ID
fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}

//Searches array by Name
fun searchName() {
    val employee = getEmployeeByName()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}


internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}

internal fun getEmployeeByName(): Employee? {
    print("Enter the employee's first name to search by: ")
    val firstName = readLine()!!.toString()
    return employees.findByName(firstName)
}

//prints payslip
fun paySlip(){
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}

//inserts filler/dummy data into the array
fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
    employees.create(Employee("Sean", "Stevens", 'm', 0, 31875.43, 40.0, 6.5, 1400.0, 22.2))
    employees.create(Employee("Chris", "Connors", 'm', 0, 512736.13, 37.5, 8.0, 1200.0, 50.3))
    employees.create(Employee("Mark", "Millers", 'm', 0, 34585.41, 34.0, 7.5, 3000.0, 10.0))
}
fun pop() {
    val answer = confirmPop()
    employees.pop()
}

fun list(){
    employees.findAll()
        .forEach{ println(it) }
}

fun listAlpha(){
    employees.findAllAlpha()

}

/*fun main(args: Array<String>) {

    var input : Int

    add()

    do {
        input = menu()
        when (input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PAYE: ${getMonthlyPAYE()}")
            3 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            4 -> println("Monthly Total Deductions: ${getMonthlyDeductions()}")
            5 -> println("Monthly Pay: ${getMonthlyPay()}")
            6 -> println("Monthly Net Salary: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != 1)

}
fun menu () : Int {
    print("""
        Employee Menu for ${getFullName()}
        1. Monthly Salary
        2. Monthly PRSI
        3. Monthly PAYE
        4. Monthly Gross Pay
        5. Monthly Total Deductions
        6. Monthly Net Pay
        7. Full Payslip
        -1. Exit
        Enter Option :  """)
       return readLine()!!.toInt()
}
*/


fun roundTwoNumbers(number: Double) = round(number * 100) / 100















