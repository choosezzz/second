package com.oracle.messageDao;

import com.oracle.tools.PageInfo;
import com.oracle.vo.SendMessage;

public interface MessageDao {
	
	/**
	 * 发送消息
	 * @param m
	 */
	public void sendMassage(SendMessage m);
	/**
	 * 查看收到的消息
	 * @param id
	 * @param info
	 */
	public void viewMassage(Integer id,PageInfo info);
	
	/**
	 * 删除用户接收到消息
	 * @param receiveId，要删除的消息id
	 */
	public void deleteReceiveMessageById(Integer receiveId);
	
	/**
	 * 批量删除接收到的消息
	 * @param ids
	 */
	public void batchDeleteReceiveMessage(Integer[] ids);
	/**
	 * 分页查看发送的消息 记录
	 * @param id
	 * @return
	 */
	public void listSendMessage(PageInfo info,Integer id);
	
	/**
	 * 根据id删除发送的消息
	 * @param sendId
	 * @param empId
	 */
	public void deleteSendMessageById(Integer sendId);
	/**
	 * 批量删除发送消息
	 * @param sendId
	 * @param empId
	 */
	public void batchDeleteSendMessage(Integer[] sendIds);
	/**
	 * 查看发送消息的详细内容
	 * @param info
	 * @param id
	 */
	public void viewSendMessage(PageInfo info,Integer empid,Integer...id);
	/**
	 * 查看收件箱消息详情
	 * @param info
	 * @param id
	 */
	public void viewReceiveMessage(PageInfo info,Integer empId,Integer id);

}
