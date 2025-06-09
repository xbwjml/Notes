package kz;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Domain {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date openDate;

    private Integer id;
}
