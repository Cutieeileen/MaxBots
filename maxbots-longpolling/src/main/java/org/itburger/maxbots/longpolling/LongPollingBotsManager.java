package org.itburger.maxbots.longpolling;

import org.itburger.maxbots.meta.bot.LongPollingBot;
import org.itburger.maxbots.client.MaxClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LongPollingBotsManager {

    private static final Logger log = LoggerFactory.getLogger(LongPollingBotsManager.class);

    private final ExecutorService executorService;
    private final Map<String, LongPollingReceiver> receivers = new ConcurrentHashMap<>();
    private final Map<String, Future<?>> futures = new ConcurrentHashMap<>();

    public LongPollingBotsManager() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public LongPollingBotsManager(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void registerBot(LongPollingBot bot) {
        String token = bot.getBotToken();
        if (receivers.containsKey(token)) {
            log.warn("Bot with token {} is already registered", maskToken(token));
            return;
        }

        MaxClient executor = new MaxClient(token);
        LongPollingReceiver receiver = new LongPollingReceiver(bot, executor);
        receivers.put(token, receiver);

        Future<?> future = executorService.submit(receiver);
        futures.put(token, future);

        log.info("Bot registered and long polling started: {}", maskToken(token));
    }

    public void unregisterBot(LongPollingBot bot) {
        String token = bot.getBotToken();
        LongPollingReceiver receiver = receivers.remove(token);
        if (receiver != null) {
            receiver.stop();
        }
        Future<?> future = futures.remove(token);
        if (future != null) {
            future.cancel(true);
        }
        log.info("Bot unregistered: {}", maskToken(token));
    }

    public void shutdown() {
        receivers.values().forEach(LongPollingReceiver::stop);
        executorService.shutdown();
        log.info("LongPollingBotsManager shut down");
    }

    private String maskToken(String token) {
        if (token == null || token.length() <= 8) return "***";
        return token.substring(0, 4) + "***" + token.substring(token.length() - 4);
    }
}
