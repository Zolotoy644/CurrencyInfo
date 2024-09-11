package com.zolotarev.currencyinfo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class WrongDateException /*extends Exception*/ {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public WrongDateException(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public WrongDateException() {}

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static class WrongDateExceptionBuilder {
        private String message;
        private String details;
        private LocalDateTime timestamp;

        public WrongDateExceptionBuilder() {}

        public WrongDateExceptionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public WrongDateExceptionBuilder details(String details) {
            this.details = details;
            return this;
        }

        public WrongDateExceptionBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public WrongDateException build() {
            return new WrongDateException(message, details, timestamp);
        }
    }
}
