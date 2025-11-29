package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class PlaylistRecommenderTest {

    @Test
    public void testEnergy() {
        List<Integer> bpms = null;
        String result = PlaylistRecommender.classifyEnergy(bpms);
        assertEquals(null, results, "When bpms is null, should return null");

        bpms = new List<>();
        result = PR.classifyEnergy(bpms);
        assertEquals(null, results, "When bpms is empty, should return null");
    }

    @Test
    public void testTitle() {
        boolean result = PlaylistRecommender.isValidTrackTitle(" ");
        assertEquals(false, result, "Title with only whitespace is invalid");

        result = PlaylistRecommender.isValidTrackTitle("Jack's B@d Tit|e");
        assertEquals(false, result, "Title should not contain special characters");

        result = PlaylistRecommender.isValidTrackTitle("aaaaabbbbbcccccdddddeeeeefffffx");
        asserEquals(false, result, "Title should not contain more than 30 characters");
    }

    @Test
    public void testNormVolume() {
        int result = PlaylistRecommender.normalizeVolume(-1000);
        assertEquals(0, result, "Negative volume should normalize to 0");

        result = PlaylistRecommender.normalizeVolume(50);
        assertEquals(50, result, "Volumes within range 0 - 100 should be unchanged");

        resdult = PlaylistRecommender.normalizeVolume(1000);
        assertEquals(100, result, "High volume should normalzie to 100");
    }
}
