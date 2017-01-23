package com.hello.world.dao;

import java.sql.SQLException;

import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;

public interface FreeBoardDAO {  

  public ArrayList<FreeBoardVO> listFreeBoard(String id) throws SQLException;

  public FreeBoardVO getFreeBoard(int seq) throws SQLException;
  public void insertFreeBoard(FreeBoardVO freeBoardVO, String session_id) throws SQLException;

  /* *
   * 관리자 모드에서 필요한 메소드
   */
  public ArrayList<FreeBoardVO> listAllFreeBoard() throws SQLException;

  public void updateFreeBoard(FreeBoardVO freeBoardVO) throws SQLException;
}
