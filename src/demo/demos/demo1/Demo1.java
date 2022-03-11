package demos.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Demo1 {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Demo1.class, args);
    }
}


@Component
@Slf4j
class DateAtStartTime implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(LocalDateTime.now());

        System.out.println("args.getNonOptionArgs() = " + args.getNonOptionArgs());
        System.out.println("args.getOptionNames() = " + args.getOptionNames());
        System.out.println("args.getSourceArgs() = " + Arrays.toString(args.getSourceArgs()));

        for (String optionName : args.getOptionNames()) {
            System.out.println("args.getOptionValues(optionName) = " + args.getOptionValues(optionName));
        }
    }
}
