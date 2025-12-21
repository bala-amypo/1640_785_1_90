import java.util.List;

public interface TicketCategoryService {

    TicketCategory createCategory(TicketCategory category);

    List<TicketCategory> getAllCategories();

    TicketCategory getCategory(Long id);

    String userDelete(Long id);

    User userUpdate(Long id, User user);
}
