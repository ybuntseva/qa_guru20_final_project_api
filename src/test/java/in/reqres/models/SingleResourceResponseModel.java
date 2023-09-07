package in.reqres.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SingleResourceResponseModel {
    private SingleResourceData data;
    private Support support;

    @Data
    public static class SingleResourceData {
        private int id;
        private String name;
        private int year;
        private String color;
        @JsonProperty("pantone_value")
        private String pantoneValue;
    }

    @Data
    public static class Support {
        private String url;
        private String text;
    }
}
