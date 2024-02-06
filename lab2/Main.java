import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Bank src = new Bank();
        for (Method method : src.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Class<?>[] parameters = method.getParameterTypes();
                Repeat annotation = method.getAnnotation(Repeat.class);
                for (int i = 0; i < annotation.value(); ++i) {
                    method.setAccessible(true);
                    Object[] argsArray = new Object[parameters.length];
                    for (int j = 0; j < parameters.length; ++j) {
                        try {
                            argsArray[j] = Executor.getDefaultValue(parameters[j]);
                        } catch (Exception e) {
                            System.out.println("Не удалось распознать параметр типа " + parameters[j]);
                            return;
                        }
                    }
                    try {
                        method.invoke(src, argsArray);
                    } catch (Exception e) {
                        System.out.println("Не удалось выполнить метод " + method);
                    }
                }
            }
        }

    }
}