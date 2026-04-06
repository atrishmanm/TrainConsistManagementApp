package test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    private boolean validateTrainId(String input) {
        return Pattern.compile("TRN-\\d{4}").matcher(input).matches();
    }

    private boolean validateCargoCode(String input) {
        return Pattern.compile("PET-[A-Z]{2}").matcher(input).matches();
    }

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(validateTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(validateTrainId("TRAIN12"));
        assertFalse(validateTrainId("TRN12A"));
        assertFalse(validateTrainId("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(validateCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET123"));
        assertFalse(validateCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        // Must be exactly 4 digits
        assertFalse(validateTrainId("TRN-123"));
        assertFalse(validateTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        // Lowercase should fail
        assertFalse(validateCargoCode("PET-Ab"));
        assertFalse(validateCargoCode("PET-aB"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(validateTrainId(""));
        assertFalse(validateCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        // Should not match if there is trailing garbage
        assertFalse(validateTrainId("TRN-1234 "));
        assertFalse(validateCargoCode("PET-ABC"));
    }
}