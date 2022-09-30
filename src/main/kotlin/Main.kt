package ie.setu

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
    println("Payslip Printer")
    payslip()
    println("\n")
    payslipRounded()
}

fun payslip() {

    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

    println ("""_________________________________________________________________________
|                          Monthly Payslip                              |
|_______________________________________________________________________|
|                                                                       |
|   Employee Name:  ${firstName.uppercase()} ${surname.uppercase()}(${gender.uppercase()})                    Employee ID: $employeeID    |
|                                                                       |
|_______________________________________________________________________|
|                                                                       |
|    PAYMENT DETAILS \t\t\t\t DEDUCTION DETAILS  \t\t\t\t|
|_______________________________________________________________________|
|    Salary: $monthlySalary\t\t PAYE: $monthlyPaye\t\t\t|
|    Bonus:  ${annualBonus / 12}\t\t\t\t PRSI: $monthlyPrsi\t\t\t|
|    \t\t\t\t\t\t\t\t Cycle To Work: $cycleToWorkMonthlyDeduction\t\t\t\t|
|_______________________________________________________________________|
|       Gross:  $grossPay \t\tTotal Deductions: $totalDeductions        |
|_______________________________________________________________________|
|   \t\t\t\t NET PAY:${grossPay - totalDeductions} \t\t\t\t\t\t\t|
|_______________________________________________________________________|""")
}

fun payslipRounded(){

    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

    println (
"""
_______________________________________________________________________
                          Monthly Payslip                              
_______________________________________________________________________                                                                      
                Employee Name:  ${firstName.uppercase()} ${surname.uppercase()}(${gender.uppercase()})
                Employee ID: $employeeID                                                                       
_______________________________________________________________________                                                               
                PAYMENT DETAILS - Gross Pay: ${"%.2f".format(grossPay)} 
_______________________________________________________________________
                Salary: ${"%.2f".format(monthlySalary)} 
                Bonus:  ${"%.2f".format((annualBonus / 12))} 
_______________________________________________________________________
                DEDUCTIONS - Total Deductions ${"%.2f".format(totalDeductions)}
                
                Cycle To Work: $cycleToWorkMonthlyDeduction
                PRSI: ${"%.2f".format(monthlyPrsi)}
                PAYE: ${"%.2f".format(monthlyPaye)}
_______________________________________________________________________
                NET PAY:${"%.2f".format((grossPay - totalDeductions))}
_______________________________________________________________________
""")
}
















