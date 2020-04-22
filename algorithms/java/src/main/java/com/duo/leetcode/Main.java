package com.duo.leetcode;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.*;

public class Main {
    public void run(String input) throws IOException {
        final ClassLoader loader = this.getClass().getClassLoader();
        final ImmutableSet<ClassPath.ClassInfo> classInfos = ClassPath.from(loader).getTopLevelClasses();
        List<ClassPath.ClassInfo> sortedClasses = new ArrayList<ClassPath.ClassInfo>();
        sortedClasses.addAll(classInfos.asList());
        sortedClasses.sort(Comparator.comparing(ClassPath.ClassInfo::getName));

        String[] ids = input.split(",");
        for (String id : ids) {
            try {
                for (final ClassPath.ClassInfo info : sortedClasses) {
                    if (!info.getName().startsWith("com.duo.leetcode.")) {
                        continue;
                    }

                    if (!id.equals("all") && !info.getName().endsWith(".".concat(id))) {
                        continue;
                    }

                    final Class<?> clazz = info.load();
                    if (!Algorithm.class.isAssignableFrom(clazz) || clazz.isInterface()) {
                        continue;
                    }

                    System.out.printf("Run algorithm %s\n", clazz.getName().substring(17));
                    Algorithm algorithm = (Algorithm) clazz.newInstance();
                    algorithm.run();
                }
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run("Parenthesis,NumIslands");
    }
}
