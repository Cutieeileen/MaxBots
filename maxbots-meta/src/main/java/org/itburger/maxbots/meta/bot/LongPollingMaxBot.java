package org.itburger.maxbots.meta.bot;

import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.generics.BotApiMethodExecutor;
import org.itburger.maxbots.meta.exceptions.MaxApiException;

import java.util.concurrent.CompletableFuture;

public abstract class LongPollingMaxBot implements LongPollingBot {

    private final BotApiMethodExecutor executor;

    protected LongPollingMaxBot(BotApiMethodExecutor executor) {
        this.executor = executor;
    }

    public <T> T execute(BotApiMethod<T> method) throws MaxApiException {
        return executor.execute(method);
    }

    public <T> CompletableFuture<T> executeAsync(BotApiMethod<T> method) {
        return executor.executeAsync(method);
    }
}
