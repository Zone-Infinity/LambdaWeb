package me.infinity.lambdarest.entity;

public class BotVote {
    private final String bot;
    private final String user;
    private final String type;
    private final boolean isWeekend;

    public BotVote(String bot, String user, String type, boolean isWeekend) {
        this.bot = bot;
        this.user = user;
        this.type = type;
        this.isWeekend = isWeekend;
    }

    public String getBot() {
        return bot;
    }

    public String getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
