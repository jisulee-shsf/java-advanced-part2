package annotation.validator;

public class Team {

    @NotEmpty(message = "이름이 비었습니다.")
    private final String name;

    @Range(min = 1, max = 999, message = "회원의 수는 1에서 999 사이여야 합니다.")
    private final int memberCount;

    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public int getMemberCount() {
        return memberCount;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", memberCount=" + memberCount +
                '}';
    }
}
