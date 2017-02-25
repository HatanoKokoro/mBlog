package com.blog.web.common;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ArSecurity {
	
	private Key key;
	private byte[] byteMi;
	private byte[] byteMing;
	private String strMi;
	private String strMing;
	
	//默认key
	private static String getDefaultKey(){
		return "#)(W9p3";
	}
	
	//加密
	public String encrypt(String text){
		if(text==null) return null;
		ArSecurity as = new ArSecurity();
		as.setKey(getDefaultKey());
		as.setStrEncrypt(text);
		return as.getStrMi();
	}
	
	//解密
	public String decrypt(String text){
		if(text==null) return null;
		ArSecurity as = new ArSecurity();
		as.setKey(getDefaultKey());
		as.setStrDecrypt(text);
		return as.getStrMing();
	}
	
	//生成Key
	public void setKey(String strKey){
		try{
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(strKey.getBytes()));
			this.key=generator.generateKey();
			generator=null;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//输出str密文
	public void setStrEncrypt(String strMing){
		BASE64Encoder base64 = new BASE64Encoder();
		try{
			this.byteMing=strMing.getBytes("utf-8");
			this.byteMi=this.encode(this.byteMing);
			this.strMi=base64.encode(byteMi);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.byteMi=null;
			this.byteMing=null;
		}
	}
	
	public String getStrMi(){
		return strMi;
	}
	
	//输出byte密文
	public byte[] encode(byte[] byt){
		byte[] bytem=null;
		try{
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			bytem = cipher.doFinal(byt);
			cipher =null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return bytem;
	}
	
	//输出明文
	public void setStrDecrypt(String strMi){
		BASE64Decoder bs = new BASE64Decoder();
		try{
			this.byteMi=bs.decodeBuffer(strMi);
			this.byteMing=this.decode(this.byteMi);
			this.strMing=new String(byteMing,"utf-8");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bs=null;
			byteMing=null;
			byteMi=null;
		}
	}
	
	public byte[] decode(byte[] byteMi){ 
		byte[] byteD=null;
		try{
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteD= cipher.doFinal(byteMi);
			cipher=null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return byteD;
	}
	
	public String getStrMing(){
		return this.strMing;
	}
}
