package org.itburger.maxbots.meta.bot;

import org.itburger.maxbots.meta.types.update.Update;

public interface LongPollingBot extends MaxBot {

    void onUpdateReceived(Update update);
}
