package com.duo.leetcode;

public class Main {
    public void run(String input) {
        String[] ids = input.split(",");
        for (String id : ids) {
            System.out.printf("Run algorithm [%s]\n", id);
            try {
                Algorithm solution = (Algorithm) Class.forName(this.getAlgorithmClass(id)).newInstance();
                solution.run();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.printf("Wrong algorithm id: %s\n", id);
            }
        }
    }

    private String getAlgorithmClass(String id) {
        int i = Integer.parseInt(id);
        return String.format("com.duo.leetcode._%02d00._%s.Solution", i / 100, id);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run("915,945");
    }
}
