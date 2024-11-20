package org.ticketbox.shared.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private Boolean success;
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timeStamp;
    private T data;

    public BaseResponse(T payload) {
        this.success = true;
        this.timeStamp = LocalDateTime.now();
        this.data = payload;
    }

    public BaseResponse(T payload, Boolean success) {
        this.success = success;
        this.timeStamp = LocalDateTime.now();
        this.data = payload;
    }

    public BaseResponse(String message, Boolean success) {
        this.success = success;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}
