



public class MyTest2 {


    @AfterSuite
    public void tastAfter() {
        System.out.println(getClass().getSimpleName() + " after");
    }

    @AnnoMyTest
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }

    @AnnoMyTest
    public void task2(){
        System.out.println(getClass().getSimpleName() + " task2");
    }

}
