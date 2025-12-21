import java.util.List;

public interface DuplicateRuleService {

    DuplicateRule createRule(DuplicateRule rule);

    List<DuplicateRule> getAllRules();

    DuplicateRule getRule(Long id);

    String duplicateruleDelete(Long id);

    User duplicateruleUpdate(Long id, DuplicateRule rule);
}
