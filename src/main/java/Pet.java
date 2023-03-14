public abstract class Pet {

    private String name;
    private boolean likesBaths;

    public Pet(String name, boolean likesBaths) {
        this.name = name;
        this.likesBaths = likesBaths;
    }

    public String getName() { return name; }
    public boolean likesBaths() { return likesBaths; }

    public abstract void giveTreat();
    public abstract void giveBath();

}
