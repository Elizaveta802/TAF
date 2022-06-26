package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Project {
        /**
         * Name of the project
         *
         * @param name New value for this project's name.
         * @return The current value of this project's name.
         */
        String name ;

        /**
         * Announcement of the project
         *
         * @param announcement New value for this project's announcement.
         * @return The current value of this project's announcement.
         */

        private String announcement;

        /**
         * IsShowAnnouncement of the project
         *
         * @param isShowAnnouncement New value for this project's isShowAnnouncement.
         * @return The current value of this project's isShowAnnouncement.
         */


        private boolean isShowAnnouncement;

        /**
         * TypeOfProject of the project
         *
         * @param typeOfProject New value for this project's typeOfProject.
         * @return The current value of this project's typeOfProject.
         */
        private int typeOfProject;

        /**
         * IsCompleted of the project
         *
         * @param isCompleted New value for this project's isCompleted.
         * @return The current value of this project's isCompleted.
         */
        private boolean isCompleted;

}
