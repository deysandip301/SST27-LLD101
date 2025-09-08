package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsappID;

    public WhatsAppDecorator(Notifier notifier, String whatsappID) {
        super(notifier);
        this.whatsappID = whatsappID;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[WHATSAPP -> " + this.whatsappID + "]: " + text);
    }
}
