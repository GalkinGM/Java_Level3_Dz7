import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Class mt = MyTest.class;
        start(mt);
        System.out.println();
        start(MyTest.class);
        System.out.println();
        start(MyTest2.class);
        System.out.println();
        start("MyTest2");
    }
    public static void start(String className) {
        try {
            Class<?> c = Class.forName(className);
            Constructor<?> constructor = c.getConstructor(null);
            start(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void start(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = c.getDeclaredMethods();
        int bsCount = 0, asCount = 0;
        List<Method> tests = new ArrayList<>();

        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                bsCount++;
                if (bsCount > 1) throw new RuntimeException("В тесте не больше одной аннотации " + o.getDeclaredAnnotations()[0].annotationType().getSimpleName() + "!!");
            } else if (o.isAnnotationPresent(AfterSuite.class)) {
                asCount++;
                if (asCount > 1) throw new RuntimeException("В тесте не больше одной аннотации " + type + "!!");
            } else if (type.equals("AnnoMyTest")) {
                tests.add(o);
            }
        }

        tests.sort((o1, o2) -> o1.getAnnotation(AnnoMyTest.class).value() - o2.getAnnotation(AnnoMyTest.class).value());

                    for (Method o : methods) {
                String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
                if (type.equals("BeforeSuite")) {
                    tests.add(0, o);
                }
                if (type.equals("AfterSuite")) {
                    tests.add(o);
                }
            }

        for (Method i : tests) {
                try {
                    System.out.print("(" + i.getDeclaredAnnotation(AnnoMyTest.class).value() + ") ");
                } catch (NullPointerException e) {

                }
            i.invoke(c.newInstance(), null);
            }
        }




}
