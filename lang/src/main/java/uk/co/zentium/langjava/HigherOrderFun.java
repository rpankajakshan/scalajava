package uk.co.zentium.langjava;

import static org.junit.Assert.assertEquals;

public class HigherOrderFun {

    private interface Processor {

        String process(int refKey);
    }

    private static class RefreshProcessor implements Processor {

        @Override
        public String process(int refKey) {
            return "refresh processed";
        }
    }

    private static class DeltaProcessor implements Processor {

        @Override
        public String process(int refKey) {
            return "delta processed";
        }
    }

    private static String processRefresh() {
        return process(new RefreshProcessor());
    }

    private static String processDelta() {
        return process(new DeltaProcessor());
    }

    private static int obtainRefKey() {
        return 10;
    }

    private static String process(Processor p) {
        int refKey = obtainRefKey();
        return refKey + " " + p.process(refKey);
    }

    public static void main(String[] args) {
        assertEquals(processRefresh(), "10 refresh processed");
        assertEquals(processDelta(), "10 delta processed");
    }
}