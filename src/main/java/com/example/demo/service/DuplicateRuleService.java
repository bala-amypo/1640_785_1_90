import java.util.List;

public interface DuplicateRuleService {

    DuplicateRule createRule(DuplicateRule rule);

    List<DuplicateRule> getAllRules();

    DuplicateRule getRule(Long id);

    String userDelete(Long id);

    User userUpdate(Long id, User user);
}
