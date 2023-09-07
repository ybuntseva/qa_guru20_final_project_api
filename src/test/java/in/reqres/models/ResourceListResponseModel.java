package in.reqres.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResourceListResponseModel {
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<ResourceData> data;
    private Support support;

    @Data
    public static class ResourceData {
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
