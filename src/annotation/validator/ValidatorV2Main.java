package annotation.validator;

import static util.MyLogger.log;

public class ValidatorV2Main {

    public static void main(String[] args) {
        User user = new User("A", 0);
        Team team = new Team("", 0);

        try {
            Validator.validate(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            Validator.validate(team);
        } catch (Exception e) {
            log(e);
        }
    }
    /*
    18:38:52.867 [     main] java.lang.RuntimeException: 나이는 1에서 100 사이여야 합니다.
    18:38:52.875 [     main] java.lang.RuntimeException: 이름이 비었습니다.
    */
}
