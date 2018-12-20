package ch.chrisport.adventofcode;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PixelatorTests {

    Pixelator taskUnderTest = new Pixelator();

    @Test
    public void givenValidClaimString_whenGetClaim_thenReturnClaim() {
        String claim = "#16 @ 442,603: 18x24";

        Claim c = taskUnderTest.mapToClaim(claim);

        assertEquals(442,c.marginLeft);
        assertEquals(603,c.marginTop);
        assertEquals(18,c.width);
        assertEquals(24,c.height);
        assertEquals(16,c.id);
    }

    @Test
    public void givenClaim_whenGetClaimToPixel_thenReturnEachPixelTheClaimCocers() {
        Claim claim = new Claim(0, 19, 23, 2, 3);

        List<String> pixels = taskUnderTest.claimToPixel(claim).collect(Collectors.toList());

        assertEquals(2*3, pixels.size());
        assertTrue(pixels.contains("23:19"));
        assertTrue(pixels.contains("23:20"));
        assertTrue(pixels.contains("24:19"));
        assertTrue(pixels.contains("24:20"));
        assertTrue(pixels.contains("25:19"));
        assertTrue(pixels.contains("25:20"));

    }

}
