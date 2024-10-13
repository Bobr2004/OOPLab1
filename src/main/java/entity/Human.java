package entity;

abstract class Human {
    String name;

    public Human(String name) {
        this.name = name;
    }

    public String getSocialStatus(){
        return "I am a human after all";
    }
}
