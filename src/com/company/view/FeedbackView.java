package com.company.view;

import com.company.controller.FeedbackController;
import com.company.model.Feedback;

import java.util.List;
import java.util.Scanner;

public class FeedbackView {
    Scanner input = new Scanner(System.in);
    FeedbackController feedbackController = new FeedbackController();

    public void createCustomerFeedback(Long customerId) {
        Feedback feedback = new Feedback();
        feedback.setIdCustomer(customerId);
        System.out.print("Informe o ID: ");
        feedback.setIdFeedback(input.nextLong());
        input.nextLine();
        System.out.print("Informe a mensagem: ");
        feedback.setMessage(input.nextLine());

        if (feedbackController.create(feedback) != null) {
            System.out.println("Feedback cadastrado com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar cadastrar o feedback");
        }
    }

    public boolean listCustomerFeedbacks(Long customerId) {
        System.out.println("Lista de Clientes");
        List<Feedback> feedbacks = feedbackController.listByCustomerId(customerId);

        if (!feedbacks.isEmpty()) {
            for (Feedback feedback : feedbacks) {
                System.out.println(feedback);
            }
        } else {
            System.out.println("Nenhum feedback cadastrado");
            return false;
        }
        return true;
    }
}
