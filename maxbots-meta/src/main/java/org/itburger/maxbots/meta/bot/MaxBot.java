package org.itburger.maxbots.meta.bot;

public interface MaxBot {

    String getBotToken();

    default String getBotUsername() {
        return null;
    }
}
