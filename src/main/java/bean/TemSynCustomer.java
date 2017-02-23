package bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * Created by tancw on 2017/2/22.
 */
@Alias("temSynCustomer")
public class TemSynCustomer {
    private Long id;
    private String idcard;  //身份证号码
    private String realname; //真实姓名
    private String mechanismcode; //管辖机构代码
    private String teamcode; //所属团队代码
    private String position;  //职位
    private String entrystate; //入离职标识
    private String superiorname; //上级姓名
    private String superioridcard; //上级身份证号码
    private Long recordid; //信用宝同步ID
    private String createddate; //同步时间
    private Date syntime; //猪猪同步时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMechanismcode() {
        return mechanismcode;
    }

    public void setMechanismcode(String mechanismcode) {
        this.mechanismcode = mechanismcode;
    }

    public String getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEntrystate() {
        return entrystate;
    }

    public void setEntrystate(String entrystate) {
        this.entrystate = entrystate;
    }

    public String getSuperiorname() {
        return superiorname;
    }

    public void setSuperiorname(String superiorname) {
        this.superiorname = superiorname;
    }

    public String getSuperioridcard() {
        return superioridcard;
    }

    public void setSuperioridcard(String superioridcard) {
        this.superioridcard = superioridcard;
    }

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public Date getSyntime() {
        return syntime;
    }

    public void setSyntime(Date syntime) {
        this.syntime = syntime;
    }
}
