package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.exe"; // Thay bằng đường dẫn file thực tế
        byte[] inputBytes;
        long startTime, endTime;

        try {
            // Đọc toàn bộ file vào mảng byte
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            // Sử dụng StringBuilder để tránh tạo garbage
            StringBuilder outputString = new StringBuilder();
            for (byte b : inputBytes) {
                outputString.append((char) b);
            }

            endTime = System.currentTimeMillis();
            System.out.println("Time with StringBuilder: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}