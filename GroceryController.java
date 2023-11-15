
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return groceryService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return groceryService.loginUser(username, password);
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestParam Long userId, @RequestParam List<String> items, @RequestParam String status) {
        return groceryService.placeOrder(userId, items, status);
    }

    @GetMapping("/orders/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {
        return groceryService.getUserOrders(userId);
    }
}
