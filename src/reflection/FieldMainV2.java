package reflection;

import reflection.data.Team;
import reflection.data.User;

public class FieldMainV2 {

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("id", null, null);
        Team team = new Team("id", null);
        System.out.println(user); // User{id='id', name='null', age=null}
        System.out.println(team); // Team{id='id', name='null'}

        FieldUtil.nullFieldToDefault(user);
        FieldUtil.nullFieldToDefault(team);
        System.out.println(user); // User{id='id', name='', age=0}
        System.out.println(team); // Team{id='id', name=''}
    }
}
