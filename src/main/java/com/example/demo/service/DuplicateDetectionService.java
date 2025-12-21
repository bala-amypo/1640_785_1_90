import java.util.List;

public interface DuplicateDetectionLogService {

    List<DuplicateDetectionLog> detectDuplicates(Long ticketId);

    List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);

    DuplicateDetectionLog getLog(Long id);

    String userDelete(Long id);

    User userUpdate(Long id, User user);
}
