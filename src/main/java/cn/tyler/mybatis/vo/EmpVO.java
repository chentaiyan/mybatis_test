package cn.tyler.mybatis.vo;

import java.io.Serializable;

public class EmpVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer empNumber;

    private String eName;

    private String job;

    public Integer getEmpNumber() {
	return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
	this.empNumber = empNumber;
    }

    public String geteName() {
	return eName;
    }

    public void seteName(String eName) {
	this.eName = eName;
    }

    public String getJob() {
	return job;
    }

    public void setJob(String job) {
	this.job = job;
    }

    @Override
    public String toString() {
	return "EmpVO [empNumber=" + empNumber + ", eName=" + eName + ", job=" + job + "]";
    }
    

}
