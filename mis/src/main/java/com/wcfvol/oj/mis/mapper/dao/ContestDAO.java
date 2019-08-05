package com.wcfvol.oj.mis.mapper.dao;

import com.wcfvol.oj.mis.pojo.data.Contest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContestDAO {
    String TABLE_NAME = "contest";
    String INSERT_NAME = " title,problems,acm_rank,oi_rank,start_time,duration,writers,password ";

    List<Contest> getContestList();
    void addContest(Contest contest);
}
