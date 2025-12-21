import java.util.List;

public interface TicketCategoryService {

    TicketCategory createCategory(Category category);

    List<TicketCategory> getAllCategories();

    TicketCategory getCategory(Long id);

    String categoryDelete(Long id);

    TicketCategory categoryUpdate(Long id, Category category);
}
