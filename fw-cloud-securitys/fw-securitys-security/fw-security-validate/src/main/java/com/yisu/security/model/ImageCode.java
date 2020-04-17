package com.yisu.security.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;


/**
 * @author xuyisu
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImageCode extends ValidateCode {

	private BufferedImage image;

	public ImageCode(BufferedImage image, String code, int expireIn){
		super(code, expireIn);
		this.image = image;
	}

	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
		super(code, expireTime);
		this.image = image;
	}


}
