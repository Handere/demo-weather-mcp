package hs.mcp.demomcp;

import hs.mcp.demomcp.service.AstronomyService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoMcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMcpApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider demoTools(AstronomyService astronomyService) {
        return MethodToolCallbackProvider.builder().toolObjects(astronomyService).build();
    }

}
