package cn.skcks.server.servlet;

import java.util.HashSet;
import java.util.Set;

public class Mapping {
    private String name;
    private Set<String> patternSet;

    public Mapping() {
        patternSet = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatternSet() {
        return patternSet;
    }

    public void setPatternSet(Set<String> patternSet) {
        this.patternSet = patternSet;
    }

    public void addPattern(String pattern)
    {
        this.patternSet.add(pattern);
    }
}
