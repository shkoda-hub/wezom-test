package listeners;
import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestListener extends TestListenerAdapter {
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = Screenshots.takeScreenShotAsFile();
        byte[] screenshotBytes = readBytesFromFile(screenshot);
        saveScreenshot(screenshotBytes);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        File screenshot = Screenshots.takeScreenShotAsFile();
        byte[] screenshotBytes = readBytesFromFile(screenshot);
        saveScreenshot(screenshotBytes);
    }

    private byte[] readBytesFromFile(File file) {
        try (FileInputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

