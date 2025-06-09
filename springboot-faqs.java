// How to add a Bean using Annotations
// Other Annotations: @Component @Service @Repository @Controller

// @Autowired is used on the top of a constructor. To tell this pring to autowire this with dependency.
// only used for multiple constructors.
// Also, @Autowired should be added to the second constructor

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


// Controlling Bean Selections using @Primary and @Qualifier
// @Primary annotation just before the class initialization
// this is to tell spring that this is the 
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class OrderService {
	private PaymentService paymentService;
	public OrderService(@Qualifier("paypal") PaymentService paymentService) {
		this.paymentService = paymentService;
	}
}

// @Service annotation can accept a parameter
// @Service("email")
  
