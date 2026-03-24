package com.example.crm.customer.service

import com.example.crm.app.Constant.CRMConstants
import com.example.crm.customer.model.Customer
import com.example.crm.customer.model.CustomerStatus
import com.example.crm.customer.repository.ICustomerRepository


class PremiumCustomerServiceImpl(private val customerRepository: ICustomerRepository) : CustomerServiceImpl(customerRepository) {
    override fun createCustomer(customer: Customer): Customer {
        return super.createCustomer(customer)
    }

    override fun updateCustomer(customer: Customer): Customer {
        if (!customer.isPremium) {
            throw IllegalArgumentException("NNN")
        }
        return super.updateCustomer(customer)
    }

    override fun findCustomerById(id: String): Customer? {
        val customer = customerRepository.findById(id)

        if (customer == null) {
            throw IllegalArgumentException("No customer with this id")
        }
        if (!customer.isPremium) {
            throw IllegalArgumentException("NNN")
        }
        return super.findCustomerById(id)
    }

    override fun listCustomers(): List<Customer> {

        return super.listCustomers()
    }

    override fun ListActiveCustomers(): List<Customer> {
        return super.ListActiveCustomers()
    }


    private fun validateCustomer(customer: Customer) {
//        if (customer.status == CustomerStatus.INACTIVE){
//            throw IllegalArgumentException("customer cannot be inactive")
//        }
//        val existingCustomer = customerRepository.findById(customer.id)
//        if (existingCustomer != null) {
//            throw IllegalArgumentException("Customer ID already exists")
//       }

        require(customer.id.isNotBlank()) { CRMConstants.ERROR_CUSTOMER_ID_REQUIRED }
        require(customer.firstName.isNotBlank()) { CRMConstants.ERROR_CUSTOMER_NAME_REQUIRED }
        require(customer.lastName.isNotBlank()) { CRMConstants.ERROR_CUSTOMER_LASTNSME_REQUIRED }
        require(customer.phone.isNotBlank()) { CRMConstants.ERROR_CUSTOMER_PHONE_REQUIRED }
        require(customer.email.isNotBlank()) { CRMConstants.ERROR_CUSTOMER_EMAIL_REQUIRED }
        require(customer.status != null) { CRMConstants.ERROR_CUSTOMER_STATUS_REQUIRED }
        require(customer.createdAt != null) { CRMConstants.ERROR_CUSTOMER_CREATED_AT_REQUIRED }
        //require(customer.status != customer.INACTIVE { "Customer creation date cannot be null" }
    }
}
