package com.company.view;

import com.company.controller.CustomerController;
import com.company.model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    Scanner input = new Scanner(System.in);
    CustomerController customerController = new CustomerController();
    FeedbackView feedbackView = new FeedbackView();

    public void mainMenu() {
        System.out.println("1 - Listar Clientes");
        System.out.println("2 - Selecionar Cliente");
        System.out.println("3 - Cadastrar Cliente");

        switch (input.nextInt()) {
            case 1 -> this.listCustomers();
            case 2 -> this.selectCustomer();
            case 3 -> this.createCustomer();
        }
        this.mainMenu();
    }

    public void showCustomer(Customer customer) {
        if (customer != null) {
            System.out.printf(" - Id: %d - Cliente: %s",
                    customer.getIdCustomer(),
                    customer.getName()
            );
        } else {
            System.out.println("Cliente não encontrado");
        }
        System.out.println();
    }

    public boolean listCustomers() {
        System.out.println("Lista de Clientes");
        List<Customer> customers = customerController.list();

        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                this.showCustomer(customer);
            }
        } else {
            System.out.println("Nenhum cliente cadastrado");
            return false;
        }
        return true;
    }

    public Long entryCustomerId() {
        if (this.listCustomers()) {
            System.out.print("Informe o codigo do cliente que deseja acessar: ");
            Long selectedId = input.nextLong();
            if (customerController.isValidCustomerId(selectedId)) {
                return selectedId;
            }
        }
        return null;
    }

    public void selectCustomer() {
        Long selectedId = this.entryCustomerId();
        if (selectedId != null) {
            int menuOption;
            do {
                System.out.println("1 - Listar Mensagens");
                System.out.println("2 - Cadastrar Mensagem");
                System.out.println("3 - Voltar ao menu");

                switch (menuOption = input.nextInt()) {
                    case 1 -> feedbackView.listCustomerFeedbacks(selectedId);
                    case 2 -> feedbackView.createCustomerFeedback(selectedId);
                }
            } while (menuOption != 3);
        } else {
            System.out.print("Não foi possível selecionar um cliente\n\n");
        }
        System.out.println();
    }

    public void createCustomer() {
        Customer customer = new Customer();
        System.out.print("Informe o ID: ");
        customer.setIdCustomer(input.nextLong());
        System.out.print("Informe o Nome: ");
        input.nextLine();
        customer.setName(input.nextLine());

        if (customerController.create(customer) != null) {
            System.out.println("Cliente cadastrado com sucesso!");
            System.out.println(customer);
        } else {
            System.out.println("Não foi possivel realizar cadastrar o cliente");
        }
        System.out.println();
    }

}
