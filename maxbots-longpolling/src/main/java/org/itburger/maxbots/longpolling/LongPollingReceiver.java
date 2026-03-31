package org.itburger.maxbots.longpolling;

import org.itburger.maxbots.client.MaxClient;
import org.itburger.maxbots.meta.bot.LongPollingBot;
import org.itburger.maxbots.meta.exceptions.MaxApiException;
import org.itburger.maxbots.meta.api.methods.requests.updates.GetUpdates;
import org.itburger.maxbots.meta.api.methods.responses.GetUpdatesResponse;
import org.itburger.maxbots.meta.types.update.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LongPollingReceiver implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(LongPollingReceiver.class);

    private static final int DEFAULT_TIMEOUT = 30;
    private static final int DEFAULT_LIMIT = 100;

    private final LongPollingBot bot;
    private final MaxClient executor;
    private volatile boolean running = true;
    private Long marker = null;

    public LongPollingReceiver(LongPollingBot bot, MaxClient executor) {
        this.bot = bot;
        this.executor = executor;
    }

    @Override
    public void run() {
        log.info("Long polling started for bot: {}", bot.getBotToken());
        while (running) {
            try {
                GetUpdates request = GetUpdates.builder()
                        .marker(marker)
                        .limit(DEFAULT_LIMIT)
                        .timeout(DEFAULT_TIMEOUT)
                        .build();

                GetUpdatesResponse response = executor.execute(request);

                if (response != null && response.getUpdates() != null) {
                    List<Update> updates = response.getUpdates();
                    if (!updates.isEmpty()) {
                        for (Update update : updates) {
                            try {
                                bot.onUpdateReceived(update);
                            } catch (Exception e) {
                                log.error("Error processing update: {}", e.getMessage(), e);
                            }
                        }
                        marker = response.getMarker();
                    }
                }
            } catch (MaxApiException e) {
                //log.error("Error fetching updates: {}", e.getMessage(), e);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        log.info("Long polling stopped");
    }

    public void stop() {
        running = false;
    }
}
