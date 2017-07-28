package com.eqiao.bidata.weixin.common;

public class Result {

	private String UserId; //成员UserID

	private String DeviceId; //手机设备号(由企业微信在安装时随机生成，删除重装会改变，升级不受影响)

	private String errcode; //返回码

	private String errmsg; //对返回码的文本描述内容

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "Result{" +
				"UserId='" + UserId + '\'' +
				", DeviceId='" + DeviceId + '\'' +
				", errcode='" + errcode + '\'' +
				", errmsg='" + errmsg + '\'' +
				'}';
	}
}
