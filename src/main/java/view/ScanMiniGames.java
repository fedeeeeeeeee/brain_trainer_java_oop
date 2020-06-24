package view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import view.controllers.Area;


/**
 * This class scans the minigames belong to an area.
 *
 */
public final class ScanMiniGames {

    private static final Map<String, Set<String>> MINIGAMES = new HashMap<>();

    static {
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("view.controllers.minigames").scan()) {
            final ClassInfoList annotationList = scanResult.getClassesWithAnnotation(Area.class.getName());

            for (final ClassInfo classes : annotationList) {
                final String area = classes.getAnnotationInfo(Area.class.getName()).getParameterValues().getValue("trainingArea").toString();
                final List<String> s = Arrays.asList(StringUtils.splitByCharacterTypeCamelCase(classes.getSimpleName().replace("Fx", "")));
                final String minigame = StringUtils.join(s, StringUtils.SPACE);
                if (MINIGAMES.containsKey(area)) {
                    MINIGAMES.get(area).add(minigame);
                } else {
                    final Set<String> set = new HashSet<>();
                    set.add(minigame);
                    MINIGAMES.put(area, set);
                }
            }
        }
    }

    /**
     * Private constructor for {@link ScanMiniGames}.
     */
    private ScanMiniGames() {
        // This is intentionally empty, nothing needed here
    }

    /**
     * Get a set of minigames in a specific Area.
     * 
     * @param trainingArea
     *          the trainingArea selected
     *
     * @return a set
     *          a set of minigames that belong to the area.
     */
    public static Set<String> getMiniGames(final TrainingArea trainingArea) {
        return MINIGAMES.get(trainingArea.getName());
    }

}
