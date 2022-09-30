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
    getFullName()

    println("Monthly Salary: ${getMonthlySalary()}")
    println("Monthly PAYE: ${getMonthlyPAYE()}")
    println("Monthly PRSI: ${getMonthlyPRSI()}")
    println("Monthly Total Deductions: ${getMonthlyDeductions()}")
    println("Monthly Pay: ${getMonthlyPay()}")
    println("Monthly Net Salary: ${getNetMonthlyPay()}")
    println(getPayslip())
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















