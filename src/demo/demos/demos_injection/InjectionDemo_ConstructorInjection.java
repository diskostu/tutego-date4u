package demos.demos_injection;

import de.diskostu.demo.date4u.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings({"FieldCanBeLocal", "ClassCanBeRecord", "unused"})
@Component
public class InjectionDemo_ConstructorInjection {

    private final FileSystem fileSystem;

    /**
     * The {@link Autowired} annotation is optional here.
     */
    public InjectionDemo_ConstructorInjection(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }
}
