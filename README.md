# MaxBots Java API

[![Maven Central](https://img.shields.io/maven-central/v/org.itburger.maxbots/MaxBots.svg?label=Maven%20Central)](https://central.sonatype.com/namespace/org.itburger.maxbots)
[![Java 17+](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://adoptium.net/)

[English version](README_EN.md)

Библиотека для удобной работы с **The Max Platform Bots API** на языке Java. Предоставляет готовые клиенты, модели данных и механизмы для получения обновлений (Long Polling).

## Структура проекта

Проект разбит на несколько модулей для удобства использования:

*   `maxbots-meta` — Базовые интерфейсы, классы запросов (Requests), ответов (Responses) и модели данных (Types).
*   `maxbots-client` — HTTP-клиент на базе OkHttp для отправки запросов к API.
*   `maxbots-longpolling` — Модуль для получения входящих обновлений от платформы с использованием механизма Long Polling.

## Требования

*   **Java 17** или выше.

## Установка

Добавьте зависимости в ваш проект. Если вам нужен только клиент или только мета-классы, вы можете подключить их отдельно. Для полноценной работы бота с Long Polling подключите `maxbots-longpolling`.

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

## Быстрый старт

Пример создания простого бота, который получает обновления через Long Polling.

### 1. Создайте класс вашего бота

Наследуйтесь от `LongPollingMaxBot` и реализуйте необходимые методы:

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
        System.out.println("Получено новое обновление: " + update);
        
        // Пример отправки сообщения в ответ
        // SendMessage message = new SendMessage(update.getChat().getId(), "Привет!");
        // executeAsync(message);
    }
}
```

### 2. Запустите бота

Используйте `LongPollingBotsManager` для регистрации и запуска бота:

```java
import org.itburger.maxbots.client.MaxClient;
import org.itburger.maxbots.longpolling.LongPollingBotsManager;

public class Main {
    public static void main(String[] args) {
        String botToken = "ВАШ_ТОКЕН_БОТА";
        
        // Создаем клиент для отправки запросов к API
        MaxClient client = new MaxClient(botToken);
        
        // Инициализируем нашего бота
        MyMaxBot bot = new MyMaxBot(botToken, client);
        
        // Запускаем менеджер Long Polling
        LongPollingBotsManager botsManager = new LongPollingBotsManager();
        botsManager.registerBot(bot);
        
        System.out.println("Бот успешно запущен!");
    }
}
```

## Лицензия

Этот проект распространяется под лицензией MIT. Подробности смотрите в файле LICENSE.
