package utils;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class AllureLogger {
    private AllureLogger() {
    }

    @Step("STEP #{0}: {1}")
    public static void stepInfo(int stepNumber, String log) {
        LOGGER.info(String.format("STEP #%s: %s", stepNumber, log));
    }
}
