package in.reqres.models;

import lombok.Data;

@Data
public class UserUpdateResponseModel {
    private String name;
    private String job;
    private String updatedAt;
}
