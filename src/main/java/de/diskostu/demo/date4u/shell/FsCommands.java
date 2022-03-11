package de.diskostu.demo.date4u.shell;

import de.diskostu.demo.date4u.FileSystem;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

@ShellComponent
public class FsCommands {

    private final FileSystem fileSystem;


    public FsCommands(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    @SuppressWarnings("SameReturnValue")
    @ShellMethod("Show application version")
    public String version() {
        return "0.1";
    }


    @ShellMethod("add")
    public int add(int a, int b) {
        return a + b;
    }


    @ShellMethod("show free disk space in GB")
    public String freeDiskSpace() {
        return DataSize.ofBytes(fileSystem.getFreeDiskSpace()).toGigabytes() + " GB";
    }
}
