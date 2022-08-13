package com.read.appnewsproject.dto;


import com.read.appnewsproject.common.ERoleAccount;
import lombok.*;

import java.util.Date;


@Data
@RequiredArgsConstructor
public class UserDTO extends ParentDTO {
    private String userName;

    private String passWord;

    private String fullName;

    private String email;

    private ERoleAccount role;

}
