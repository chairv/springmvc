package ognl.testbean;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("keepAlive")
public class KeepAlive {
	private Long id;
	private Date regDate; // 注册时间
	private Date createTime; // 创建时间
	private int regCnt; // 注册数
	private int keep1Cnt; // 次日留存率
	private int keep3Cnt; // 第3日留存率
	private int keep7Cnt; // 第7日留存率
	private int keep30Cnt; // 第30日留存率
	private String remark; // 备注

	private Keep keep; //不存库

	public enum Keep {
		_1, _3, _7, _30, REG, NONE
	}

	public KeepAlive() {
	}

	public KeepAlive(Date createTime) {
		this.createTime = createTime;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getRegCnt() {
		return regCnt;
	}

	public void setRegCnt(int regCnt) {
		this.regCnt = regCnt;
	}

	public int getKeep1Cnt() {
		return keep1Cnt;
	}

	public void setKeep1Cnt(int keep1Cnt) {
		this.keep1Cnt = keep1Cnt;
	}

	public int getKeep3Cnt() {
		return keep3Cnt;
	}

	public void setKeep3Cnt(int keep3Cnt) {
		this.keep3Cnt = keep3Cnt;
	}

	public int getKeep7Cnt() {
		return keep7Cnt;
	}

	public void setKeep7Cnt(int keep7Cnt) {
		this.keep7Cnt = keep7Cnt;
	}

	public int getKeep30Cnt() {
		return keep30Cnt;
	}

	public void setKeep30Cnt(int keep30Cnt) {
		this.keep30Cnt = keep30Cnt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Keep getKeep() {
		return keep;
	}

	public void setKeep(Keep keep) {
		this.keep = keep;
	}

	public void initCnt(Keep keep) {
		switch (keep) {
		case _1:
			this.keep1Cnt = 0;
			return;
		case _3:
			this.keep3Cnt = 0;
			return;
		case _7:
			this.keep7Cnt = 0;
			return;
		case _30:
			this.keep30Cnt = 0;
			return;
		case REG:
			this.regCnt = 0;
			return;
		}
	}

	public void incrCnt(Keep keep) {
		switch (keep) {
		case _1:
			this.keep1Cnt++;
			return;
		case _3:
			this.keep3Cnt++;
			return;
		case _7:
			this.keep7Cnt++;
			return;
		case _30:
			this.keep30Cnt++;
			return;
		case REG:
			this.regCnt++;
			return;
		}
	}
}
