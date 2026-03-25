package bensadon.spirograph;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

class SpirographControllerTest {

    @Test
    void updateSpirograph() {

        // Given
        SpirographView spirographView = mock();
        JTextField largeRadiusField = mock();
        JTextField smallRadiusField = mock();
        JTextField penDistanceField = mock();
        JTextField numStepsField = mock();
        JTextField anglePerStepField = mock();

        doReturn("200").when(largeRadiusField).getText();
        doReturn("75").when(smallRadiusField).getText();
        doReturn("55").when(penDistanceField).getText();
        doReturn("8000").when(numStepsField).getText();
        doReturn("0.007").when(anglePerStepField).getText();

        SpirographController controller = new SpirographController(
                spirographView,
                largeRadiusField,
                smallRadiusField,
                penDistanceField,
                numStepsField,
                anglePerStepField
        );

        // When
        controller.updateSpirograph();

        // Then
        verify(spirographView).setModel(new SpirographModel(200, 75, 55, 8000, 0.007));
    }
}