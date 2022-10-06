package ie.setu.ie.setu

import ie.setu.controllers.EmployeeAPI
import ie.setu.models.Employee
import mu.KotlinLogging
import kotlin.math.round


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

fun main(args: Array<String>){
    start()
}


fun menu () : Int {
    logger.info { "Launching Employee App" }
    print("""
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees
         |   4. Print Payslip for Employee
         |  -1. Exit
         |
         |Enter Option : """.trimMargin())
    return readLine()!!.toInt()
}

fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun list(){
    employees.findAll()
    .forEach{ println(it) }
}

fun search() {
    val employee = getEmployeeById()
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
fun paySlip(){
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}

fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
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















