package id.ac.ui.cs.advprog.eshop.model;

import enums.OrderStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
public class Payment {
    String id;
    String method;
    Order order;
    Map<String, String> paymentData;
    String status;
    static List<Payment> allPayment = new ArrayList<>();

    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.order = order;

        this.paymentData = paymentData;
        if (method.equals("VOUCHER_CODE")) {
            this.status = verifyVoucherCode();
        }
        else if (method.equals("CASH_ON_DELIVERY")) {
            this.status = verifyCashOnDelivery();
        }
        allPayment.add(this);
    }

    public void setStatus(String status) {
    }

    private String verifyVoucherCode() {
        String voucherCode = this.paymentData.get("voucherCode");
        if (voucherCode == null || voucherCode.length() != 16 || !voucherCode.startsWith("ESHOP")) {
            return "REJECTED";
        }

        int numCount = 0;
        for (char character: voucherCode.toCharArray()) {
            if (Character.isDigit(character)) {
                numCount += 1;
            }
        }
        if (numCount != 8) {
            return "REJECTED";
        }

        return "SUCCESS";
    }

    private String verifyCashOnDelivery() {
        String address = this.paymentData.get("address");
        String deliveryFee = this.paymentData.get("deliveryFee");

        if (address == null || address.isEmpty()) {
            return "REJECTED";
        }
        if (deliveryFee == null || deliveryFee.isEmpty()) {
            return "REJECTED";
        }
        return "SUCCESS";
    }

    public Payment getPayment(String paymentId){
        for(Payment payment: allPayment){
            if(payment.id.equals(paymentId)){
                return payment;
            }
        }
        return null;
    }

    public List<Payment> getAllPayments(){
        return allPayment;
    }

}