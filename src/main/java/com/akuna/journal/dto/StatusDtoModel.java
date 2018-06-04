package com.akuna.journal.dto;

public class StatusDtoModel
{
    private final Status status;

    public StatusDtoModel(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status
    {
        SUCCESSFULLY("SUCCESSFULLY"),
        FAIL("FAIL");

        private String value;

        Status(String value) {
            this.value = value;
        }
    }
}
