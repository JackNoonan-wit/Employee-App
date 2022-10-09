package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    //sorts employees in alphabetical order
    fun findAllAlpha() {
        /*for (employee in employees)
            println(employee)

        for ((index, value) in employees.withIndex())
            println("$index: $value") */

        //employees.forEach  {println(it)}
        employees
            .sortedBy {it.firstName}
            .forEach{ println(it) }

    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeID == id }
    }

    fun findByName(name: String): Employee? {
        return employees.find { p -> p.firstName == name }
    }

    fun create(employee: Employee) {
        employee.employeeID = getId()
        employees.add(employee)
    }
    /*fun update(employee: Employee) {
        employee.employeeID = getId()
        employees.remove(employee)
        employees.add(employee)
    }*/

    //deletes entire array
    fun delete() {
        employees.clear()
    }
    //deletes most recent addition to the array
    fun pop() {
        employees.removeLast()
    }
}
