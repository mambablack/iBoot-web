package com.ai.mapping;

import com.ai.model.SysParamDetail;
import com.ai.model.SysParamDetailExample;
import com.ai.model.SysParamDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParamDetailMapper {
    int countByExample(SysParamDetailExample example);

    int deleteByExample(SysParamDetailExample example);

    int deleteByPrimaryKey(SysParamDetailKey key);

    int insert(SysParamDetail record);

    int insertSelective(SysParamDetail record);

    List<SysParamDetail> selectByExample(SysParamDetailExample example);

    SysParamDetail selectByPrimaryKey(SysParamDetailKey key);

    int updateByExampleSelective(@Param("record") SysParamDetail record, @Param("example") SysParamDetailExample example);

    int updateByExample(@Param("record") SysParamDetail record, @Param("example") SysParamDetailExample example);

    int updateByPrimaryKeySelective(SysParamDetail record);

    int updateByPrimaryKey(SysParamDetail record);
}