package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldMainV1 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id", "userA", 10);
        System.out.println(user.getName()); // userA

        Class<? extends User> aClass = user.getClass();
        Field nameField = aClass.getDeclaredField("name");
        System.out.println(nameField); // private java.lang.String reflection.data.User.name

        nameField.setAccessible(true);
        nameField.set(user, "userB");
        System.out.println(user.getName()); // userB
    }
}
