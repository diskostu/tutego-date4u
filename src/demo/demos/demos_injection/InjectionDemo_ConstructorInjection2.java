package demos.demos_injection;

import de.diskostu.demo.date4u.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Component
public class InjectionDemo_ConstructorInjection2 {

    private final FileSystem fileSystem;

    private String lala;

    /**
     * The {@link Autowired} annotation is not optional here, because we have multiple constructors.
     */
    @Autowired
    public InjectionDemo_ConstructorInjection2(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    public InjectionDemo_ConstructorInjection2(FileSystem fileSystem, String lala) {
        this.fileSystem = fileSystem;
        this.lala = lala;
    }
}
