package demos.demos_injection;

import de.diskostu.demo.date4u.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class InjectionDemo_FieldInjection {

    /**
     * Don't do this, it leads to harder testability.
     */
    @Autowired
    private FileSystem fileSystem;
}
