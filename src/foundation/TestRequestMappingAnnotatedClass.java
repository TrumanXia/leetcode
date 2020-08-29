package foundation;

/**
 * @author 97994
 * @since 2020-08-08
 */
public class TestRequestMappingAnnotatedClass {
    public static void main(String[] args) {
        RequestMappingAnnotatedClass requestMappingAnnotatedClass = new RequestMappingAnnotatedClass();
        System.out.println(requestMappingAnnotatedClass.getClass().isAnnotationPresent(RequestMapping.class));
        RequestMapping annotation = requestMappingAnnotatedClass.getClass().getAnnotation(RequestMapping.class);
        System.out.println(annotation);
        String[] value = annotation.value();
    }
}
