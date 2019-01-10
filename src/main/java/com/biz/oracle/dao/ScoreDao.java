package com.biz.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;

import com.biz.oracle.sql.ScoreSQL;
import com.biz.oracle.vo.ScoreVO;

public interface ScoreDao {
	
	@Select(ScoreSQL.SC_ALL)
	public List<ScoreVO> selectAll();
	
	@Select(ScoreSQL.SC_FIND_ID)
	public ScoreVO findById(long id);	// ScoreVO 리턴: PRIMARY KEY로 검색하는 경우에만!!!!
							// Because..값이 1개만 출력 되기 때문에
							// List로 해도 상관은 없지만 굳이 다시 1개의 값을 추출하려면 귀찮....
	
	@Select(ScoreSQL.SC_FIND_NUM)
	public List<ScoreVO> findByStNum(String st_num);
	
	@Insert(ScoreSQL.INSERT)
	public int insert(ScoreVO vo);
	
	@Update(ScoreSQL.UPDATE)
	public int update(ScoreVO vo);
	
	@Delete(ScoreSQL.DELETE)
	public int delete(long id);
	
	
}
