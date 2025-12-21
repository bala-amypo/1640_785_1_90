import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DuplicateDetectionLogRepository
        extends JpaRepository<DuplicateDetectionLog, Long> {

    List<DuplicateDetectionLog> findByTicket(Ticket ticket);
}
