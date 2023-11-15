
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    private List<String> items;

    private String status; // Pending, Shipped, Delivered, etc.
    // Other order-related fields, getters, setters, and constructors
}
