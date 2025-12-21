import java.util.List;

public interface TicketCategoryService {

    TicketCategory createCategory(TicketCategory category);

    List<TicketCategory> getAllCategories();

    TicketCategory getCategory(Long id);

    String ticketcategoryDelete(Long id);

    TicketCategory ticketcategoryUpdate(Long id, TicketCategory categoryv);
}
