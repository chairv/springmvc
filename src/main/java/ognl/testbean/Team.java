package ognl.testbean;

public class Team {
    // 团队名称
    private String teamname;
    // 定义团队人员属性
    private Person person;
    // 团队人数
    private int personnum;
    //属性的getter和setter方法
    public String getTeamname() {
        return teamname;
    }
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public int getPersonnum() {
        return personnum;
    }
    public void setPersonnum(int personnum) {
        this.personnum = personnum;
    }
}
