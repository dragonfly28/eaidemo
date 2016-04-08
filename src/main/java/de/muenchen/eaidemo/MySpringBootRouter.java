package de.muenchen.eaidemo;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootRouter extends FatJarRouter {

    @Value("${processed.dir}")
    private String processedDir;
    private String lower = "lower";
    private String greater = "greater";

    private static final String HOME = System.getProperty("user.home");
    
    @Override
    public void configure() {
//        from("timer:trigger")
//                .transform().simple("ref:myBean")
//                .to("log:out");

        from("direct:uploaded")
                .choice().when().jsonpath("$.[?(@.amount < 10)]")
                .to("direct:lower")
                .otherwise()
                .to("direct:greater");
        
        from("direct:lower")
                .log("amount is <= 10")
                .toF("file://%s%s", HOME, processedDir + lower);

        from("direct:greater")
                .log("amount is > 10")
                .toF("file://%s%s", HOME, processedDir + greater);
    }

}
