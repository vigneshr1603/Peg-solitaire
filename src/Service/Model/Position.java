package Service.Model;

public class Position {
    private Type type;

    Position(Type type) {
        this.type=type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}