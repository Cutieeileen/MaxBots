package org.itburger.maxbots.meta.bot;

import org.itburger.maxbots.meta.types.update.Update;

public interface WebhookBot extends MaxBot {

    String getWebhookPath();

    void onWebhookUpdateReceived(Update update);
}
