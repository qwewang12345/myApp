package com.example.demo.service.builder.generate;

/**
 * @author gaonan1
 * @date 2020/5/21
 **/
public class ParentTest {
    private String b;

    public static ParentTest.ParentBuilder builder() {
        return new ParentTest.ParentBuilder();
    }

    public ParentTest() {
    }

    public ParentTest(String b) {
        this.b = b;
    }

    public static class ParentBuilder {
        private String b;

        ParentBuilder() {
        }

        public ParentTest.ParentBuilder b(String b) {
            this.b = b;
            return this;
        }

        public ParentTest build() {
            return new ParentTest(this.b);
        }
    }
}
