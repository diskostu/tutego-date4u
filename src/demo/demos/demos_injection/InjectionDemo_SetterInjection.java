package demos.demos_injection;

import de.diskostu.demo.date4u.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("FieldCanBeLocal")
@Component
public class InjectionDemo_SetterInjection {

    private FileSystem fileSystem;


    /**
     * Other as in constructor injection, where the {@link Autowired} annotation is optional, it is mandatory here.
     *
     */
    @Autowired
    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }
}
