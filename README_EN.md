# MaxBots Java API

[![Maven Central](https://img.shields.io/maven-central/v/org.itburger.maxbots/MaxBots.svg?label=Maven%20Central)](https://central.sonatype.com/namespace/org.itburger.maxbots)
[![Java 17+](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://adoptium.net/)

[Русская версия](README.md)

A Java library for interacting with **The Max Platform Bots API**. It provides ready-to-use API clients, data models, and mechanisms for receiving updates (Long Polling).

## Project Structure

The project is divided into several modules for ease of use:

*   `maxbots-meta` — Core interfaces, request classes, response classes, and data models (Types).
*   `maxbots-client` — An OkHttp-based HTTP client for sending requests to the API.
*   `maxbots-longpolling` — A module for receiving incoming updates from the platform using the Long Polling mechanism.

## Requirements

*   **Java 17** or higher.

## Installation

Add the dependencies to your project. If you only need the client or the meta-classes, you can include them separately. For a fully functional bot with Long Polling, include `maxbots-longpolling`.

### Maven

```xml
<dependency>
    <groupId>org.itburger.maxbots</groupId>
    <artifactId>maxbots-longpolling</artifactId>
    <version>0.0.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'org.itburger.maxbots:maxbots-longpolling:0.0.1'
```

## Quick Start

Here is an example of creating a simple bot that receives updates via Long Polling.

### 1. Create your Bot class

Extend `LongPollingMaxBot` and implement the required methods:

```java
import org.itburger.maxbots.meta.bot.LongPollingMaxBot;
import org.itburger.maxbots.meta.api.generics.BotApiMethodExecutor;
import org.itburger.maxbots.meta.types.update.Update;

public class MyMaxBot extends LongPollingMaxBot {

    private final String botToken;

    public MyMaxBot(String botToken, BotApiMethodExecutor executor) {
        super(executor);
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Received a new update: " + update);
        
        // Example of sending a reply message
        // SendMessage message = new SendMessage(update.getChat().getId(), "Hello!");
        // executeAsync(message);
    }
}
```

### 2. Run the Bot

Use `LongPollingBotsManager` to register and start your bot:

```java
import org.itburger.maxbots.client.MaxClient;
import org.itburger.maxbots.longpolling.LongPollingBotsManager;

public class Main {
    public static void main(String[] args) {
        String botToken = "YOUR_BOT_TOKEN";
        
        // Create a client to send requests to the API
        MaxClient client = new MaxClient(botToken);
        
        // Initialize our bot
        MyMaxBot bot = new MyMaxBot(botToken, client);
        
        // Start the Long Polling manager
        LongPollingBotsManager botsManager = new LongPollingBotsManager();
        botsManager.registerBot(bot);
        
        System.out.println("Bot started successfully!");
    }
}
```

## License

This project is licensed under the MIT License. See the LICENSE file for details.
