package btvn.bt04;

import java.io.IOException;

public class UserService {
    private FileService fileService = new FileService();

    public void processUserData() throws IOException {
        fileService.saveToFile();
    }
}