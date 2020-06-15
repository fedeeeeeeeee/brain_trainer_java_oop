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
 *  Implementation of the {@link ScanMiniGames}.
 *
 */
public class ScanMiniGamesImpl implements ScanMiniGames {

    private final Map<String, Set<String>> minigames;

    /**
     * Simple Constructor of {@link ScanMiniGames}.
     */
    public ScanMiniGamesImpl() {
        this.minigames = new HashMap<>();
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("view.controllers.minigames").scan()) {
            final ClassInfoList annotationList = scanResult.getClassesWithAnnotation(Area.class.getName());

            for (final ClassInfo classes : annotationList) {
                final String area = classes.getAnnotationInfo(Area.class.getName()).getParameterValues().getValue("trainingArea").toString();
                final List<String> s = Arrays.asList(StringUtils.splitByCharacterTypeCamelCase(classes.getSimpleName().replace("Fx", "")));
                final String minigame = StringUtils.join(s, StringUtils.SPACE);
                if (this.minigames.containsKey(area)) {
                    this.minigames.get(area).add(minigame);
                } else {
                    final Set<String> set = new HashSet<>();
                    set.add(minigame);
                    this.minigames.put(area, set);
                }
            }
        }
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public Set<String> getMiniGames(final TrainingArea trainingArea) {
        return this.minigames.get(trainingArea.getName());
    }

}
