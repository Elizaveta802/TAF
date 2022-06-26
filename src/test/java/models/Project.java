package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Project {
        private String name;
        private String announcement;
        private boolean isShowAnnouncement;
        @SerializedName(value = "suite_mode")
        private int typeOfProject;
        @SerializedName(value = "is_completed") //переменная из Json, значение из нее перемести в переменную isCompleted
        private boolean isCompleted;
        private User user;
}
