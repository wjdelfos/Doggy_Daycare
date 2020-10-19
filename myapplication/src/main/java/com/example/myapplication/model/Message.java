package com.example.myapplication.model;

import java.sql.Date;
import java.util.UUID;

public class Message {
    private UUID Id;
    private String Contents;
    private Date SendAtTime;
    private UUID Sender;
    private UUID Receiver;
    private App_Gebruiker _Sender;
    private App_Gebruiker _Receiver;

    public Message() {
        Id = UUID.randomUUID();
    }

    public Message(UUID fromString) {
        Id=fromString;
    }

    public UUID getId() {
        return Id;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        Contents = contents;
    }

    public Date getSendAtTime() {
        return SendAtTime;
    }

    public void setSendAtTime(Date sendAtTime) {
        SendAtTime = sendAtTime;
    }

    public UUID getSender() {
        return Sender;
    }

    public void setSender(UUID sender) {
        Sender = sender;
    }

    public UUID getReceiver() {
        return Receiver;
    }

    public void setReceiver(UUID receiver) {
        Receiver = receiver;
    }

    public App_Gebruiker get_Sender() {
        return _Sender;
    }

    public void set_Sender(App_Gebruiker _Sender) {
        this._Sender = _Sender;
        this.Sender=_Sender.getID();
    }

    public App_Gebruiker get_Receiver() {
        return _Receiver;
    }

    public void set_Receiver(App_Gebruiker _Receiver) {
        this._Receiver = _Receiver;
        this.Receiver=_Receiver.getID();
    }


}
