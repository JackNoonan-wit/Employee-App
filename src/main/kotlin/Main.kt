package ie.setu

import kotlin.math.round


var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)



fun add(){

    print("Enter first name: ")
    val firstName = readLine().toString()

    print("Enter surname: ")
    val surname = readLine().toString()

    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]

    print("Enter employee ID: ")
    val employeeID = readLine()!!.toInt()

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

    employee = Employee(firstName, surname, gender, employeeID, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction)
}


fun main(args: Array<String>) {

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







fun getFullName() =when(employee.gender){
    'm', 'M' ->"Mr. ${employee.firstName} ${employee.surname}"
    'f','F' ->"Ms. ${employee.firstName} ${employee.surname}"
    else -> "${employee.firstName} ${employee.surname}"
}
fun getMonthlySalary()=roundTwoNumbers(employee.grossSalary/12)
fun getMonthlyPRSI()=roundTwoNumbers(getMonthlySalary() * (employee.prsiPercentage/100))
fun getMonthlyPAYE()=roundTwoNumbers(getMonthlySalary() * (employee.payePercentage/100))
fun getMonthlyPay()=roundTwoNumbers(getMonthlySalary() + (employee.annualBonus / 12))
fun getMonthlyDeductions()=roundTwoNumbers((getMonthlyPRSI() + getMonthlyPAYE() + employee.cycleToWorkMonthlyDeduction))
fun getNetMonthlyPay()=roundTwoNumbers(roundTwoNumbers(getMonthlyPay()-getMonthlyDeductions()))

fun getPayslip()=

"""
_______________________________________________________________________
                          Monthly Payslip                              
_______________________________________________________________________                                                                      
                Employee Name:  ${getFullName()} (${employee.gender.uppercase()})
                Employee ID: $employee.employeeID                                                                       
_______________________________________________________________________                                                               
                PAYMENT DETAILS - Gross Pay: ${getMonthlyPay()} 
_______________________________________________________________________
                Salary: ${(getMonthlySalary())} 
                Bonus:  ${roundTwoNumbers(employee.annualBonus / 12)} 
_______________________________________________________________________
                DEDUCTIONS - Total Deductions ${getMonthlyDeductions()}
                
                Cycle To Work: $employee.cycleToWorkMonthlyDeduction
                PRSI: ${getMonthlyPRSI()}
                PAYE: ${getMonthlyPAYE()}
_______________________________________________________________________
                NET PAY:${getNetMonthlyPay()}
_______________________________________________________________________
"""



fun roundTwoNumbers(number: Double) = round(number * 100) / 100















