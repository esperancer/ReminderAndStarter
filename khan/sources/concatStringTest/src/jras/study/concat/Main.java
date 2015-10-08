package jras.study.concat;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final long CONCAT_APPEND_MAX = 100000;

    public static void main(String[] args) {
        Concatable<String> stringConcatable = new Concatable<String>() {
            @Override
            public void createStringObject() {
                concatStringObject = "";
            }

            @Override
            public void concat(Object appendObject) {
                concatStringObject += appendObject.toString();
            }

            @Override
            public String getStringObject() {
                return concatStringObject;
            }
        };
        Concatable<StringBuilder> stringBuilderConcatable = new Concatable<StringBuilder>() {
            @Override
            public void createStringObject() {
                concatStringObject = new StringBuilder();
            }

            @Override
            public void concat(Object appendObject) {
                concatStringObject.append(appendObject);
            }

            @Override
            public String getStringObject() {
                return concatStringObject.toString();
            }
        };
        Concatable<StringBuffer> stringBufferConcatable = new Concatable<StringBuffer>() {
            @Override
            public void createStringObject() {
                concatStringObject = new StringBuffer();
            }

            @Override
            public void concat(Object appendObject) {
                concatStringObject.append(appendObject);
            }

            @Override
            public String getStringObject() {
                return concatStringObject.toString();
            }
        };
        System.out.printf("concat Ƚ�� : %s\n", CONCAT_APPEND_MAX);
        List<Concatable> concatables = new ArrayList<>();
        concatables.add(stringConcatable);
        concatables.add(stringBuilderConcatable);
        concatables.add(stringBufferConcatable);
        concatables.forEach(concatable -> {
            concatable.createStringObject();
            concatable.concatString(CONCAT_APPEND_MAX);
        });
        concatables.forEach(concatable -> {
            concatable.createStringObject();
            concatable.concatString(CONCAT_APPEND_MAX);
        });
        concatables.forEach(concatable -> {
            concatable.createStringObject();
            concatable.concatString(CONCAT_APPEND_MAX);
        });
    }

    static abstract class Concatable<T> {
        T concatStringObject;
        int counter = 0;
        public Concatable() {
            createStringObject();
        }

        public String concatString(long maxValue) {
            counter++;
            long initialTimestamp = System.currentTimeMillis();
            for (int i = 0; i < maxValue; i++) {
                concat(i);
                concat("��\n");
            }
            String result = getStringObject();
            long elapsed = System.currentTimeMillis() - initialTimestamp;
            System.out.printf("�ݺ� Ƚ��: %s, %s ó�� �ð�: %sms\n", counter, concatStringObject.getClass().getSimpleName(), elapsed);
            return result;
        }

        public abstract void createStringObject();
        public abstract void concat(Object appendObject);
        public abstract String getStringObject();
    }
}
