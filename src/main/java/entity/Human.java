package entity;

abstract class Human {
    String name;

    public Human(String name) {
        this.name = name;
    }

    public void declareSocialStatus(){
        System.out.println("I am a human after all");
    }
}
