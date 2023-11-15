
public class GroceryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public User registerUser(User user) {
        // Implement user registration logic
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        // Implement user login logic
        return userRepository.findByUsername(username).orElse(null);
    }

    public Order placeOrder(Long userId, List<String> items, String status) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Order order = new Order();
            order.setUser(user);
            order.setItems(items);
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null; // Handle user not found
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
