package com.example.demo.service.builder.generate;

/**
 * @author gaonan1
 * @date 2020/5/21
 **/
public class ChildTest extends ParentTest {
    private String b;

    // public static ChildTest.ChildBuilder builder() {
    //     return new ChildTest.ChildBuilder();
    // }

    public ChildTest() {
    }

    public ChildTest(String b) {
        this.b = b;
    }

    public static class ChildBuilder {
        private String b;

        ChildBuilder() {
        }

        public ChildTest.ChildBuilder b(String b) {
            this.b = b;
            return this;
        }

        public ChildTest build() {
            return new ChildTest(this.b);
        }
    }
}
