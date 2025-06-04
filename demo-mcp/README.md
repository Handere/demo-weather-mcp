# Getting Started
NOTE: This is a POC under development.

Model Context Protocol (MCP) server built with Spring AI as a connector for AI agents on top of the weatherapi.com API.

Helpful links:
* [Weather API](https://www.weatherapi.com)
* [Spring AI](https://docs.spring.io/spring-ai/reference/index.html)
* [Spring Boot MCP Server](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)
* [Model Context Protocol](https://modelcontextprotocol.io/introduction)

### General setup

1. Create the MCP server as a `.jar` file.

```bash
./mvnw clean install -DskipTests

```
2. Obtain a [weatherapi.com](https://www.weatherapi.com/docs/) API key.
```
WEATHER_API_KEY=your-api-key
```
3. Add the API key to your MCP client environment.
   
3. Connect the MCP client to the MCP server with STDIO:

Postman
```
java -jar /ABSOLUTE/PATH/TO/JAR/FILE/demo-mcp-0.0.1-SNAPSHOT.jar
```

YAML
```
name: Weather MCP Server
version: 0.0.1
schema: v1
mcpServers:
  - name: demo-mcp
    command: java
    args:
      - -jar
      - /ABSOLUTE/PATH/TO/JAR/FILE/demo-mcp-0.0.1-SNAPSHOT.jar
    env: ${WEATHER_API_KEY}
```
