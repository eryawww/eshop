package id.ac.ui.cs.advprog.eshop.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enums.OrderStatus;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class PaymentTest {
    private List<Product> products;
    private Order order;
    private List<Order> orders;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("A");
        product1.setProductQuantity(2);
        
        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("B");
        product2.setProductQuantity(1);
        this.products.add(product1);
        this.products.add(product2);

        this.orders = new ArrayList<>();
        Order order1 = new Order("ESHOP11111111XXX", this.products, 69L, "A", OrderStatus.SUCCESS.getValue());
        Order order2 = new Order("ESHOP11111111XXX", this.products, 70L, "B", OrderStatus.SUCCESS.getValue());
        this.orders.add(order1);
        this.orders.add(order2);

        this.order = order1;
    }

    @Test
    void testDuplicatePayment() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP11111111XXX");
        Payment payment = new Payment("ESHOP11111111XXX", "VOUCHER_CODE", this.orders.getFirst(), paymentData);

        assertSame(this.orders.getFirst(), payment.getOrder());
    }

    @Test
    void testSuccessValidVoucherCode() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP11111111XXX");

        Payment payment = new Payment("ESHOP11111111XXX", "VOUCHER_CODE", this.orders.getFirst(), paymentData);
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testRejectedVoucherCodeNot16Chars() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP11111111XXX");

        Payment payment = new Payment("ESHOP11111111XXX", "VOUCHER_CODE", this.orders.getFirst(), paymentData);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testRejectedVoucherCodeWrongPrefix() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP11111111XXX");

        Payment payment = new Payment("ESHOP11111111XXX", "VOUCHER_CODE", this.orders.getFirst(), paymentData);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testRejectedVoucherCodeNot8CharNumerical() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "XXX");

        Payment payment = new Payment("ESHOP11111111XXX", "VOUCHER_CODE", this.orders.getFirst(), paymentData);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testSuccessValidCashOnDelivery() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("address", "RM ADDR");
        paymentData.put("deliveryFee", "69000");

        Payment payment = new Payment("ESHOP11111111XXX", "CASH_ON_DELIVERY", this.orders.getFirst(), paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testRejectedCashOnDeliveryEmptyAddress() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("deliveryFee", "69000");
        Payment payment = new Payment("ESHOP11111111XXX", "CASH_ON_DELIVERY", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testRejectedCashOnDeliveryEmptyDeliveryFee() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("address", "JL PETRICK STAR");
        Payment payment = new Payment("ESHOP11111111XXX", "CASH_ON_DELIVERY", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
}