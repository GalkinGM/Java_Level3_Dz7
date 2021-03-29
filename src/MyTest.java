



public class MyTest {


    @BeforeSuite
    public void taskBefore() {
        System.out.println(" before");
    }

    @AnnoMyTest(1)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }

    @AnnoMyTest(2)
    public void task2() {
        System.out.println(getClass().getSimpleName() + " task2");
    }

    @AnnoMyTest(4)
    public void task3() {
        System.out.println(getClass().getSimpleName() + " task4");
    }

    @AnnoMyTest(3)
    public void task4() {
        System.out.println(getClass().getSimpleName() + " task3");
    }

    @AfterSuite
    public void tastAfter() {
        System.out.println(getClass().getSimpleName() + " after");
    }

//    @AfterSuite
//    public void tastAfter2() {
//        System.out.println(getClass().getSimpleName() + " after");
//    }

//    @BeforeSuite
//    public void taskBefore2() {
//        System.out.println(" before");
//    }


}
