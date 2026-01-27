import java.lang.reflect.Field;

class SecretStash {
    private String secretCode = "MySuperSecretPassword123";

    private void showSecret(){
        System.out.println("Secret is: "+ secretCode);
    }
}
public class ReflectionHacker {
    public static void main(String[] args) throws Exception{
        SecretStash stash = new SecretStash();

        System.out.println("Hacking into the object ... ");

        Class<?> clazz = stash.getClass();

        Field field = clazz.getDeclaredField("secretCode");

        field.setAccessible(true);

        String originValue = (String) field.get(stash);
        System.out.println("Hacked Value: "+originValue);

        field.set(stash, "HACKED_BY_ENGINEER");
        System.out.println(" Changed private value to: "+field.get(stash));

        System.out.println("Mission Accomplished. Frameworks Work like this internally. ");
    }

}
