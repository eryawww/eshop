package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;
    List<Order> orders;

    @BeforeEach
    public void setUp() {
        paymentRepository = new PaymentRepository();
        
        List<Product> products = new ArrayList<>();
        
        Product product1 = new Product();
        product1.setProductId("A");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);
        
        Product product2 = new Product();
        product2.setProductId("B");
        product2.setProductName("Sampo Cap Bambang New");
        product2.setProductQuantity(1);
        products.add(product2);
        
        orders = new ArrayList<>();
        Order order1 = new Order("1111-1111-1111-1111", products, 68L, "A");
        orders.add(order1);
        Order order2 = new Order("2222-2222-2222-2222", products, 69L, "B");
        orders.add(order2);

        // payment
        payments = new ArrayList<>();

        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP11111111XXX");
        Payment payment1 = new Payment("3333-3333-3333-3333", PaymentMethod.VOUCHER_CODE.getValue(), orders.getFirst(), paymentData1);
        payments.add(payment1);

        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("address", "RM Petrick");
        paymentData2.put("deliveryFee", "6900");
        Payment payment2 = new Payment("3333-3333-3333-3333", PaymentMethod.CASH_ON_DELIVERY.getValue(), orders.getFirst(), paymentData2);
        payments.add(payment2);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.get(1);
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getPaymentData().keySet(), findResult.getPaymentData().keySet());
        assertEquals(payment.getStatus(), findResult.getStatus());
    }

    @Test
    void testFindNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("RANDOM");
        assertNull(findResult);
    }

    @Test
    void testFindAll(){
        for (Payment payment: payments) {
            paymentRepository.save(payment);
        }

        List<Payment> paymentList = paymentRepository.getAllPayment();
        assertEquals(2, paymentList.size());
    }
}