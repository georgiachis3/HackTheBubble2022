package exceptions;

public class NoSuchGameObjectException extends Exception {
    private String id;

    public NoSuchGameObjectException(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Bad Id: \"%s\"\n\n%s", id, super.getMessage());
    }
}
