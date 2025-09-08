package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private final String phoneNo;

    public SmsDecorator(Notifier notifier, String phoneNo) {
        super(notifier);
        this.phoneNo = phoneNo;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[SMS -> " + this.phoneNo + "]: " + text);
    }
}
