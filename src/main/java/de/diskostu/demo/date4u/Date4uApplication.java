package de.diskostu.demo.date4u;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@Slf4j
public class Date4uApplication {

    public Date4uApplication() {
        log.info("constructor");
    }


    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Date4uApplication.class, args);

        final String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("bean: " + beanDefinitionName);
        }

        final FileSystem fileSystem = context.getBean(FileSystem.class);
        System.out.println("freeDiskSpace = " + DataSize.ofBytes(fileSystem.getFreeDiskSpace()).toGigabytes());
    }
}
