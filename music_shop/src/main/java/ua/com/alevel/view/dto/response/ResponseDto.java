package ua.com.alevel.view.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class ResponseDto {

    private Long id;
    private Date created;
    private Date updated;
}
