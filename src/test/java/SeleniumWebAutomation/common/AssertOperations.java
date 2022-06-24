package SeleniumWebAutomation.common;

import org.testng.Assert;
import org.jetbrains.annotations.NotNull;

public class AssertOperations {
    public void CheckAssertEquals(@NotNull String actual, @NotNull String expected, @NotNull String errorMessage) {
        Assert.assertEquals(actual, expected, errorMessage);
    }

    public void CheckAssertTrue(@NotNull String actual,@NotNull String expected) {
        Assert.assertTrue(actual.contains(expected));
    }
}