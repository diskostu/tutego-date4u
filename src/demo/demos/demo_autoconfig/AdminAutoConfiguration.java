package demos.demo_autoconfig;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(AdminAutoConfiguration.AdministratorOrDennyPropertyAvailableCondition.class)
public class AdminAutoConfiguration {

    public AdminAutoConfiguration() {
    }


    static final class AdministratorOrDennyPropertyAvailableCondition extends AnyNestedCondition {

        public AdministratorOrDennyPropertyAvailableCondition() {
            super(ConfigurationPhase.PARSE_CONFIGURATION);
        }


        @ConditionalOnProperty(name = "user.name", havingValue = "Administrator")
        static class UserNameIsAdministrator {

        }

        @ConditionalOnProperty(name = "user.name", havingValue = "Denny")
        static class UserNameIsDenny {

        }
    }
}
