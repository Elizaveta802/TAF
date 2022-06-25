package models;

public class MilestoneBuilder {
    private String name;
    private String description;

    public static class Builder{
        private MilestoneBuilder newMilestone;

        public Builder(){
            newMilestone = new MilestoneBuilder();
        }

        public Builder withName(String name){
            newMilestone.name = name;
            return this;
        }

        public Builder withDescription(String description){
            newMilestone.description = description;
            return this;
        }

        public MilestoneBuilder build(){
            return newMilestone;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
