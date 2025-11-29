package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        //Return "HIGH" if avg BPM ≥ 140 X
        //"MEDIUM" if 100–139 X
        //"LOW" if < 100 X
        //Reject null or empty lists X
        if(bpms == null) 
            return null;
        if(bpms.isEmpty())
            return null;

        int average = 0;

        for(Integer i : bpms) 
            average = average + i.intValue();

        average = average / bpms.size();

        if(average >= 140)
            return "HIGH";
        if(average >= 100)
            return "MEDIUM";
        if(average < 100)
            return "LOW";
        
        return null;
    }

    public static boolean isValidTrackTitle(String title) {
        //Checks for alphabetic characters + spaces, 1–30 chars
        //Reject null or special characters
        if(title == null)
            return false;
        if(title.length() > 30 || title.length() == 0)
            return false;

        boolean containsLetter = false;

        for(int i = 0; i < title.length(); i++) {
            if(!Character.isAlphabetic(title.charAt(i))) {
                if(!Character.isWhitespace(title.charAt(i)))
                    return false;
            } else {
                containsLetter = true; // whitespace not acceptable title
            }
        }
        return containsLetter;
    }

    public static int normalizeVolume(int volumeDb) {
        //Clamp volume into range 0–100 (e.g., 120 -> 100, -10 -> 0)
        if(volumeDb < 0)
            return 0;
        if(volumeDb > 100)
            return 100;
        return volumeDb;
    }
}
