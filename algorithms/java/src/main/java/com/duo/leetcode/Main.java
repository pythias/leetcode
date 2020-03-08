package com.duo.leetcode;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;

public class Main {
    public void run(String input) throws IOException {
        final ClassLoader loader = this.getClass().getClassLoader();
        final ImmutableSet<ClassPath.ClassInfo> classInfos = ClassPath.from(loader).getTopLevelClasses();
        String[] ids = input.split(",");
        for (String id : ids) {
            String packageName = this.getAlgorithmClass(id);
            try {
                for (final ClassPath.ClassInfo info : classInfos) {
                    if (!info.getName().startsWith(packageName)) {
                        continue;
                    }

                    final Class<?> clazz = info.load();
                    if (!Algorithm.class.isAssignableFrom(clazz)) {
                        continue;
                    }

                    System.out.printf("Run algorithm %s\n", id);
                    Algorithm algorithm = (Algorithm) clazz.newInstance();
                    algorithm.run();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private String getAlgorithmClass(String id) {
        int i = Integer.parseInt(id);
        return String.format("com.duo.leetcode._%02d00._%s.", i / 100, id);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run("1352");
    }
}
