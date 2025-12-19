package ex1;

public enum Position {

    DEV("Developer", 1),
    TEST("Tester", 2),
    SCRUM_MASTER("Scrum Master", 3),
    PM("Project Manager", 4);

    private String name;
    private int id;

    Position(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
