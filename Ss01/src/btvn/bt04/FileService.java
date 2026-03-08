package btvn.bt04;

import java.io.IOException;

public class FileService {
    public void saveToFile() throws IOException {
        // Giả lập lỗi khi ghi file
        throw new IOException("Lỗi khi ghi dữ liệu vào file!");
    }
}