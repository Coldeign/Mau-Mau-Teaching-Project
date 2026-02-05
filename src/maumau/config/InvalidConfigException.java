package maumau.config;

public class InvalidConfigException extends IllegalArgumentException {
    public InvalidConfigException() {
        super("The read config is invalid.");
    }
}
