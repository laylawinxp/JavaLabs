import java.lang.reflect.Constructor;

public class Executor {
    private static final double DEFAULT_DOUBLE_VALUE = 10.1;
    private static final float DEFAULT_FLOAT_VALUE = 0.1f;
    private static final String DEFAULT_STRING_VALUE = "много сотрудников";
    private static final int DEFAULT_INT_VALUE = 1000000;
    private static final short DEFAULT_SHORT_VALUE = 30000;
    private static final byte DEFAULT_BYTE_VALUE = 120;
    private static final char DEFAULT_CHAR_VALUE = ')';
    private static final boolean DEFAULT_BOOLEAN_VALUE = true;
    public static Object getDefaultValue(Class<?> type) {
        if (type == double.class || type == Double.class) {
            return DEFAULT_DOUBLE_VALUE;
        } else if (type == float.class || type == Float.class) {
            return DEFAULT_FLOAT_VALUE;
        } else if (type == String.class) {
            return DEFAULT_STRING_VALUE;
        } else if (type == int.class || type == long.class || type == Integer.class || type == Long.class) {
            return DEFAULT_INT_VALUE;
        } else if (type == short.class || type == Short.class) {
            return DEFAULT_SHORT_VALUE;
        } else if (type == byte.class || type == Byte.class) {
            return DEFAULT_BYTE_VALUE;
        } else if (type == char.class || type == Character.class) {
            return DEFAULT_CHAR_VALUE;
        } else if (type == boolean.class || type == Boolean.class) {
            return DEFAULT_BOOLEAN_VALUE;
        } else if (type == double[].class) {
            return new double[]{2.7, 3.4, 5.7};
        } else if (type == float[].class) {
            return new float[]{3.4f, 1.2f, 9.0f};
        } else if (type == short[].class) {
            return new short[]{-12, 23, 17};
        } else if (type == byte[].class) {
            return new byte[]{1, -120, 57};
        } else if (type == int[].class) {
            return new int[]{2, 3, 5};
        } else if (type == boolean[].class) {
            return new boolean[]{true, false, true};
        } else if (type == long[].class) {
            return new long[]{200000000, 300, 50};
        } else if (type == char[].class) {
            return new char[]{'s', ')', '1'};
        } else if (type == String[].class) {
            return new String[]{"rub", "euro", "dollar"};
        } else {
            Constructor<?> constructor = type.getDeclaredConstructors()[0];
            Class<?>[] constructorParameters = constructor.getParameterTypes();
            Object[] constructorArgsArray = new Object[constructorParameters.length];
            for (int k = 0; k < constructorParameters.length; ++k) {
                constructorArgsArray[k] = getDefaultValue(constructorParameters[k]);
            }
            constructor.setAccessible(true);
            try {
                return constructor.newInstance(constructorArgsArray);
            } catch (Exception e) {
                System.out.println("Не удалось вызвать конструктор");
                return null;
            }
        }
    }
}
