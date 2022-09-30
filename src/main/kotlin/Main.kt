package ie.setu

import kotlin.math.round

val firstName = "Joe"
val surname = "Soap"
val gender = "M"
val employeeID =6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkMonthlyDeduction = 54.33







fun main(args: Array<String>) {

    var input : Int

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

fun getFullName() = when(gender){
    "m", "M" ->"Mr. $firstName $surname"
    "f", "F" ->"Ms. $firstName $surname"
    else -> "$firstName $surname"
}
fun getMonthlySalary()=roundTwoNumbers(grossSalary/12)
fun getMonthlyPRSI()=roundTwoNumbers(getMonthlySalary() * (prsiPercentage/100))
fun getMonthlyPAYE()=roundTwoNumbers(getMonthlySalary() * (payePercentage/100))
fun getMonthlyPay()=roundTwoNumbers(getMonthlySalary() + (annualBonus / 12))
fun getMonthlyDeductions()=roundTwoNumbers((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))
fun getNetMonthlyPay()=roundTwoNumbers(roundTwoNumbers(getMonthlyPay()-getMonthlyDeductions()))

fun getPayslip()=

"""
_______________________________________________________________________
                          Monthly Payslip                              
_______________________________________________________________________                                                                      
                Employee Name:  ${getFullName()} (${gender.uppercase()})
                Employee ID: $employeeID                                                                       
_______________________________________________________________________                                                               
                PAYMENT DETAILS - Gross Pay: ${getMonthlyPay()} 
_______________________________________________________________________
                Salary: ${(getMonthlySalary())} 
                Bonus:  ${roundTwoNumbers(annualBonus / 12)} 
_______________________________________________________________________
                DEDUCTIONS - Total Deductions ${getMonthlyDeductions()}
                
                Cycle To Work: $cycleToWorkMonthlyDeduction
                PRSI: ${getMonthlyPRSI()}
                PAYE: ${getMonthlyPAYE()}
_______________________________________________________________________
                NET PAY:${getNetMonthlyPay()}
_______________________________________________________________________
"""



fun roundTwoNumbers(number: Double) = round(number * 100) / 100















