package com.read.appnewsproject.restapi.responeobject;

import com.read.appnewsproject.dto.UserDTO;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponeObject {

    private Date time;

    private int statusCode;
    private String message;
    private Object data;

}
