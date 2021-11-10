package com.company.controller;

import com.company.DAO.FeedbackDAO;
import com.company.model.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackController {
    private FeedbackDAO feedbackDAO = new FeedbackDAO();

    public List<Feedback> list() {
        return feedbackDAO.list();
    }

    public List<Feedback> listByCustomerId(Long customerId) {
        List<Feedback> customerFeedbacks = new ArrayList<>();
        for (Feedback feedback : this.list()) {
            if (feedback.getIdCustomer() == customerId) {
                customerFeedbacks.add(feedback);
            }
        }
        return customerFeedbacks;
    }

    public Feedback create(Feedback customer) {
        if (customer != null && !this.isValidFeedbackId(customer.getIdCustomer())) {
            return feedbackDAO.create(customer);
        }
        return null;
    }

    public boolean isValidFeedbackId(Long idFeedback) {
        for (Feedback feedback : feedbackDAO.list()) {
            if (feedback.getIdFeedback() == idFeedback) {
                return true;
            }
        }
        return false;
    }
}
