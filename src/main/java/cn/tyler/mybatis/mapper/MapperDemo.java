package cn.tyler.mybatis.mapper;

import cn.tyler.mybatis.vo.EmpVO;

public interface MapperDemo {

    EmpVO findEmpByNumber(int id);
}
