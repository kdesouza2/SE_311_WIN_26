package src.hw_3.server;

import java.util.List;

public interface Input {

    public List<String> readLines();

    public void setFilename(String filename);
}
