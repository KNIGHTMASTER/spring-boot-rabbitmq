package com.zisal.messaging.shared;

import java.io.Serializable;

/**
 * @author : <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @since : 2019-09-04
 **/
public class ReplyDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4358661288063300980L;

    private Long eventId;
    private String receiverName;
    private boolean status;

    public ReplyDTO() {
    }

    public ReplyDTO(Long eventId, String receiverName, boolean status) {
        this.eventId = eventId;
        this.receiverName = receiverName;
        this.status = status;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReplyDTO{" +
                "eventId=" + eventId +
                ", receiverName='" + receiverName + '\'' +
                ", status=" + status +
                '}';
    }
}
