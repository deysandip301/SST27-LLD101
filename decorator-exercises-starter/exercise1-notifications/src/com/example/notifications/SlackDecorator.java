package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private final String slackID;

    public SlackDecorator(Notifier notifier, String slackID) {
        super(notifier);
        this.slackID = slackID;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[SLACK -> " + this.slackID + "]: " + text);
    }
}
