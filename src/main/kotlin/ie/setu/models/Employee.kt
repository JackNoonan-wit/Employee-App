package ie.setu.models

import ie.setu.ie.setu.*

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

       yellow+ """
_______________________________________________________________________
                          """+blueu+"""Monthly Payslip"""+reset+yellow+"""                              
_______________________________________________________________________                                                                      
                """+blueu+"""Employee Name:"""+reset+white+"""  ${getFullName()} (${gender.uppercase()})
                """+blueu+"""Employee ID:"""+reset+white+""" $employeeID  """+yellow+"""                                                                     
_______________________________________________________________________                                                               
                """+blueu+"""PAYMENT DETAILS - Gross Pay:"""+reset+white+""" ${getMonthlyPay()} """+yellow+"""
_______________________________________________________________________
                """+blueu+"""Salary:"""+reset+white+""" ${(getMonthlySalary())} 
                """+blueu+"""Bonus:"""+reset+white+"""  ${roundTwoNumbers(annualBonus / 12)} """+yellow+"""
_______________________________________________________________________
                """+blueu+"""DEDUCTIONS - Total Deductions:"""+reset+white+""" ${getMonthlyDeductions()}
                
                """+blueu+"""Cycle To Work:"""+reset+white+""" $cycleToWorkMonthlyDeduction
                """+blueu+"""PRSI:"""+reset+white+""" ${getMonthlyPRSI()}
                """+blueu+"""PAYE:"""+reset+white+""" ${getMonthlyPAYE()}"""+yellow+"""
_______________________________________________________________________
                """+blueu+"""NET PAY:${getNetMonthlyPay()}"""+reset+yellow+"""
_______________________________________________________________________"""+reset+"""
"""

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }
}