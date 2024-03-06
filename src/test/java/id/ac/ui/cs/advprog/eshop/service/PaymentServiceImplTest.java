package id.ac.ui.cs.advprog.eshop.service;

import enums.PaymentMethod;
import enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import java.util.*;
import java.util.UUID;

import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentRepository paymentRepository;
    List<Order> orders;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("A");
        product1.setProductName("A");
        product1.setProductQuantity(2);
        products.add(product1);

        orders = new ArrayList<>();
        Order order1 = new Order("1111-1111-1111-1111", products,
                69L, "ZZXX");
        orders.add(order1);
        Order order2 = new Order("2222-2222-2222-2222", products,
                70L, "ZZXX");
        orders.add(order2);

        payments = new ArrayList<>();

        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP11111111XXX");
        Payment payment1 = new Payment("3333-3333-3333-3333", PaymentMethod.VOUCHER_CODE.getValue(), orders.getFirst(), paymentData1);
        payments.add(payment1);

        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("address", "RM Petrik");
        paymentData2.put("deliveryFee", "69");
        Payment payment2 = new Payment("3333-3333-3333-3333", PaymentMethod.CASH_ON_DELIVERY.getValue(), orders.getFirst(), paymentData2);
        payments.add(payment2);
    }

    @Test
    void testSetValidStatus() {
        Payment payment = payments.get(1);

        Payment newPayment1 = new Payment(payment.getId(), payment.getMethod(), payment.getOrder(), payment.getPaymentData());
        Payment result1 = paymentService.setStatus(newPayment1, "SUCCESS");
        assertEquals(newPayment1.getId(), result1.getId());
        assertEquals(OrderStatus.SUCCESS.getValue(), result1.getOrder().getStatus());

        Payment newPayment2 = new Payment(payment.getId(), payment.getMethod(), payment.getOrder(), payment.getPaymentData());
        Payment result2 = paymentService.setStatus(newPayment1, "REJECTED");
        assertEquals(newPayment2.getId(), result2.getId());
        assertEquals(OrderStatus.FAILED.getValue(), result1.getOrder().getStatus());
    }

    @Test
    void testFindByIdIfIdFound() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        Payment result = paymentService.getPayment(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        doReturn(null).when(paymentRepository).findById("tes");
        assertNull(paymentService.getPayment("tes"));
    }

    @Test
    void testGetAllPayments() {
        doReturn(payments).when(paymentRepository).getAllPayment();

        List<Payment> results = paymentService.getAllPayments();
        assertEquals(payments, results);
    }
}