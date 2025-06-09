// How to add a Bean using Annotations
// Other Annotations: @Component @Service @Repository @Controller

@SpringbootApplication
public class StoreApplication {
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(StoreApplication.);
    var orderService = context.getBean(OrderService.class);
    orderService.placeOrder();
  }
}

// OrderService
import org.springframework.stereotype.Component;

@Component
public class OrderService {
  private PaymentService paymentService;

  public OrderService(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  public void placeOrder() {
    paymentService.processPayment(10);
  }
}
