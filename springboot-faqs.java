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
@Primary annotation just before the class initialization
this is to tell spring that this is the 


import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class OrderService {
	private PaymentService paymentService;
	public OrderService(@Qualifier("paypal") PaymentService paymentService) {
		this.paymentService = paymentService;
	}
}


to get values in config files
you can use @Value annotation to get the values.
Example:
@Value("${stripe.apiUrl}")
private String apiUrl;	

// to add a default value do this:
@Value("${stripe.apiUrl:3000}")

@Value("${stripe.supported-currencies}")
private List<String> supportedCurrencies;

// application.properties file
stripe.apiUrl= https://api.stripe.com
stripe.supported-currencies=USD,PHP,EUR,GDP


// Configuring Beans using Java code
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public PaymentService stripe() {
		return new StripePaymentService();
	}

	@Bean
	public OrderService orderService() {
		return new OrderService(stripe());
	}
}

// Lazy Initialization

// Bean Initialization
- Early / Eager
- Lazy
	- optimization technique
	- create objects when needed
- just add @Lazy annotation above the class name

// @Service annotation can accept a parameter which is the bean name
// @Service("email")


// Bean Scopes (singleton, prototype, application, request, session)
- Singleton (default) - 1 instance of bean is created per container 
- Prototype - a new instance is created everytime it is requested in the IOC container
- Request - a new bean instance is created for each HTTP request. The bean exists only for the duration of the HTTP request. Destroyed once the request is completed.
- Session - a new bean instance is created for each HTTP Session request. The bean exists only for the duration of the HTTP Session request. Destroyed once the request is completed.

public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext  context = SpringApplication.run();
		var orderService = context.getBean(OrderService.class);

		var orderService2 = context.getBean(OrderService.class);
	
	}
}

// Spring IOC container - lalagyan ng beans ng springboot

// Prototype Bean Scope example
@Bean
@Scope("prototype")

// There is also a lifecyle of Bean

