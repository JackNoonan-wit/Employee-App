package ie.setu

class Employee (
    var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
    var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
    var annualBonus: Double, var cycleToWorkMonthlyDeduction: Double

) {

    fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. ${firstName} ${surname}"
        'f', 'F' -> "Ms. ${firstName} ${surname}"
        else -> "${firstName} ${surname}"
    }

    fun getMonthlySalary() = roundTwoNumbers(grossSalary / 12)
    fun getMonthlyPRSI() = roundTwoNumbers(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoNumbers(getMonthlySalary() * (payePercentage / 100))
    fun getMonthlyPay() = roundTwoNumbers(getMonthlySalary() + (annualBonus / 12))
    fun getMonthlyDeductions() =
        roundTwoNumbers((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))

    fun getNetMonthlyPay() = roundTwoNumbers(roundTwoNumbers(getMonthlyPay() - getMonthlyDeductions()))

    fun getPayslip() =

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

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }
}