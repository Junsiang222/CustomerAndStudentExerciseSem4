package com.example.crm.customer.service

import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.CustomerStatus
import com.example.crm.customer.repository.ICustomerRepository

class CustomerServiceImpl(private val customerRepository: ICustomerRepository) : CustomerService {
    override fun createCustomer(customer: Customer): Customer {
        validateCustomer(customer)


        return customerRepository.create(customer)
    }

    override fun updateCustomer(customer: Customer): Customer {
        validateCustomer(customer)
        return customerRepository.update(customer)
    }

    override fun findCustomerById(id: String): Customer? {
        val customer = customerRepository.findById(id)

        if (customer == null) {
            throw IllegalArgumentException("No customer with this id")
        }
        return customer}

    override fun listCustomers(): List<Customer> {

        return customerRepository.findAll()
    }

    override fun ListActiveCustomers(): List<Customer> {
        return customerRepository.findAllActive()
    }


    private fun validateCustomer(customer: Customer) {
//        if (customer.status == CustomerStatus.INACTIVE){
//            throw IllegalArgumentException("customer cannot be inactive")
//        }
//        val existingCustomer = customerRepository.findById(customer.id)
//        if (existingCustomer != null) {
//            throw IllegalArgumentException("Customer ID already exists")
//       }

        require(customer.id.isNotBlank()) { "Customer ID cannot be blank" }
        require(customer.lastName.isNotBlank()) { "Customer name cannot be blank" }
        require(customer.firstName.isNotBlank()) { "Customer name cannot be blank" }
        require(customer.phone.isNotBlank()) { "Customer phone cannot be blank" }
        require(customer.email.isNotBlank()) { "Customer email cannot be blank" }
        require(customer.status != null) { "Customer status cannot be null" }
        require(customer.createdAt != null) { "Customer creation date cannot be null" }
        //require(customer.status != customer.INACTIVE { "Customer creation date cannot be null" }
    }
}
