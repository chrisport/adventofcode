package ch.chrisport.adventofcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Pixelator {
    private static final Pattern inputPattern = Pattern.compile("^#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");

    Stream<String> claimToPixel(Claim c) {
        var coordinates = new LinkedList<String>();
        for (int x = c.marginLeft; x < c.marginLeft + c.width; x++) {
            for (int y = c.marginTop; y < c.marginTop + c.height; y++) {
                coordinates.add(x + ":" + y);
            }
        }
        return coordinates.stream();
    }

    Claim mapToClaim(String e) {
        var parts = inputPattern.matcher(e);
        if (!parts.find()) {
            throw new IllegalArgumentException("Could not decode input claim: " + e);
        }
        var id = Integer.parseInt(parts.group(1));
        var marginLeft = Integer.parseInt(parts.group(2));
        var marginTop = Integer.parseInt(parts.group(3));
        var width = Integer.parseInt(parts.group(4));
        var height = Integer.parseInt(parts.group(5));
        return new Claim(id, marginTop, marginLeft, height, width);
    }

    Long countPixelsWithOverlap(List<String> claims) {
        Map<String, Long> pixelOccurences = claims.stream()
                .map(this::mapToClaim)
                .flatMap(this::claimToPixel)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return pixelOccurences.values().stream().filter(po -> po > 1).count();
    }

    int findClaimIDWithoutOverlap(List<String> claims) {
        List<Claim> cs = claims.stream()
                .map(this::mapToClaim).collect(Collectors.toList());
        Map<String, Long> pixelOccurences = cs.stream()
                .flatMap(this::claimToPixel)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var result = cs.stream()
                .filter(
                        claim -> claimToPixel(claim).noneMatch(e -> pixelOccurences.get(e) != 1)
                ).findFirst();
        return result.get().id;
    }


}