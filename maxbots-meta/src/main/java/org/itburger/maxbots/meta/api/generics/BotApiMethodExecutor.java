package org.itburger.maxbots.meta.api.generics;

import org.itburger.maxbots.meta.exceptions.MaxApiException;

import java.util.concurrent.CompletableFuture;

public interface BotApiMethodExecutor {

    <T> T execute(BotApiMethod<T> method) throws MaxApiException;

    <T> CompletableFuture<T> executeAsync(BotApiMethod<T> method);
}
